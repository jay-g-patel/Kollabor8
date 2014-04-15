/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.util.ArrayList;
import model.Users;
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
public class DataGroupTest
{
    
    public DataGroupTest()
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
     * Test of datagroup method, of class DataGroup.
     */
    @Test
    public void testDatagroup()
    {
        System.out.println("datagroup");
        DataGroup instance = new DataGroup();
        instance.datagroup();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGroupBoardID method, of class DataGroup.
     */
    @Test
    public void testGetGroupBoardID()
    {
        System.out.println("getGroupBoardID");
        int groupID = 0;
        DataGroup instance = new DataGroup();
        int expResult = 0;
        int result = instance.getGroupBoardID(groupID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGroupName method, of class DataGroup.
     */
    @Test
    public void testSetGroupName()
    {
        System.out.println("setGroupName");
        int groupID = 0;
        String newName = "";
        DataGroup instance = new DataGroup();
        boolean expResult = false;
        boolean result = instance.setGroupName(groupID, newName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGroupName method, of class DataGroup.
     */
    @Test
    public void testGetGroupName()
    {
        System.out.println("getGroupName");
        int groupID = 0;
        DataGroup instance = new DataGroup();
        String expResult = "";
        String result = instance.getGroupName(groupID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGroupUserList method, of class DataGroup.
     */
    @Test
    public void testGetGroupUserList()
    {
        System.out.println("getGroupUserList");
        int groupID = 0;
        DataGroup instance = new DataGroup();
        ArrayList<Users> expResult = null;
        ArrayList<Users> result = instance.getGroupUserList(groupID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
