package com.okhoxi.common.mq.model.vo;

import com.arangodb.entity.BaseDocument;
import com.arangodb.entity.BaseEdgeDocument;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.okhoxi.common.mq.model.MessageVo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author Mr.Tang on 2021/9/13 12:05.
 * <p>
 * 消息实体，图分析数据转换消息
 */
@Data
@Accessors(chain = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
public class GraphMessageVo implements MessageVo {


    private String dbName;

    private String collectionName;

    private SchemaType type;

    private List<? extends BaseDocument> values;

    private List<? extends BaseEdgeDocument> edgeValues;

    /**
     *  删除 顶点时，顶点id 集合
     */
    private List<String> vertexKeys;

    /**
     *  删除 边时，边id 集合
     */
    private List<String> edgeKeys;
}
