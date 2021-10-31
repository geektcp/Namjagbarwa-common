package com.okhoxi.common.spring.util;

import com.okhoxi.common.spring.constant.ProgressStatus;
import com.okhoxi.common.spring.model.vo.ProgressVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @author Mr.Tang
 * @date 2020/1/3 10:34
 * <p>
 * 进度条的使用流程：
 * 1. 调用start标记任务开始
 * 2. 可选步骤 --- 调用processing标记任务正在进行，同时设置totalSize
 * 3. 调用setCurrentSize标记任务当前的进度计数
 * <p>
 * 如果上述任一流程出现进度条异常，就调用fail标记任务异常
 **/
@Component
public class ProgressUtil {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    private long expireTime = 3600;
    @Autowired
    private TimeUtils timeUtils;
    private Object lock = new Object();

    /**
     * 开始进度
     *
     * @param key
     * @param title
     * @return
     */
    public void start(String key, String title) {
        synchronized (lock) {
            ProgressVo progressVo = getStartProgressVo(key, title);
            setRedis(key, progressVo, null, null);
        }
    }

    /**
     * 开始进度
     *
     * @param key
     * @param title
     * @param totalSize
     */
    public void start(String key, String title, Integer totalSize) {
        synchronized (lock) {
            ProgressVo progressVo = getStartProgressVo(key, title, totalSize);
            setRedis(key, progressVo, null, null);
        }
    }

    /**
     * 开始进度
     *
     * @param key
     * @param title
     * @param totalSize
     * @param expireTime
     */
    public void start(String key, String title, Integer totalSize, Long expireTime) {
        synchronized (lock) {
            ProgressVo progressVo = getStartProgressVo(key, title, totalSize);
            setRedis(key, progressVo, expireTime, null);
        }
    }

    /**
     * 开始进度
     *
     * @param key
     * @param title
     * @param totalSize
     * @param expireTime
     * @param timeUnit
     */
    public void start(String key, String title, Integer totalSize, Long expireTime, TimeUnit timeUnit) {
        synchronized (lock) {
            ProgressVo progressVo = getStartProgressVo(key, title, totalSize);
            setRedis(key, progressVo, expireTime, timeUnit);
        }
    }

    /**
     * 初始化进度开始的ProgressVo
     *
     * @param key
     * @param title
     * @param totalSize
     * @return
     */
    private ProgressVo getStartProgressVo(String key, String title, Integer... totalSize) {
        ProgressVo progressVo = new ProgressVo();
        progressVo.setStatus(ProgressStatus.PROCESSING.getCode());
        progressVo.setKey(key);
        progressVo.setTitle(title);
        progressVo.setStartTime(timeUtils.getCurrentTick());
        if (totalSize.length > 0) {
            progressVo.setTotalSize(totalSize[0]);
        }
        return progressVo;
    }

    /**
     * 进度进行中
     *
     * @param key
     * @param totalSize
     * @return
     */
    public ProgressVo processing(String key, Integer totalSize) {
        synchronized (lock) {
            ProgressVo progressVo = getProcessingProgressVo(key, totalSize);
            if (progressVo != null) {
                setRedis(key, progressVo, null, null);
            }
            return progressVo;
        }
    }

    /**
     * 进度进行中
     *
     * @param key
     * @param totalSize
     * @param expireTime
     * @return
     */
    public ProgressVo processing(String key, Integer totalSize, Long expireTime) {
        synchronized (lock) {
            ProgressVo progressVo = getProcessingProgressVo(key, totalSize);
            if (progressVo != null) {
                setRedis(key, progressVo, expireTime, null);
            }
            return progressVo;
        }
    }

    /**
     * 进度进行中
     *
     * @param key
     * @param totalSize
     * @param expireTime
     * @param timeUnit
     * @return
     */
    public ProgressVo processing(String key, Integer totalSize, Long expireTime, TimeUnit timeUnit) {
        synchronized (lock) {
            ProgressVo progressVo = getProcessingProgressVo(key, totalSize);
            if (progressVo != null) {
                setRedis(key, progressVo, expireTime, timeUnit);
            }
            return progressVo;
        }
    }

    /**
     * 初始化进度进行中的ProgressVo
     *
     * @param key
     * @param totalSize
     * @return
     */
    private ProgressVo getProcessingProgressVo(String key, Integer totalSize) {
        ProgressVo progressVo = getValue(key);
        if (progressVo == null || progressVo.getStatus().equals(ProgressStatus.FAILED.getCode())) {
            return null;
        }
        if (totalSize.equals(0)) {
            progressVo.setStatus(ProgressStatus.COMPLETED.getCode());
            progressVo.setEndTime(timeUtils.getCurrentTick());
        } else {
            if (progressVo.getTotalSize() >= 0 &&
                    !progressVo.getTotalSize().equals(totalSize)) {
                progressVo.setTotalSize(totalSize);
            }
        }
        return progressVo;
    }

