package com.okhoxi.common.spring.jpa;

import com.okhoxi.common.spring.model.po.BasePo;
import com.okhoxi.common.spring.util.HttpRequestHeadUtil;
import org.apache.commons.lang3.StringUtils;

import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import java.util.Date;

/**
 * BasePo 保存通用字段赋值监听
 *
 * @author Mr.Tang
 * @date 2021/8/30 11:18
 */
public class JpaBasePoListener {

    @PrePersist
    public void prePersist(BasePo basePo) {
        String id = HttpRequestHeadUtil.getValueByKey("userId");
        if (StringUtils.isNotBlank(id)) {
            basePo.setCreateBy(id);
            basePo.setUpdateBy(id);
        }
        String tenantId = HttpRequestHeadUtil.getValueByKey("tenantId");
        if (StringUtils.isNotBlank(tenantId)) {
            basePo.setTenantId(tenantId);
        }
        Date now = new Date();
        basePo.setCreateDate(now);
        basePo.setUpdateDate(now);
        String isEnable = basePo.getIsEnable();
        if (StringUtils.isBlank(isEnable)) {
            basePo.setIsEnable("1");
        }
    }

    @PreUpdate
    public void preUpdate(BasePo basePo) {
        String id = HttpRequestHeadUtil.getValueByKey("userId");
        if (StringUtils.isNotBlank(id)) {
            basePo.setUpdateBy(id);
        }

        Date now = new Date();
        basePo.setUpdateDate(now);
    }
}
