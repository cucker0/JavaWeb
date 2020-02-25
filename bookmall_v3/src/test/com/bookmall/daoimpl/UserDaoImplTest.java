package test.com.bookmall.daoimpl; 

import com.bookmall.bean.User;
import com.bookmall.dao.UserDao;
import com.bookmall.daoimpl.UserDaoImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* UserDaoImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>01/13/2020</pre> 
* @version 1.0 
*/ 
public class UserDaoImplTest { 
    private static UserDao userDao;


    @Before
    public void before() throws Exception {
        userDao = new UserDaoImpl();
    } 
    
    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: findUserByUsernameAndPassword(User user) 
    * 
    */ 
    @Test
    public void testQueryUserByUsernameAndPassword() throws Exception {
        //TODO: Test goes here...
        User user = new User(null, "admin", "py123456", "");
        User user1 = userDao.queryUserByUsernameAndPassword(user);
        System.out.println(user1);
    } 

    /** 
    * 
    * Method: saveUser(User user) 
    * 
    */ 
    @Test
    public void testSaveUser() throws Exception { 
        //TODO: Test goes here...
        User user = new User(null, "tangping", "py123456", "tangping@qq.com");
        int id = userDao.saveUser(user);
        System.out.println(id);
    } 

    /** 
    * 
    * Method: existUsername(String username) 
    * 
    */ 
    @Test
    public void testQeuryUserByUsername() throws Exception {
        //TODO: Test goes here...
        String username = "admin";
        boolean isExist = userDao.queryUserByUsername(username);
        System.out.println("user admin is exist? : " + isExist);
    } 


} 
