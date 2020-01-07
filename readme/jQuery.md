jQuery
==

## 概述
```text
jQuery: JavaScript和Query，是辅助JavaScript开发的js类库

核心思想：write less, do more，写得少，做得多

功能：操作文档对象、选择DOM元素、制作动画效果、事件处理、使用Ajax以及其他功能

官网：https://jquery.com
```

## jQuery的使用
* 导入jQeury js库文件
    ```html
    <head>
        <script type="text/javascript" src="js/jquery-3.4.1.js"></script>
    </head>
    ```
* 在页面加载完之后，查找节点，然后在节点对象上绑定事件  

* js加载时间顺序
    ```js
    // DOM准备就绪时，即DOM加载完成之后，这时候页面可能并没有正常显示出来
    $(document).ready(function() {
      
    });
    
    // 简写
    $().ready(function() {
      
    });
    
    // 简写
    $(function() {
      
    });
    ```
* $(document).ready() vs window.onload()
    * window.onload(): 页面准备就绪完成时
        >要等到页面中所引用的图片等外部资源 完全下载完成后并且在浏览器中显示才执行
    * $(document).ready():  DOM准备就绪完成时，早于window.onload()

## jQuery本质
```text
jQuery本质是js函数，一个立即执行函数

```
```js
(function (global, factory) {})(
    typeof window !== "undefined" ? window : this, function(window, noGlobal) {
    }
    // 上面的this为window，因为由此对象来加载jQeury库
);

// 最终执行了 
// 若想node.js 使用了 module.exports，则调用
factory(global, true ); // global 为window

// 一般的
factory(global); //global 为window， noGlobal没传，调用时为undefined
```
![](../images/jQuery/jQuery函数.png)  

## jQuery中的$本质
```text
$为window.$的简写，是js函数，jQeury中的核心函数，一个object对象
```
```js
if ( !noGlobal ) {
	window.jQuery = window.$ = jQuery;
}

/**
* 一般情况下，noGlobal为undefined，即为false
* 此时 window.$ = jQuery;
* window.jQuery = jQuery;
* 
* 而jQuery是一个函数。
* 另外 window.$，在使用时也可以省去window，即$，效果同调用window.$
* window.jQuery同上
*/


/**
* jQuery函数
* 
* jQuery对象都是 jQuery.fn.init 的实例
*/
var
	version = "3.4.1",

	// Define a local copy of jQuery
	jQuery = function( selector, context ) {

		// The jQuery object is actually just the init constructor 'enhanced'
		// Need init if jQuery is called (just allow error to be thrown if not included)
		return new jQuery.fn.init( selector, context );
	},

	// Support: Android <=4.0 only
	// Make sure we trim BOM and NBSP
	rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;

```

![](../images/jQuery/$01.png)  
![](../images/jQuery/$02.png)  

## jQeury核心函数$()
$()函数能完成很多功能，可链式编程，即对象方法之后再.方法、.属性等


* $(函数)
    ```text
    $(function(){})  表示DOM就绪之后(DOM加载完成之后)，执行传入的函数
    $(function(){})  是一种简写形式
    ```
    ```js
    //jq的写法
    $(document).ready(function(){
        //do something
    });
    //简写，默认document
    $().ready(function(){
        // do somethin
    });
    // 简写
    $(function(){
        // do something
    });
    ```
* $(inner.HTML字符串)
    创建HTML标签对象
    ```js
    $("<div><span>12</span></div>");
    
    // 相当于
    var spanObj = document.createElement("span");
    spanObj.innerHTML = 12;
    var divObj = document.createElement("div");
    divObj.appendChild(spanObj);
    ```

* $(选择器字符串)  
    jQuery选择器，获取jQuery对象  
    使用规则见 http://jquery.cuishifeng.cn
    ```js
    $("#id属性值")  // id选择器
    $(".class属性值")  // 类选择器
    $("标签名 ")  // 标签选择器
    ```

* $(DOM对象)
    传入的DOM对象转换成jQuery对象。jQuery选择器也是jQuery对象
    ```js
    // DOM对象，如类似下面这种方式获取到的对象，就是DOM对象
    var domObj = document.getElementById("id属性值");
    
    // jQuery对象，如类似下面这种方式获取到的对象，就是jQuery对象
    var jqueryObj = $(domObj);
    var jqueryObj2 = $("选择器");
    ```
 
## jQuery对象与DOM对象
### 概念
* DOM对象
    ```text
    直接通过document对象的方法创建的节点、或是查找到的节点，就是DOM对象.
    console.log(DOM对象);显示的为HTMLCollection对象
    如 
    var divObj = document.getElementById("id属性值");
    var spanObj = document.createElement("span");
    ```
* jQuery对象
```text
通过jQuer接口创建的对象、jQuer接口查询到的对象、jQuery包装的DOM对象，就是jQue对象
console.log(jQuery对象);显示的为jQuery.fn.init对象
```

### JQuery对象的本质
```text
Jquery对象本质是一个数组，该数组素由dom对象数组、一系列jquery对象提供的方法组成
```

### jQuery对象和DOM对象使用区别
* DOM对象的属性和方法不能被jQuery对象使用
* jQuery对象的属性和方法也不能被DOM对象使用

### jQuery对象与DOM对象互转
* DOM对象转jQuery对象
    ```js
    var DOM对象 = document.getElementByXxx("属性值"); // Xxx为Id、name、class等
    var $jq对象 = $(DOM对象);
    ```

* jQuery对象转DOM对象
    ```js
    var $jq对象 = $("选择器字符串");
    var DOM对象 = $jq对象[index值];
    ```

