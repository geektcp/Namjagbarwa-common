package com.okhoxi.common.spring.interceptor;


import com.okhoxi.common.spring.context.TraceHelper;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mr.Tang
 * @date :2021-07-09
 * @description : 请求拦截，添加traceId 到mdc中
 */
public class TraceInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String traceIdVal = request.getHeader(TraceHelper.TRACE_ID);
        if (StringUtils.isNotEmpty(traceIdVal)) {
            MDC.put(TraceHelper.TRACE_ID, traceIdVal);
        } else {
            MDC.remove(TraceHelper.TRACE_ID);
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
