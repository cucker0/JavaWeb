cookie和session
==


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