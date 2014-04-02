/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import model.Users;

/**
 *
 * @author Jayshree
 */
public class DataGroup
{
    
    private DataSource ds = null;
    private PreparedStatement pstmt = null;

    public void datagroup()
    {

        
    }

    public int getGroupBoardID(int groupID)
    {
        int boardID = 0;
        try
        {
            // Obtain our environment naming context
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            // Look up our data source
            ds = (DataSource) envCtx.lookup("jdbc/fypDatabase");
        } catch (Exception e)
        {
            System.out.println("Exception message is " + e.getMessage());
        }
        try
        {
            Connection connection = ds.getConnection();
            if (connection != null)
            {
                String query = "SELECT board FROM studentgroup where groupID = ?";
                pstmt = connection.prepareStatement(query);
                pstmt.setInt(1, groupID);
                ResultSet rs = pstmt.executeQuery();
                rs.next();
                boardID = rs.getInt(1);
            }
        } catch (SQLException e)
        {
            System.out.println("Exception is ;" + e + ": message is " + e.getMessage());
        }
        return boardID;
    }
    
    public boolean setGroupName(int groupID, String newName)
    {
        boolean success = false;
        try
        {
            // Obtain our environment naming context
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            // Look up our data source
            ds = (DataSource) envCtx.lookup("jdbc/fypDatabase");
        } catch (Exception e)
        {
            System.out.println("Exception message is " + e.getMessage());
        }
        try
        {
            Connection connection = ds.getConnection();
            if (connection != null)
            {
                String query = "Update studentgroup SET name = '?' WHERE groupID = 1";
                pstmt = connection.prepareStatement(query);
                pstmt.setString(1,newName);
                pstmt.setInt(2, groupID);
                int result = pstmt.executeUpdate();
                if(result == 1)
                {
                    success = true;
                }
            }
        } catch (SQLException e)
        {
            System.out.println("Exception is ;" + e + ": message is " + e.getMessage());
        }
        return success;
    }
    
    public String getGroupName(int groupID)
    {
        String groupName = "";
        try
        {
            // Obtain our environment naming context
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            // Look up our data source
            ds = (DataSource) envCtx.lookup("jdbc/fypDatabase");
        } catch (Exception e)
        {
            System.out.println("Exception message is " + e.getMessage());
        }
        try
        {
            Connection connection = ds.getConnection();
            if (connection != null)
            {
                String query = "SELECT name FROM studentgroup where groupID = ?";
                pstmt = connection.prepareStatement(query);
                pstmt.setInt(1, groupID);
                ResultSet rs = pstmt.executeQuery();
                rs.next();
                groupName = rs.getString(1);
            }
        } catch (SQLException e)
        {
            System.out.println("Exception is ;" + e + ": message is " + e.getMessage());
        }
        return groupName;
    }

    public ArrayList<Users> getGroupUserList(int groupID)
    {
        ArrayList<Users> groupUserList = new ArrayList<Users>();
        try
        {
            // Obtain our environment naming context
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            // Look up our data source
            ds = (DataSource) envCtx.lookup("jdbc/fypDatabase");
        } catch (Exception e)
        {
            System.out.println("Exception message is " + e.getMessage());
        }
        try
        {
            Connection connection = ds.getConnection();
            if (connection != null)
            {
                String query = "SELECT * FROM pateljg_fyp.user WHERE groupID = ?";
                pstmt = connection.prepareStatement(query);
                pstmt.setInt(1, groupID);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next())
                {
                    Users tmpUser = new Users();
                    tmpUser.setUserIDL(rs.getInt("userID"));
                    tmpUser.setUserTypeL(rs.getInt("userType"));
                    tmpUser.setGroupIDL(rs.getInt("groupID"));
                    tmpUser.setNameL(rs.getString("userName"));
                    groupUserList.add(tmpUser);
                }
                
            }
        } catch (SQLException e)
        {
            System.out.println("Exception is ;" + e + ": message is " + e.getMessage());
        }
        return groupUserList;
    }
    
}
