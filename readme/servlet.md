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
* 可以获取web工程中文件病人或文件在服务器上的绝对路径
* 可以设置、获取web工程的全局属性



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

## MIME类型
```text
MIME是HTTP协议中的数据类型
MIME：Multipurpose Internet Mail Extensions，多功能Internet邮件扩充服务

MIME类型的格式是
"大类型/小类型"，并与某一种文件的扩展名相对应
```


## HttpServletRequest类

## HttpServletResponse类

## 请求转发和重定向的对比


