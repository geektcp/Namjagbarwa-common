package com.okhoxi.common.spring.model.qo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.Valid;

/**
 * @author Mr.Tang on 2018/12/26.
 */
@Data
public class PageQoBase {

    /**
     * 分页查询信息
     */
    @Valid
    @ApiModelProperty(value = "分页查询参数")
    protected PageQo page = new PageQo();
}
