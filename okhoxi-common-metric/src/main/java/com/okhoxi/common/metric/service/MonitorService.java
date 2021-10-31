package com.okhoxi.common.metric.service;

import com.okhoxi.common.metric.model.MonitorInfoVo;
import com.sun.management.OperatingSystemMXBean;

import java.lang.management.ThreadMXBean;

/**
 * @author Mr.Tang
 * @date 2021/7/7 11:16
 */
public class MonitorService {
    private static MonitorService instance = new MonitorService();
    private static final int KB = 1024 * 1024;

    private OperatingSystemMXBean osmxb;
    private ThreadMXBean threadBean;

    public static MonitorService getInstance() {
        return instance;
    }

    /**
     * 获得当前的监控对象
     *
     * @return
     */
    public MonitorInfoVo getMonitorInfo() {
        // 可使用内存
        long totalMemory = Runtime.getRuntime().totalMemory() / KB;
        // 剩余内存
        long freeMemory = Runtime.getRuntime().freeMemory() / KB;
        // 最大可使用内存
        long maxMemory = Runtime.getRuntime().maxMemory() / KB;
        // 总的物理内存
        long totalMemorySize = osmxb.getTotalPhysicalMemorySize() / KB;
        // 剩余的物理内存
        long freePhysicalMemorySize = osmxb.getFreePhysicalMemorySize() / KB;
        // 已使用的物理内存
        long usedMemory = (osmxb.getTotalPhysicalMemorySize() - osmxb.getFreePhysicalMemorySize()) / KB;

        // 活动线程
        int activeCount = threadBean.getThreadCount();
        long totalThread = threadBean.getTotalStartedThreadCount();
        MonitorInfoVo infoBean = new MonitorInfoVo();
        infoBean.setFreeMemory(freeMemory);
        infoBean.setFreePhysicalMemorySize(freePhysicalMemorySize);
        infoBean.setMaxMemory(maxMemory);
        infoBean.setTotalMemory(totalMemory);
        infoBean.setTotalMemorySize(totalMemorySize);
        infoBean.setTotalThread(totalThread);
        infoBean.setActiveThread(activeCount);
        infoBean.setUsedMemory(usedMemory);
        infoBean.setCpuRatio(osmxb.getProcessCpuLoad());
        return infoBean;
    }

}