    /**
     * 进度失败
     *
     * @param key
     * @param msg
     * @return
     */
    public void fail(String key, String msg) {
        synchronized (lock) {
            ProgressVo progressVo = getFailProgressVo(key, msg, false, true);
            if (progressVo != null) {
                setRedis(key, progressVo, null, null);
            }
        }
    }

    /**
     * 进度失败
     *
     * @param key
     * @param msg
     * @param expireTime
     */
    public void fail(String key, String msg, Long expireTime) {
        synchronized (lock) {
            ProgressVo progressVo = getFailProgressVo(key, msg, false, true);
            if (progressVo != null) {
                setRedis(key, progressVo, expireTime, null);
            }
        }
    }

    /**
     * 进度失败
     *
     * @param key
     * @param msg
     * @param expireTime
     * @param timeUnit
     */
    public void fail(String key, String msg, Long expireTime, TimeUnit timeUnit) {
        synchronized (lock) {
            ProgressVo progressVo = getFailProgressVo(key, msg, false, true);
            if (progressVo != null) {
                setRedis(key, progressVo, expireTime, timeUnit);
            }
        }
    }

    /**
     * 进度失败
     *
     * @param key
     * @param msg
     * @param append
     */
    public void fail(String key, String msg, Boolean append) {
        synchronized (lock) {
            ProgressVo progressVo = getFailProgressVo(key, msg, append, true);
            if (progressVo != null) {
                setRedis(key, progressVo, null, null);
            }
        }
    }

    /**
     * 进度失败
     *
     * @param key
     * @param msg
     * @param append
     * @param expireTime
     */
    public void fail(String key, String msg, Boolean append, Long expireTime) {
        synchronized (lock) {
            ProgressVo progressVo = getFailProgressVo(key, msg, append, true);
            if (progressVo != null) {
                setRedis(key, progressVo, expireTime, null);
            }
        }
    }

    /**
     * 进度失败
     *
     * @param key
     * @param msg
     * @param append
     * @param expireTime
     * @param timeUnit
     */
    public void fail(String key, String msg, Boolean append, Long expireTime, TimeUnit timeUnit) {
        synchronized (lock) {
            ProgressVo progressVo = getFailProgressVo(key, msg, append, true);
            if (progressVo != null) {
                setRedis(key, progressVo, expireTime, timeUnit);
            }
        }
    }

    /**
     * 进度失败
     *
     * @param key
     * @param msg
     * @param append
     * @param completed
     */
    public void fail(String key, String msg, Boolean append, Boolean completed) {
        synchronized (lock) {
            ProgressVo progressVo = getFailProgressVo(key, msg, append, completed);
            if (progressVo != null) {
                setRedis(key, progressVo, null, null);
            }
        }
    }

    /**
     * 进度失败
     *
     * @param key
     * @param msg
     * @param append
     * @param completed
     * @param expireTime
     */
    public void fail(String key, String msg, Boolean append, Boolean completed, Long expireTime) {
        synchronized (lock) {
            ProgressVo progressVo = getFailProgressVo(key, msg, append, completed);
            if (progressVo != null) {
                setRedis(key, progressVo, expireTime, null);
            }
        }
    }

    /**
     * 进度失败
     *
     * @param key
     * @param msg
     * @param append
     * @param completed
     * @param expireTime
     * @param timeUnit
     */
    public void fail(String key, String msg, Boolean append, Boolean completed, Long expireTime, TimeUnit timeUnit) {
        synchronized (lock) {
            ProgressVo progressVo = getFailProgressVo(key, msg, append, completed);
            if (progressVo != null) {
                setRedis(key, progressVo, expireTime, timeUnit);
            }
        }
    }

    /**
     * 初始化进度失败的ProgressVo
     *
     * @param key
     * @param msg
     * @param append
     * @return
     */
    private ProgressVo getFailProgressVo(String key, String msg, Boolean append, Boolean completed) {
        ProgressVo progressVo = getValue(key);
        if (progressVo == null) {
            return null;
        }
        progressVo.setStatus(ProgressStatus.FAILED.getCode());
        if (completed) {
            progressVo.setEndTime(timeUtils.getCurrentTick());
        }
        initProgressVo(progressVo, msg, append);
        return progressVo;
    }

    /**
     * 初始化ProgressVo
     *
     * @param progressVo
     * @param msg
     * @param append
     */
    private void initProgressVo(ProgressVo progressVo, String msg, Boolean append) {
        if (append) {
            if (StringUtils.isEmpty(progressVo.getMsg())) {
                progressVo.setMsg(msg);
            } else {
                progressVo.setMsg(progressVo.getMsg() + ";" + msg);
            }
        } else {
            progressVo.setMsg(msg);
        }
    }

