package test.com.bookmall.daoimpl; 

import com.bookmall.bean.Book;
import com.bookmall.dao.BookDao;
import com.bookmall.daoimpl.BookDaoImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
* BookDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>03/16/2020</pre> 
* @version 1.0 
*/ 
public class BookDaoImplTest { 
    private BookDao bookDao;

    @Before
    public void before() throws Exception {
        bookDao = new BookDaoImpl();
    } 
    
    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: saveBook(Book book) 
    * 
    */ 
    @Test
    public void testSaveBook() throws Exception { 
        //TODO: Test goes here...
        Book book = new Book(null, "时间简史", 33.4, 10, 20, "https://img.jd.com/2020/sjjs.png",
                null, null, LocalDate.now());
        Integer auto_increment_id = bookDao.saveBook(book);
        System.out.println(auto_increment_id);
    } 

    /** 
    * 
    * Method: deleteBookById(int bookId) 
    * 
    */ 
    @Test
    public void testDeleteBookById() throws Exception { 
        //TODO: Test goes here...
        int i = bookDao.deleteBookById(23);
        System.out.println(i);
    } 

    /** 
    * 
    * Method: updateBook(Book book) 
    * 
    */ 
    @Test
    public void testUpdateBook() throws Exception { 
        //TODO: Test goes here...
        Book book = bookDao.queryBookById(23);
        book.setPrice(99.0);
        int i = bookDao.updateBook(book);
        System.out.println(i);

    } 

    /** 
    * 
    * Method: queryAllBook() 
    * 
    */ 
    @Test
    public void testQueryAllBook() throws Exception { 
        //TODO: Test goes here...
        List<Book> books = bookDao.queryAllBook();
        books.forEach(System.out::println);
    } 

    /** 
    * 
    * Method: queryBookById(int bookdId) 
    * 
    */ 
    @Test
    public void testQueryBookById() throws Exception { 
        //TODO: Test goes here...
        Book book = bookDao.queryBookById(23);
        System.out.println(book);
    } 

    /** 
    * 
    * Method: isValidBookId(int bookId) 
    * 
    */ 
    @Test
    public void testIsValidBookId() throws Exception { 
        //TODO: Test goes here...
        boolean status = bookDao.isValidBookId(19);
        System.out.println(status);
    } 

    /** 
    * 
    * Method: queryBookByIdNameKey(String nameKey) 
    * 
    */ 
    @Test
    public void testQueryBookByIdNameKey() throws Exception { 
        //TODO: Test goes here...
        List<Book> books = bookDao.queryBookByIdNameKey("双");
        System.out.println(books);
    }

    /**
     *
     * Method: queryBookByIdSet(Set<Integer> idSet)
     *
     */
    @Test
    public void testQueryBookByIdSet() throws Exception {
        //TODO: Test goes here...
        Set<Integer> idSet = new HashSet<>();
        idSet.add(2);
        idSet.add(5);
        idSet.add(8);
        List<Book> books = bookDao.queryBookByIdSet(idSet);
        books.forEach(System.out::println);
    }
} 
