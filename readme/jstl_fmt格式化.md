jstl fmt格式化
==

https://www.cnblogs.com/Ant-soldier/p/5051873.html
https://www.cnblogs.com/yadongliang/p/6236540.html

## 概述
```text
对数字、日期、货币、国际化等做格式化
```
分类

* 数字、日期、时区标签
    ```text
    <fmt:fromatNumber>
    
    <fmt:formatDate>
    
    <fmt:parseDate>
    
    <fmt:parseNumber>
    
    <fmt:setTimeZone>
    
    <fmt:timeZone>
    ```

* 国际化标签
    ```text
    <fmt:setLocale>
    
    <fmt:requestEncoding>
    
    <fmt:bundle>
    
    <fmt:message>
    
    <fmt:param>
    
    <fmt:setBundle>
        ```

## 数字、日期、时区标签
* \<fmt:formatNumber>
    ```text
    根据区域定制的方式将数字格式化成数字，货币，百分比  
  
    value:要格式化的数字
    
    type：按照什么类型格式化
    
    pattern：自定义格式化样式
    
    currencyCode:ISO-4721货币代码，只适用于按照货币格式化的数字
    
    currencySymbol： 货币符号,如￥,只适用于按照货币格式化的数字
    
    groupingUsed： 是否包含分隔符
    
    maxIntegerDigits： 整数部分最多显示多少位
    
    mixIntegerDigits： 整数部分最少显示多少位
    
    maxFractionDigits： 小数部分最多显示多位位
    
    minFractionDigits： 小数部分最少显示多位位
    
    var: 存储格式化后的结果
    
    scope: 存储的范围
    ```


## 国际化标签