package com.liuchang.cloud_zuul.filter;

import com.liuchang.cloud_zuul.ZuulApplication;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;


@Component
public class LoginFiter extends ZuulFilter {


    @Override
    public String filterType() {//过滤类型
        return "pre";
    }

    @Override
    public int filterOrder() {//过滤顺序
        return 1;
    }

    @Override
    public boolean shouldFilter() {//是否启用
        return true;
    }

    @Override
    public Object run() throws ZuulException {//过滤方法
        // 登录校验逻辑。
        // 1）获取Zuul提供的请求上下文对象
        RequestContext ctx = RequestContext.getCurrentContext();
        // 2) 从上下文中获取request对象
        HttpServletRequest req = ctx.getRequest();
        // 3) 从请求中获取token
        String token = req.getParameter("access-token");
        // 4) 判断
        if(token == null || "".equals(token.trim())){
            // 没有token，登录校验失败，拦截
            ctx.setSendZuulResponse(false);
            // 返回401状态码。也可以考虑重定向到登录页。
            ctx.setResponseStatusCode(HttpStatus.UNAUTHORIZED.value());
        }
        // 校验通过，可以考虑把用户信息放入上下文，继续向后执行
        return null;
    }
    }

