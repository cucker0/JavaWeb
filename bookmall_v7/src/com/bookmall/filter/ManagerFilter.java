package com.bookmall.filter;

import com.bookmall.bean.User;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 访问/admin/*下的所有资源要求登录
 */
public class ManagerFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;
        User user = (User) httpServletRequest.getSession().getAttribute("user");
        // 已登录，放行，继续执行后续的流程
        if (user != null) {
            chain.doFilter(req, resp);
        }
        // 未登录，跳转到登录页
        else {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+ "/pages/user/login.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
