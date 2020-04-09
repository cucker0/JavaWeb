package test.com.bookmall.daoimpl; 

import com.bookmall.bean.Publisher;
import com.bookmall.dao.PublisherDao;
import com.bookmall.daoimpl.PublisherDaoImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* PublisherDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>03/17/2020</pre> 
* @version 1.0 
*/ 
public class PublisherDaoImplTest { 
    private PublisherDao publisherDao = new PublisherDaoImpl();

    @Before
    public void before() throws Exception { 
    } 
    
    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: savePublisher(Publisher publisher) 
    * 
    */ 
    @Test
    public void testSavePublisher() throws Exception { 
        //TODO: Test goes here...
        Publisher publisher = new Publisher(0, "高等教育出版社");
        Integer id = publisherDao.savePublisher(publisher);
        System.out.println(id);
    } 

    /** 
    * 
    * Method: deletePublisherById(int publisherId) 
    * 
    */ 
    @Test
    public void testDeletePublisherById() throws Exception { 
        //TODO: Test goes here...
        int i = publisherDao.deletePublisherById(21);
        System.out.println(i);
    } 

    /** 
    * 
    * Method: updatePublisher(Publisher publisher) 
    * 
    */ 
    @Test
    public void testUpdatePublisher() throws Exception { 
        //TODO: Test goes here...
        Publisher publisher = publisherDao.queryPublisherById(2);
        publisher.setName("机械工业出版社222");
        int i = publisherDao.updatePublisher(publisher);
        System.out.println(i);
    } 

    /** 
    * 
    * Method: queryAllPublisher() 
    * 
    */ 
    @Test
    public void testQueryAllPublisher() throws Exception { 
        //TODO: Test goes here...
        List<Publisher> publishers = publisherDao.queryAllPublisher();
        for (int i = 0; i <publishers.size(); ++i) {
            System.out.println(publishers.get(i));
        }
    } 

    /** 
    * 
    * Method: queryPublisherById(int publisherId) 
    * 
    */ 
    @Test
    public void testQueryPublisherById() throws Exception { 
        //TODO: Test goes here...
        Publisher publisher = publisherDao.queryPublisherById(2);
        System.out.println(publisher);
    } 

    /** 
    * 
    * Method: queryPublisherByNameKey(String nameKey) 
    * 
    */ 
    @Test
    public void testQueryPublisherByNameKey() throws Exception { 
        //TODO: Test goes here...
        List<Publisher> publishers = publisherDao.queryPublisherByNameKey("中国");
        for (Publisher p : publishers) {
            System.out.println(p);
        }
    } 


} 
