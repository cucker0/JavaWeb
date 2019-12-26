dom4j
==


## 概述
```text
dom4j is an open source framework for processing XML which is integrated with XPath and fully supports DOM, SAX, JAXP and the Java platform such as Java 2 Collections

项目地址：https://github.com/dom4j/dom4j
flexible XML framework for Java https://dom4j.github.io

dom4j 的xpath功能依赖 jaxen.jar包，否则报异常：java.lang.NoClassDefFoundError: org/jaxen/JaxenException

jaxen项目地址：https://github.com/jaxen-xpath/jaxen

jaxen.jar包可以通过下面的地址下载
https://maven.aliyun.com/repository/central/jaxen/jaxen/1.2.0/jaxen-1.2.0.jar?spm=a2c40.aliyun_maven_repo.repo_mvn_view.3.36183054fU1RUo&file=jaxen-1.2.0.jar
```

## dom4j使用
* readXml
* addXml
* xpath快速搜索

[Dom4jTest](../xml/src/com/java/www/Dom4jTest.java)

[Xpath 示例](./Xpath_simples.pdf)

## XPath快速搜索
```text
XPath，全称 XML Path Language，即 XML 路径语言，它是一门在 XML 文档中查找信息的语言。
XPath 的选择功能十分强大，它提供了非常简洁明了的路径选择表达式。
它还提供了超过 100 个内建函数，用于字符串、数值、时间的匹配以及节点、序列的处理等，几乎所有想要定位的节点都可以用 XPath 来选择。

官方文档：
https://www.w3.org/TR/xpath/all/
```

### XPath常用规则

表达式 |描述
:--- |:---
nodename |选择此节点的所有子节点
`/` |从当前节点选取直接节点
`//` |从当前节点选取所有后代节点
. |选择当前节点
.. |选取当前节点的父节点
@ |属性过虑,如@id、@id='12'
* |匹配所有元素
[x] |选择节点数组中索引为x的节点
[last()] |节点数组中的最后一个元素
[@attr=xx] |过滤属性=xx的节点
`/text()` |获取该节点的文本
:: |节点轴选择


### XPath运算符

运算符	|描述	|实例	|返回值
:--- |:--- |:--- |:--- 
or |或 |age=18 or age=20 |age=18：True；<br>age=21：False
and |与 |age>18 and age<21 |age=20：True；<br>age=21：False
mod	|计算除法的余数 |5 mod 2 |1 
&#124; |多个节点集的并集 |//book &#124; //cd | 返回所有拥有 book 和 cd 元素的节点集
+ |加法 |5 + 3 |8
- |减法 |5 - 3 |2
* |乘法 |5 * 3 |15
div	|除法 |8 div 4 |2
= |等于 |age=19 | 
! |	不等于 |age!=19 |
< |小于 |age<19 |
< |小于等于 |age<=19 |
`>` |大于 |age>19 |
`>` |大于等于 |age>=19 |

### XPath内置函数
https://www.w3school.com.cn/xpath/xpath_functions.asp

