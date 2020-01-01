js中(function(){}()),(function(){})(),$(function(){})之间的区别
==

## 3中写法
```js
(function () {
    // 方法体
}());

(function () {
    // 方法体
})();

$(function () {
   // 方法体 
});
```

## (function(){}())与(function(){})()
```text
都是立即执行函数，或叫自执行函数
即IIFE (Immediately Invoked Function Expression)。
这种函数在函数定义的地方就直接执行了

没有名称，在解释器经过它们时执行一次
```

## $(function(){})
```text
$(function(){/*...*/}) 是$(document).ready(function(){/*...*/})的简写形式，
是在DOM加载完成后执行的回调函数，并且只会执行一次。
```