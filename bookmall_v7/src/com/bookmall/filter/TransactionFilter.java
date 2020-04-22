package com.bookmall.filter;

import com.bookmall.utils.C3p0Utils;

import javax.servlet.*;
import java.io.IOException;

/**
 * 管理事务
 */
public class TransactionFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        try {
            // 进入执行原本的逻辑
            chain.doFilter(req, resp);
            // 提交事务
            C3p0Utils.commitTransaction();
        } catch (Exception e) {
            // 回滚事务
            C3p0Utils.rollbackTransaction();
            throw e; // 此处的错误会被tomcat捕获到，可触发设置的默认错误页面
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
