Filter过滤器
==

## 什么是Filter
* Filter是一个interface接口
* Filter是java web三大组件之一
    >Servlet小程序、Filter过滤器、Listener监听器
* Filter是服务器专门用来过滤请求、拦截响应的，类似于哨卡的作用（进入之前、出来之后做些审问登记）

### Filter的常见作用
* 检查用户访问权限，权限管理
* 设置response编码，解决乱码问题

## 案例
* 需求
    ```text
    现在在WebContent目录下有一个目录admin，
    这个目录是管理员操作的目录，这个目录里有jsp、html、图片资源文件，
    现在我们要让这些资源都在用户登录才能被访问，如何怎么实现这样的需求。
    ```

* session解决思路
    ```text
    我们可以在用户登录之后。把用户的信息保存在session域对象中，
    然后在jsp页面里通过session域对象获取用户的信息，如果用户信息存在，说明用户已登录;
    否则就重定向到登录页面。
    
    缺点：对于html、样式、图片文件则不会进行session判断，因此无法对这类资源无法鉴权
    ```