package test.com.bookmall.serviceimpl; 

import com.bookmall.bean.Publisher;
import com.bookmall.service.PublisherService;
import com.bookmall.serviceimpl.PublisherServiceImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* PublisherServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>03/21/2020</pre> 
* @version 1.0 
*/ 
public class PublisherServiceImplTest {
    private PublisherService publisherService = new PublisherServiceImpl();


    @Before
    public void before() throws Exception { 
    } 
    
    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: addPublisher(Publisher publisher) 
    * 
    */ 
    @Test
    public void testAddPublisher() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: deletePublisherById(int id) 
    * 
    */ 
    @Test
    public void testDeletePublisherById() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: updatePublisher(Publisher publisher) 
    * 
    */ 
    @Test
    public void testUpdatePublisher() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: queryAllPublisher() 
    * 
    */ 
    @Test
    public void testQueryAllPublisher() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: queryAllPublisher(int bookId) 
    * 
    */ 
    @Test
    public void testQueryAllPublisherBookId() throws Exception { 
        //TODO: Test goes here...
        List<Publisher> publishers = publisherService.queryAllPublisher(43);
        publishers.forEach(System.out::println);
    } 

    /** 
    * 
    * Method: queryPublisherById(int id) 
    * 
    */ 
    @Test
    public void testQueryPublisherById() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: searchPublisherByNameKey(String nameKey) 
    * 
    */ 
    @Test
    public void testSearchPublisherByNameKey() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: isValidPublisherById(int id) 
    * 
    */ 
    @Test
    public void testIsValidPublisherById() throws Exception { 
        //TODO: Test goes here... 
    } 


} 
