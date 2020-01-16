Servlet
==

## ServletContext类
### 什么是ServletContext
```text
ServletContext是一个接口
ServletContext是一个域对象
每个web工程，都对应一个ServletContext对象
```

### ServletContext作用
* 可以获取web.xml文件中的配置上下文参数
* 可以获取web工程在服务器上的工程名
* 可以获取web工程中文件夹或文件在服务器上的绝对路径
* 可以设置、获取web工程的全局共享属性，对所有的请求都有效

**示例**
* [获取web.xml文件中的配置上下文参数、工程名、资源路径等](../tomcat/src/com/java/servlet2/ServletContext3.java)  
* [设置、获取web工程的全局共享属性](../tomcat/src/com/java/servlet2/ServletContext1.java)  
* [获取web工程的全局共享属性2](../tomcat/src/com/java/servlet2/ServletContext2.java)




## http协议
### http请求数据格式
```text
请求行
请求头
空行
请求体
```

* 请求行结构
    ```text
    method request-URI http-version
    ```
* 常用请求方法
    ```text
    get post put delete head
    ```
* http版本
    ```text
    HTTP/0.9
    HTTP/1.0
    HTTP/1.1
    HTTP/2.0
    
    其中常用的为 HTTP/1.1、其次HTTP/2.0，
    HTTP/2.0出现于2013年
    ```
* 请求头
    >可以有多个header头属性

* [HTTP Request Header请求头列表](../readme/HTTP_Request_Header请求头.md)

#### get请求数据格式
```texts
请求行
请求头信息
空行
```

```text
GET /?username=admin&pwd=pwd123456&sex=female&course=java&course=go HTTP/1.1
Host: 127.0.0.1
Connection: keep-alive
Upgrade-Insecure-Requests: 1
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36
Sec-Fetch-User: ?1
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
Sec-Fetch-Site: cross-site
Sec-Fetch-Mode: navigate
Referer: http://localhost:8080/tomcat/
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9

```
[WebSocket服务端获取数据](../tomcat/src/com/java/webserver/WebServer.java)

#### post请求数据格式
```text
请求行
请求头
空行
请求体
```

```text
POST / HTTP/1.1
Host: 127.0.0.1
Connection: keep-alive
Content-Length: 61
Cache-Control: max-age=0
Origin: http://localhost:8080
Upgrade-Insecure-Requests: 1
Content-Type: application/x-www-form-urlencoded
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/79.0.3945.117 Safari/537.36
Sec-Fetch-User: ?1
Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.9
Sec-Fetch-Site: cross-site
Sec-Fetch-Mode: navigate
Referer: http://localhost:8080/tomcat/
Accept-Encoding: gzip, deflate, br
Accept-Language: zh-CN,zh;q=0.9

username=admin&pwd=pwd123456&sex=female&course=java&course=go
```

### http响应数据格式
```text
响应行
响应头
空行
响应体
```

```text
HTTP/1.1 200 
Accept-Ranges: bytes
ETag: W/"2197-1579060979109"
Last-Modified: Wed, 15 Jan 2020 04:02:59 GMT
Content-Type: text/html
Content-Length: 2197
Date: Wed, 15 Jan 2020 10:13:18 GMT

<!DOCTYPE html>
<html lang="en">
<head>
...
<html>
```

* 响应行
    ```text
    http版本 响应状态码
    ```
    * [HTTP Responses Header响应头列表](../readme/HTTP_Responses_Header响应头.md)

[Socket模拟浏览器获取响应数据](../tomcat/src/com/java/webserver/WebClient.java)

### MIME类型
```text
MIME是HTTP协议中的数据类型
MIME：Multipurpose Internet Mail Extensions，多功能Internet邮件扩充服务

MIME类型的格式是
"大类型/小类型"，并与某一种文件的扩展名相对应
```

文件类型 |后缀 |MIME类型 
:--- |:--- |:--- 
超文本标记语言文本 |.html,.html |text/html
普通文本 |.txt |text/plain
RTF文本 |.rtf |application/rtf
GIF图形 |.gif |image/gif
JPEG图形	|.jpeg, .jpg |image/jpeg
au声音文件 |.au |audio/basic
MIDI音乐文件 |mid, .midi |audio/midi, audio/x-midi
RealAudio音乐文件	|.ra, .ram |audio/x-pn-realaudio
MPEG文件	|.mpg, .mpeg |video/mpeg
AVI文件 |.avi |video/x-msvideo
GZIP文件 |.gz |application/x-gzip
TAR文件 |.tar |application/x-tar 

### 响应状态码
状态码 |含义 
:--- |:--- 
200 |请求成功，浏览器会把响应体内容显示在浏览器中。响应休内容通过是html
404 |请求资源没有找到，表示客户端请求了不存在的资源
405 |服务器禁止了使用当前 HTTP 方法的请求，或服务器内部调用了不可调用的方法，如调用了HttpServlet父类的doGet或doPosst方法
500 |请求的资源找到了，但服务器内部出现了错误，如代码报错等
302 |资源临时重定向，Moved Temporarily资源临时改变了位置，表示服务器要求浏览器重新再发一个请求，<br>服务器会发送一个响应头Location，它指定了新请求的URL地址
301 |资源永久重定向，表示资源永久性移到另外一个页面了，<br>服务器会发送一个响应头Location，它指定了新请求的URL地址。并且浏览器会缓存此记录



