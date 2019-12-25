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