package com.arangodb.entity;

import com.arangodb.entity.DocumentField.Type;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.Tang on 2021/10/19 14:05.
 */

@Data
public class BaseDocument implements Serializable {
    private static final long serialVersionUID = -1824742667228719116L;
    @DocumentField(Type.ID)
    protected String id;
    @DocumentField(Type.KEY)
    protected String key;
    @DocumentField(Type.REV)
    protected String revision;
    protected Map<String, Object> properties;

    public BaseDocument() {
        this.properties = new HashMap();
    }

    public BaseDocument(String key) {
        this();
        this.key = key;
    }

    public BaseDocument(Map<String, Object> properties) {
        this();
        Object tmpId = properties.remove(Type.ID.getSerializeName());
        if (tmpId != null) {
            this.id = tmpId.toString();
        }

        Object tmpKey = properties.remove(Type.KEY.getSerializeName());
        if (tmpKey != null) {
            this.key = tmpKey.toString();
        }

        Object tmpRev = properties.remove(Type.REV.getSerializeName());
        if (tmpRev != null) {
            this.revision = tmpRev.toString();
        }

        this.properties = properties;
    }

    public void addAttribute(String key, Object value) {
        this.properties.put(key, value);
    }

    public void updateAttribute(String key, Object value) {
        if (this.properties.containsKey(key)) {
            this.properties.put(key, value);
        }

    }

    public Object getAttribute(String key) {
        return this.properties.get(key);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("BaseDocument [documentRevision=");
        sb.append(this.revision);
        sb.append(", documentHandle=");
        sb.append(this.id);
        sb.append(", documentKey=");
        sb.append(this.key);
        sb.append(", properties=");
        sb.append(this.properties);
        sb.append("]");
        return sb.toString();
    }


}
