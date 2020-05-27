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

### json对象的定义与使用
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

### json对象与json字符串互转
这时JSON中常用的两个方法
* JSON.stringify(json对象)
    >把一个json对象转换成json字符串
* JSON.parse(jsonString)
    >把一个json字符串转换成json对象

[json示例](../JavaScript/json/json.html)

### 在java中json的使用
```text
在java中使用json，需要依赖第三方jar包gson.jar
gson是有google提供的，用于对java对象与json数据之间进行映射，
即json字符串与java对象之间的互转
```
gson下载链接：https://repo1.maven.org/maven2/com/google/code/gson/gson




























