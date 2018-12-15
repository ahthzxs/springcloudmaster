package com.zxs.mine.api.interceptor;

import com.zxs.mine.api.exception.UserLoginException;
import com.zxs.mine.api.utils.JwtUtil;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class JwtInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        //System.out.println("-------------->"+request.getPathInfo());

        String authHeader = request.getHeader("Authorization");


        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            throw new UserLoginException("用户未登录");
        }

        //取得token
        String token = authHeader.substring(7,authHeader.length());
        System.out.println("token-------------->\n"+token);

        //验证token
        String userName = JwtUtil.validateToken(token);
        if("".equals(userName) || userName==null){
            System.out.println("token校验失败！");
        }else {
            System.out.println("已登陆用户："+userName);
        }


        request.setAttribute("username", userName);

        return true;

    }

}

