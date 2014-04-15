/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.util.ArrayList;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import model.Story;

/**
 *
 * @author Jayshree
 */
public class StoryTest
{
    
    public StoryTest()
    {
    }
    
    @BeforeClass
    public void setUpClass()
    {
    }
    
    @AfterClass
    public void tearDownClass()
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
     * Test of getCompletionDate method, of class Story.
     */
    @Test
    public void testGetCompletionDate()
    {
        System.out.println("getCompletionDate");
        Story instance = new Story();
        instance.completionDate = new Date();
        Date expResult = null;
        Date result = instance.getCompletionDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCompletionDateAsString method, of class Story.
     */
    @Test
    public void testGetCompletionDateAsString()
    {
        System.out.println("getCompletionDateAsString");
        Story instance = new Story();
        String expResult = "";
        String result = instance.getCompletionDateAsString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getOverdue method, of class Story.
     */
    @Test
    public void testGetOverdue()
    {
        System.out.println("getOverdue");
        Story instance = new Story();
        boolean expResult = false;
        boolean result = instance.getOverdue();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCompletionDate method, of class Story.
     */
    @Test
    public void testSetCompletionDate()
    {
        System.out.println("setCompletionDate");
        Date completionDate = null;
        Story instance = new Story();
        instance.setCompletionDate(completionDate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getName method, of class Story.
     */
    @Test
    public void testGetName()
    {
        System.out.println("getName");
        Story instance = new Story();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Story.
     */
    @Test
    public void testSetName()
    {
        System.out.println("setName");
        String newname = "";
        Story instance = new Story();
        instance.setName(newname);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStoryID method, of class Story.
     */
    @Test
    public void testGetStoryID()
    {
        System.out.println("getStoryID");
        Story instance = new Story();
        int expResult = 0;
        int result = instance.getStoryID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStoryID method, of class Story.
     */
    @Test
    public void testSetStoryID()
    {
        System.out.println("setStoryID");
        int id = 0;
        Story instance = new Story();
        instance.setStoryID(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getColumnID method, of class Story.
     */
    @Test
    public void testGetColumnID()
    {
        System.out.println("getColumnID");
        Story instance = new Story();
        int expResult = 0;
        int result = instance.getColumnID();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setColumnID method, of class Story.
     */
    @Test
    public void testSetColumnID()
    {
        System.out.println("setColumnID");
        int colID = 0;
        Story instance = new Story();
        instance.setColumnID(colID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Story.
     */
    @Test
    public void testGetType()
    {
        System.out.println("getType");
        Story instance = new Story();
        int expResult = 0;
        int result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class Story.
     */
    @Test
    public void testSetType()
    {
        System.out.println("setType");
        int type = 0;
        Story instance = new Story();
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class Story.
     */
    @Test
    public void testGetUser()
    {
        System.out.println("getUser");
        Story instance = new Story();
        int expResult = 0;
        int result = instance.getUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUser method, of class Story.
     */
    @Test
    public void testSetUser()
    {
        System.out.println("setUser");
        int user = 0;
        Story instance = new Story();
        instance.setUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateStoryUser method, of class Story.
     */
    @Test
    public void testUpdateStoryUser()
    {
        System.out.println("updateStoryUser");
        int userID = 0;
        Story instance = new Story();
        instance.updateStoryUser(userID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of enterCompletionDate method, of class Story.
     */
    @Test
    public void testEnterCompletionDate()
    {
        System.out.println("enterCompletionDate");
        Date date = null;
        Story instance = new Story();
        instance.enterCompletionDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDateAsFormattedString method, of class Story.
     */
    @Test
    public void testGetDateAsFormattedString()
    {
        System.out.println("getDateAsFormattedString");
        Story instance = new Story();
        String expResult = "";
        String result = instance.getDateAsFormattedString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of changeColumn method, of class Story.
     */
    @Test
    public void testChangeColumn()
    {
        System.out.println("changeColumn");
        int columnID = 0;
        Story instance = new Story();
        instance.changeColumn(columnID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of commitBacklogStory method, of class Story.
     */
    @Test
    public void testCommitBacklogStory()
    {
        System.out.println("commitBacklogStory");
        String csName = "";
        int groupID = 0;
        Story instance = new Story();
        instance.commitBacklogStory(csName, groupID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of commitStory method, of class Story.
     */
    @Test
    public void testCommitStory()
    {
        System.out.println("commitStory");
        String csName = "";
        int csCID = 0;
        Story instance = new Story();
        instance.commitStory(csName, csCID);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserName method, of class Story.
     */
    @Test
    public void testGetUserName()
    {
        System.out.println("getUserName");
        Story instance = new Story();
        String expResult = "";
        String result = instance.getUserName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateName method, of class Story.
     */
    @Test
    public void testUpdateName()
    {
        System.out.println("updateName");
        String storyDesc = "";
        Story instance = new Story();
        instance.updateName(storyDesc);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDependencies method, of class Story.
     */
    @Test
    public void testSetDependencies()
    {
        System.out.println("setDependencies");
        ArrayList<Integer> dependentStories = null;
        Story instance = new Story();
        instance.setDependencies(dependentStories);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDependencies method, of class Story.
     */
    @Test
    public void testGetDependencies()
    {
        System.out.println("getDependencies");
        Story instance = new Story();
        ArrayList<Integer> expResult = null;
        ArrayList<Integer> result = instance.getDependencies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of doesStoryHaveDependencies method, of class Story.
     */
    @Test
    public void testDoesStoryHaveDependencies()
    {
        System.out.println("doesStoryHaveDependencies");
        Story instance = new Story();
        boolean expResult = false;
        boolean result = instance.doesStoryHaveDependencies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDependentStories method, of class Story.
     */
    @Test
    public void testGetDependentStories()
    {
        System.out.println("getDependentStories");
        Story instance = new Story();
        ArrayList<Story> expResult = null;
        ArrayList<Story> result = instance.getDependentStories();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
