package test.com.bookmall.serviceimpl; 

import com.bookmall.bean.Book;
import com.bookmall.bean.Cart;
import com.bookmall.bean.CartGoods;
import com.bookmall.bean.Order;
import com.bookmall.dao.BookDao;
import com.bookmall.daoimpl.BookDaoImpl;
import com.bookmall.service.OrderService;
import com.bookmall.serviceimpl.OrderServiceImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* OrderServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>04/14/2020</pre> 
* @version 1.0 
*/ 
public class OrderServiceImplTest { 
    private OrderService  orderService;
    private BookDao bookDao;

    @Before
    public void before() throws Exception {
        orderService = new OrderServiceImpl();
        bookDao = new BookDaoImpl();
    } 
    
    @After
    public void after() throws Exception { 
    } 
    
    /** 
    * 
    * Method: addOrder(Cart cart, int userId) 
    * 
    */ 
    @Test
    public void testAddOrder() throws Exception {
        Cart cart = new Cart();
        Book book = bookDao.queryBookById(7);
        Book book2 = bookDao.queryBookById(10);
        CartGoods goods = new CartGoods(book.getId(), book.getName(), book.getPrice(), 1);
        CartGoods goods2 = new CartGoods(book2.getId(), book2.getName(), book2.getPrice(), 3);
        cart.addGoods(goods);
        cart.addGoods(goods2);
        cart.addGoods(goods2);
        String orderId = orderService.addOrder(cart, 1); // "1586875915958_1"
        System.out.println(orderId);
    }
    
    /** 
    * 
    * Method: queryOrderById(String orderId) 
    * 
    */ 
    @Test
    public void testQueryOrderById() throws Exception {
        String orderId = "1586875915958_1";
        Order order = orderService.queryOrderById(orderId);
        System.out.println(order);
    } 
    
    /** 
    * 
    * Method: queyrOrdersByUserId(int userId) 
    * 
    */ 
    @Test
    public void testQueyrOrdersByUserId() throws Exception {
        List<Order> orders = orderService.queyrOrdersByUserId(1);
        System.out.println(orders);
    } 
    
    /** 
    * 
    * Method: updateOrderStatus(String orderId, int status) 
    * 
    */ 
    @Test
    public void testUpdateOrderStatus() throws Exception {
        testQueryOrderById();
        orderService.updateOrderStatus("1586875915958_1", 2);
    } 
    
    
} 
