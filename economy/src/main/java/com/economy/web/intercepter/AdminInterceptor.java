package com.economy.web.intercepter;

import com.economy.common.utils.WebConstants;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 后台拦截器
 *
 * @author: zhangteng
 * @time: 14-1-16 下午2:43
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Integer uid = (Integer) request.getSession().getAttribute(WebConstants.SESSIONUID);

        if(uid != null) {
            return true;
        }

        String requestUrl = request.getRequestURL().toString();
        // 如果是登陆请求，跳转到登陆页
        if(requestUrl.indexOf("login") > -1) {
            return true;
        }

        String forReturn = request.getScheme() + "://"
                           + request.getServerName() + ":"
                           + request.getServerPort()
                           + request.getContextPath();
        response.sendRedirect(forReturn + "/admin/login");

        return false;
    }

}
