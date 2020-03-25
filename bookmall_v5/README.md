bookmall v5
==

## 模块拆分
* 图书模块增、删、改、查

    * BookDao接口
    ```text
    savebook  保存指定的图书
    deleteById  删除指定ID的图书
    updateBook  修改图书
    queryAllBooks  查询所有图书
    queryBookById  查询指定ID的图书
    ```

* 图书模块的分页搜索
* 图书首页的显示和按价格条件搜索
* 把分页导航条抽取成一个单独的jsp模块

## MVC概念
```text
M: Model模型
V: View视图
C: Controller控制器

MVC最早出现在JavaEE三层中的WEB层(DAO层、Service层、WEB层)，
它可以指导WEB层代码如何分离
```

* View视图
    >只负责数据和界面的显示，不接受任何与显示数据无关的代码，便于程序员和美工的分工合作--jsp \ html

* Controller控制器
    >只负责接收请求，调用业务层的业务逻辑代码处理请求，然后转发请求到指定的jsp页面，是一个"调度者"角色--Servlet

* Model模型
    >将业务逻辑相关的数据封装为具体的JavaBean类，其中不掺杂任何与数据处理相关的代码--JavaBean (有些取名domain\entity)

MVC是一种思想，MVC的理念是将软件 代码拆分成组件、单独开发、组合使用，目的是是为了解耦合

![](../images/bookmall/bm5_01.png)

## 图书模块实现步骤
1. 创建图书模块的数据库
2. 编写图书的JavaBean--Book类
3. 创建图书模块的BookDao接口和实现类BookDaoImpl
4. 编写BookDao测试用例
5. 编写图书模块的BookService和实现类BookServiceImpl
6. 编写BookServlet类，实现如下功能
    * 列表查询所有图书功能
    * 图书的增加功能
    * 图书的删除功能
    * 图书的修改功能
7. 图书分页器
8. 首页index.jsp页面的访问
    >先经过Servlet获取要显示的数据，再转发到index.jsp显示数据
9. 实现首页图书按价格条件搜索并展示的功能

### 创建图书数据库表
在bookmall项目[第一阶段的sql](../bookmall/sql/bookmall.sql)基础上，执行下列sql
[bookmall_v5 sql脚本](sql/bookmall_v5.sql)

### 编写图书的JavaBean--Book类


### 创建图书模块的BookDao接口和实现类BookDaoImpl

### 编写BookServlet类


### 问题
* QeuryRunner in (set) 模糊查询问题1
    ```java
    String sql = "SELECT id, `name`, brief FROM t_author WHERE id IN (?);";
    getBeanList(sql, "2, 3, 5");
    
    /* 
    参数替换后的sql为：
    SELECT id, `name`, brief FROM t_author WHERE id IN ('2, 3, 5');
    这样的sql查询结果与下列的结果相同
    SELECT id, `name`, brief FROM t_author WHERE id IN (2);
    */
    ```

* QeuryRunner in (set) 模糊查询问题2
    ```java
    String sql = "SELECT id, `name`, brief FROM t_author WHERE id IN ?;";
    getBeanList(sql, "(2, 3, 5)");
    
    /*
    参数替换后的sql为：
    SELECT id, `name`, brief FROM t_author WHERE id IN '(2, 3, 5)';
    会报语法错误
    */
    ```

* 正确示例：QeuryRunner in (set) 模糊查询
    ```java
        public List<Author> queryAuthorByIdSet(Set<Integer> idSet) {
            if (idSet == null || idSet.isEmpty()) {
                return null;
            }
            // 去掉null元素要
            idSet.remove(null);
            // 拼接in (set) 中元素?占位
            // 如：
            // in (?, ?, ?)，需要括号里的内容：?, ?, ?
            String parametersStr = "";
            int i = 0;
            for (Integer id : idSet) {
                ++i;
                if (i == idSet.size()) {
                    parametersStr += "?";
                } else {
                    parametersStr += "?" + ", ";
                }
            }
            Object[] paramertsList = idSet.toArray();
            String sql = String.format("SELECT id, `name`, brief FROM t_author WHERE id IN (%s);", parametersStr);
    //        System.out.println(parametersStr);
            return getBeanList(sql, paramertsList);
        }
    ```
* JavaBean中时间属性(Date, LocalDate等)的处理

    [Book示例中的time属性](src/com/bookmall/bean/Book.java)
    ```test
    添加一个额外的setter方法
    
    用于BeanUtils工具设置 发布日期time
    查询数据库Date字段返回对一数据类型为java.sql.Date
    sql查询语句，查询time列时，需要起别名为sqlTime 或 SqlTime
    如果重载setTime，BeanUtils工具赋值JavaBean时失败，
    报异常：java.sql.SQLException: Cannot set time: incompatible types, cannot convert java.sql.Date to java.time.LocalDate Query: SELECT id, `name`, price, sales, stock, img_path imgPath, publisher_id, `time` FROM  t_book WHERE `name` LIKE ?; Parameters: [%双%]
    ```
    
* 在jsp的表达式中，两int数相除结果为double
```text
<c:forEach var="i" begin="${4 - (3 / 2)}" end = 4 - 1, step="1">
    ${i}
</c:forEach>

// 结果为
2
3


/*
begin="${4 - (3 / 2)}"  结果为2.5
页变量i类型要求为int，所以这时会下取整
*/
```