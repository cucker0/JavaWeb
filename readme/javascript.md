JavaScript
==


## 概述
```text
JavaScript是一种具有函数优先的轻量级，解释型或即时编译型的编程语言。
是一种属于网络的脚本语言,已经被广泛用于Web应用开发,常用来为网页添加各式各样的动态功能,
为用户提供更流畅美观的浏览效果。
与java没有关系
```

## javascript代码与html代码结合的方式
* 在head或body标签内添加script标签  
    head标签内  
    ```html
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
        <script type="text/javascript">
            alert("hi javascript");
        </script>
    </head>
    <body>
    </body>
    </html>
    ```
    
    body标签内(推荐)  
    ```html
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
    </head>
    <body>
        <div>
            请按F12打开Console控制台
        </div>
        <script type="text/javascript">
            console.log("^_^, javascript lable in body");
        </script>
    </body>
    </html>
    ```
* 在head标签内引入javascript代码文件  
    路径可以使用先对路径，或URL地址  
    ```html
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <title>Title</title>
        <script type="text/javascript" src="./js/common.js"></script>
    </head>
    <body>
    </body>
    </html>
    ```

**也可以两种方式同时使用**  

## 变量
### 变量类型
* number：数值类型
* string：字符串类型
* boolean：布尔类型
* object：对象类型
    * array：数组
    * 字典
* function：函数类型

#### number
```js
// number
var num = 2;
var age = Number(18);
var a1 = 1, a2 = 2, a3 = 3;

```
* 字符串解析为数值
    ```js
    var n1 = parseInt("1.2"); // 1
    var n2 = parseFloat("1.2"); // 1.2
    console.log(n1, n2);
    ```

#### string
```js
// string
var name = "pikaqs";
var theam = String("black");
var age_str = String(18);
```

* string对象常用方法
    ```js
    // 去掉空格
    obj.trim()
    
    // 去掉左空格
    obj.trimLeft()
    
    // 去掉右空格 
    obj.trimRight()
    
    // 根据下标查找字符
    obj.charAt(index)
    
    // 根据下标查找子字符串
    obj.substring(start,end)
    
    // 根据字符查找下标
    obj.indexOf(char)
    
    // 字符串长度
    obj.length     
    ```

#### boolean
```js
// boolean
var status = true;
var siClose = false;
var flag1 = Boolean(1); // 非0数值为true
var flag2 = Boolean(0); // false
console.log(flag1, flag2);
console.log(typeof(flag1));
```
* typeof(对象)
    ```text
    获取对象的类型
    ```

#### object
* array
    ```js
    // Array
    var person = ['tom', 'cherry', 'rich'];
    var person2 = Array('tom', 'cherry', 'rich');
    console.log(typeof(person2)); // object
    console.log(person[0]);
    
    // 遍历数组
    console.log("-- 遍历数组 --");
    for (var i in person) {
        console.log(person[i]);
    }
    ```
    * 数组常用方法
        ```text
        * 添加
            obj.push(ele)                   追加
            obj.unshift(ele)                最前插入
            obj.splice(index,0,'content')   指定索引插入
        * 移除
            obj.pop()                       数组尾部获取
            obj.shift()                     数组头部获取
            obj.splice(index,count)         数组指定位置后count个字符
          
        *切片
            obj.slice(start,end)          
        * 合并
            newArray ＝ obj1.concat(obj2)  
        * 翻转
            obj.reverse()
          
        *字符串化
            obj.join('_')
        * 长度
            obj.length
    ```
* 字典
    ```js
    // dictionary
    var items = {k1: "v1", k2: "v2"}; // 标准写法, key为字符串，无需用引号包裹key
    var items2 = {items: '00', 'addr': "中金大道"};
    console.log(items.k1);
    var a = {k1: "v1", k2: "v2"};
    console.log(a);
    console.log(items);
    console.log(items2.items); // 00
    console.log(items2['items']); // 00
    console.log(typeof(items2));
    
    // 遍历字典
    console.log("-- 遍历字典 --");
    for (var k in items) {
        console.log(items[k]);
    }
    console.log("-- end 遍历字典 --");
    /* end object */
    ```
    * 序列化：对象转字符串
        ```js
        var a = {k1: "v1", k2: "v2"};
        var b = JSON.stringify(a);
        console.log(b); // '{"k1":"v1","k2":"v2"}'
        ```
    * 反序列化：字符串转对象
        ```js
        var stu = JSON.parse('{"name":"dicke","age":18}');
        console.log(stu.age);
        console.log("stu type: " + typeof (stu)); // object
        ```


#### function
```js
var func1 = new Function();
console.log(typeof(func1));
```

### 特殊值
* undefined：未定义
    ```text
    没有定义，或没有赋值的，如 var name; //此时的name为undefined
    ```
* null：空值
* NAN：not a number
    ```js
    var a = 12;
    var b = "adsfa";
    var c = a + b; // 报错NAN
    ```


