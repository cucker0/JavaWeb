Intellij idea的tomcat原理
==


## tomcat常识
https://blog.csdn.net/leo3070/article/details/88062663
* tomcat需要JRE环境，JDK包含JRE
* 运行tomcat前需要配置一些系统环境变量
```
首先：添加系统变量 CATALINA_HOME ： C:\apache-tomcat-8.0.41 
其次：添加环境变量 PATH ： %CATALINA_HOME%\bin 
－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－－ 
启动 tomcat 服务器,打开你的cmd，输入以下命令 
catalina run 　 　// 启动，在原窗口启动 
catalina start 　　// 启动，会打开一个新的dos窗口启动 
catalina stop　　 // 停止tomcat服务器
```

* 看看简短的启动信息，对于理解intellij的tomcat很关键
```
C:\Users\chenyuchao>catalina start 
Using CATALINA_BASE: "C:\apache-tomcat-8.0.42"
Using CATALINA_HOME: "C:\apache-tomcat-8.0.42" 
Using CATALINA_TMPDIR: "C:\apache-tomcat-8.0.42\temp"
Using JRE_HOME: "C:\Java\jdk1.8.0_101"
```
