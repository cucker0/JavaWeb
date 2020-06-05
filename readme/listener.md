Listener监听器
==

## listener监听器概念
```text
什么是监听器？监听器就是实时监视一些事物状态的程序，我们称为监听器。

java web 三大组件：Servlet、Filter、Listener

Listener有8个监听器
```

## listenner监听器分类
```text
生命周期监听器、属性监听器，一定要在web.xml文件中配置之后才会生效
```

* 生命周期监听器
    * javax.servlet.ServletContextListener
        >ServletContext监听器
    * javax.servlet.ServletRequestListener
        ```text
        ServletRequest监听器
        * 每次请求进来时，创建一个request对象
        * 请求完成时，销毁该request对象
        ```
    * javax.servlet.http.HttpSessionListener
        ```text
        HttpSession监听器
        * 首次需要使用session时，创建一个session对象
        * session对象自动超时的时候(过了最大不活动时间)或手动执行 session.invalidate()方法使session无效时，销毁该session对象
  
        idea设置了开启tomcat自动打开浏览器时，首次会发起两次相同的请求，都是请求项目的根路径
        ```
* 属性监听器
    * javax.servlet.ServletContextAttributeListener
        >ServletContext属性监听器
    * javax.servlet.http.HttpSessionAttributeListener
        >HttpSession属性监听器
    * javax.servlet.ServletRequestAttributeListener
        >Request属性监听器
* 对象监听器
    * javax.servlet.http.HttpSessionActivationListener
        >保存到Session域中的对象，活化和钝化的监听器
    * javax.servlet.http.HttpSessionBindingListener
        >对象被绑定到Session域中的监听器