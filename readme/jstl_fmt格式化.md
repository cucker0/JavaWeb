jstl fmt格式化
==

## 概述
```text
对数字、日期、货币格式化，并做国际化语言环境设置
```
分类

* 数字、日期、时区格式化标签
    ```text
    <fmt:fromatNumber>
    
    <fmt:formatDate>
    
    <fmt:parseDate>
    
    <fmt:parseNumber>
    
    <fmt:setTimeZone>
    
    <fmt:timeZone>
    ```
    [formatnumber 示例](../jspProj/web/jstl/fmt/formatnumber.jsp)

* 国际化标签
    ```text
    <fmt:setLocale>  设置区域
    
    <fmt:requestEncoding>  指定request编码字符码
    
    <fmt:bundle>
    
    <fmt:message>
    
    <fmt:param>
    
    <fmt:setBundle>
        ```

## 数字、日期、时区标签
* \<fmt:formatNumber>
    ```text
    根据区域定制的方式将数字格式化成数字，货币，百分比  
    
    属性:
    ===
    value: 要格式化的数字
    
    type: 按照什么类型格式化
    
    pattern: 自定义格式化样式
    
    currencyCode: ISO-4721货币代码，只适用于按照货币格式化的数字
    
    currencySymbol: 货币符号,如￥,只适用于按照货币格式化的数字
    
    groupingUsed: 是否包含分隔符
    
    maxIntegerDigits: 整数部分最多显示多少位
    
    mixIntegerDigits: 整数部分最少显示多少位
    
    maxFractionDigits: 小数部分最多显示多位位
    
    minFractionDigits: 小数部分最少显示多位位
    
    var: 存储格式化后的结果
    
    scope: 存储的范围
    ```
    ```text
    java格式化输出：
    DecimalFormat df = new DecimalFormat("格式");
    String fmt =df.format(double);
  
    符号          意义
    0            一个数位
    #            一个数位，前导零和追尾零不显示
    .            小数点分割位置
    ,            组分隔符的位置
    -            负数前缀
    %            用100乘，并显示百分号
    其他任何符号    在输出字符串中包括指定符号
    ```
    
* \<fmt:parseNumber>
    ```text
    用来将字符串类型的数字,货币或百分比转换成数字类型，作用与<fmt:formatNumber> 相反
    ```

    [parsenumber 示例](../jspProj/web/jstl/fmt/parsenumber.jsp)

* \<fmt:formatDate>
    ```text
    格式化日期
    
    属性：
    ===
    value: 用来格式化的时间或日期
    
    type: 指定格式化的是日期还是时间，或者两者都是，取值范围:date,time,both
    
    pattern: 自定义格式化样式
    
    dateStyle: 日期的格式化样式
        yyyy: 年
        MM: 两位数的月份
        M：自然数的月份
        dd: 两位数的日
        d: 自然数的日
        HH: 24小时制的时
        hh: 12小时制的时
        mm: 分
        ss: 秒
        SSS: 毫秒
        a: AM、PM
        例：
            yyyy-MM-dd HH:mm:ss
            yyyy-M-d a hh:mm:ss
    
    timeStyle: 时间的格式化样式
    
    timeZone: 指定使用的时区
    
    var: 存储格式化后的结果
    
    scope: 指定存储的范围
    ```
    [formatDate 示例](../jspProj/web/jstl/fmt/formatdate.jsp)
    

* \<fmt:parseDate>
    ```text
    从日期时间中解析出日期对象，作用与<fmt:formatDate>相反
    
    属性：
    ===
    
    value: 用来格式化的时间或日期的字符串，必填
    type: 指定格式化的是日期还是时间,或者两者都是取值范围:date,time,both
    pattern: 自定义格式化样式，必定填
    dateStyle: 日期的格式化样式
    timeStyle: 时间的格式化样式
    timeZone: 指定使用的时区
    var: 存储格式化后的结果
    scope: 指定存储的范围
    ```
    [parseDate 示例](../jspProj/web/jstl/fmt/parsedate.jsp)

* \<fmt:setTimeZone>、\<fmt:timeZone>
    ```text
    设置时区，
    fmt:setTimeZone  在本页面内有效
    
    fmt:timeZone  仅所在的父标签内有效
    
    属性：
    ===
        value: 设定时区，可选EST,CST,MST,PST等 
        var: 存储设定的时区
        scope: 存储的范围
    
    ```