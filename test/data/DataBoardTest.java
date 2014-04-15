/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.Story;
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
public class DataBoardTest
{
    
    public DataBoardTest()
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
     * Test of DataBoard method, of class DataBoard.
     */
    @Test
    public void testDataBoard()
    {
        System.out.println("DataBoard");
        DataBoard instance = new DataBoard();
        instance.DataBoard();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoardName method, of class DataBoard.
     */
    @Test
    public void testGetBoardName()
    {
        System.out.println("getBoardName");
        int boardID = 0;
        DataBoard instance = new DataBoard();
        String expResult = "";
        String result = instance.getBoardName(boardID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnCount method, of class DataBoard.
     */
    @Test
    public void testGetColumnCount()
    {
        System.out.println("getColumnCount");
        int boardID = 0;
        DataBoard instance = new DataBoard();
        int expResult = 0;
        int result = instance.getColumnCount(boardID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoardColumns method, of class DataBoard.
     */
    @Test
    public void testGetBoardColumns()
    {
        System.out.println("getBoardColumns");
        int boardID = 0;
        DataBoard instance = new DataBoard();
        ResultSet expResult = null;
        ResultSet result = instance.getBoardColumns(boardID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStorycolumnPositionByID method, of class DataBoard.
     */
    @Test
    public void testGetStorycolumnPositionByID()
    {
        System.out.println("getStorycolumnPositionByID");
        int id = 0;
        DataBoard instance = new DataBoard();
        int expResult = 0;
        int result = instance.getStorycolumnPositionByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStoryByID method, of class DataBoard.
     */
    @Test
    public void testGetStoryByID()
    {
        System.out.println("getStoryByID");
        int id = 0;
        DataBoard instance = new DataBoard();
        Story expResult = null;
        Story result = instance.getStoryByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBacklogStories method, of class DataBoard.
     */
    @Test
    public void testGetBacklogStories()
    {
        System.out.println("getBacklogStories");
        int boardID = 0;
        DataBoard instance = new DataBoard();
        ArrayList<Story> expResult = null;
        ArrayList<Story> result = instance.getBacklogStories(boardID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
