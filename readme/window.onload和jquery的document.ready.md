window.onload和jquery的document.ready
==

## window.onload
```text
* 执行时机：在网页中所有元素(包括元素的所有关联文件)完全加载到浏览器后才执行，
    即JavaScript此时可以访问网页中的所有元素。

* 多次执行：JavaScript的onload事件一次只能保存对一个函数的引用，
    他会自动调用最后面的函数覆盖前面的函数。
```

示例
```js
/*
  多次使用：运行结果为：只执行了two
*/
function one(){
    alert("one");
}
function two(){
    alert("two");
}
 
window.onload = one;
window.onload = two;
 
/*
  写法
*/
window.onload = function(){
    // do something
}

// 等价于
$(window).load(function(){
    // do something
})
```

## document.ready
```text
原生的javascript中没有document.ready()，在jQuery中有

* 执行时机：在DOM完全就绪时就可以被调用。

* 多次使用：在同一个文件中多次使用，一次调用。
    理解：document.ready()的意思是在DOM加载完成之后执行ready()方法中的代码，
        换句话说，这个方法的本意是为了让代码的执行时间是在DOM加载完成之后才开始执行。
```

示例
```js
/*
  多次使用：运行结果为：先是one,然后是two
*/
function one(){
    alert("one");
}
function two(){
    alert("two");
}
$(document).ready(function(){
    one();
});
$(document).ready(function(){
    two();
});
 
/*
  写法
*/
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

## document.ready和window.onload的区别
* document.ready，表示文档结构已经加载完成（不包含图片等非文字媒体文件）
* window.onload，指示页面包含图片等文件在内的所有元素都加载完成
* 因此document.ready早于window.onload

## 为什么要使用document.ready或者document.onload
```text
$(document).ready() 里的代码是在页面内容都加载完才执行的，
如果把代码直接写到script标签里，当页面加载完这个script标签就会执行里边的代码了，
此时如果你标签里执行的代码调用了当前还没加载过来的代码或者dom，那么就会报错，

当然如果你把script标签放到页面最后面那么就没问题了，此时和ready效果一样
```