## HttpServletRequest类
```text
HttpServletRequest类封装了从客户端传递过来的信息。
每次请求，Tomcat都会把客户端请求的信息封装在一个HttpServletRequest对象实例传递到service请求的方法中让我们使用
```

### HttpServletRequest常用方法
```text
getRequestURI()
获取请求的资源路径

getRequestURL()
获取请求的统一资源定位符

getRemoteHost()
获取请求的客户端ip地址

getHeader("field")					
获取请求头信息

getParameter("nameStr")
获取请求参数值

String[] getParameterValues("nameStr")
获取请求的多个值（常用于复选框

RequestDispatcher getRequestDispatcher("uriStr")
获取请求的转发对象。

RequestDispatcher.forward(resquest, response)
转发请求。如 request.getRequestDispatcher("/servlet2/forward.html").forward(request, response);

getMethod()
获取请求的方式GET 或 POST

setAttribute(key, value)
设置Request请求范围内域的属性值

getAttribute(key);  			获取Request请求范围的属性值。

getCookies()					获取Cook对象
getSession()					获取或创建Session对象
```

### 获取请求参数的值
[GetParameterFromHttpServletRequest](../tomcat/src/com/java/servlet2/GetParameterFromHttpServletRequest.java)

### request响应休中文乱码解决方法
```text

request获取的参数，为中文是出现乱码，
主要原因是，服务端默认使用ISO-8859-1字符集进行解码，客户端使用UTF-8字符集进行编码

解决方法1: 字符串转码
获取到乱码的参数值后，先用ISO-8859-1字符集进行编码，在用UTF-8字符集解码

username = new String(username.getBytes("ISO-8859-1"), "UTF-8");


解决方法2: 给request对象指定编码字符集.
request.setCharacterEncoding("UTF-8");
在使用前先设置
```

### 请求Request中设置属性和获取属性
```text
setAttribute(key, value)
设置Request请求范围内域的属性值

getAttribute(key);  			获取Request请求范围的属性值。

不同的请求不共享，只在同一个HttpServletResponse对象中能访问到


其实在Request对象中，有一个Map对象用来存放 属性值。
所以属性的操作就跟操作一个map对象是一样一样的
```

### base标签
见[base标签](https://github.com/cucker0/html-css/blob/master/readmd/html.md#base%E6%A0%87%E7%AD%BE)


### 转发请求
[ForwardRequest](../tomcat/src/com/java/servlet2/ForwardRequest.java)
```text
在getRequestDispatcher(urlStrig)中，
/ 表示http://ip:port/工程名/
也就是与web目录对应
```

## HttpServletResponse类
```text
Response对象封装了服务器到客户端返回的信息
```

### 获取输出流
* getOutoutStream()
    >获取字节流。主要用于返回二进制数据。比如说下载，图片验证码等。
* getWriter()
    >获取字符流。大部分的返回都用writer

```text
这两个输出流，我们不能同时获取两个，只有使用其中一个
```

### 如何往客户端回传数据
1. 获取输出流
2. 调用输出流对象，写出数据给客户端

[HttpServletResponse示例](../tomcat/src/com/java/servlet2/HttpServletResponse1.java)

### response响应体中文乱码解决方法
```text
// 告诉客户端发送的内容的使用的编码字符集
response.setContentType("text/html; charset=UTF-8");

// 效果同上
// response.setHeader("Content-Type\"", "text/html; charset=UTF-8");
```

### 请求重定向
* 设置响应状态码和设置响应头方式
```text
// 设置Location请求头 与response.sendRedirect() URL重定向的效果相同
// 设置响应状态码
response.setStatus(302);
response.setHeader("Location", "https://www.baidu.com");
```

* 请求重定向sendRedirect的方式
```text
// 指定重定向的地址，同时把响应状态码设置为302
response.sendRedirect("/tomcat/servlet2/home.html");
```

```text
请求重定向。是两次请求，浏览器地址栏会发生改变。
第一次请求返回的响应码为302.并且有响应头Location的内容。
第二次请求的地址就是Location对应的值。
重定向，第二次请求不仅可以是站内的资源，也可以是站外的资源
```
[请求重定向示例](../tomcat/src/com/java/servlet2/Redirect.java)


## 请求转发和重定向的对比

对比项 |请求转发 |请求重定向 
:--- |:--- |:--- 
浏览器地址栏 |不会变化	|会变化
几次请求	|一次请求，同一个请求	|两次请求
API	|Request对象	|Response对象
WEB-INF	|可以访问	|不能访问
共享request请求域数据	|可以共享	|不可以共享
目标资源	|必须是当前Web应用中的资源	|不局限于当前Web应用

