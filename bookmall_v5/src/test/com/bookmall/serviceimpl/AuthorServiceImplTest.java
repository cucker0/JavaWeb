package test.com.bookmall.serviceimpl; 

import com.bookmall.bean.Author;
import com.bookmall.service.AuthorService;
import com.bookmall.serviceimpl.AuthorServiceImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* AuthorServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>03/21/2020</pre> 
* @version 1.0 
*/ 
public class AuthorServiceImplTest { 
    private AuthorService authorService;

    @Before
    public void before() throws Exception {
        authorService = new AuthorServiceImpl();
    } 
    
    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: saveAuthor(Author author) 
    * 
    */ 
    @Test
    public void testSaveAuthor() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: deleteAuthorById(int id) 
    * 
    */ 
    @Test
    public void testDeleteAuthorById() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: updateAuthor(Author author) 
    * 
    */ 
    @Test
    public void testUpdateAuthor() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: queryAllAuthor() 
    * 
    */ 
    @Test
    public void testQueryAllAuthor() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: queryAllAuthor(int bookId) 
    * 
    */ 
    @Test
    public void testQueryAllAuthorBookId() throws Exception { 
        //TODO: Test goes here...
        List<Author> authors = authorService.queryAllAuthor(19);
        authors.forEach(System.out::println);
    } 

    /** 
    * 
    * Method: queryAuthorById(int id) 
    * 
    */ 
    @Test
    public void testQueryAuthorById() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: searchAuthorByNameKey(String nameKey) 
    * 
    */ 
    @Test
    public void testSearchAuthorByNameKey() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: queryAuthorByIdSet(Set<Integer> idSet) 
    * 
    */ 
    @Test
    public void testQueryAuthorByIdSet() throws Exception { 
        //TODO: Test goes here... 
    } 


} 
