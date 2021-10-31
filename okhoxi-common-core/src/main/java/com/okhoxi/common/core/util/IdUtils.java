package com.okhoxi.common.core.util;

import java.util.Objects;

/**
 * @author Mr.Tang on 2018/2/27 10:10.
 */
@SuppressWarnings("all")
public class IdUtils {

    private static final long START_TIME = 1420041600000L;
    private static final long WORKER_ID_BITS = 5L;
    private static final long DATA_CENTER_ID_BITS = 5L;
    private static final long MAX_WORKER_ID = -1L ^ (-1L << WORKER_ID_BITS);
    private static final long MAX_DATA_CENTER_ID = -1L ^ (-1L << DATA_CENTER_ID_BITS);
    private static final long SEQUENCE_BITS = 12L;
    private static final long WORKER_ID_SHIFT = SEQUENCE_BITS;
    private static final long DATA_CENTER_ID_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;
    private static final long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS + DATA_CENTER_ID_BITS;
    private static final long SEQUENCE_MASK = -1L ^ (-1L << SEQUENCE_BITS);

    private static long SEQUENCE = 0L;
    private static long LAST_TIMESTAMP = -1L;

    private long workerId;
    private long dataCenterId;

    private static IdUtils instance;

    private IdUtils(long workerId, long datacenterId) {
        if (workerId > MAX_WORKER_ID || workerId < 0) {
            throw new IllegalArgumentException(
                    String.format("worker Id can't be greater than %d or less than 0", MAX_WORKER_ID));
        }
        if (datacenterId > MAX_DATA_CENTER_ID || datacenterId < 0) {
            throw new IllegalArgumentException(
                    String.format("datacenter Id can't be greater than %d or less than 0", MAX_DATA_CENTER_ID));
        }
        this.workerId = workerId;
        this.dataCenterId = datacenterId;
    }

    private synchronized long nextId() {
        long timestamp = timeGen();
        if (timestamp < LAST_TIMESTAMP) {
            throw new RuntimeException(String.format(
                    "Clock moved backwards.  Refusing to generate id for %d milliseconds", LAST_TIMESTAMP - timestamp));
        }

        if (LAST_TIMESTAMP == timestamp) {
            SEQUENCE = (SEQUENCE + 1) & SEQUENCE_MASK;
            if (SEQUENCE == 0) {
                timestamp = tilNextMillis(LAST_TIMESTAMP);
            }
        } else {
            SEQUENCE = 0L;
        }

        LAST_TIMESTAMP = timestamp;

        return ((timestamp - START_TIME) << TIMESTAMP_LEFT_SHIFT)
                | (dataCenterId << DATA_CENTER_ID_SHIFT)
                | (workerId << WORKER_ID_SHIFT)
                | SEQUENCE;
    }

    private long tilNextMillis(long lastTimestamp) {
        long timestamp = timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = timeGen();
        }
        return timestamp;
    }

    private long timeGen() {
        return System.currentTimeMillis();
    }

    public static IdUtils getInstance() {
        if (Objects.isNull(instance)) {
            instance = new IdUtils(10L, 0L);
        }
        return instance;
    }

    public static Long getId() {
        return getInstance().nextId();
    }

    public static String getId(String pre) {
        return pre + "_" + getId();
    }

}
