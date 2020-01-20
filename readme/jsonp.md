JSONP
==

## 同源策略
```text
要理解跨域，先要了解一下“同源策略”。
同源是指，域名、协议、端口相同。所谓“同源策略“，简单的说就是基于安全考虑，当前域不能访问其他域的东西。

在同源策略下，在某个服务器下的页面是无法获取到该服务器以外的数据的
```
* 常见的是否同源示例

URL |是否同源 |说明 
:--- |:--- |:--- 
http://www.a.com <br>https://www.a.com |不同源 |协议不同
http://www.a.com <br>http://www.b.com |不同源 |域名不同  
http://www.a.com:8080 <br>http://www.a.com:8090 |不同源 |端口不同  
http://www.a.com/a.js <br>http://www.a.com/b.js |同源 |域名、协议、端口相同  
http://www.a.com/abc/a.js <br>http://www.a.com/efg/b.js|同源 |域名、协议、端口相同  

* 示例  
在自己的网站通过ajax去获取豆瓣上https://developers.douban.com/wiki/?title=api_v2提供的接口数据
![](../images/jQuery/jsonp_02.png) 

```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>ajax</title>
</head>
<body>
    <div id="mydiv">
        <button id="btn">点击</button>
    </div>
</body>
<script type="text/javascript">
    window.onload = function() {

    var oBtn = document.getElementById('btn');

    oBtn.onclick = function() {

        var xhr = new XMLHttpRequest();

        xhr.onreadystatechange = function() {
            if (xhr.readyState == 4 && xhr.status == 200) {
                    alert( xhr.responseText );
            }
        };

        xhr.open('get', 'https://api.douban.com/v2/book/search?q=javascript&count=1', true);
        xhr.send(); 
    };

};
</script>
</html>
```
报错：
![](../images/jQuery/jsonp_01.png)  


**<img>、<link>、<script>可跨域请求**
```text
<img>的src  获取图片 
<link>的href  获取css  
<script>的src  获取javascript 

这三个都不符合同源策略，它们可以跨域获取数据
```

## JSONP
```text
JSONP: JSON with padding，填充式JSON或参数式JSON
JSONP实现跨域请求的原理简单的说，就是动态创建<script>标签，然后利用<script>的src 不受同源策略约束来跨域获取数据

JSONP 由两部分组成：回调函数和数据。
回调函数是当响应到来时应该在页面中调用的函数。回调函数的名字一般是在请求中指定的。
数据就是传入回调函数中的 JSON 数据
```

动态创建<script>标签，设置其src，回调函数在src中设置
```js
var script = document.createElement("script");
script.src = "https://api.douban.com/v2/book/search?q=javascript&count=1&callback=handleResponse";
document.body.insertBefore(script, document.body.firstChild);
```

在页面中，返回的JSON作为参数传入回调函数中，我们通过回调函数来来操作数据
```js
function handleResponse(response){
    // 对response数据进行操作代码
}
```

了解了JSONP的基本使用方法，我们在实现上面通过ajax调用豆瓣接口的需求，实现代码如下
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>JSONP实现跨域2</title>
</head>
<body>
    <div id="mydiv">
        <button id="btn">点击</button>
    </div>
</body>
<script type="text/javascript">
    function handleResponse(response){
            console.log(response);
    }

    window.onload = function() {
        var oBtn = document.getElementById('btn');
    
        oBtn.onclick = function() {     
    
            var script = document.createElement("script");
            script.src = "https://api.douban.com/v2/book/search?q=javascript&count=1&callback=handleResponse";
            document.body.insertBefore(script, document.body.firstChild);   
        };
    };
</script>
</html>
```

在控制台，我们可以查看到返回的response数据格式为JSON对象格式的，具体需要取出哪些参数，可以根据自己的需要
![](../images/jQuery/jsonp_03.png) 

```text
JSONP目前还是比较流行的跨域方式，虽然JSONP使用起来方便，
但是也存在一些问题： 
首先， JSONP 是从其他域中加载代码执行。如果其他域不安全，很可能会在响应中夹带一些恶意代码，
而此时除了完全放弃 JSONP 调用之外，没有办法追究。因此在使用不是你自己运维的 Web 服务时，一定得保证它安全可靠。

其次，要确定 JSONP 请求是否失败并不容易。虽然 HTML5 给<script>元素新增了一个 onerror事件处理程序，
但目前还没有得到任何浏览器支持。为此，开发人员不得不使用计时器检测指定时间内是否接收到了响应。
```

## jQuery封装JSONP
```text
对于经常用jQuery的开发者来说，能注意到jQuery封装的$.ajax中有一个dataType属性，
如果将该属性设置成dataType:"jsonp"，就能实现JSONP跨域了。

需要了解的一点是，虽然jQuery将JSONP封装在$.ajax中，但是其本质与$.ajax不一样
```

通过jQuery的$.ajax实现跨域的代码参考如下
```html
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>jQuery实现JSONP</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
</head>
<body>
    <div id="mydiv">
        <button id="btn">点击</button>
    </div>
</body>

<script type="text/javascript">
    $(function(){
        $("#btn").click(function(){
            $.ajax({
                async: true,
                url: "https://api.douban.com/v2/book/search",
                type: "GET",
                dataType: "jsonp", // 返回的数据类型，设置为JSONP方式
                jsonp: 'callback', //指定一个查询参数名称来覆盖默认的 jsonp 回调参数名 callback
                jsonpCallback: 'handleResponse', //设置回调函数名
                data: {
                    q: "javascript", 
                    count: 1
                }, 
                success: function(response, status, xhr){
                    console.log('状态为：' + status + ',状态是：' + xhr.statusText);
                    console.log(response);
                }
            });
        });
    });
</script>
</html>
```

最后的结果与JavaScript通过动态添加<script>标签得到的结果是一样的
![](../images/jQuery/jsonp_04.png)  


## 通过$.getJSON()跨域
只要在地址中加上callback=?参数即可
```js
$.getJSON(
    "https://api.douban.com/v2/book/search?q=javascript&count=1&callback=?", 
    function(data){
        console.log(data)
    }
);
```