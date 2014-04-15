/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

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
public class UsersTest {
    
    public UsersTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getUserType method, of class Users.
     */
    @Test
    public void testGetUserType() {
        System.out.println("getUserType");
        int typeID = 0;
        Users instance = new Users();
        int expResult = 0;
        int result = instance.getUserType(typeID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isValid method, of class Users.
     */
    @Test
    public void testIsValid() {
        System.out.println("isValid");
        String name = "";
        String pwd = "";
        Users instance = new Users();
        int expResult = 0;
        int result = instance.isValid(name, pwd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class Users.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        String name = "";
        String pwd = "";
        Users instance = new Users();
        instance.addUser(name, pwd);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doesUserExist method, of class Users.
     */
    @Test
    public void testDoesUserExist() {
        System.out.println("doesUserExist");
        String username = "";
        Users instance = new Users();
        int expResult = 0;
        int result = instance.doesUserExist(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserIDL method, of class Users.
     */
    @Test
    public void testGetUserIDL()
    {
        System.out.println("getUserIDL");
        Users instance = new Users();
        int expResult = 0;
        int result = instance.getUserIDL();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserIDL method, of class Users.
     */
    @Test
    public void testSetUserIDL()
    {
        System.out.println("setUserIDL");
        int userID = 0;
        Users instance = new Users();
        instance.setUserIDL(userID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserTypeL method, of class Users.
     */
    @Test
    public void testGetUserTypeL()
    {
        System.out.println("getUserTypeL");
        Users instance = new Users();
        int expResult = 0;
        int result = instance.getUserTypeL();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUserTypeL method, of class Users.
     */
    @Test
    public void testSetUserTypeL()
    {
        System.out.println("setUserTypeL");
        int userType = 0;
        Users instance = new Users();
        instance.setUserTypeL(userType);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGroupIDL method, of class Users.
     */
    @Test
    public void testGetGroupIDL()
    {
        System.out.println("getGroupIDL");
        Users instance = new Users();
        int expResult = 0;
        int result = instance.getGroupIDL();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGroupIDL method, of class Users.
     */
    @Test
    public void testSetGroupIDL()
    {
        System.out.println("setGroupIDL");
        int groupID = 0;
        Users instance = new Users();
        instance.setGroupIDL(groupID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNameL method, of class Users.
     */
    @Test
    public void testGetNameL()
    {
        System.out.println("getNameL");
        Users instance = new Users();
        String expResult = "";
        String result = instance.getNameL();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setNameL method, of class Users.
     */
    @Test
    public void testSetNameL()
    {
        System.out.println("setNameL");
        String name = "";
        Users instance = new Users();
        instance.setNameL(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGroupID method, of class Users.
     */
    @Test
    public void testGetGroupID()
    {
        System.out.println("getGroupID");
        int userID = 0;
        Users instance = new Users();
        int expResult = 0;
        int result = instance.getGroupID(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserNameByID method, of class Users.
     */
    @Test
    public void testGetUserNameByID()
    {
        System.out.println("getUserNameByID");
        int userID = 0;
        Users instance = new Users();
        String expResult = "";
        String result = instance.getUserNameByID(userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
