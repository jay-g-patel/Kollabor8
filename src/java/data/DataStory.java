/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package data;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import model.Story;

/**
 *
 * @author Jayshree
 */
public class DataStory
{
    private DataSource ds = null;
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    ResultSet rs = null;
    private Connection nConnection = null;
    
    private void getConnection()
    {
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
            nConnection = ds.getConnection();
        }
        catch(Exception e)
        {
            System.out.println("Exception message is " + e.getMessage());
        }
    }
    
    public DataStory()
    { 
    
    }
    
    public Story getStoryDetailsByID(int id)
    {
        Story tmpStory = new Story();;
        int statusID = 0;
        int type = 0;
        int user = 0;
        int columnID = 0;
        String name = "";
        getConnection();
        try
        {
            String query = "SELECT * FROM story WHERE storyID = ?";
            pstmt = nConnection.prepareStatement(query);
            pstmt.setInt(1, id);
            ResultSet success = pstmt.executeQuery();
            if(success.next())
                {
                    columnID = success.getInt(1);
                    type = success.getInt(2);
                    user = success.getInt(3);
                    name = success.getString(4);
                    //dependencies = success.getInt(5);
                    statusID = success.getInt(6);
                    
                }
                else
                {
                    throw new SQLException();
                }
        } catch (Exception e)
        {
            System.out.println("Exception message is " + e.getMessage());
        }
        tmpStory.setColumnID(columnID);
        tmpStory.setName(name);
        tmpStory.setType(type);
        tmpStory.setUser(user);
        
        return tmpStory;
        
    }
    
//    public int getStoryTypeByID(int id)
//    {
//        
//    }
    
//    public int getUserByID(int id)
//    {
//        
//    }
    
//    public int getColByID(int ID)
//    {
//        
//    }
    
//    public String getNameByID(int ID)
//    {
//        
//    }
    
    public int changeStoryColumn(int storyID, int newColumn)
    {
        int colID = 0;
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
            String query = "UPDATE story SET columnID = ? WHERE storyID = ?";
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, newColumn);
            pstmt.setInt(2, storyID);
            int success = pstmt.executeUpdate();
            if(success>=1)
                {
                    colID = newColumn;
                }
                else
                {
                    throw new SQLException();
                }
        } catch (Exception e)
        {
            System.out.println("Exception message is " + e.getMessage());
        }
        return colID;
    }
    
    public int addNewStoryToColumn(String desc, int colID)
    {
        int sID = 0;
        int cID = colID;
        String sName = desc;
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
            String sql = "call CreateNewColumnStory(?,?,?);";
            CallableStatement cStmt = connection.prepareCall(sql);
            
            cStmt.setInt(1, cID);
            cStmt.setString(2,sName);
            
             cStmt.registerOutParameter(3, java.sql.Types.INTEGER);
            
            cStmt.executeUpdate();

             sID = cStmt.getInt(3);
            
            
           
//            }
        }
        catch(Exception e)
        {
            
            String s = e.getMessage();
        }
        return sID;
    }

    public int updateCompletionDate(int storyid, String date)
    {
        int success = 0;
        getConnection();
        try
        {
            String query = "UPDATE story SET `endDate` = ? WHERE `storyID` = ?;";
            pstmt = nConnection.prepareStatement(query);
            pstmt.setString(1, date);
            pstmt.setInt(2, storyid);
            success = pstmt.executeUpdate();
        } catch (Exception e)
        {
            System.out.println("Exception message is " + e.getMessage());
        }
        return success;
        
    }

    public int updateStoryUser(int storyid, int userID)
    {
        int success = 0;
        getConnection();
        try
        {
            String query = "UPDATE story SET `user` = ? WHERE `storyID` = ?;";
            pstmt = nConnection.prepareStatement(query);
            pstmt.setInt(1, userID);
            pstmt.setInt(2, storyid);
            success = pstmt.executeUpdate();
        } catch (Exception e)
        {
            System.out.println("Exception message is " + e.getMessage());
        }
        return success;
    }
}
