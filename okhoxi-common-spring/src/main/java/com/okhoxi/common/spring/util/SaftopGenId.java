package com.okhoxi.common.spring.util;

import com.okhoxi.common.core.util.IdUtils;
import com.okhoxi.common.spring.model.po.Po;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import tk.mybatis.mapper.genid.GenId;

import javax.persistence.Table;

@Slf4j
public class SaftopGenId implements GenId<String> {
    @Override
    public String genId(String table, String column) {
        return getId(table);
    }

    public static String getId(String tableName) {
        String prefix = StringUtils.substringAfter(tableName, "des_");
        return IdUtils.getId(prefix);
    }

    public static <A extends Po> String getIdByClass(Class<A> poClass) {
        String tableName = poClass.getAnnotation(Table .class).name();
        String prefix = StringUtils.substringAfter(tableName, "des_");
        return IdUtils.getId(prefix);
    }
}
