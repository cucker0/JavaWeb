package com.java.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 测试Filter的生命周期
 */
public class Filter2 implements Filter {

    // 构造器
    public Filter2() {
        System.out.println("Filter2 构造器");
    }

    // 销毁方法，在tomcat关闭时执行
    @Override
    public void destroy() {
        System.out.println("Filter2 destroy销毁方法执行了...");
    }

    // 过滤方法，每次访问此Filter拦截的URL是都执行，在web.xml文件中设置
    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("Filter2 doFilter过滤方法执行了...");
        // 要执行chain.doFilter(req, resp);用户才能访问到URL上指向的资源
        chain.doFilter(req, resp);
    }

    // 初始化方法，在tomcat启动时执行
    @Override
    public void init(FilterConfig config) throws ServletException {
        System.out.println("Filter2 init初始化方法执行了...");

        // 获取Filter名称
        String filterName = config.getFilterName();
        System.out.println("filterName: " + filterName);
        // 获取filter初始化参数
        String sn = config.getInitParameter("sn");
        System.out.println("sn: " + sn);
        // 获取ServletContext的对象实例
        ServletContext context = config.getServletContext();
        System.out.println("ServletContext: " + context);

        /*
        打印结果：
Filter2 init初始化方法执行了...
filterName: Filter2
sn: s1001
ServletContext: org.apache.catalina.core.ApplicationContextFacade@7d21a5f5
        * */
    }

}
