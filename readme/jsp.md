jsp
==


## jsp概述
JSP: Java Server Pages，Sun公司专门为了解决动态生成HTML文档的技术。方便html内容的输出

* 普通的Servlet程序输出html内容  
    [普通的Servlet输出html内容示例](../jspProj/src/com/java/servlet/HtmlServlet.java)  
    弊端：需要一行一行输出，很麻烦

```text
jsp面世最主要的目的是什么？

jsp最主要是为了解决输出html内容。
jsp在整个JavaEE中的定位。就只是为了输出html数据。
在jsp中，并不推荐编写大量的java代码。
```

## jsp本质
jsp的本质是Servlet程序，要求文件后缀为.jsp，否则将找不到资源

* [page.jsp源文件](../jspProj/web/page1.jsp)  
http://localhost:8080/jsp/page1.jsp

* 查看jsp文件翻译后的文件
    ```text
    运行idea的tomcat，注意查看Server日志，
    查看Using CATALINA_BASE显示的路径，在该目录下，work\Catalina\localhost\  找翻译出来的java文件
    如：
    ```
    ```text
    Using CATALINA_BASE:   "C:\Users\cd\.IntelliJIdea2019.1\system\tomcat\Tomcat_9_0_30_(1)_JavaWeb"
    Using CATALINA_HOME:   "D:\tomcat\apache-tomcat-9.0.30"
    Using CATALINA_TMPDIR: "D:\tomcat\apache-tomcat-9.0.30\temp"
    Using JRE_HOME:        "D:\java\jdk-12.0.1"
    Using CLASSPATH:       "D:\tomcat\apache-tomcat-9.0.30\bin\bootstrap.jar;D:\tomcat\apache-tomcat-9.0.30\bin\tomcat-juli.jar"
    ```

    ```text
    在目录C:\Users\cd\.IntelliJIdea2019.1\system\tomcat\Tomcat_9_0_30_(1)_JavaWeb\work\Catalina\localhost\jsp\org\apache\jsp
    ```
    翻译的java文件   
    [page1_jsp.java](../readme/page1_jsp.java)  
    
    page1_jsp.java翻译的java文件截图
    ![](../images/jsp/jsp_00.png)  
    
    ![](../images/jsp/jsp_03.png)  
    
    [org.apache.jasper.runtime.HttpJspBase类](../readme/HttpJspPage.java)  
    ![](../images/jsp/jsp_01.png)  
    **由此可见，jsp其实就是一个HttpServlet程序(即servlet程序)**  
    
    jsp源文件与翻译的java文件对应关系  
    ![](../images/jsp/jsp_02.png)
    
    ```text
    查看jsp文件翻译的java文件时，需要添加依赖jar包
    在apache-tomcat程序的/lib
    
    el-api.jar
    jasper.jar
    jsp-api.jar
    tomcat-api.jar
    ```

* jsp文件何时翻译和编译
    ```text
    jsp文件在其首次被访问时(或有更新时)，翻译成java源文件，并编译成.class文件
    翻译的jsp文件命名规则：原jsp文件名_jsp.java
    ```


## jsp语法
```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
```
```text
属性              含意
language        值只能是java，表示用java语言进行翻译
contentType     设置response header的Content-Type字段的值
pageEncoding    设置当前jsp文件的本身的编码
import          给当前jsp页面导入需要使用的类包
autoFlush		设置是否自动刷新out的缓冲区，默认为true，
                    即response的输出流out的缓冲区满后是否自动刷新，
                    如果不自动刷新，当内容超出了out缓冲区大小时，将报JSP Buffer overflow错误
buffer		    设置response的输出流out的缓冲区大小。默认为8KB
errorPage       设置当前jsp发生错误后，需要转发到哪个页面，定义错误页面，URL不跳转
isErrorPage	    设置当前jsp页面是否是错误页面，是的话，就可以使用exception异常对象
session		    设置当前jsp页面是否获取session对象，默认为true
extends		    设置jsp文件翻译后的类继承的类，给类似tomcat厂商预留的jsp默认翻译的servlet继承于什么类
```

### jsp中的注释
```text
<%-- jsp注释 --%>

<!-- html注释 -->

<%
    // java单行注释注释

    /*
    java块注释
     */
%>
```


### jsp的三种脚本语法
#### 1声明式脚本
```text
<%!
    java声明代码
%>
```
在声明脚本块中，可以做如下声明
* 定义全局变量
* 定义static静态代码块
* 定义方法
* 定义内部类  
几乎可以写在类中的代码，都可以通过声明脚本类实现  

[声明式脚本示例](../jspProj/web/syntax1.jsp)  

#### 2表达式脚本
```text
<%= 表达式 %>
```
```text
表达式脚本用于向html页面中输出内容
表达式脚本 翻译到Servlet程序的service方法中 以 out.print() 打印输出
out 是jsp的一个内置对象，用于生成html的源代码
```
* 注意：表达式不要以分号结尾，否则会报错
* 表达式脚本可以输出任意类型

[表达式脚本示例](../jspProj/web/syntax2.jsp)  

#### 3代码脚本
```text
<%
    java代码
%>
```
```text
代码脚本里可以书写任意的java语句
代码脚本的内容都会被翻译到service方法中
所以service方法中可以写的java代码，都可以书写到代码脚本中
```

[代码脚本示例](../jspProj/web/syntax3.jsp) 

