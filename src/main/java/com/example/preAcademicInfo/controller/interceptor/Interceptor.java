package com.example.preAcademicInfo.controller.interceptor;

import com.example.preAcademicInfo.service.UserService;
import com.example.preAcademicInfo.utils.ContextProvider;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interceptor extends HandlerInterceptorAdapter {

    private UserService userService;

    public Interceptor() {
        userService = ContextProvider.getBean(UserService.class);
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (handler instanceof HandlerMethod) {
            RequestMapping rm = ((HandlerMethod) handler).getMethodAnnotation(RequestMapping.class);

            boolean alreadyLoggedIn = request.getSession()
                    .getAttribute("username") != null;
            boolean loginPageRequested = rm != null && rm.value().length > 0 && "/login".equals(
                    rm.value()[0]);
            if (alreadyLoggedIn && loginPageRequested) {
                response.sendRedirect(request.getContextPath() + "/home");
                return false;
            } else if (!alreadyLoggedIn && !loginPageRequested) {
                response.sendRedirect(request.getContextPath() + "/login");
                return false;
            }
        }
        return true;
    }


    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView
            modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception
            ex) throws Exception {

    }


}
