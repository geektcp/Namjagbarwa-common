package com.okhoxi.common.spring.util;

import com.okhoxi.common.spring.model.vo.HttpContextInfo;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.Date;


/**
 * 实体类相关工具类
 * <p>
 * 解决问题： 1、快速对实体的常驻字段，如：createBy、crtHost、updateBy等值快速注入
 *
 * @author Mr.Tang
 * @version 1.0
 * @date 2016年4月18日
 * @since 1.7
 */
public class EntityUtils {
    /**
     * 快速将bean的createBy、crtHost、createDate、updateBy、updHost、updateDate附上相关值
     *
     * @param entity 实体bean
     * @author Mr.Tang
     */
    public static <T> void setCreatAndUpdatInfo(T entity) {
        setCreateInfo(entity);
        setUpdatedInfo(entity);
        setTenantId(entity);
    }


    public static <T> void setTenantId(T entity) {
        // 默认属性
        String tenantId = HttpRequestHeadUtil.getValueByKey("tenantId");
        String[] fields = {"tenantId"};
        // 默认值
        Object[] value = new Object[]{tenantId};
        // 填充默认属性值
        setDefaultValues(entity, fields, value);
    }

    /**
     * 快速将bean的createBy、crtHost、createDate附上相关值
     *
     * @param entity 实体bean
     * @author Mr.Tang
     */
    public static <T> void setCreateInfo(T entity) {
        String hostIp = HttpRequestHeadUtil.getValueByKey("userHost");
        String name = HttpRequestHeadUtil.getValueByKey("userName");
        String id = HttpRequestHeadUtil.getValueByKey("userId");
        try {
            name = URLDecoder.decode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        // 默认属性

        String[] fields = {"crtName", "createBy", "crtHost", "createDate"};
        Field field = ReflectionUtils.getAccessibleField(entity, "createDate");
        // 默认值

        Object[] value = null;
        if (field != null && field.getType().equals(Date.class)) {
            value = new Object[]{name, id, hostIp, new Date()};
        }
        // 填充默认属性值

        setDefaultValues(entity, fields, value);
    }

    /**
     * 快速将bean的updateBy、updHost、updateDate附上相关值
     *
     * @param entity 实体bean
     * @author Mr.Tang
     */
    public static <T> void setUpdatedInfo(T entity) {
        String hostIp = HttpRequestHeadUtil.getValueByKey("userHost");
        String name = HttpRequestHeadUtil.getValueByKey("userName");
        String id = HttpRequestHeadUtil.getValueByKey("userId");
        try {
            name = URLDecoder.decode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        // 默认属性
        String[] fields = {"updName", "updateBy", "updHost", "updateDate"};
        Field field = ReflectionUtils.getAccessibleField(entity, "updateDate");
        Object[] value = null;
        if (field != null && field.getType().equals(Date.class)) {
            value = new Object[]{name, id, hostIp, new Date()};
        }
        // 填充默认属性值

        setDefaultValues(entity, fields, value);
    }

    /**
     * 依据对象的属性数组和值数组对对象的属性进行赋值
     *
     * @param entity 对象
     * @param fields 属性数组
     * @param value  值数组
     * @author Mr.Tang
     */
    private static <T> void setDefaultValues(T entity, String[] fields, Object[] value) {
        for (int i = 0; i < fields.length; i++) {
            String field = fields[i];
            if (ReflectionUtils.hasField(entity, field)) {
                ReflectionUtils.invokeSetter(entity, field, value[i]);
            }
        }
    }

    /**
     * 根据主键属性，判断主键是否值为空
     *
     * @param entity
     * @param field
     * @return 主键为空，则返回false；主键有值，返回true
     * @author Mr.Tang
     * @date 2016年4月28日
     */
    public static <T> boolean isPKNotNull(T entity, String field) {
        if (!ReflectionUtils.hasField(entity, field))
            return false;
        Object value = ReflectionUtils.getFieldValue(entity, field);
        return value != null && !"".equals(value);
    }

    public static <T> void setCreatAndUpdatInfo(T entity, HttpContextInfo info) {
        setCreateInfo(entity, info);
        setUpdatedInfo(entity, info);
        setTenantId(entity, info);
    }

    public static <T> void setCreateInfo(T entity, HttpContextInfo info) {
        String hostIp = info.getHostIp();
        String name = info.getUserName();
        String id = info.getUserId().toString();
        try {
            name = URLDecoder.decode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {

        }
        // 默认属性

        String[] fields = {"crtName", "createBy", "crtHost", "createDate"};
        Field field = ReflectionUtils.getAccessibleField(entity, "createDate");
        // 默认值

        Object[] value = null;
        if (field != null && field.getType().equals(Date.class)) {
            value = new Object[]{name, id, hostIp, new Date()};
        }
        // 填充默认属性值

        setDefaultValues(entity, fields, value);
    }

    public static <T> void setUpdatedInfo(T entity, HttpContextInfo info) {
        String hostIp = info.getHostIp();
        String name = info.getUserName();
        String id = info.getUserId().toString();
        try {
            name = URLDecoder.decode(name, "UTF-8");
        } catch (UnsupportedEncodingException e) {

        }
        // 默认属性
        String[] fields = {"updName", "updateBy", "updHost", "updateDate"};
        Field field = ReflectionUtils.getAccessibleField(entity, "updateDate");
        Object[] value = null;
        if (field != null && field.getType().equals(Date.class)) {
            value = new Object[]{name, id, hostIp, new Date()};
        }
        // 填充默认属性值

        setDefaultValues(entity, fields, value);
    }

    public static <T> void setTenantId(T entity, HttpContextInfo info) {
        // 默认属性
        String tenantId = info.getTenantId();
        String[] fields = {"tenantId"};
        // 默认值
        Object[] value = new Object[]{tenantId};
        // 填充默认属性值
        setDefaultValues(entity, fields, value);
    }

    public static HttpContextInfo getHttpContextInfo() {
        HttpContextInfo info = new HttpContextInfo();
//        info.setTenantId(HttpRequestHeadUtil.getValueByKey("tenantId"));
//        info.setHostIp(HttpRequestHeadUtil.getValueByKey("userHost"));
//        info.setUserName(HttpRequestHeadUtil.getValueByKey("userName"));
//        info.setUserId(Integer.parseInt(HttpRequestHeadUtil.getValueByKey("userId")));
//        info.setUserType(Integer.parseInt(HttpRequestHeadUtil.getValueByKey("userType")));
        return info;
    }
}
