package com.okhoxi.common.spring.context;

import java.util.UUID;

/**
 *
 * @author Mr.Tang
 * @date :2021-07-09
 * @description : 生成 trace
 */
public class TraceHelper {

    public static final String TRACE_ID = "traceId";

    /**
     * 生成 traceid
     *
     * @return traceId
     */
    public static String getTraceId() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
