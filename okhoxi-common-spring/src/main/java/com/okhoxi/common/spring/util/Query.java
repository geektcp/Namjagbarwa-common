package com.okhoxi.common.spring.util;

import org.apache.commons.collections4.MapUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 查询参数
 */
public class Query extends LinkedHashMap<String, Object> {
    private static final long serialVersionUID = 1L;
    //当前页码
    private int page = 1;
    //每页条数
    private int limit = 10;

    public Query(Map<String, Object> params) {
        if(MapUtils.isEmpty(params)){
            return;
        }
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            String key = entry.getKey();
            if(StringUtils.isBlank(key)){
                continue;
            }
            Object value = entry.getValue();
            if(value == null){
                continue;
            }
            if(value instanceof String && StringUtils.isBlank((String)value)){
                continue;
            }
            this.put(key, value);
        }
        //分页参数
        if (params.get("page") != null) {
            this.page = Integer.parseInt(params.get("page").toString());
            this.remove("page");
        }
        if (params.get("limit") != null) {
            this.limit = Integer.parseInt(params.get("limit").toString());
            this.remove("limit");
        }
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
