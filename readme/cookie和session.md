cookie和session
==


## 请求过程中的session操作
1. 首先要解析请求中的sessionId信息，然后将sessionId存储到request的参数列表中。

2. 然后再从 request获取session的时候，如果存在sessionId那么就根据Id从session池中获取session，如果sessionId不存在或者session失效，那么则新建session并且将session信息放入session池，供下次使用。


response headers
Set-Cookie: no=xs1001
当需要设置多个cookie时，就添加多条Set-Cookie: value


request headers
Cookie: no=xs1001

多个cookie值之间用;分隔


session最大不活动间隔时间(超时时间)


配置文件 conf/web.xml，这是对全局生效的

idea
${CATALINA_BASE}/conf/web.xml
```text
  <!-- ==================== Default Session Configuration ================= -->
  <!-- You can set the default session timeout (in minutes) for all newly   -->
  <!-- created sessions by modifying the value below.                       -->

    <session-config>
        <session-timeout>30</session-timeout>
    </session-config>
```


* response.encodeRedirectURL(String url)
```text
当客户端禁用了cookie时，向服务器上发起的request不包括jsessionid cookie时，会自动在你指定的URL的参数前插入 ;jsessionid=jsessionid值
如 sessionServlet;jsessionid=E1764F5AFB67A96A5B8F8EFD4700F673?action=createOrGetSession

当客户端服务器上发起的request包括jsessionid cookie时，response.encodeRedirectURL(url)方法返回的就是url，不做任何处理 
```

* <c:url value="sessionServlet?action=createOrGetSession" />同上


session纯化与活化

序列化文件
${CATALINA_BASE}/work/Catalina/localhost/项目名/SESSIONS.ser
C:\Users\cd\.IntelliJIdea2019.1\system\tomcat\Tomcat_9_0_30_(1)_JavaWeb_3\work\Catalina\localhost\cookieSession\SESSIONS.ser
