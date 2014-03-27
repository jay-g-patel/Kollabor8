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

    public String getBoardName(int boardID)
    {
        String name = "";
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
}
