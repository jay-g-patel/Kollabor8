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
public class BoardTest
{
    
    public BoardTest()
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
     * Test of getBoardID method, of class Board.
     */
    @Test
    public void testGetBoardID()
    {
        System.out.println("getBoardID");
        Board instance = new Board();
        int expResult = 0;
        int result = instance.getBoardID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBoardID method, of class Board.
     */
    @Test
    public void testSetBoardID()
    {
        System.out.println("setBoardID");
        int id = 0;
        Board instance = new Board();
        instance.setBoardID(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createBoard method, of class Board.
     */
    @Test
    public void testCreateBoard()
    {
        System.out.println("createBoard");
        Board instance = new Board();
        instance.createBoard();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnIDAtPosition method, of class Board.
     */
    @Test
    public void testGetColumnIDAtPosition()
    {
        System.out.println("getColumnIDAtPosition");
        int i = 0;
        Board instance = new Board();
        int expResult = 0;
        int result = instance.getColumnIDAtPosition(i);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoardColumn method, of class Board.
     */
    @Test
    public void testGetBoardColumn()
    {
        System.out.println("getBoardColumn");
        int colID = 0;
        Board instance = new Board();
        Column expResult = null;
        Column result = instance.getBoardColumn(colID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoardName method, of class Board.
     */
    @Test
    public void testGetBoardName()
    {
        System.out.println("getBoardName");
        Board instance = new Board();
        String expResult = "";
        String result = instance.getBoardName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBoardColumns method, of class Board.
     */
    @Test
    public void testGetBoardColumns()
    {
        System.out.println("getBoardColumns");
        Board instance = new Board();
        Column[] expResult = null;
        Column[] result = instance.getBoardColumns();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnCount method, of class Board.
     */
    @Test
    public void testGetColumnCount()
    {
        System.out.println("getColumnCount");
        Board instance = new Board();
        int expResult = 0;
        int result = instance.getColumnCount();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStorycolumnPositionByID method, of class Board.
     */
    @Test
    public void testGetStorycolumnPositionByID()
    {
        System.out.println("getStorycolumnPositionByID");
        int id = 0;
        Board instance = new Board();
        int expResult = 0;
        int result = instance.getStorycolumnPositionByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStoryByID method, of class Board.
     */
    @Test
    public void testGetStoryByID()
    {
        System.out.println("getStoryByID");
        int id = 0;
        Board instance = new Board();
        Story expResult = null;
        Story result = instance.getStoryByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStoryNameByStringID method, of class Board.
     */
    @Test
    public void testGetStoryNameByStringID()
    {
        System.out.println("getStoryNameByStringID");
        String idString = "";
        Board instance = new Board();
        String expResult = "";
        String result = instance.getStoryNameByStringID(idString);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBacklogStories method, of class Board.
     */
    @Test
    public void testGetBacklogStories()
    {
        System.out.println("getBacklogStories");
        Board instance = new Board();
        ArrayList<Story> expResult = null;
        ArrayList<Story> result = instance.getBacklogStories();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
