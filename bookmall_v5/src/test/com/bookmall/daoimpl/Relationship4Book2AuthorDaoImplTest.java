package test.com.bookmall.daoimpl; 

import com.bookmall.bean.Relationship4Book2Author;
import com.bookmall.dao.Relationship4Book2AuthorDao;
import com.bookmall.daoimpl.Relationship4Book2AuthorDaoImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* Relationship4Book2AuthorDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>03/16/2020</pre> 
* @version 1.0 
*/ 
public class Relationship4Book2AuthorDaoImplTest { 
    private Relationship4Book2AuthorDao rDao = new Relationship4Book2AuthorDaoImpl();

    @Before
    public void before() throws Exception { 
    } 
    
    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: saveSingleRelationship4Book2Author(int bookId, int authorId) 
    *
     * @throws Exception
     */
    @Test
    public void testSaveSingleRelationship4Book2Author() throws Exception { 
        //TODO: Test goes here...
//        Integer i1 = rDao.saveSingleRelationship4Book2Author(3, 3);
//        Integer i2 = rDao.saveSingleRelationship4Book2Author(3, 4);
        Integer i1 = rDao.saveSingleRelationship4Book2Author(10, 10);
        Integer i2 = rDao.saveSingleRelationship4Book2Author(10, 11);
        System.out.println(i1);
        System.out.println(i2);
    }

    /** 
    * 
    * Method: deleteRelationship4Book2AuthorByBookId(int bookId) 
    * 
    */ 
    @Test
    public void testDeleteRelationship4Book2AuthorByBookId() throws Exception { 
        //TODO: Test goes here...
        int i = rDao.deleteRelationship4Book2AuthorByBookId(10);
        System.out.println(i);
    } 

    /** 
    * 
    * Method: deleteRelationship4Book2AuthorByBookIdAndAuthorId(int bookId, int authorId) 
    * 
    */ 
    @Test
    public void testDeleteRelationship4Book2AuthorByBookIdAndAuthorId() throws Exception { 
        //TODO: Test goes here...
        int i = rDao.deleteRelationship4Book2AuthorByBookIdAndAuthorId(3, 3);
        int i2 = rDao.deleteRelationship4Book2AuthorByBookIdAndAuthorId(3, 4);
        System.out.println(i);
    } 

    /** 
    * 
    * Method: queryAuthorsByBookId(int bookId) 
    * 
    */ 
    @Test
    public void testQueryAuthorsByBookId() throws Exception { 
        //TODO: Test goes here...
        List<Relationship4Book2Author> relationship4Book2Authors = rDao.queryAuthorsByBookId(10);
        System.out.println(relationship4Book2Authors);
        // [Relationship4Book2Author{id=11, bookId=10, authorId=10}, Relationship4Book2Author{id=12, bookId=10, authorId=11}]
    } 

    /** 
    * 
    * Method: queryBooksByAuthorId(int authorId) 
    * 
    */ 
    @Test
    public void testQueryBooksByAuthorId() throws Exception { 
        //TODO: Test goes here...
        List<Relationship4Book2Author> relationship4Book2Authors = rDao.queryBooksByAuthorId(1);
        System.out.println(relationship4Book2Authors);
        // [Relationship4Book2Author{id=2, bookId=2, authorId=1}]
    } 

    /** 
    * 
    * Method: isValidRelationshipQeuryByBookIdAndAuthorId(int bookId, int authorId) 
    * 
    */ 
    @Test
    public void testIsValidRelationshipQeuryByBookIdAndAuthorId() throws Exception { 
        //TODO: Test goes here...
        boolean status = rDao.isValidRelationshipQeuryByBookIdAndAuthorId(3, 4);
        System.out.println(status);
    }


} 
