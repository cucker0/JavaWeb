XML
==

## Table Of Contents
* [XML简介](#XML简介)
    * [XML作用](#XML作用)
* [XML语法](#XML语法)
    * [语法规则](#语法规则)
    * [文档声明](#文档声明)
    * [元素(标签)](#元素标签)
    * [xml属性](#xml属性)
    * [xml注释](#xml注释)
    * [文本区域(CDATA区)](#文本区域CDATA区)
* [xml解析技术](#xml解析技术)
* [dom4j](#dom4j)



## XML简介
```text
xml指的是可扩展的标记性语言
```

### XML作用
* 描述信息
* 用于工程、模块的配置文件
* 用于网络数据传输的格式


## XML语法
* 文档声明
* 元素(标签)
* xml属性
* xml注释(同html)
* 文本区域(CDATA区)

### 语法规则
* 所有xml元素必须闭合
* xml标签对大小写敏感
* xml必须正确嵌套
* 文档必须有且且只有一个根元素，即第一层只能有一个元素
* xml中的特殊字符，同html
* 文本区域(CDATA区)

### 文档声明
```text
<?xml version="1.0" encoding="UTF-8"?>
```
**属性**  
* version  版本
* encoding  xml文件编码
* standalone="yes/no"  表示这个xml文件是否是独立的xml文件

[xml文件示例](../xml/src/books.xml)


### 元素(标签)
```text
元素是指从开始标签到结束标签的内容

可有：
单标签
双标签

大小写敏感
```
* 单标签 格式
```html
<标签名 属性="值" 属性="值" ... ... />
```
* 双标签 格式
```html
<标签名 属性="值" 属性="值" ... ...>文本数据或子标签</标签名>
```

### xml属性
```text
xml的标签属性和html 的标签属性是非常类似的，属性可以提供元素的额外信息  
一个标签上可以书写多个属性。每个属性的值必须使用 引号 引起来。  
规则和标签的书写规则一致。
```
**每个属性的值必须使用 引号 引起来**  

### xml注释
```text
与html相同，块注释

<!--  注释  -->
```

### 文本区域(CDATA区)
```text
一般情况下。xml解析器在解析xml的时候，< >会当有标签来解析，特殊字符做特殊处理，
如果你想这些内容在解析的时候，当成文本来解析的话，就可以使用CDATA区
```

* CDATA 格式
```xml
<![CDATA[ 这里可以把你输入的字符原样显示，不会解析xml ]]>
```
[c3p0-config xml配置有特殊字符的示例](https://github.com/cucker0/jdbc/blob/master/day04/src/c3p0-config.xml)

## xml解析技术
```text
不管是html文件还是xml文件它们都是标记型文档,都可以用dom技术来解析

早期JDK为我们提供了两种xml解析技术Dom和Sax,现在主要用dom4j
```
* dom解析，已经过时
* sax解析，已经过时
* dom4j解析

## dom4j
