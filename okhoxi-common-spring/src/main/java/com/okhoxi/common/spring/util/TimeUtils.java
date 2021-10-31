package com.okhoxi.common.spring.util;

import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@Component
public class TimeUtils {
    public long getCurrentTick() {
        LocalDateTime time = LocalDateTime.now();
        return time.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }

    public String now(String format) {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);
        LocalDateTime time = LocalDateTime.now();
        return time.format(dtf);
    }
}
