/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import data.DataGroup;
import java.util.ArrayList;

/**
 *
 * @author Jayshree
 */
public class Group
{

    public int groupID = 0;
    public int boardID = 0;
    public String groupName = "";
    private Statement stmt = null;
    private DataGroup dataGroup = new DataGroup();

    public Group(int groupID)
    {
        this.groupID = groupID;
        setupGroupBoard();
    }
    
    private void setupGroupBoard()
    {
        this.groupName = dataGroup.getGroupName(this.groupID);
        this.boardID = dataGroup.getGroupBoardID(this.groupID);
    }

    //retrieves local GroupID
    public int getGroupID()
    {
        return groupID;
    }

    //sets local GroupID
    public void setGroupID(int id)
    {
        this.groupID = id;
    }
    
    public String getGroupName()
    {
        return this.groupName;
    }
    
    public void setGroupName(String newName)
    {
        this.groupName = newName;
    }
        

    /**
     * gets Board ID from DB with current GroupID
     * 
    */
    public int getBoardID()
    {
        return this.boardID;        
    }
    
    public void setBoardID(int id)
    {
        this.boardID = id;
    }
    
    public ArrayList<Users> getGroupUserList()
    { 
        return dataGroup.getGroupUserList(this.groupID);
    }
    
    
}
