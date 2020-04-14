package test.com.bookmall.daoimpl; 

import com.bookmall.bean.Order;
import com.bookmall.dao.OrderDao;
import com.bookmall.daoimpl.OrderDaoImpl;
import com.bookmall.utils.CommonUtils;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.time.LocalDateTime;
import java.util.List;

/** 
* OrderDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>04/14/2020</pre> 
* @version 1.0 
*/ 
public class OrderDaoImplTest { 
    private OrderDao orderDao;

    @Before
    public void before() throws Exception {
        orderDao = new OrderDaoImpl();
    } 
    
    @After
    public void after() throws Exception { 
    } 
    
    /** 
    * 
    * Method: saveOrder(Order order) 
    * 
    */ 
    @Test
    public void testSaveOrder() throws Exception {
        int userId = 1;
        String orderId = CommonUtils.generateOrderId(1); // "1586871637027_1"
        Order order = new Order(orderId, userId, 999.99, 0, LocalDateTime.now());
        orderDao.saveOrder(order);
    } 
    
    /** 
    * 
    * Method: queryOrderById(String orderId) 
    * 
    */ 
    @Test
    public void testQueryOrderById() throws Exception {
        String orderId = "1586871637027_1";
        Order order = orderDao.queryOrderById(orderId);
        System.out.println(order);
    } 
    
    /** 
    * 
    * Method: queryOrdersByUserId(int userId) 
    * 
    */ 
    @Test
    public void testQueryOrdersByUserId() throws Exception {
        List<Order> orders = orderDao.queryOrdersByUserId(1);
        System.out.println(orders);
    } 
    
    /** 
    * 
    * Method: updateOrderStatus(String orderId, int status) 
    * 
    */ 
    @Test
    public void testUpdateOrderStatus() throws Exception {
        String orderId = "1586871637027_1";
        Order order = orderDao.queryOrderById(orderId);
        System.out.println("status: " + order.getStatus());

        orderDao.updateOrderStatus(orderId, 1);
        Order order2 = orderDao.queryOrderById(orderId);
        System.out.println("status: " + order2.getStatus());
    } 
    
    
} 
