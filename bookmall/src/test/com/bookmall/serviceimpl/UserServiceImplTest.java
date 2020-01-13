package test.com.bookmall.serviceimpl; 

import com.bookmall.bean.User;
import com.bookmall.service.UserService;
import com.bookmall.serviceimpl.UserServiceImpl;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* UserServiceImpl Tester. 
* 
* @author <Authors name> 
* @since <pre>01/13/2020</pre> 
* @version 1.0 
*/ 
public class UserServiceImplTest { 
    private UserService userService;

    @Before
    public void before() throws Exception {
        userService = new UserServiceImpl();
    } 
    
    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: regist(User user) 
    * 
    */ 
    @Test
    public void testRegist() throws Exception { 
        //TODO: Test goes here...
        User user = new User(null, "lindanda", "pw123456", "lindanda@gmail.com");
        userService.regist(user);
    } 

    /** 
    * 
    * Method: login(User user) 
    * 
    */ 
    @Test
    public void testLogin() throws Exception { 
        //TODO: Test goes here...
        User user = new User(null, "admin", "py123456", "");
        System.out.println(userService.login(user));
    } 

    /** 
    * 
    * Method: existUsername(String username) 
    * 
    */ 
    @Test
    public void testExistUsername() throws Exception { 
        //TODO: Test goes here...
        System.out.println(userService.existUsername("lindanda"));
    } 


} 
