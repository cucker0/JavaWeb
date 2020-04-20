package test.com.bookmall.daoimpl; 

import com.bookmall.bean.Author;
import com.bookmall.dao.AuthorDao;
import com.bookmall.daoimpl.AuthorDaoImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
* AuthorDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>03/16/2020</pre> 
* @version 1.0 
*/ 
public class AuthorDaoImplTest { 
    private AuthorDao authorDao = new AuthorDaoImpl();

    @Before
    public void before() throws Exception { 
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
        Author author = new Author(0, "雅科夫·卡茨", "《耶路撒冷邮报》主编，哈佛大学继续教育学院讲师。曾担任《耶路撒冷邮报》的军事记者和国防分析员近十年，与人合著有《以色列与伊朗：影子战争》。现居耶路撒冷。");
        Integer integer = authorDao.saveAuthor(author);
        System.out.println(integer);
    } 

    /** 
    * 
    * Method: deleteAuthorById(int authorId) 
    * 
    */ 
    @Test
    public void testDeleteAuthorById() throws Exception { 
        //TODO: Test goes here...
        int i = authorDao.deleteAuthorById(34);
        System.out.println(i);
    } 

    /** 
    * 
    * Method: updateAuthor(Author author) 
    * 
    */ 
    @Test
    public void testUpdateAuthor() throws Exception { 
        //TODO: Test goes here...
        Author author = authorDao.queryAuthorById(34);
        author.setName("hahaha");
        int i = authorDao.updateAuthor(author);
        System.out.println(i);
    } 

    /** 
    * 
    * Method: queryAllAuthor() 
    * 
    */ 
    @Test
    public void testQueryAllAuthor() throws Exception { 
        //TODO: Test goes here...
        List<Author> authors = authorDao.queryAllAuthor();
        authors.forEach(System.out::println);
    } 

    /** 
    * 
    * Method: queryAuthorById(int authorId) 
    * 
    */ 
    @Test
    public void testQueryAuthorById() throws Exception { 
        //TODO: Test goes here...
        Author author = authorDao.queryAuthorById(10);
        System.out.println(author);
    } 

    /** 
    * 
    * Method: isValidAuthorId(int authorId) 
    * 
    */ 
    @Test
    public void testIsValidAuthorId() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: queryAuthorByNameKey(String nameKey) 
    * 
    */ 
    @Test
    public void testQueryAuthorByNameKey() throws Exception { 
        //TODO: Test goes here...
        List<Author> authors = authorDao.queryAuthorByNameKey("haha");
        authors.forEach(System.out::println);
    }

    /**
     *
     * Method: queryAuthorByIdList(Set<Integer> idSet)
     *
     */
    @Test
    public void testQueryAuthorByIdSet() throws Exception {
        //TODO: Test goes here...
        Set<Integer> idSet = new HashSet<>();
        idSet.add(1);
        idSet.add(3);
        idSet.add(4);
        idSet.add(6);
        idSet.add(null);
        System.out.println(idSet);
        List<Author> authors = authorDao.queryAuthorByIdSet(idSet);
        authors.forEach(System.out::println);
    }

} 
