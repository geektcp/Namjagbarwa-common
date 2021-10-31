package com.okhoxi.common.metric.model;


/**
 * @author Mr.Tang
 * @date 2021/7/7 11:14
 */
public class MonitorInfoVo {

    /**
     * 可使用内存
     */
    private long totalMemory;

    /**
     * 剩余内存
     */
    private long freeMemory;

    /**
     * 最大可使用内存
     */
    private long maxMemory;

    /**
     * 总的物理内存
     */
    private long totalMemorySize;

    /**
     * 剩余的物理内存
     */
    private long freePhysicalMemorySize;

    /**
     * 已使用的物理内存
     */
    private long usedMemory;

    /**
     * 活跃线程 总数
     */
    private int activeThread;

    /**
     * 所有线程总数
     */
    private long totalThread;

    /**
     * cpu使用率 0到1直接， 可能出现大于1的情况
     */
    private double cpuRatio;


    public long getTotalMemory() {
        return totalMemory;
    }

    public void setTotalMemory(long totalMemory) {
        this.totalMemory = totalMemory;
    }

    public long getFreeMemory() {
        return freeMemory;
    }

    public void setFreeMemory(long freeMemory) {
        this.freeMemory = freeMemory;
    }

    public long getMaxMemory() {
        return maxMemory;
    }

    public void setMaxMemory(long maxMemory) {
        this.maxMemory = maxMemory;
    }

    public long getTotalMemorySize() {
        return totalMemorySize;
    }

    public void setTotalMemorySize(long totalMemorySize) {
        this.totalMemorySize = totalMemorySize;
    }

    public long getFreePhysicalMemorySize() {
        return freePhysicalMemorySize;
    }

    public void setFreePhysicalMemorySize(long freePhysicalMemorySize) {
        this.freePhysicalMemorySize = freePhysicalMemorySize;
    }

    public long getUsedMemory() {
        return usedMemory;
    }

    public void setUsedMemory(long usedMemory) {
        this.usedMemory = usedMemory;
    }

    public int getActiveThread() {
        return activeThread;
    }

    public void setActiveThread(int activeThread) {
        this.activeThread = activeThread;
    }

    public long getTotalThread() {
        return totalThread;
    }

    public void setTotalThread(long totalThread) {
        this.totalThread = totalThread;
    }

    public double getCpuRatio() {
        return cpuRatio;
    }

    public void setCpuRatio(double cpuRatio) {
        this.cpuRatio = cpuRatio;
    }
}
