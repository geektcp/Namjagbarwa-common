package com.okhoxi.common.spring.model.vo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.LinkedList;

/**
 * Created by tanghaiyang on 2019/1/8.
 */
@Data
@AllArgsConstructor
@MappedSuperclass
public class BaseTreeNodeVo<T extends BaseTreeNodeVo> implements Serializable{

    @ApiModelProperty(value = "资源ID", example = "0")
    protected Long id;

    @ApiModelProperty(value = "用户父ID", example = "8")
    protected Long parentId;

    @ApiModelProperty(value = "子节点列表")
    private LinkedList<T> children;

    public BaseTreeNodeVo(){
        this.id = 0L;
        this.parentId = 0L;
    }

    public boolean add(T childNode){
        if (children == null) {
            children = new LinkedList<>();
        }
        return children.add(childNode);
    }

    @Override
    public String toString(){
        return JSON.toJSONString(this, SerializerFeature.PrettyFormat, SerializerFeature.DisableCircularReferenceDetect);
    }

}
