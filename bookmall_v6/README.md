bookmall v6
==

## 本阶段需要实现功能
* 显示登录的用户名
* 注销登录的用户
* 防止表单重复提交
* 图片验证码
* 购物车功能实现
    * 购物车的分析
    * 购物车模型创建
    * 购物车测试
    * double精度问题(使用BigDecimal类型)
    * 添加商品到购物车
    * 显示购物车列表
    * 删除购物车中的商品
    * 修改购物车商品数量
    * 清空购物车
    * 修改首页价格搜索上面的购物车提示


### 显示登录的用户名



### 其他
```text
history.back(-1):直接返回当前页的上一页，数据全部消息，是个新页面
history.go(-1):也是返回当前页的上一页，不过表单里的数据全部还在 
history.back(1) 前进 
history.back(-1) 后退


window.location.reload(); //刷新 
window.history.go(1); //前进 
window.history.go(-1); //返回+刷新 
window.history.forward(); //前进 
window.history.back(); //返回 
```

* 客户端js防止form表单重复提交
```text
<body onunload="location='about:blank'">
```

* 遍历删除Map中符合条件的元素报java.util.ConcurrentModificationException并发修改异常
    [Cart removeCheckedGoods方法](src/com/bookmall/bean/Cart.java)
    
* js修改input值如何触发change事件
    ```text
    1. 在js给input赋值的时候就给目标input标签触发input事件
    $("#inpstart").trigger("input"); 
    
    2. 目标input标签监听input和change事件
    $("#inpstart").on("input propertychange",function () {
        ...
    });
    ```