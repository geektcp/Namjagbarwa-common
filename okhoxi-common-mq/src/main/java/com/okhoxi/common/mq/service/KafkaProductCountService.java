package com.okhoxi.common.mq.service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Mr.Tang
 * @date 2021/9/26 10:32
 */
public class KafkaProductCountService {
    /**
     * spring-bean 单例模式下才能使用
     */
    public static final ConcurrentHashMap<String, AtomicLong> sendCountMap = new ConcurrentHashMap<String, AtomicLong>();

    public static void countConcurrentMap(String key) {
        AtomicLong oldValue = null;
        AtomicLong newValue = null;
        while (true) {
            oldValue = sendCountMap.get(key);
            if (oldValue == null) {
                oldValue = new AtomicLong(1L);
                if (sendCountMap.putIfAbsent(key, oldValue) == null) {
                    break;
                }
            } else {
                newValue = new AtomicLong(oldValue.get() + 1L);
                if (sendCountMap.replace(key, oldValue, newValue)) {
                    break;
                }
            }
        }
    }
}
