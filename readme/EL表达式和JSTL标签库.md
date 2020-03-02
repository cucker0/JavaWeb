EL表达式 和 JSTL标签库
==

## EL表达式
### 什么是EL表达式
```text
EL：Expression Language，表达式语言。
可以输出表达式的值。跟jsp的表达式脚本一样，计算表达式的值后输出。

EL表达式出现的目的是为了使JSP写起来更加简单，让jsp的代码更简化。
主要用于替换 jsp 中表达式脚本
EL表达式的最主要功能就是从域对象中获取数据，并且输出
```

### EL表达式获取域对象属性值
语法
```text
${属性名}
```

### EL表达式运算


## JSTL标签库
```text
JSTL：JSP Standard Tag Library，即JSP标准标签库。

是一个不断完善的开放源代码的JSP标签库。
EL表达式主要是为了替换jsp中的表达式脚本，
而标签库则是为了替换代码脚本。这样使得整个jsp页面变得更佳简洁。

依赖 taglibs lib库
官网：http://archive.apache.org/dist/tomcat/taglibs/

jar包：
taglibs-standard-impl-1.2.5.jar
taglibs-standard-spec-1.2.5.jar
taglibs-standard-compat-1.2.5.jar
```

```text
https://downloads.apache.org/tomcat/taglibs/taglibs-standard-1.2.5/README_bin.txt

CORE LIBRARY
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

XML LIBRARY
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

FMT LIBRARY 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

SQL LIBRARY
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>

FUNCTIONS LIBRARY
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
```

### 使用步骤
1. 导入taglib库
```text
<%@ taglib prefix="tagPrefix" uri="http://java.sun.com/jsp/jstl/core" %>
或
<%@ taglib prefix="tagPrefix" tagDir="tagDir" %>

属性含义
======
    prefix: 标签的前缀，区分多个自定义标签。不可以使用保留前缀和空前缀，遵循XML命名空间的命名约定。
        相当于库的唯一标识，因为JSTL由多个不同的库组成，使用该属性指定要导入哪个库
    uri: 定位标签库描述符的位置。唯一标识和前缀相关的标签库描述符，可以使用绝对或相对URL。
    tagDir: 指示前缀将被用于标识在WEV-INF/tags目录下的标签文件。可解压jar文件，查看.tld文件

```