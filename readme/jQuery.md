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
Jquery对象本质是一个数组，jquery对象由dom对象数组、一系列jquery对象提供的方法组成
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

### 基本选择器
```text
#id  id选择器
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
[attribute]
[attribute=value]
[attribute!=value]
[attribute^=value]
[attribute$=value]
[attribute*=value]
[attrSel1][attrSel2][attrSelN]  同时满足多个属性条件
```
### 子元素选择器
```text
:first-child
:first-of-type
:last-child
:last-of-type
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
:checked  已选中的
:selected  已选中的下拉列表选项
```
