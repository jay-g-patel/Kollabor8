/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.sql.ResultSet;
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
public class DataBColumnTest
{
    
    public DataBColumnTest()
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
     * Test of dataBColumn method, of class DataBColumn.
     */
    @Test
    public void testDataBColumn()
    {
        System.out.println("dataBColumn");
        DataBColumn instance = new DataBColumn();
        instance.dataBColumn();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnStoryCount method, of class DataBColumn.
     */
    @Test
    public void testGetColumnStoryCount()
    {
        System.out.println("getColumnStoryCount");
        int colID = 0;
        DataBColumn instance = new DataBColumn();
        int expResult = 0;
        int result = instance.getColumnStoryCount(colID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnStories method, of class DataBColumn.
     */
    @Test
    public void testGetColumnStories()
    {
        System.out.println("getColumnStories");
        int colID = 0;
        DataBColumn instance = new DataBColumn();
        ResultSet expResult = null;
        ResultSet result = instance.getColumnStories(colID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNewColumn method, of class DataBColumn.
     */
    @Test
    public void testAddNewColumn()
    {
        System.out.println("addNewColumn");
        int cboardID = 0;
        String pColumnName = "";
        DataBColumn instance = new DataBColumn();
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.addNewColumn(cboardID, pColumnName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
