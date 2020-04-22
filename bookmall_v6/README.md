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
* 订单模块

### 添加订单表和订单项表
[sql脚本](sql/bookmall_v6.sql)

### 显示登录的用户名
```text
在login的方法中，登录成功时，把User对象保存到session域对象中 session.setAttribute("user", user1);
在需要显示的jsp页面中，从session中获取user信息，session.getAttribute("user");
```

### 注销登录的用户
```text
只需要在UserServlet中添加一个logout方法，让用户访问之后把Session中的用户信息移除。
移除用户信息之后，可以让页面重定向到首页面，或者登录页面
```

### 防止表单重复提交
```text
当我们注册完用户后，跳转去注册成功页面。我们按下F5 刷新页面。这时候页面会提示我们是不是要重复提交表单。
这个时候，如果我们点击【继续】，表单又会重新请求一次，这样我们的网站的健壮性就不够好。
```
* 表单重复提交有三个原因
    * 表单提交成功后，刷新页面
    * 提交表单的时候网络比较慢（服务器sleep(3000)模拟），提不过去,所以多点几次提交。发了多次的请求。
    * 用户提交完成之后，回退浏览器到上一个页面，然后再次提交

* 解决方案
    * 使用重定向
        >response.sendRedirect(跳转的URL); 但用户回退再提交也存在问题
    * 使用token防止表单重复提交(推荐，解决所有问题)

#### token防止表单重复提交
1. 在表单页面端使用代码生成一个token存放到Session对象中
2. 在Servlet中，获取Session中的token数据做对比。如果相同就执行业务操作，然后移除token数据。

### kaptcha图片验证码
```text
验证码，其实和我们前面讲的token是一样的。可以有效的防止用户恶意的提交数据。
我们使用的是谷歌的kaptcha验证码
```

### kaptcha验证码使用步骤
1. 添加kaptcha的lib类库
2. 在web.xml中配置kaptcha类库中用于生成验证码的Servlet程序和访问地址	
3. 在页面中使用<img>标签的src属性引入访问路径。（验证码前端验证需要结合Ajax使用。）
4. 在接收的Servlet程序中通过Session获取验证码对比


### 购物车功能实现
* Cart 购物车Bean
    * 添加商品
    * 删除商品
    * 调整商品数量
    * 清空购物车
    * 或去购物车中所有的商品
    * 计算购物车所有商品的总结，各个商品的小计总结

* CartGoods商品Bean模型
    * 商品id
    * 商品名称
    * 商品价格
    * 商品数量
    * 是否选中

* [购物车Servlet](src/com/bookmall/web/CartServlet.java)


* 
```text
这里我们使用session来保存购物车信息。
实际生产可以用数据库保存、session保存

如果我们的购物车信息，需要Session钝化和活化，就必须让Cart和CartGoods类实现序列化Serializable 接口
```

#### 浮点数，计算的精度问题
[示例BigDecimalTest](src/test/com/bookmall/bean/BigDecimalTest.javas)

* 小结
```text
千万要记住：在java编程中。如果遇到和钱有关的数据，对精度有要求的，必须使用BigDecimal类。
像double，float这种数据类型都是会有精度丢失的。
```

### 订单模块
* Order Bean
    ```text
        // 订单id
        private String id;
        // 订单关联的用户id
        private int userId;
        // 此订单的总金额
        private BigDecimal totalAmount;
        // 订单的物流状态，0:未发货  1:已发货  2:用户已签收
        private int status;
        // 支付状态， 0:未付款， 1:已支付, 2:订单取消
        private int payStatus = 0;
        // 订单创建时间
        private LocalDateTime createTime;
    ```
    * 创建订单
    * 通过订单号查询订单
    * 通过用户id查询他的所有订单
    * 更新订单的物流状态
    * 更新订单的支付状态
    * 分页查询订单
    * 支付订单

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
* 解决行内块元素（inline-block）之间的空格(空白)问题
    * 方法1：多个内联元素代码不换行，写到一行上
        ```html
        <div style="border:1px red solid">
            <a style="display:inline-block;width:20%;">1111</a><a 
            style="display:inline-block;width:80%;">2222</a>
        </div>
        ```
        ```html
        <div style="border:1px red solid">
           <a style="display:inline-block;width:20%;">1111</a><a style="display:inline-block;width:80%;">2222</a>
        </div>
        ```
        ```html
        <!-- 使用注释，把换行与空格注释掉 -->
        <div style="border:1px red solid">
            <a style="display:inline-block;width:20%;">1111</a><!--
         --><a style="display:inline-block;width:80%;">2222</a>
        </div>
        ```
    * 方法2：在父元素上设置字体大小为0
        ```css
        符元素 {
            font-size: 0;
        }
        ```
    * 方法3：display不用inline-block改为float