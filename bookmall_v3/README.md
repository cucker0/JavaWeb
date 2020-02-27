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

* 登录、注册错误提示、及表单回显
    ```text
    一般在实际工作的情况，就是一个模块，一个Servlet。
    用户登录，和用户注册，一般都在一个UserServlet中。
    ```
* BaseServlet的抽取
    ```text
    一般在实际项目中，一个数据库表，对应一个实体类。
    一个实体类对应一个DAO模块和一个service，这个DAO模块与不这个service是对应的。
    一个模块对应一个servlet程序
    
    要求：客户端请求的action参数值与业务方法名相同
          继承于BaseServlet的Servlet业务方法，访问权限至少为protected
          通过获取客户端请求的action参数值，然后通过反射找到相应的方法，再调用该方法
      
  
    ```
* GET与POST请求获取参数区别
    * GET
        ```text
        GET请求从请求行获取参数
        
        在form标签的action属性值中，在URL后直接追加?key1=value&key2=value的时候，
        action属性中的参数，会直接被表单项中的其他参数覆盖掉。
        这个时候服务器收不到参数
        ```
    * POST
        ```text
        POST请求从请求体获取参数。
        
        在form标签的action属性值中，在URL后直接追加?key1=value&key2=value的时候，
        action中的参数会被提交到服务器
        ```
        
    * 建议
    ```text
    尽量使用input标签去传参数：
    <input type="hidden" name="key" value="">
    
    无论是GET请求，还是POST请求，参数都可以传到服务器
    ```

* 数据的封装和抽取BeanUtils的使用