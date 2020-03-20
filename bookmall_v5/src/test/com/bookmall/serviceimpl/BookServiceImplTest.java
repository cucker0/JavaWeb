package test.com.bookmall.serviceimpl; 

import com.bookmall.bean.Author;
import com.bookmall.bean.Book;
import com.bookmall.bean.Publisher;
import com.bookmall.service.AuthorService;
import com.bookmall.service.BookService;
import com.bookmall.service.PublisherService;
import com.bookmall.serviceimpl.AuthorServiceImpl;
import com.bookmall.serviceimpl.BookServiceImpl;
import com.bookmall.serviceimpl.PublisherServiceImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** 
* BookServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>03/19/2020</pre> 
* @version 1.0 
*/ 
public class BookServiceImplTest { 
    private BookService bookService;
    private AuthorService authorService;
    private PublisherService publisherService;

    @Before
    public void before() throws Exception {
        bookService = new BookServiceImpl();
        authorService = new AuthorServiceImpl();
        publisherService = new PublisherServiceImpl();
    } 
    
    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: addBook(Book book) 
    * 
    */ 
    @Test
    public void testAddBook() throws Exception { 
        //TODO: Test goes here...
        List<Author> authors = new ArrayList<>();
        authors.add(authorService.queryAuthorById(1));
        authors.add(authorService.queryAuthorById(2));
        Publisher publisher = publisherService.queryPublisherById(1);
        Book book = new Book();
        book.setName("光阴似箭");
        book.setPrice(9.9);
        book.setSales(10);
        book.setStock(2);
        book.setTime(LocalDate.now());
        book.setAuthors(authors);
        book.setPublisher(publisher);
        //System.out.println(book);
        //System.out.println("time:" + book.getTime());
        bookService.addBook(book);
    } 

    /** 
    * 
    * Method: deleteBookById(int id) 
    * 
    */ 
    @Test
    public void testDeleteBookById() throws Exception { 
        //TODO: Test goes here...
        bookService.deleteBookById(34);
        bookService.deleteBookById(38);
        bookService.deleteBookById(42);
        bookService.deleteBookById(41);
    }

    /** 
    * 
    * Method: updateBook(Book book) 
    * 
    */ 
    @Test
    public void testUpdateBook() throws Exception { 
        //TODO: Test goes here...
        Book book = bookService.queryBookById(31);
        book.setName("武林神功");
        bookService.updateBook(book);
        System.out.println(bookService.queryBookById(31));
    } 

    /** 
    * 
    * Method: queryAllBook() 
    * 
    */ 
    @Test
    public void testQueryAllBook() throws Exception { 
        //TODO: Test goes here...
        List<Book> books = bookService.queryAllBook();
        books.forEach(System.out::println);
    } 

    /** 
    * 
    * Method: queryBookById(int id) 
    * 
    */ 
    @Test
    public void testQueryBookById() throws Exception { 
        //TODO: Test goes here...
        Book book = bookService.queryBookById(35);
        System.out.println(book);
    } 

    /** 
    * 
    * Method: searBooksByNameKey(String nameKey) 
    * 
    */ 
    @Test
    public void testSearBooksByNameKey() throws Exception { 
        //TODO: Test goes here...
        List<Book> books = bookService.searBooksByNameKey("光阴似箭");
        books.forEach(System.out::println);
    } 

    /** 
    * 
    * Method: isValidBook(Book book) 
    * 
    */ 
    @Test
    public void testIsValidBook() throws Exception { 
        //TODO: Test goes here...
        List<Author> authors = new ArrayList<>();
        authors.add(authorService.queryAuthorById(1));
        authors.add(authorService.queryAuthorById(2));
        Publisher publisher = publisherService.queryPublisherById(1);
        Book book = new Book();
        book.setName("光阴似箭");
        book.setPrice(9.9);
        book.setSales(10);
        book.setStock(2);
        book.setTime(LocalDate.now());
        book.setAuthors(authors);
        book.setPublisher(publisher);
        boolean status = bookService.isValidBook(book);
        System.out.println(status);
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
        idSet.add(1);
        idSet.add(3);
        idSet.add(10);
        List<Book> books = bookService.queryBookByIdSet(idSet);
        books.forEach(System.out::println);
    }


} 
