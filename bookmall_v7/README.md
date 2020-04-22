bookmall_v7
==

## Filter实现部分资源要求登录后才能访问
```text
/pages/manager/目录下的后台管理资源

订单的增删改查
```

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
为了能够管理事务，做一些一些调整
* C3p0Utils的改进
    [C3p0Utils](src/com/bookmall/utils/C3p0Utils.java)
    ```text
    添加threadLocal属性，用于保存获取的Connection对象
    
    修改getConnection方法，获取连接时，关闭事务自动提交功能，设置autocommit = 0 
    
    添加提交事务方法 commitTransaction()
    
    添加回滚事务方法 rollbackTransaction()
    ```
    
* BaseDao的改进
    [BaseDao4Transaction](src/com/bookmall/dao/BaseDao4Transaction.java)
    ```text
    在BaseDao的方法中，不要关闭connection，因为所有的操作都在使用同一个connection。
    所有的异常都往外抛，让Filter拦截后，做rollback事务回滚

    所有的Dao实现类都继承BaseDao4Transaction抽象类
    ```
* BaseServlet的改进
    [BaseServlet4Transaction](src/com/bookmall/web/BaseServlet4Transaction.java)
    ```text
    把异常往外抛
    ```
* 添加Filter实现类
    [TransactionFilter](src/com/bookmall/filter/TransactionFilter.java)
    ```text
    先执行原本的业务逻辑，在没有报错的情况下，提交事务并关闭连接(释放会连接池)；
    如果出错，则回滚事务，并关闭连接(释放会连接池)
    ```
* web.xml中设置Filter
    ```xml
    <web-app>
        <filter>
            <filter-name>TransactionFilter</filter-name>
            <filter-class>com.bookmall.filter.TransactionFilter</filter-class>
        </filter>
    
        <filter-mapping>
            <filter-name>TransactionFilter</filter-name>
            <url-pattern>/*</url-pattern>
        </filter-mapping>
        
    </web-app>
    ```

* 给tomcat配置默认的500错误页
    ```xml
    <web-app>
        <!-- 配置默认的错误页 -->
        <error-page>
            <!-- htpt 响应状态码-->
            <error-code>500</error-code>
            <location>/pages/err500.jsp</location>
        </error-page>
    
    </web-app>
    ```