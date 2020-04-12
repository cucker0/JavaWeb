package test.com.bookmall.bean; 

import com.bookmall.bean.Cart;
import com.bookmall.bean.CartGoods;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* Cart Tester. 
* 
* @author <Authors name> 
* @since <pre>04/12/2020</pre> 
* @version 1.0 
*/ 
public class CartTest {
    private Cart cart;
    @Before
    public void before() throws Exception {
        cart = new Cart();
        testAddGoods();
    } 
    
    @After
    public void after() throws Exception { 
    } 
    
    /** 
    * 
    * Method: addGoods(CartGoods goods) 
    * 
    */ 
    @Test
    public void testAddGoods() throws Exception { 
        cart.addGoods(new CartGoods(1, "健康包", 1, 99.99));
        cart.addGoods(new CartGoods(1, "健康包", 1, 99.99));
        cart.addGoods(new CartGoods(2, "手机", 1, 1999));
        cart.addGoods(new CartGoods(3, "笔记本", 1, 4800));
//        testGetGoods();
    }
    
    /** 
    * 
    * Method: deleteGoods(int goodsId) 
    * 
    */ 
    @Test
    public void testDeleteGoods() throws Exception { 
        cart.deleteGoods(1);
        testGetGoods();
    } 
    
    /** 
    * 
    * Method: updateGoods(int goodsId, int count) 
    * 
    */ 
    @Test
    public void testUpdateGoods() throws Exception { 
        cart.updateGoods(2, 3);
        testGetGoods();
    } 
    
    /** 
    * 
    * Method: clear() 
    * 
    */ 
    @Test
    public void testClear() throws Exception { 
        cart.clear();
        testGetGoods();
    } 
    
    /** 
    * 
    * Method: getTotalCount() 
    * 
    */ 
    @Test
    public void testGetTotalCount() throws Exception {
        testGetGoods();
        int totalCount = cart.getTotalCount();
        System.out.println(totalCount);
    } 
    
    /** 
    * 
    * Method: getTotalAmount() 
    * 
    */ 
    @Test
    public void testGetTotalPrice() throws Exception {
        //TODO: Test goes here... 
    } 
    
    /** 
    * 
    * Method: getGoods() 
    * 
    */ 
    @Test
    public void testGetGoods() throws Exception {
        System.out.println("购物车商品：");
        for (CartGoods g : cart.getGoods().values()) {
            System.out.println(g);
        }
        System.out.println("总价：￥" + cart.getTotalPrice());
    } 
    
    /** 
    * 
    * Method: removeCheckedGoods() 
    * 
    */ 
    @Test
    public void testRemoveCheckedGoods() throws Exception {
        cart.checkedGoods(1, false);
        int i = cart.removeCheckedGoods();
        System.out.println(i);
        testGetGoods();
    }

    /**
     *
     * Method: checkedGoods(int goodsId, boolean checked)
     *
     */
    @Test
    public void testCheckedGoods() throws Exception {
        cart.checkedGoods(3, false);
        testGetGoods();
    }

    /** 
    * 
    * Method: toString() 
    * 
    */ 
    @Test
    public void testToString() throws Exception { 
        //TODO: Test goes here... 
    }
    
    
} 
