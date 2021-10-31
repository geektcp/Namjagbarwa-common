package com.okhoxi.common.spring.config;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 全局拦截器
 * @author Mr.Tang
 * @date 2021/8/17 14:40
 */
@Component
public class GlobalResponseHeaderFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String rToken = httpServletRequest.getHeader("r-token");
        if(StringUtils.isNotBlank(rToken)){
            httpServletResponse.addHeader("r-token", rToken);
        }
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