    /**
     * 进度成功
     *
     * @param key
     * @param data
     * @return
     */
    public void success(String key, String data) {
        synchronized (lock) {
            ProgressVo progressVo = getSuccessProgressVo(key, data);
            if (progressVo != null) {
                setRedis(key, progressVo, null, null);
            }
        }
    }

    /**
     * 进度成功
     *
     * @param key
     * @param data
     * @param expireTime
     */
    public void success(String key, String data, Long expireTime) {
        synchronized (lock) {
            ProgressVo progressVo = getSuccessProgressVo(key, data);
            if (progressVo != null) {
                setRedis(key, progressVo, expireTime, null);
            }
        }
    }

    /**
     * 进度成功
     *
     * @param key
     * @param data
     * @param expireTime
     * @param timeUnit
     */
    public void success(String key, String data, Long expireTime, TimeUnit timeUnit) {
        synchronized (lock) {
            ProgressVo progressVo = getSuccessProgressVo(key, data);
            if (progressVo != null) {
                setRedis(key, progressVo, expireTime, timeUnit);
            }
        }
    }

    /**
     * 初始化进度成功的ProgressVo
     *
     * @param key
     * @param data
     * @return
     */
    private ProgressVo getSuccessProgressVo(String key, String data) {
        ProgressVo progressVo = getValue(key);
        if (progressVo == null) {
            return null;
        }
        progressVo.setStatus(ProgressStatus.COMPLETED.getCode());
        progressVo.setEndTime(timeUtils.getCurrentTick());
        progressVo.setData(data);
        progressVo.setCurrentSize(progressVo.getTotalSize());
        return progressVo;
    }

    /**
     * 设置进度条显示的当前计数
     *
     * @param key
     * @param increaseSize
     * @return
     */
    public ProgressVo setCurrentSize(String key, Integer increaseSize) {
        synchronized (lock) {
            ProgressVo progressVo = getCurrentSizeProgressVo(key, increaseSize, null, null);
            if (progressVo != null) {
                setRedis(key, progressVo, null, null);
            }
            return progressVo;
        }
    }

    /**
     * 设置进度条显示的当前计数
     *
     * @param key
     * @param increaseSize
     * @param expireTime
     * @return
     */
    public ProgressVo setCurrentSize(String key, Integer increaseSize, Long expireTime) {
        synchronized (lock) {
            ProgressVo progressVo = getCurrentSizeProgressVo(key, increaseSize, null, null);
            if (progressVo != null) {
                setRedis(key, progressVo, expireTime, null);
            }
            return progressVo;
        }
    }

    /**
     * 设置进度条显示的当前计数
     *
     * @param key
     * @param increaseSize
     * @param expireTime
     * @param timeUnit
     * @return
     */
    public ProgressVo setCurrentSize(String key, Integer increaseSize, Long expireTime, TimeUnit timeUnit) {
        synchronized (lock) {
            ProgressVo progressVo = getCurrentSizeProgressVo(key, increaseSize, null, null);
            if (progressVo != null) {
                setRedis(key, progressVo, expireTime, timeUnit);
            }
            return progressVo;
        }
    }

    /**
     * 设置进度条显示的当前计数
     *
     * @param key
     * @param increaseSize
     * @param failMessage
     * @param append
     * @return
     */
    public ProgressVo setCurrentSize(String key, Integer increaseSize, String failMessage, Boolean append) {
        synchronized (lock) {
            ProgressVo progressVo = getCurrentSizeProgressVo(key, increaseSize, failMessage, append);
            if (progressVo != null) {
                setRedis(key, progressVo, null, null);
            }
            return progressVo;
        }
    }

    /**
     * 设置进度条显示的当前计数
     *
     * @param key
     * @param increaseSize
     * @param failMessage
     * @param append
     * @param expireTime
     * @return
     */
    public ProgressVo setCurrentSize(String key, Integer increaseSize, String failMessage, Boolean append, Long expireTime) {
        synchronized (lock) {
            ProgressVo progressVo = getCurrentSizeProgressVo(key, increaseSize, failMessage, append);
            if (progressVo != null) {
                setRedis(key, progressVo, expireTime, null);
            }
            return progressVo;
        }
    }

    /**
     * 设置进度条显示的当前计数
     *
     * @param key
     * @param increaseSize
     * @param failMessage
     * @param append
     * @param expireTime
     * @param timeUnit
     * @return
     */
    public ProgressVo setCurrentSize(String key, Integer increaseSize, String failMessage, Boolean append, Long expireTime, TimeUnit timeUnit) {
        synchronized (lock) {
            ProgressVo progressVo = getCurrentSizeProgressVo(key, increaseSize, failMessage, append);
            if (progressVo != null) {
                setRedis(key, progressVo, expireTime, timeUnit);
            }
            return progressVo;
        }
    }

