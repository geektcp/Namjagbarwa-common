package com.okhoxi.common.spring.constant;

import java.util.EnumSet;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by Mr.Tang on 2018/8/17.
 */
public enum StorageType {
    GDB("GDB", false, new String[]{}),
    UNKNOWN("unknown", false, new String[]{});

    private static final Map<String, StorageType> codeLookup = new ConcurrentHashMap<>(6);

    static {
        for (StorageType type : EnumSet.allOf(StorageType.class)){
            codeLookup.put(type.name.toLowerCase(), type);
        }
    }

    private boolean isHadoopPlatform;
    private String name;
    private String[] configFile;
    StorageType(String name, boolean isHadoopPlatform, String[] configFile){
        this.name = name;
        this.isHadoopPlatform = isHadoopPlatform;
        this.configFile = configFile;
    }

    public String getName() {
        return name;
    }

    public boolean isHadoopPlatform() {
        return isHadoopPlatform;
    }

    public String[] getConfigFile() {
        return configFile;
    }

    public static StorageType fromCode(String code) {
        if (code == null){
            return StorageType.UNKNOWN;
        }
        StorageType data = codeLookup.get(code.toLowerCase());
        if (data == null) {
            return StorageType.UNKNOWN;
        }
        return data;
    }
}
