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
import data.DataBoard;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

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
    Date completionDate = null;
    ArrayList <Integer> dependantStories = new ArrayList<Integer>();

    public Date getCompletionDate()
    {
        return completionDate;
    }
    public String getCompletionDateAsString()
    {
        String dateString = "";
        if(this.completionDate != null)
        {
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        dateString = df.format(this.completionDate);
        }
        return dateString;
    }
    
    public boolean getOverdue()
    {
        boolean overdue = false;                
        Date today = new Date();
        if(this.completionDate.after(today))
        {
            overdue = false;
        }
        else
        {
            overdue = true;
        }
        return overdue;
    }

    public void setCompletionDate(Date completionDate)
    {
        this.completionDate = completionDate;
    }

    public Story()
    {
       
    }

    public Story(int sID)
    {
       dataStory.getStoryDetailsByID(sID);
        
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

    public int getType()
    {
        return type;
    }

    public void setType(int type)
    {
        this.type = type;
    }

    public int getUser()
    {
        return user;
    }

    public void setUser(int user)
    {
        this.user = user;
    }
    
    public void updateStoryUser(int userID)
    {
        int success = dataStory.updateStoryUser(this.storyid, userID);
        if(success == 0)
        {
            this.user = 0;
        }
        else
        {
            this.user = userID;
        }
    }
    
    public void enterCompletionDate(Date date)
    {
        //this should be in the correct format!!!!
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        String dateString = df.format(date);
        int success = dataStory.updateCompletionDate(this.storyid, dateString);
        if(success == 0)
        {
            this.completionDate = null;
        }
        else
        {
            this.completionDate = date;
        }
    }
    
    public String getDateAsFormattedString()
    {
        String formattedDate = "";
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        if(this.completionDate != null)
        {
            formattedDate = df.format(this.completionDate);
        }
        return formattedDate;
    }

    public void changeColumn(int columnID)
    {
        int col = dataStory.changeStoryColumn(this.storyid, columnID);
        if (col >= 1)
        {
            this.columnID = col;
        }
    }
    
    public void commitBacklogStory(String csName, int groupID)
    {
     int sID = dataStory.addNewStoryToBacklog(csName, groupID); 
     setStoryID(sID);
     setName(csName);
     
    }

    public void commitStory(String csName, int csCID)
    {
       int sID = dataStory.addNewStoryToColumn(csName, csCID);
        setStoryID(sID);
        setColumnID(csCID);
        setName(csName);
    }
    
    public String getUserName()
    {
        int id = this.getUser();
        String userName = dataStory.getStoryOwnerNameByUserID(id);
        if(userName == null)
        {
            userName = "";
        }
        return userName;
    }

    public void updateName(String storyDesc)
    {
        int i = dataStory.updateStoryName(this.storyid, storyDesc);
        if(i !=0 )
        {
            this.name = storyDesc;
        }
        
    }
    
//    public void updateStory()
//    {
//        Story sto = dataStory.getStoryDetailsByID(this.storyid);
//        this.setDependencies(sto.dependantStories);
//        this.setName(sto.name);
//        
//    }

    public void setDependencies(ArrayList<Integer> dependentStories)
    {
        this.dependantStories = dependentStories;
    }
    
    public ArrayList<Integer> getDependencies()
    {
        //this.updateStory();
        return this.dependantStories;
    }
    
    public boolean doesStoryHaveDependencies()
    {
        boolean hasDependencies = false;
        if(dependantStories.size() > 0)
        {
            hasDependencies = true;
        }
         
        return hasDependencies;
    }
    
    public ArrayList<Story> getDependentStories()
    {
        ArrayList<Story> stories = new ArrayList<Story>();
        DataBoard b = new DataBoard();
       for(int i=0; i<dependantStories.size(); i++)
       {
          
           Story x = b.getStoryByID(dependantStories.get(i));
           stories.add(x);
       }
       return stories;
    }
}
