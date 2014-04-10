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
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import model.Story;

/**
 *
 * @author Jayshree
 */
public class DataBoard
{

    private PreparedStatement pstmt = null;
    private DataSource ds = null;

    public void DataBoard()
    {
       
    }

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
    }
    
    public String getBoardName(int boardID)
    {
        String name = "";
        getConnection();
        try
        {
            Connection connection = ds.getConnection();

            if (connection != null)
            {
                String query = "SELECT boardName FROM board WHERE boardID = ?";
                pstmt = connection.prepareStatement(query);
                pstmt.setInt(1, boardID);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next())
                {
                    name = rs.getString(1);
                }

            }
        } catch (SQLException e)
        {
            System.out.println("Exception is ;" + e + ": message is " + e.getMessage());
        }
        return name;
    }

    public int getColumnCount(int boardID)
    {
        int colCount = 0;
        getConnection();
        try
        {
            Connection connection = ds.getConnection();

            if (connection != null)
            {
                String columnCountquery = "SELECT count(*) FROM boardcolumn WHERE boardID = ?";
                pstmt = connection.prepareStatement(columnCountquery);
                pstmt.setInt(1, boardID);
                ResultSet rs = pstmt.executeQuery();
                if (rs.next())
                {
                    colCount = rs.getInt(1);
                }
            }
        } catch (SQLException e)
        {
            System.out.println("Exception is ;" + e + ": message is " + e.getMessage());
        }
        return colCount;
    }

    public ResultSet getBoardColumns(int boardID)
    {
        ResultSet rs = null;
        getConnection();
        try
        {
            Connection connection = ds.getConnection();

            if (connection != null)
            {
                String queryColumnRetrieval = "SELECT * FROM boardcolumn WHERE boardID=? ORDER BY position ASC";
                pstmt = connection.prepareStatement(queryColumnRetrieval);
                pstmt.setInt(1, boardID);
                rs = pstmt.executeQuery();
            }
        } catch (SQLException e)
        {
            System.out.println("Exception is ;" + e + ": message is " + e.getMessage());
        }
        return rs;
    }
    
     public int getStorycolumnPositionByID(int id)
    {
        getConnection();
        
        int pos = 0;
        String q = "SELECT bc.position FROM boardcolumn bc LEFT OUTER JOIN Story sto ON sto.columnid = bc.columnID WHERE sto.storyID = ?";
        try
        {
        Connection connection = ds.getConnection();
        pstmt = connection.prepareStatement(q);
        pstmt.setInt(1, id);
        ResultSet ids = pstmt.executeQuery();
        while(ids.next())
            {
                pos = ids.getInt(1);
            }
        }catch(SQLException e)
        {
            System.out.println("Exception message is " + e.getMessage());
        }
            return pos;
    }
     
     public Story getStoryByID(int id)
    {
        getConnection();
        Story s = new Story();
        int pos = 0;
        String q = "SELECT * FROM Story WHERE storyID = ?";
        try
        {
        Connection connection = ds.getConnection();
        pstmt = connection.prepareStatement(q);
        pstmt.setInt(1, id);
        ResultSet ids = pstmt.executeQuery();
        while(ids.next())
            {
                s.setColumnID(ids.getInt(2));
                s.setName(ids.getString(5));
                s.setStoryID(ids.getInt(1));
                s.setUser(ids.getInt(4));
            }
        }catch(SQLException e)
        {
            System.out.println("Exception message is " + e.getMessage());
        }
            return s;
    }
}
