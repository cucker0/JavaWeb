Book Mall
==

## jar导入
**一个lib库一个jar包方式**
1. 使用添加jar包到Modules
    ```text
    先是添加Global Libraries，在从Global Libraries添加到。
    可以为一个Global Librarie添加多个jar包，如建立一个tomcat的Library，然后把相关的jar都添加进来，这样方便操作
    需要的Modules。
    ```
2. 在Artifacts中把Modules中的包添加到WEB-INF/lib
    ```text
    dbutils使用上述的方法导入后，在访问web时，包下列错误：
    java.lang.ClassNotFoundException: org.apache.commons.dbutils.ResultSetHandler
    ```
    ![](../images/tomcat/dbutils_01.png)

    **处理方法**
    ```text
    Project Structure ->Artifacts ->Output Layout
    右键 commons-dbutils-1.7，点击 Put into/WEB-INF/lib，
    其他包类似
    点击应用，重启tomcat即可
    ```
    ![](../images/tomcat/dbutils_02.png)  
    
    ![](../images/tomcat/dbutils_03.png)
    
* Artifacts批量导入jar包
    ![](../images/tomcat/artifacts_import_jar.png)  
    ![](../images/tomcat/artifacts_import_jar_02.png)  

**一个lib库包括多个jar方式(操作方便)**
    1. Global Libraries中添加一个Library，比如命名为tomcat
    ![](../images/tomcat/jar_import01.png)  
    2. 从把全局的tomcat库添加到Modules
    ![](../images/tomcat/jar_import02.png)  
    3. Artifacts中把tomcat库添加到WEB-INF/lib
    ![](../images/tomcat/jar_import03.png)  