## jps九大内置对象
* request：请求对象，可获取请求信息
* response：响应对象，可设置响应信息
* pageContext：当前页面的上下文对象，可在该对象中保存属性信息
* session：会话对象，可获取会话信息
* application：ServletContext对象实例，可获取真个工程的一些信息
* config：ServletConfig对象实例，可获取Servlet的配置信息
* out：输出流
    ```text
    主要用来在jsp页面上进行输出。在jsp页面中输出数据的时候，统一使用out进行输出（性能好，并且输出统一）
    而不使用response.getWriter进行输出
    ```
* page：当前Servlet对象实例，使用this对象代替它更合适
* exception：异常对象，只有在jsp页面的page 指令中设置 isErrorPage="true" 的时才会存在

以上9大内置对象，在[代码脚本]、[表达式脚本]中可以直接使用

## jsp四大域对象
* pageContext：可以保存数据在同一个jsp页面中
    >作用范围：当前jsp页面内
* request：可以保存数据在同一个request对象中
    >作用范围：同一个request对象
* session：可以保存数据在同一个会话中
    >作用范围：浏览器从打开到关闭中间都在同一个session中
* application：就是ServletContext对象
    >作用范围：Tomcat服务器从启动到关闭

```text
4个域对象都有setAttribute、getAttribute方法，都可设置、获取属性值
```

### 该使用那个与对象
```text
选择域对象优先顺序：对象的作用范围从小到大，
pageContext -> request -> session -> application
```

### jsp中out输出流与response.getwriter()输出流的区别
**输出内容到客户的输出流有：**
* out输出流
* response.getWriter()输出流

建议统一使用out输出流，

**这两个输出流都有两个方法：**
* write(输出的对象)    输出字符串时优先使用
* print(输出的对象)    输出任何类型

建议统一使用print方法


[out_getWriter源文件](../jspProj/web/out_getWriter.jsp)  

out输出流与response.getwriter()输出流缓冲区工作原理
![](../images/jsp/out_response.getWriter.png)  


## jsp常用标签
### 静态包含
```text
很常用
静态包含是把包含的页面内容原封装不动的输出到包含的位置
被静态包含的文件没有被翻译成为Servlet源文件

静态包含会比动态包含性能更优
```

语法
```jsp
<%@ include file="" %>
```


### 动态包含
```text
很少用

动态包含会把被包含的页面单独翻译成servlet文件(即使是html文件)，然后在执行到<jsp:include时再调用翻译的servlet程序，
并把计算的结果返回，将其追加到其包含的jsp的out缓冲区中
动态包含是在执行的时候，才会加载。

动态包含适合于，去包含那些，在jsp页面中有大量的java源代码的，
或者 在jsp页面中有一些耗时比较长的操作的java代码的页面。
比如在jsp页面中编写Socket操作。或者是有jdbc的操作等等
```

语法
```
<jsp:include page=""></jsp:include>
或
<jsp:include page="" />
```

翻译后的包含jsp文件
```text
      out.write("\n");
      out.write("<html>\n");
      out.write("<head>\n");
      out.write("    <title>动态包含</title>\n");
      out.write("</head>\n");
      out.write("<body>\n");
      out.write("<h3>jsp动态包含</h3>\n");
      out.write("\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.html", out, false);
      out.write("\n");
      out.write("</body>\n");
      out.write("</html>\n");
```
调用了org.apache.jasper.runtime.JspRuntimeLibrary.include方法

### 页面转发
```text
常用，URL不会跳转

功能同
request.getRequestDispatcher("/xxxx.jsp").forward(request, response);
```

语法
```jsp
<jsp:forward page=""></jsp:forward>
```

翻译后的jsp文件
```text
_jspx_page_context = pageContext;

if (true) {
    _jspx_page_context.forward("forward_home.jsp");
    return;
}
```
执行了pageContext.forward("转发页面路径")

* 对比jstl的`<c:redirect url="">`标签实现url 302跳转

### jsp include标签在包含html文件乱码解决方法
* 方法一：就是不要include html页面，改成include jsp页面
* 方法二：在被包含的html文件的第一行添加如jsp指令
```jsp
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
```
* 方法三(推荐)：配置web.xml，所有html文件输出时都采用UTF-8的编码
```text
<jsp-config>
    <jsp-property-group>
        <url-pattern>*.html</url-pattern>
        <page-encoding>UTF-8</page-encoding>
    </jsp-property-group>
</jsp-config>
```

### 静态包含与动态包含的区别

项|静态包含 |动态包含 
:---|:---|:---
是否生成java |否 |是 
_jspService方法中的区别 |把包含内容复制到_jspService中 |调用了org.apache.jasper.runtime.JspRuntimeLibrary.include方法 
是否可以传递参数 |不能 |可以 
编译次数 |1次 |包含的文件数 + 1 
适用范围 |适用于那些大部分是静态页面内容 的jsp页面 |jsp页面中包含有大量的java代码的jsp页面，或者耗时 时间比较长的jsp页面 


## html中的路径与jsp中java代码的路径使用注意事项 
* html相对路径
    ```text
    html中的相对路是base标签中定义的baseUrl，
    如果没有定义则是 当前页面在浏览器上显示的URL  
  
    html中相对路径不以/开头，
    如果是以/开头则表示为绝对路径，/ 表示为基准路径
    ```
* html中的java代码里的路径
    ```text
    基准URL为 http://服务器ip:port/工程名
    
    所有其路径要求以/开头，后台会对URL进行拼接
    ```
    
[示例(href、file里路径)](../bookmall_v3/web/pages/user/login.jsp)  