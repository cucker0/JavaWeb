package test.com.bookmall.utils; 

import com.bookmall.utils.C3p0Utils;
import org.junit.Test;
import org.junit.Before; 
import org.junit.After; 

/** 
* C3p0Utils Tester. 
* 
* @author <Authors name> 
* @since <pre>01/13/2020</pre> 
* @version 1.0 
*/ 
public class C3p0UtilsTest { 

    @Before
    public void before() throws Exception { 
    } 
    
    @After
    public void after() throws Exception { 
    } 

    /** 
    * 
    * Method: getConnection() 
    * 
    */ 
    @Test
    public void testGetConnection() throws Exception { 
        //TODO: Test goes here...
        System.out.println(C3p0Utils.getConnection());
    } 

    /** 
    * 
    * Method: release(ResultSet resultSet, Statement statement, Connection connection) 
    * 
    */ 
    @Test
    public void testReleaseForResultSetStatementConnection() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: release(Statement statement, Connection connection) 
    * 
    */ 
    @Test
    public void testReleaseForStatementConnection() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: release(Connection connection) 
    * 
    */ 
    @Test
    public void testReleaseConnection() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: release(ResultSet resultSet, Connection connection) 
    * 
    */ 
    @Test
    public void testReleaseForResultSetConnection() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: beginTransaction(Connection connection) 
    * 
    */ 
    @Test
    public void testBeginTransaction() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: commitTransaction(Connection connection) 
    * 
    */ 
    @Test
    public void testCommitTransaction() throws Exception { 
        //TODO: Test goes here... 
    } 

    /** 
    * 
    * Method: rollbackTransaction(Connection connection) 
    * 
    */ 
    @Test
    public void testRollbackTransaction() throws Exception { 
        //TODO: Test goes here... 
    } 


} 