    /**
     * 初始化设置进度条显示的当前计数的ProgressVo
     *
     * @param key
     * @param increaseSize
     * @param failMessage
     * @param append
     * @return
     */
    private ProgressVo getCurrentSizeProgressVo(String key, Integer increaseSize, String failMessage, Boolean append) {
        ProgressVo progressVo = getValue(key);
        if (progressVo == null) {
            return null;
        }
        progressVo.setCurrentSize(progressVo.getCurrentSize() + increaseSize);
        // 进度递增的过程中，有失败的信息
        if (!StringUtils.isEmpty(failMessage)) {
            progressVo.setStatus(ProgressStatus.FAILED.getCode());
            initProgressVo(progressVo, failMessage, append);
        }
        // 进度条完成
        if (progressVo.getCurrentSize().equals(progressVo.getTotalSize())) {
            // 当且仅当进度条的状态是非失败状态的时候，才能把状态设置成完成
            if (!progressVo.getStatus().equals(ProgressStatus.FAILED.getCode())) {
                progressVo.setStatus(ProgressStatus.COMPLETED.getCode());
            }
            progressVo.setEndTime(timeUtils.getCurrentTick());
        }
        return progressVo;
    }

    /**
     * redis-get
     *
     * @param key
     * @return
     */
    private ProgressVo getValue(String key) {
        Object value = redisTemplate.opsForValue().get(key);
        return value == null ? null : (ProgressVo) value;
    }

    /**
     * redis-set
     *
     * @param key
     * @param progressVo
     * @param expireTime
     * @param timeUnit
     */
    private void setRedis(String key, ProgressVo progressVo, Long expireTime, TimeUnit timeUnit) {
        redisTemplate.opsForValue().set(key, progressVo, expireTime == null ? this.expireTime : expireTime, timeUnit == null ? TimeUnit.SECONDS : timeUnit);
    }

    /**
     * 判断是否可以开始统计进度
     * 如果存在正在进行的统计，就不允许再执行统计进度的操作
     *
     * @param key
     * @return
     */
    public boolean canExecute(String key) {
        synchronized (lock) {
            Object value = redisTemplate.opsForValue().get(key);
            if (value == null) {
                return true;
            }
            ProgressVo progressVo = (ProgressVo) value;
            return progressVo.getStatus().equals(ProgressStatus.PROCESSING) ? false : true;
        }
    }

    /**
     * 判断是否可以开始统计进度
     * 如果存在正在进行的统计，就不允许再执行统计进度的操作
     *
     * @param patternKey
     * @return
     */
    public boolean canExecuteByPattern(String patternKey) {
        synchronized (lock) {
            Set<String> keys = redisTemplate.keys(patternKey);
            if (keys.isEmpty()) {
                return true;
            }
            List<Object> list = redisTemplate.opsForValue().multiGet(keys);
            list.removeIf(Objects::isNull);
            List<ProgressVo> targetList = list.stream().map(x -> (ProgressVo) x).collect(Collectors.toList());
            return !targetList.stream().anyMatch(x -> x.getStatus().equals(ProgressStatus.PROCESSING.getCode()));
        }
    }

    /**
     * 查询进度条列表
     *
     * @param patternKey
     * @return
     */
    public List<ProgressVo> get(String patternKey) {
        synchronized (lock) {
            List<ProgressVo> progressList = new ArrayList<>();
            Set<String> keys = redisTemplate.keys(patternKey);
            if (!keys.isEmpty()) {
                List<Object> list = redisTemplate.opsForValue().multiGet(keys);
                list.removeIf(Objects::isNull);
                progressList.addAll(list.stream().map(x -> (ProgressVo) x).collect(Collectors.toList()));
            }
            return progressList;
        }
    }

    /**
     * 删除进度条列表
     *
     * @param keys
     */
    public void delete(List<String> keys) {
        synchronized (lock) {
            if (keys != null && !keys.isEmpty()) {
                this.redisTemplate.delete(keys);
            }
        }
    }

    /**
     * 查询指定的进度信息
     *
     * @param key
     * @return
     */
    public ProgressVo getOne(String key) {
        synchronized (lock) {
            Object value = redisTemplate.opsForValue().get(key);
            return value == null ? null : (ProgressVo) value;
        }
    }

    /**
     * 批量查询进度信息
     *
     * @param keys
     * @return
     */
    public List<ProgressVo> getMulti(List<String> keys) {
        synchronized (lock) {
            List<ProgressVo> progressList = new ArrayList<>();
            if (keys == null || keys.isEmpty()) {
                return progressList;
            }
            List<Object> list = redisTemplate.opsForValue().multiGet(keys);
            list.removeIf(Objects::isNull);
            progressList.addAll(list.stream().map(x -> (ProgressVo) x).collect(Collectors.toList()));
            return progressList;
        }
    }
}
