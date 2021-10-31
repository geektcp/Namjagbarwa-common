package com.okhoxi.common.spring.jpa;

import com.okhoxi.common.spring.model.po.SysBasePo;
import com.okhoxi.common.spring.util.HttpRequestHeadUtil;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * SysBasePo  保存通用字段赋值监听
 *
 * @author Mr.Tang
 * @date 2021/8/30 11:18
 */
public class JpaSysBasePoListener {

    @PrePersist
    public void prePersist(SysBasePo sysBasePo) {
        String id = HttpRequestHeadUtil.getValueByKey("userId");
        if (StringUtils.isNotBlank(id)) {
            sysBasePo.setCreateBy(id);
            sysBasePo.setUpdateBy(id);
        }
        Date now = new Date();
        sysBasePo.setCreateDate(now);
        sysBasePo.setUpdateDate(now);
        String isEnable = sysBasePo.getIsEnable();
        if(StringUtils.isBlank(isEnable)){
            sysBasePo.setIsEnable("1");
        }
    }

    @PreUpdate
    public void preUpdate(SysBasePo sysBasePo) {
        String id = HttpRequestHeadUtil.getValueByKey("userId");
        if (StringUtils.isNotBlank(id)) {
            sysBasePo.setUpdateBy(id);
        }
        Date now = new Date();
        sysBasePo.setUpdateDate(now);
    }
}
