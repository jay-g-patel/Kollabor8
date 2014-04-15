/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

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
public class DataStoryTest
{
    
    public DataStoryTest()
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
     * Test of getStoryDetailsByID method, of class DataStory.
     */
    @Test
    public void testGetStoryDetailsByID()
    {
        System.out.println("getStoryDetailsByID");
        int id = 0;
        DataStory instance = new DataStory();
        Story expResult = null;
        Story result = instance.getStoryDetailsByID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeStoryColumn method, of class DataStory.
     */
    @Test
    public void testChangeStoryColumn()
    {
        System.out.println("changeStoryColumn");
        int storyID = 0;
        int newColumn = 0;
        DataStory instance = new DataStory();
        int expResult = 0;
        int result = instance.changeStoryColumn(storyID, newColumn);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNewStoryToBacklog method, of class DataStory.
     */
    @Test
    public void testAddNewStoryToBacklog()
    {
        System.out.println("addNewStoryToBacklog");
        String sName = "";
        int groupID = 0;
        DataStory instance = new DataStory();
        int expResult = 0;
        int result = instance.addNewStoryToBacklog(sName, groupID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addNewStoryToColumn method, of class DataStory.
     */
    @Test
    public void testAddNewStoryToColumn()
    {
        System.out.println("addNewStoryToColumn");
        String desc = "";
        int colID = 0;
        DataStory instance = new DataStory();
        int expResult = 0;
        int result = instance.addNewStoryToColumn(desc, colID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateCompletionDate method, of class DataStory.
     */
    @Test
    public void testUpdateCompletionDate()
    {
        System.out.println("updateCompletionDate");
        int storyid = 0;
        String date = "";
        DataStory instance = new DataStory();
        int expResult = 0;
        int result = instance.updateCompletionDate(storyid, date);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateStoryUser method, of class DataStory.
     */
    @Test
    public void testUpdateStoryUser()
    {
        System.out.println("updateStoryUser");
        int storyid = 0;
        int userID = 0;
        DataStory instance = new DataStory();
        int expResult = 0;
        int result = instance.updateStoryUser(storyid, userID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStoryOwnerNameByUserID method, of class DataStory.
     */
    @Test
    public void testGetStoryOwnerNameByUserID()
    {
        System.out.println("getStoryOwnerNameByUserID");
        int id = 0;
        DataStory instance = new DataStory();
        String expResult = "";
        String result = instance.getStoryOwnerNameByUserID(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateStoryName method, of class DataStory.
     */
    @Test
    public void testUpdateStoryName()
    {
        System.out.println("updateStoryName");
        int storyid = 0;
        String storyDesc = "";
        DataStory instance = new DataStory();
        int expResult = 0;
        int result = instance.updateStoryName(storyid, storyDesc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDependantStoryList method, of class DataStory.
     */
    @Test
    public void testGetDependantStoryList()
    {
        System.out.println("getDependantStoryList");
        int storyID = 0;
        DataStory instance = new DataStory();
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.getDependantStoryList(storyID);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
