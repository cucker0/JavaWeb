Listener监听器
==

## Table Of Contents
* [listener监听器概念](#listener监听器概念)
* [listenner监听器分类](#listenner监听器分类)
    * [生命周期监听器(全局有效，必须在web.xml中配置注册监听器)](#生命周期监听器全局有效必须在web.xml中配置注册监听器)
    * [属性监听器(全局有效，必须在web.xml中配置注册监听器)](#属性监听器全局有效必须在web.xml中配置注册监听器)
    * [对象监听器(只对实现了相应接口的类的对象有效果，不需要在web.xml配置注册监听器)](#对象监听器只对实现了相应接口的类的对象有效果不需要在web.xml配置注册监听器)


## listener监听器概念
```text
什么是监听器？监听器就是实时监视一些事物状态的程序，我们称为监听器。

java web 三大组件：Servlet、Filter、Listener

Listener有8个监听器
```

## listenner监听器分类
```text
生命周期监听器、属性监听器，一定要在web.xml文件中配置之后才会生效


通过HttpSession监听器，把每次新建的session对象保存到一个自定义的map中，
其他会话读取该map时，仍然只能读取到该会话的session对象，
这是tomcat servlet api安全权限的限制
```

### 生命周期监听器(全局有效，必须在web.xml中配置注册监听器)
```text
都有两个方法
* 对象创建时
* 对象销毁时
```

* javax.servlet.ServletContextListener
    ```text
    ServletContext监听器
    * 在启动tomcat时创建ServletContext对象
    * 在正常关闭tomcat时销毁ServletContext对象
    ```
* javax.servlet.ServletRequestListener
    ```text
    ServletRequest监听器
    * 每次请求进来时，创建一个request对象
    * 请求完成时，销毁该request对象
    ```
* javax.servlet.http.HttpSessionListener
    ```text
    HttpSession监听器
    * 首次需要使用session时(即request.getSession())，创建一个session对象
    * session对象自动超时的时候(过了最大不活动时间)或手动执行 session.invalidate()方法使session无效时，销毁该session对象

    idea设置了开启tomcat自动打开浏览器时，首次会发起两次相同的请求，都是请求项目的根路径
    ```
示例  
[ContextCycleListener](../Listener/src/com/java/listener/cycle/ServletContextCycleListener.java)  
[RequestCycleListener](../Listener/src/com/java/listener/cycle/RequestCycleListener.java)  
[SessionCycleListener](../Listener/src/com/java/listener/cycle/HttpSessionCycleListener.java)  
    
### 属性监听器(全局有效，必须在web.xml中配置注册监听器)
```text
都有3个方法，
* attributeAdded  添加了属性时
* attributeRemoved  移除了属性时
* attributeReplaced  更新了属性值时
```

* javax.servlet.ServletContextAttributeListener
    >ServletContext属性监听器
* javax.servlet.http.HttpSessionAttributeListener
    >HttpSession属性监听器
* javax.servlet.ServletRequestAttributeListener
    >Request属性监听器
    
示例  
[ContextAttributeListener](../Listener/src/com/java/listener/attribute/ContextAttributeListener.java)  
[RequestAttributeListener](../Listener/src/com/java/listener/attribute/RequestAttributeListener.java)  
[SessionAttributeListener](../Listener/src/com/java/listener/attribute/SessionAttributeListener.java)  

    
### 对象监听器(只对实现了相应接口的类的对象有效果，不需要在web.xml配置注册监听器)
* javax.servlet.http.HttpSessionActivationListener
    ```text
    保存到Session域中的对象，活化和钝化的监听器

    * public void sessionWillPassivate(HttpSessionEvent se)
    在session钝化时，当前对象自动执行的函数
    在tomcat正常关闭时执行

    * public void sessionDidActivate(HttpSessionEvent se)
    在session活化时，当前对象自动执行的函数
    在启动tomcat时执行
    ```
    示例  
    [对象类实现HttpSessionActivationListener、Serializable接口](../Listener/src/com/java/bean/Person.java)  
    [测试](../Listener/web/sessionActivationListener.jsp)
* javax.servlet.http.HttpSessionBindingListener
    ```text
    对象被绑定到Session域中的监听器

    * public void valueBound(HttpSessionBindingEvent event)
    对象在绑定为session对象的属性值时，自动调用的函数
        session对象添加一个属性，值设置为该对象时
        把session的key值修改给此对象，也会触发
    
    * public void valueUnbound(HttpSessionBindingEvent event)
    对象作为session对象的属性值在解绑时，自动调用的函数
    即删除session的属性值为该对象的属性在删除的时候，或是原session key为该类对象的值被修改为其他任何值的时候
    ```
    示例  
    [对象类实现HttpSessionBindingListener接口](../Listener/src/com/java/bean/User.java)  
    [测试](../Listener/web/sessionBindingListener.jsp)