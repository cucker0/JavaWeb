Book Mall v3说明
==

## 在bookmall基础上，利用jsp技术进一步完善优化
https://github.com/cucker0/JavaWeb/tree/master/bookmall

## 优化要求
* 页面jsp动态化
    ```text
    1.在html页面顶部加上page指令
    2.修改文件后缀扩展名为.jsp
    3.修改完之后。需要把jsp中所有的连接的后缀.html都修改为.jsp
    ```


* 抽取页面中相同的内容
    1. head中css、jquery、base标签
    2. 每个页面的页脚
    3. 登录成功后的菜单
    4. manager模块的菜单

* 登录，注册错误提示，及表单回显
    ```text
    一般在实际工作的情况，就是一个模块，一个Servlet。
    用户登录，和用户注册，一般都在一个UserServlet中。
    ```
* BaseServlet的抽取
* get请求获取请求行，Post请求获取请求体，他们获取参数的区别
* 数据的封装和抽取BeanUtils的使用