package com.java.www;

import com.java.Bean.Book;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.junit.Test;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.List;


/**
 * dom4j测试
 * https://github.com/dom4j/dom4j/wiki/Quick-Start-Guide
 */
public class Dom4jTest {
    /**
     * 获取document
     *
     * @throws DocumentException
     */
    @Test
    public void getDocument() throws DocumentException {
        // 1. 创建SAXReader对象
        SAXReader saxReader = new SAXReader();
        // 2. 调用SAXReader对象的read方法
        Document document = saxReader.read("src/books.xml");
        System.out.println(document);
    }

    /**
     * 读取xml文件内容，生成Book对象
     *
     * @throws Exception
     */
    @Test
    public void readXml() throws Exception {
        SAXReader reader = new SAXReader();
        // 从一个URL读取xml
        Document document = reader.read(new URL("file:///E:/dev/JavaWeb/xml/src/books.xml"));
        // 获取root元素
        Element root = document.getRootElement();
        List<Element> books = root.elements();

        for (Element book : books) {
            Element name = book.element("name");
            String nameStringValue =  name.getStringValue();
            // 获取元素文本
            String priceStringValue = book.elementText("price");
            String authorStringValue = book.elementText("author");
            // 获取元素属性值
            String snValue = book.attributeValue("sn");
//            System.out.printf("name:%s price:%s author:%s sn:%s\n",
//                    nameStringValue, priceStringValue, authorStringValue, snValue);
            Book bk = new Book(snValue, nameStringValue, Double.valueOf(priceStringValue), authorStringValue);
            System.out.println(bk);
        }
    }

    /**
     * 给第二个book添加子元素: <girl boyfriend=”班长”>凤姐</girl>
     *
     * @throws DocumentException
     */
    @Test
    public  void addXml() throws DocumentException, IOException {
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/books.xml");

        Element root = document.getRootElement();
        Element secondBook = root.elements("book").get(1);
//        System.out.println(secondBook.asXML()); // 打印xml文本
        // 添加<girl></girl>
        Element girlElement = secondBook.addElement("girl");
        // 给元素设置文本，<girl>凤姐</girl>
        girlElement.setText("凤姐");
        //
        girlElement.addAttribute("boyfriend", "班长");
        System.out.println(girlElement.asXML());

        // 将修改后的xml保存到硬盘文件
        // 方法1
        /*
        FileWriter fw = new FileWriter("out1.xml");
        document.write(fw);
        fw.flush();
        fw.close();
        */

        // 方法2
        // lets write to a file
        /*
        XMLWriter writer = new XMLWriter(
                new FileWriter("out2.xml")
        );
        writer.write(document);
        writer.close();
        */

        // 方法3: 格式化xml输出
        // ，Pretty print the document to System.out
        /*
        OutputFormat format = OutputFormat.createPrettyPrint();
        FileWriter fw = new FileWriter("out3.xml");
        XMLWriter writer = new XMLWriter(fw, format);
        writer.write(document);
        writer.close();
        */

        // 方法4：紧凑格式化
        // Compact format to System.out
        OutputFormat format = OutputFormat.createCompactFormat();
        FileWriter fw = new FileWriter("out4.xml");
        XMLWriter writer = new XMLWriter(fw, format);
        writer.write(document);
        writer.close();
    }


    /**
     * xpath快速搜索测试
     * 标签、元素、属性等的查找
     *
     * xpath依赖jaxen.jar
     * @throws DocumentException
     */
    @Test
    public void xpathTest() throws DocumentException {
        SAXReader reader = new SAXReader();
        Document document = reader.read("src/books.xml");

        // 需求1：获取books下的所有book标签 /books/book
        List<Node> nodes = document.selectNodes("/books/book");
        System.out.println(nodes.size());

        // 需求2：获取根标签下的books元素下的book元素，且这个book元素拥有sn属性，且值为SN12341231。下的name元素	/books/book[@sn='SN12341231']/name
        Node node = document.selectSingleNode("/books/book[@sn='SN12341231']/name");
        System.out.println(node.asXML());

        // 需求3：获取根标签下的books元素下的第一个book元素	/books/book[1]
        Node book = document.selectSingleNode("/books/book[1]");
        System.out.println(book.asXML());
    }
}
