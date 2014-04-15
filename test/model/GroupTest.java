/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
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
public class GroupTest
{
    
    public GroupTest()
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
     * Test of getGroupID method, of class Group.
     */
    @Test
    public void testGetGroupID()
    {
        System.out.println("getGroupID");
        Group instance = null;
        int expResult = 0;
        int result = instance.getGroupID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGroupID method, of class Group.
     */
    @Test
    public void testSetGroupID()
    {
        System.out.println("setGroupID");
        int id = 0;
        Group instance = null;
        instance.setGroupID(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGroupName method, of class Group.
     */
    @Test
    public void testGetGroupName()
    {
        System.out.println("getGroupName");
        Group instance = null;
        String expResult = "";
        String result = instance.getGroupName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGroupName method, of class Group.
     */
    @Test
    public void testSetGroupName()
    {
        System.out.println("setGroupName");
        String newName = "";
        Group instance = null;
        instance.setGroupName(newName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoardID method, of class Group.
     */
    @Test
    public void testGetBoardID()
    {
        System.out.println("getBoardID");
        Group instance = null;
        int expResult = 0;
        int result = instance.getBoardID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBoardID method, of class Group.
     */
    @Test
    public void testSetBoardID()
    {
        System.out.println("setBoardID");
        int id = 0;
        Group instance = null;
        instance.setBoardID(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGroupUserList method, of class Group.
     */
    @Test
    public void testGetGroupUserList()
    {
        System.out.println("getGroupUserList");
        Group instance = null;
        ArrayList<Users> expResult = null;
        ArrayList<Users> result = instance.getGroupUserList();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
