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
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import data.DataStory;

/**
 *
 * @author Jayshree
 */
public class Story
{

    DataStory dataStory = new DataStory();

    int storyid = 0;
    int type = 0;
    int user = 0;
    int columnID;
    String name = "";

    public Story()
    {

    }

    public Story(int sID, int sType, int sUserID, String sDescription)
    {
        this.storyid = sID;
        this.type = sType;
        this.user = sUserID;
        this.name = sDescription;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String newname)
    {
        this.name = newname;
    }

    public int getStoryID()
    {
        return this.storyid;
    }
    
    public void setStoryID(int id)
    {
        this.storyid = id;
    }

    public int getColumnID()
    {
        return this.getColumnID();
    }

    public void setColumnID(int colID)
    {
        this.columnID = colID;
    }

    public void changeColumn(int columnID)
    {
        int col = dataStory.changeStoryColumn(this.storyid, columnID);
        if (col >= 1)
        {
            this.columnID = col;
        }
    }

    public void commitStory(String csName, int csCID)
    {
       int sID = dataStory.addNewStoryToColumn(csName, csCID);
        setStoryID(sID);
        setColumnID(csCID);
        setName(csName);
    }
}
