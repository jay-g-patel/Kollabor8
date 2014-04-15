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
public class ColumnTest
{
    
    public ColumnTest()
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
     * Test of setPosition method, of class Column.
     */
    @Test
    public void testSetPosition()
    {
        System.out.println("setPosition");
        int position = 0;
        Column instance = new Column();
        instance.setPosition(position);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPosition method, of class Column.
     */
    @Test
    public void testGetPosition()
    {
        System.out.println("getPosition");
        Column instance = new Column();
        int expResult = 0;
        int result = instance.getPosition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Column.
     */
    @Test
    public void testSetName()
    {
        System.out.println("setName");
        String newName = "";
        Column instance = new Column();
        instance.setName(newName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Column.
     */
    @Test
    public void testGetDescription()
    {
        System.out.println("getDescription");
        Column instance = new Column();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnID method, of class Column.
     */
    @Test
    public void testGetColumnID()
    {
        System.out.println("getColumnID");
        Column instance = new Column();
        int expResult = 0;
        int result = instance.getColumnID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColumnID method, of class Column.
     */
    @Test
    public void testSetColumnID()
    {
        System.out.println("setColumnID");
        int id = 0;
        Column instance = new Column();
        instance.setColumnID(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoardID method, of class Column.
     */
    @Test
    public void testGetBoardID()
    {
        System.out.println("getBoardID");
        Column instance = new Column();
        int expResult = 0;
        int result = instance.getBoardID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBoardID method, of class Column.
     */
    @Test
    public void testSetBoardID()
    {
        System.out.println("setBoardID");
        int id = 0;
        Column instance = new Column();
        instance.setBoardID(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of prepareColumn method, of class Column.
     */
    @Test
    public void testPrepareColumn()
    {
        System.out.println("prepareColumn");
        Column instance = new Column();
        instance.prepareColumn();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnStories method, of class Column.
     */
    @Test
    public void testGetColumnStories()
    {
        System.out.println("getColumnStories");
        Column instance = new Column();
        Story[] expResult = null;
        Story[] result = instance.getColumnStories();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStoryFromColumn method, of class Column.
     */
    @Test
    public void testGetStoryFromColumn()
    {
        System.out.println("getStoryFromColumn");
        int sID = 0;
        Column instance = new Column();
        Story expResult = null;
        Story result = instance.getStoryFromColumn(sID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setToFirstColumn method, of class Column.
     */
    @Test
    public void testSetToFirstColumn()
    {
        System.out.println("setToFirstColumn");
        Column instance = new Column();
        instance.setToFirstColumn();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getIsFirstColumn method, of class Column.
     */
    @Test
    public void testGetIsFirstColumn()
    {
        System.out.println("getIsFirstColumn");
        Column instance = new Column();
        boolean expResult = false;
        boolean result = instance.getIsFirstColumn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of commitNewColumn method, of class Column.
     */
    @Test
    public void testCommitNewColumn()
    {
        System.out.println("commitNewColumn");
        int cboardID = 0;
        String pColumnName = "";
        Column instance = new Column();
        instance.commitNewColumn(cboardID, pColumnName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
