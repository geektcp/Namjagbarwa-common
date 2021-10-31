package com.okhoxi.common.spring.util;

import org.springframework.util.Base64Utils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

public class HttpRequestHeadUtil {

    private HttpRequestHeadUtil() {
    }

    public static String getValueByKey(String key) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (Objects.isNull(requestAttributes)) {
            return "";
        }
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        Object value = request.getHeader(key);
        if (Objects.isNull(value)) {
            value = request.getAttribute(key);
        }
        if (Objects.isNull(value)) {
            return "";
        }
        return value.toString();

    }

    public static boolean setValueByKey(String key, String tenantId) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes == null) {
            return false;
        }
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        if (request == null) {
            return false;
        } else {
            String value = request.getHeader(key);
            request.setAttribute(key, tenantId);
            return true;
        }
    }

    public static String getCurUserName() {
        String authorization = getValueByKey("Authorization");
        return new String(Base64Utils.decodeFromString(authorization));
    }

    public static String getCurUID() {
        return getValueByKey("userId");
    }

    public static String getCurTenantId() {
        return getValueByKey("tenantId");
    }

    public static String getCurUType() {
        return getValueByKey("userType");
    }

    public static boolean setCurTenantId(String tenantId) {
        return setValueByKey("tenantId", tenantId);
    }

    public static String getCurName() {
        return getValueByKey("name");
    }

    public static String getCurIp() {
        return getValueByKey("ip");
    }

    public static boolean setCurName(String name) {
        return setValueByKey("name", name);
    }

    public static boolean setCurIp(String ip) {
        return setValueByKey("ip", ip);
    }
}
