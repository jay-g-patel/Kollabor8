/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jayshree
 */
public class DataUsersTest
{
    
    public DataUsersTest()
    {
    }
    
    @BeforeClass
    public static void setUpClass()
    {
    }
    
    @AfterClass
    public static void tearDownClass()
    {
    }
    
    @Before
    public void setUp()
    {
    }
    
    @After
    public void tearDown()
    {
    }

    /**
     * Test of getUserType method, of class DataUsers.
     */
    @Test
    public void testGetUserType()
    {
        System.out.println("getUserType");
        int typeID = 0;
        DataUsers instance = new DataUsers();
        int expResult = 0;
        int result = instance.getUserType(typeID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValid method, of class DataUsers.
     */
    @Test
    public void testIsValid()
    {
        System.out.println("isValid");
        String name = "";
        String pwd = "";
        DataUsers instance = new DataUsers();
        int expResult = 0;
        int result = instance.isValid(name, pwd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class DataUsers.
     */
    @Test
    public void testAddUser()
    {
        System.out.println("addUser");
        String name = "";
        String pwd = "";
        DataUsers instance = new DataUsers();
        instance.addUser(name, pwd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doesUserExist method, of class DataUsers.
     */
    @Test
    public void testDoesUserExist()
    {
        System.out.println("doesUserExist");
        String username = "";
        DataUsers instance = new DataUsers();
        int expResult = 0;
        int result = instance.doesUserExist(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGroupID method, of class DataUsers.
     */
    @Test
    public void testGetGroupID()
    {
        System.out.println("getGroupID");
        int userID = 0;
        DataUsers instance = new DataUsers();
        int expResult = 0;
        int result = instance.getGroupID(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserNameByID method, of class DataUsers.
     */
    @Test
    public void testGetUserNameByID()
    {
        System.out.println("getUserNameByID");
        int id = 0;
        DataUsers instance = new DataUsers();
        String expResult = "";
        String result = instance.getUserNameByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
