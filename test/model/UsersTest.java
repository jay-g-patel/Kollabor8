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
    
}
