/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import data.DataBColumn;

/**
 *
 * @author Jayshree
 */
public class Column
{

    public DataBColumn dataBColumn = new DataBColumn();
    public int boardID = 0;
    public int position = 0;
    public String name = null;
    public HashMap storyMap = null;
    public Story[] storyArray;
    public int columnID = 0;
    public boolean isFirstColumn = false;

    public Column()
    {

    }

    public Column(int id, int position, String description)
    {
        this.columnID = id;
        this.position = position;
        this.name = description;
    }

    public void setPosition(int position)
    {
        this.position = position;
    }

    public int getPosition()
    {
        return this.position;
    }

    public void setName(String newName)
    {
        this.name = newName;
    }

    public String getDescription()
    {
        return this.name;
    }

    public int getColumnID()
    {
        return this.columnID;
    }

    public void setColumnID(int id)
    {
        this.columnID = id;
    }

    public int getBoardID()
    {
        return this.boardID;
    }

    public void setBoardID(int id)
    {
        this.boardID = id;
    }

    public void prepareColumn()
    {
        int storyCount = dataBColumn.getColumnStoryCount(this.columnID);
        int aID = 0;
        if (storyCount > 0)
        {
            storyArray = null;
            storyArray = new Story[storyCount];
            ResultSet colStories = dataBColumn.getColumnStories(this.columnID);

            try
            {
                while (colStories.next())
                {
                    int sID = colStories.getInt(1);
                    int sType = colStories.getInt(3);
                    int sUserID = colStories.getInt(4);
                    String sDescription = colStories.getString(5);
                    Story tmpStory = new Story(sID, sType, sUserID, sDescription);
                    storyArray[aID] = tmpStory;
                    aID++;
                }
            }catch (SQLException e)
            {
                System.out.println("Exception is ;" + e + ": message is " + e.getMessage());
            }

            
        }
        else{
            storyArray = null;
            storyArray = new Story[0];
        }

    }
    
        public Story[] getColumnStories()
    {
        return this.storyArray;
    }

    public Story getStoryFromColumn(int sID)
    {
        Story tempstory = null;
        for(Story s : storyArray)
        {
            if(s.storyid == sID)
            {
                tempstory = s;
            }
        }
        return tempstory;
    }
    
    public void setToFirstColumn()
    {
        this.isFirstColumn = true;
    }
    
    public boolean getIsFirstColumn()
    {
        return this.isFirstColumn;
    }
    
}
