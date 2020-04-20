package test.com.bookmall.daoimpl; 

import com.bookmall.bean.OrderItem;
import com.bookmall.dao.OrderItemDao;
import com.bookmall.daoimpl.OrderItemDaoImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After;

import java.util.List;

/** 
* OrderItemDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>04/14/2020</pre> 
* @version 1.0 
*/ 
public class OrderItemDaoImplTest { 
    private OrderItemDao orderItemDao;

    @Before
    public void before() throws Exception {
        orderItemDao = new OrderItemDaoImpl();
    } 
    
    @After
    public void after() throws Exception { 
    } 
    
    /** 
    * 
    * Method: saveOrderItem(OrderItem orderItem) 
    * 
    */ 
    @Test
    public void testSaveOrderItem() throws Exception {
        OrderItem orderItem = new OrderItem(1L, "1586871637027_1", "战争与和平", 74.20, 1);
        OrderItem orderItem2 = new OrderItem(2L, "1586871637027_1", "了不起的博物馆", 51.00, 2);
        Integer i = orderItemDao.saveOrderItem(orderItem);
        Integer i2 = orderItemDao.saveOrderItem(orderItem2);
        System.out.println("i: " + i);
        System.out.println("i2: " + i2);
    }
    
    /** 
    * 
    * Method: queryOrderItemsByOrderId(String orderId) 
    * 
    */ 
    @Test
    public void testQueryOrderItemsByOrderId() throws Exception {
        String orderId = "1586871637027_1";
        List<OrderItem> orderItems = orderItemDao.queryOrderItemsByOrderId(orderId);
        System.out.println(orderItems);
    }
} 
