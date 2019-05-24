package com.mateacademy.springmvc.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class UserInterceptor extends HandlerInterceptorAdapter {
    private static final Logger LOGGER = LoggerFactory.getLogger("StudentInterceptor");
    @Override
    public boolean preHandle(HttpServletRequest requestServlet,
                             HttpServletResponse responseServlet, Object handler) throws Exception {
        LOGGER.info("-----Interceptor preHandle called");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        LOGGER.info("-----Interceptor postHandle called");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception exception) throws Exception {
        LOGGER.info("-----Interceptor afterCompletion called");
    }
}
