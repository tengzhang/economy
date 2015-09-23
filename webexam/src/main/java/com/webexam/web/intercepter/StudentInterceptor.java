package com.webexam.web.intercepter;

import com.webexam.common.utils.WebConstants;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * StudentInterceptor
 *
 * @author: zhangteng
 * @time: 14-2-5 下午1:07
 */
public class StudentInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Integer uid = (Integer) request.getSession().getAttribute(WebConstants.STUSESSIONUID);

        if(uid != null) {
            return true;
        }

        String requestUrl = request.getRequestURL().toString();
        if(requestUrl.indexOf("login") > -1) {
            return true;
        }

        String forReturn = request.getScheme() + "://"
                           + request.getServerName() + ":"
                           + request.getServerPort()
                           + request.getContextPath();
        response.sendRedirect(forReturn + "/student/login");

        return false;
    }
}
