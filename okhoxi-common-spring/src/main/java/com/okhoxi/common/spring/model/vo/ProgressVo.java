package com.okhoxi.common.spring.model.vo;

import lombok.Data;

/**
 * @author Mr.Tang
 * @date 2020/1/2 13:35
 **/
@Data
public class ProgressVo {
    /**
     * 实时状态
     */
    private Integer status;
    /**
     * 进度条显示的总数
     */
    private Integer totalSize = 0;
    /**
     * 进度条显示的当前计数
     */
    private Integer currentSize = 0;

    /**
     * 进度条的标题
     */
    private String title;
    /**
     * redis存储的key，用于在前端清除进度的缓存
     */
    private String key;

    /**
     * 进度条开始统计的时间
     */
    private Long startTime;

    /**
     * 进度条结束统计的时间
     */
    private Long endTime;

    /**
     * 消息
     */
    private String msg;

    /**
     * 数据体
     */
    private String data;
}
