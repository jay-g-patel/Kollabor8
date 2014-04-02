/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import data.DataUsers;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author bastinl
 */
public class Users {
  
    DataUsers dataUsers = new DataUsers();
    int userID = 0;
    int userType = 0;
    int groupID = 0;
    String name = "";
   
    public Users() {
       
    }

    public int getUserIDL()
    {
        return userID;
    }

    public void setUserIDL(int userID)
    {
        this.userID = userID;
    }

    public int getUserTypeL()
    {
        return userType;
    }

    public void setUserTypeL(int userType)
    {
        this.userType = userType;
    }

    public int getGroupIDL()
    {
        return groupID;
    }

    public void setGroupIDL(int groupID)
    {
        this.groupID = groupID;
    }

    public String getNameL()
    {
        return name;
    }

    public void setNameL(String name)
    {
        this.name = name;
    }

    
    
    public int getUserType(int typeID)
    {
        int nuserType = dataUsers.getUserType(typeID);
        this.userType = nuserType;
        return nuserType;
    }
    
    
    
    public int isValid(String name, String pwd) {
       int isValid = dataUsers.isValid(name, pwd);
       return isValid;
    }
    
    // TODO (Optional steps 3 and 4) add a user with specified username and password
    public void addUser(String name, String pwd) {
       dataUsers.addUser(name, pwd);
    }
    
    //function to check if a user exists using the username
    public int doesUserExist(String username)
    {
        
        int clientID = dataUsers.doesUserExist(username);
        if(clientID >0)
        {
            this.name=username;
            this.userID = clientID;
        }
        return clientID;
        
    }
    
    public int getGroupID(int userID)
    {
        int ngroupID = dataUsers.getGroupID(userID);
        this.groupID = ngroupID;
        return ngroupID;
    }
    
    public String getUserNameByID(int userID)
    {
        return dataUsers.getUserNameByID(userID);
    }
    
}


