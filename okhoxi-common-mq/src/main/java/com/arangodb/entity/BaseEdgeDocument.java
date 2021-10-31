package com.arangodb.entity;

import com.arangodb.entity.DocumentField.Type;
import lombok.Data;

import java.util.Map;

/**
 * @author Mr.Tang on 2021/10/19 14:09.
 */
@Data
public class BaseEdgeDocument extends BaseDocument {
    private static final long serialVersionUID = 6904923804449368783L;
    @DocumentField(Type.FROM)
    private String from;
    @DocumentField(Type.TO)
    private String to;

    public BaseEdgeDocument() {
    }

    public BaseEdgeDocument(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public BaseEdgeDocument(String key, String from, String to) {
        super(key);
        this.from = from;
        this.to = to;
    }

    public BaseEdgeDocument(Map<String, Object> properties) {
        super(properties);
        Object tmpFrom = properties.remove(Type.FROM.getSerializeName());
        if (tmpFrom != null) {
            this.from = tmpFrom.toString();
        }

        Object tmpTo = properties.remove(Type.TO.getSerializeName());
        if (tmpTo != null) {
            this.to = tmpTo.toString();
        }

    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BaseDocument [documentRevision=");
        sb.append(this.revision);
        sb.append(", documentHandle=");
        sb.append(this.id);
        sb.append(", documentKey=");
        sb.append(this.key);
        sb.append(", from=");
        sb.append(this.from);
        sb.append(", to=");
        sb.append(this.to);
        sb.append(", properties=");
        sb.append(this.properties);
        sb.append("]");
        return sb.toString();
    }


}
