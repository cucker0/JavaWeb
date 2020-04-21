bookmall_v7
==

## /pages/manager/目录下的资源要求登录后才能访问
* [新建ManagerFilter，实现鉴权逻辑](../bookmall_v7/src/com/bookmall/filter/ManagerFilter.java)
* web.xml配置Filter
    ```xml
    <web-app>
    
        <!-- filter与类 mapping -->
        <filter>
            <filter-name>ManagerFilter</filter-name>
            <filter-class>com.bookmall.filter.ManagerFilter</filter-class>
        </filter>
        <!-- filter、url mapping -->
        <filter-mapping>
            <filter-name>ManagerFilter</filter-name>
            <!-- 需要登录才能访问 /pages/manager/*  -->
            <url-pattern>/pages/manager/*</url-pattern>
        </filter-mapping>
    
    </web-app>
    ```
* 重启tomcat即可

## Filter、ThreadLoad组合来管理事务

