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
    
    public DataStory()
    { 
    
    }
    
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
}
