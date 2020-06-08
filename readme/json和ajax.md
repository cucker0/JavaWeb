json和ajax
==


## json
什么事json
```text
json(JavaScript Object Notation)，对象表示法，是一种轻量级的数据交换格式。key-value对 
易于人阅读和编写，易于机器解析和生成。
它基于JavaScript Programming Language, Standard ECMA-262 3rd Edition - December 1999的一个子集。 JSON采用完全独立于语言的文本格式，
但是也使用了类似于C语言家族的习惯（包括C, C++, C#, Java, JavaScript, Perl, Python等）。 
这些特性使JSON成为理想的数据交换语言。
```

### javascript中json的使用
#### json对象的定义与使用
* json定义

    在javascript中 包裹key名的引号可以省略，但值的引号不能省略
    ```javascript
    var 变量名 = {
        "key1": 22,  // Number类型
        "key2": "str2",  // 字符串类型
        "key3": [11, 33],  // 数组类型
        "key4": {"name": "sally", "age": 18}, // json对象类型
        "key5": [{"name":"coco", "age":20}, {"name":"dudu", "age":21}]  // json数组类型
    };

    // 也可以写成
    var obj = {
        key1: 22, 
        key2: "str2", 
        key3:[11, 33], 
        key4: {name: "sally", age: 18}, 
        key5: [{name: "coco", age: 20}, {name: "dudu", age: 21}]
    }
    ```
    
* json对象的使用
    json对象，是一个对象，key名就是对象的属性。我们只需要访问对象的属性，就能获取属性对应的值。
    ```text
    对象名.属性名
    
    即
    对象.key
    ```
    
    示例
    ```text
    obj.key1:  22
    obj.key3[0]:  11
    obj.key4.name:  sally
    obj.key5[1].name: dudu
    ```

#### json对象与json字符串互转
这时JSON中常用的两个方法
* JSON.stringify(json对象)
    >把一个json对象转换成json字符串
* JSON.parse(jsonString)
    >把一个json字符串转换成json对象

[json示例](../JavaScript/json/json.html)


### java中json的使用
#### Gson
```text
在java中使用json，需要依赖第三方jar包gson.jar
gson是有google提供的，用于对java对象与json数据之间进行映射，
即json字符串与java对象之间的互转
```
gson下载链接：https://repo1.maven.org/maven2/com/google/code/gson/gson

##### gson常用方法
* String gson.toJson(Object obj)
    >Java对象转json字符串
* <T> T fromJson(String json, Class<T> classOfT)
    >json字符串转单个java Bean对象
* List<T> list = gson.fromJson(json字符串, (new TypeToken<List<T>>() {}).getType());
    >json字符串转List集合
* Map<K, V> map2 = gson.fromJson(mapJsonStr2, (new TypeToken<Map<K, V>>() {}).getType());
    >json字符串转Map集合

##### [gson使用示例](../JavaScript/src/com/java/www/GsonTest.java)

#### FastJson
```text
FastJson是阿里巴巴开发的java类库，用于java对象与json字符串互转。
fastjson是目前java语言中最快的json库，比自称最快的jackson速度还要快。

github网址： https://github.com/alibaba/fastjson
jar包下载地址 https://repo1.maven.org/maven2/com/alibaba/fastjson/
```


##### FastJson常用方法
* String jsonString = JSON.toJSONString(obj)
    >序列化，java对象转json字符串
* VO vo = JSON.parseObject(jsonString, VO.class)
    >反序列化，json字符串转java Bean对象
* List<T> list = JSON.parseArray("json串", T.class)
    >将包含过多个java bean对象的List格式的json字符串转换成List集合
* 泛型反序列化
    ```text
    import com.alibaba.fastjson.TypeReference;
    
    List<VO> list = JSON.parseObject("...字符串", new TypeReference<List<VO>>() {});

    Map<K, V> map = JSON.parseObject("json字符串", new TypeReference<>() {});  // <>钻石简略写法
    ```

##### [FastJson使用示例](../JavaScript/src/com/java/www/FastJsonTest.java)


## ajax
```text
ajax: Asynchronous Javascript And XML，异步JavaScript和XML，是一种创建交互式网页应用的网页开发技术。
ajax是一种由浏览器发起异常请求，局部更新页面的技术
```

### javascript原生的ajax请求
1. 创建XMLHttpRequest对象
2. 调用open方法设置请求参数
3. 在send方法之前绑定onreadystatechange事件，处理请求完成后的操作
4. 调用send方法发送请求

#### ajax的XMLHttpRequest对象
```text
ajax的核心是XMLHttpRequest对象
XMLHttpRequest 对象用于同幕后服务器交换数据。这意味着可以更新网页的部分，而不需要重新加载整个页面。

不管是js的ajax请求、jQuery的请求，还是html上的a标签、submit提交发起的请求，
只要是浏览器没有禁止cookie，则只要是由浏览器发起的请求都会带上本域的Cookie信息

* 跨域访问限制
出于安全原因，现代浏览器不允许跨域访问。
```

* XMLHttpRequest对象的方法

方法 |描述 
:--- |:--- 
new XMLHttpRequest() |创建新的XMLHttpRequest对象 
open(method, url, async, user, psw) |规定请求 <br> * method：请求类型 GET 或 POST <br>* url：url地址<br>* async：是异步请求，true（异步请求）或 false（同步请求）<br> * user：用户名称，可选<br> * psw：密码，可选的<br> 
setRequestHeader("header名", "value") |向该请求对象中添加htttp头的键值对，<br>如：xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
send() |将请求发送到服务器，用于 GET 请求 
send(string) |将请求发送到服务器，用于 POST 请求，<br>如：xhr.send("fname=Bill&lname=Gates");
abort() |在已发送请求，请求还未响应时，取消当前请求 
getAllResponseHeaders() |在请求响应后，获取头部信息 
getResponseHeader("key名") |在请求响应后，获取特定的头部信息 


* XMLHttpRequest 对象属性

属性 |描述 
:--- |:---
onreadystatechange |定义当 readyState 属性发生变化时被调用的函数，<br> var xhr = new XMLHttpRequest();<br> xhr.onreadystatechange = function() {};
readyState |XMLHttpRequest的状态值。<br><br> * 0：请求未初始化 <br>* 1：服务器连接已建立 <br>* 2：请求已收到 <br>* 3：正在处理请求 <br>* 4：请求已完成且响应已就绪
responseText |以字符串方式获取响应数据 
responseXML |以XML方式获取响应数据 
status |获取请求的响应状态码， 如：<br><br> * 200: "OK" <br>* 403: "Forbidden" <br>* 404: "Not Found" <br>...
statusText |获取请求的响应状态文本（比如 "OK" 或 "Not Found" ）



