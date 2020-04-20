package com.java.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Filter1 implements Filter {
    // 销毁方法
    public void destroy() {
    }

    /**
     * 拦截(过滤)request、response
     *
     * @param req
     * @param resp
     * @param chain
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        // req类型强转为其子类HttpServletRequest
        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
        // resp类型强转为其子类HttpServletResponse
        HttpServletResponse httpServletResponse = (HttpServletResponse) resp;

        String username = (String) httpServletRequest.getSession().getAttribute("username");
        // 鉴权
        if (username != null) {
            // request方向，通过了此Filter，进入下一个环节，访问客户端指定的资源或匹配下一个Filter
            chain.doFilter(req, resp);
        } else {
            httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login.jsp");
        }
    }

    // 初始化方法
    public void init(FilterConfig config) throws ServletException {

    }
}