## jQuery选择器
jQuery选择器与css选择器是一样的，参考 http://jquery.cuishifeng.cn  
选择返回的jQuery对象为一个由n个DOM对象和一些方法组成的数组，  
**调用方法时，可以直接用数组对象.方法名()**  
**调用数据里面的DOM对象元素时，需要指定具体的元素，如 jqArr[0].checked**


### 基本选择器
```text
#id  id选择器，返回一个元素，或0个元素。
element  标签选择器
.class  类选择器
*  匹配所有元素
selector1,selector2,selectorN  多个选择器的并集
```

### 层级选择器
```text
ancestor descendant  匹配ancestor后代元素为descendant的元素
parent > child  匹配parent的子元素为child的元素
prev + next  匹配跟在 prev 后为 next 的next这个兄弟元素
             prev与next为同级
prev ~ siblings  查找与prev同辈的兄弟元素中为siblings的元素 （不包括prev）
                 prev与siblings为同级
```

### 基本筛选器
```text
:first  第一元素
:not(selector)  不是selector的元素
:even  匹配所有索引为偶数的元素
:odd  匹配所有索引为奇数的元素
:eq(index)  匹配索引=index的元素
:gt(index)  匹配索引>index的元素
:lt(index)  匹配索引<index的元素
:lang
:last  最后一个元素
:header  匹配如 h1, h2, h3之类的标题元素
:animated  匹配所有正在执行动画效果的元素
:focus  匹配当前获取焦点的元素
:root  选择该文档的根元素，即HTML标签
:target  
```

### 内容选择器
```text
:contains(text)  匹配包含给定文本的元素
:empty  匹配所有不包含子元素或者文本的空元素
:has(selector)
:parent  匹配含有子元素或者文本的元素
```

### 可见性选择器
```text
:hidden  匹配所有不可见元素，或者type为hidden的元素
:visible  匹配所有的可见元素
```
### 属性选择器
```text
[attribute]  匹配包含给定属性的元素
[attribute=value]  查找属性attribute值 = value的元素
[attribute!=value]  查找属性attribute值 != value的元素
[attribute^=value]  查找属性attribute值 以 value开头的元素
[attribute$=value]  查找属性attribute值 以 value结尾的元素
[attribute*=value]  查找属性attribute值 包含 value的元素
[attrSel1][attrSel2][attrSelN]  同时满足多个属性条件
```
### 子元素选择器
```text
:first-child  匹配所给选择器( :之前的选择器)的第一个子元素
:first-of-type  等价于:nth-of-type(1) 选择器
:last-child  匹配所给选择器( :之前的选择器)的最后一个子元素
:last-of-type  等价于:nth-of-type(1) 选择器
:nth-child
:nth-last-child()
:nth-last-of-type()
:nth-of-type()
:only-child
:only-of-type
```
### 表单选择器
```text
:input  匹配所有 input、textarea、select、button元素
:text  匹配所有的单行文本框
:password  匹配所有的密码框
:radio  匹配所有单选按钮，即type="radio"的input元素
:checkbox  匹配所有复选框
:submit  匹配所有提交按钮
:image
:reset
:button
:file
```
### 表单对象属性选择器
```text
:enabled  可用的元素
:disabled  不可用的元素
:checked  已选中的,匹配所有选中的单选，复选，和下拉列表中选中的option标签对象
:selected  已选中的下拉列表选项,匹配所有选中的option
```

## jQuery常用方法
* jQuery.each(object, [callback])
```text
object:需要遍历的对象或数组。
callback:每个成员/元素执行的回调函数
```
```js
// 遍历数组，同时使用元素索引和内容
$.each( [0,1,2], function(i, n){
    alert( "Item #" + i + ": " + n );
});

// 遍历对象，同时使用成员名称和变量内容
$.each( { name: "John", lang: "JS" }, function(i, n){
    alert( "Name: " + i + ", Value: " + n );
});
```

* $("选择器").each(function () {});
```js
$("选择器").each(function () {
    console.log(this); // this为选择器匹配的元素数组中的遍历的一个一个元素
});
```
* $("选择器").each(function (i) {});
```js
$("选择器").each(function (i) { // 这里的i为选择器匹配的元素数组遍历时的下标
});  
```
* $("选择器").each(function (i, n) {});
```js
$("选择器").each(function (i, n) { // 这里的i为选择器匹配的元素数组遍历时的下标，n为元素
}); 
```

## 其他
* **对加载后，动态生成的DOM对象上同样自动绑定事件方法**
    ```js
    // 我的域名 分页导航绑定点击事件。
    // DomainPage为方法，{'optype': 2}为要传的参数，需要用字典，不传参可以省略此字段
    $(document).on("click", "#domain_box button[name=jump-page]", {'optype': 2}, DomainPage);
    
    function DomainPage(event){
      if (event.data.optype == 1){
          
      }
    }
    ```
    ```js
    // 该方式，只针在DOM准备就绪后，绑定一次，之后动态生成的DOM对象匹配，即使匹配选择器字，不会自动绑定该事件
    $("选择器字符串").bind('事件名', 方法名);
    ```
* jq对象绑定事件方式
    * jQuery对象.事件名(方法名);
        ```js
        $("选择器字符串").click(方法名或匿名函数);
        ```
    * jQuery对象.bind(type, [selector], [data], fn)
        >css 3.0弃用，建议使用on()
    * jQeury对象.on(events, [selector], [data], fn)
        >当一个事件被触发时要传递event.data给事件处理函数，用{}字典来传包装多个数
    * $(document).on(events, selector, [data], fn);
        ```text
        建议使用此方法，动态生成的DOM对象同样也能绑定上设置的事件  
  
        events: 字符串形式，可以为多个事件，多个事件之间用","分隔，
        selector: 选择器的字符串
        data: 用{}字典来传包装多个数
        fn: 方法
        document参数不能省略
        ```
