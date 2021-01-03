package com.luckyBoy.config.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.luckyBoy.base.ResponseResult;
import org.springframework.web.servlet.HandlerInterceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * 会话管理的路径拦截器
 * User: Listen-Y.
 * Date: 2021-01-03
 * Time: 10:52
 */

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("user") != null) {
            //进行了登录 可以执行Controller中的方法
            return true;
        }
        if (request.getRequestURI().contains("js") || request.getRequestURI().contains("css")
        || request.getRequestURI().contains("img") || request.getRequestURI().contains("3rd")) {
            //访问静态资源就放行
            return true;
        }
        //说明此时没有进行登录
        //不容许执行Controller中的方法
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode("SYS000");
        responseResult.setMessage("未进行登录");
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(responseResult);
        response.getWriter().write(jsonStr);
        response.getWriter().flush();
        response.sendRedirect("index.html");
        return false;
    }
}
