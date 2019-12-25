package com.java.www;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * dom4j测试
 * https://github.com/dom4j/dom4j/wiki/Quick-Start-Guide
 */
public class Dom4jTest {
    /**
     * 读取xml文件
     *
     * @throws DocumentException
     */
    @Test
    public void getDocument() throws DocumentException {
        // 创建SAXReader对象
        SAXReader saxReader = new SAXReader();
        // 调用SAXReader对象的read方法
        Document document = saxReader.read("src/books.xml");
        System.out.println(document);
    }

}
