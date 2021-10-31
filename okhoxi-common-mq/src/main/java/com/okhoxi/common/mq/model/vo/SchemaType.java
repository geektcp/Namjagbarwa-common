package com.okhoxi.common.mq.model.vo;

/**
 * Created by Mr.Tang on 2021/1/16.
 */
public enum SchemaType {
    VERTEX("实体", false, false),
    VERTEX_MAIN("主实体", false, false),
    EDGE("普通边", false, true),
    EDGE_DETAIL("明细边", false, true),
    EDGE_SUMMARY("汇总边", true, true),
    EDGE_DM("挖掘边", true, true);

    private String label;
    private boolean hidden;
    private boolean edge;

    SchemaType(String label, boolean hidden, boolean edge) {
        this.label = label;
        this.hidden = hidden;
        this.edge = edge;
    }

    public boolean isEdge(){
        return edge;
    }

    public boolean isVertex(){
        return !edge;
    }

    public static boolean isVertex(SchemaType type) {
        return !isEdge(type);
    }

    public static boolean isMainVertex(SchemaType type) {
        return (type == VERTEX_MAIN);
    }

    public static boolean isEdge(SchemaType type) {
        return type.edge;
    }
}
