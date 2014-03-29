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
public class DataBColumn
{
    private DataSource ds = null;
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    
    public void dataBColumn()
    {
        
    }
    
    public int getColumnStoryCount(int colID)
    {
        int count = 0;
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
            String queryStoryCount = "SELECT COUNT(*) FROM story WHERE columnid = ?";
            pstmt = connection.prepareStatement(queryStoryCount);
            pstmt.setInt(1, colID);
            ResultSet rsSCount = pstmt.executeQuery();
            if(rsSCount.next())
            {
                count = rsSCount.getInt(1);
            }
            
        } catch (SQLException e)
        {
            System.out.println("Exception is ;" + e + ": message is " + e.getMessage());
        }
        return count;
    }
    
    public ResultSet getColumnStories(int colID)
    {
        ResultSet columnStories = null;
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
            String query = "SELECT * FROM story WHERE columnid = ?";
            pstmt = connection.prepareStatement(query);
            pstmt.setInt(1, colID);
            columnStories = pstmt.executeQuery();
        }catch (SQLException e)
        {
            System.out.println("Exception is ;" + e + ": message is " + e.getMessage());
        }
        return columnStories;
    }

    public ArrayList<Integer> addNewColumn(int cboardID, String pColumnName)
    {
        ArrayList al = new ArrayList<Integer>();
        int bID = cboardID;
        String cName = pColumnName;
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
            String sql = "call CreateNewBoardColumn(?,?,?,?);";
            CallableStatement cStmt = connection.prepareCall(sql);
            
            cStmt.setString(1,cName);
            cStmt.setInt(2, bID);
             cStmt.registerOutParameter(3, java.sql.Types.INTEGER);
             cStmt.registerOutParameter(4, java.sql.Types.INTEGER);
            
            cStmt.executeUpdate();
//            if(results){
//            int i =0;
//            while(results.next())
//            {
//                ResultSet rs = cStmt.getResultSet();
//                
//            }
            int cID = cStmt.getInt(3);
            int cPos = cStmt.getInt(4);
            al.add(cID);
             al.add(cPos);
           
//            }
        }
        catch(Exception e)
        {
            
            String s = e.getMessage();
        }
        return al;
        
    }
    
}
