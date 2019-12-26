tomcat
==


## 概述
* java web
```text
Java web，是用java技术来解决相关web互联网领域的技术的总称。
简而言之：使用java语言实现浏览器可以访问的程序内容。
web包括：web服务器和web客户端两部分
```

## web资源分类
```text
web资源即放在Internet网上供外界访问的文件或程序
```
* 静态资源
    ```text
    静态网页文件：html文件、css文件、文本、音频、视频文件等
    ```
* 动态资源
    ```text
    jsp、Servlet、php程序等
    ```
    
## 常见的java web服务器
* Tomcat
    >免费，应用广泛。由Apache组织提供的一种Web服务器，提供对jsp和Servlet的支持
* Jboss
    >免费，个遵从JavaEE规范的、开放源代码的、纯Java的EJB服务器，它支持所有的JavaEE规范
* GlassFish
    >免费，应用少，由Oracle公司开发的一款Java Web服务器，是一款强健的商业服务器，达到产品级质量,
* Resin
    >收费，应用比较多。是CAUCHO公司的产品，是一个非常流行的服务器，对servlet和JSP提供了良好的支持，
     性能也比较优良。
* WebLogic
    >收费，用的不多，适合大公司.是BEA公司的产品，支持JavaEE规范    
* WebSphere
    >IBM公司的产品
* Jetty
    >更轻量级开源的servlet容器
    


## tomcat服务器安装部署
* **tomcat web服务器依赖java运行环境，即jre**，所以必须先配置好，java运行环境安装
见[安装JDK](https://github.com/cucker0/java_2019/blob/master/README/install_JDK.md)
* 下载tomcat包，http://tomcat.apache.org/
* 把下载的tomcat包解压到一个目录，目录中不带空格
* 配置tomcat系统环境变量
    ```text
    * 添加系统环境变量
    环境变量名：CATALINA_HOME
    值：上一步中tomcat的根路径，如D:\tomcat\apache-tomcat-9.0.30
    
    * 在Path系统变量中追加tomcat相关路径
    %CATALINA_HOME%\bin;%CATALINA_HOME%\lib
    ```

