/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;
import java.sql.Statement;

/**
 *
 * @author bastinl
 */
public class Users {
  
    private ResultSet rs = null;
    private PreparedStatement pstmt = null;
    private Statement stmt = null;
    DataSource ds = null;
   
    public Users() {
        
        // You don't need to make any changes to the try/catch code below
        try {
            // Obtain our environment naming context
            Context initCtx = new InitialContext();
            Context envCtx = (Context) initCtx.lookup("java:comp/env");
            // Look up our data source
            ds = (DataSource)envCtx.lookup("jdbc/fypDatabase");
        }
            catch(Exception e) {
            System.out.println("Exception message is " + e.getMessage());
        }
        
    
        
    }

    public int getUserType(int typeID)
    {
        try {
            
            Connection connection = ds.getConnection();

            if (connection != null) {

                //query to see if there is a row in the DB with the given user credentials
                String query = "SELECT userType FROM user WHERE userID = ?"; 
                pstmt = connection.prepareStatement(query);
                pstmt.setInt(1, typeID);
                ResultSet rs1 = pstmt.executeQuery();
                
                //go to the first row in the result set
                rs1.next();
                //if the entry returns a result, the client id of the row is returned, else -1 ios returned
                if(rs1 != null)
                {
                    int userTypeID = rs1.getInt(1);
                    return userTypeID;
                }
                else
                {
                    return -1;
                }
            }
            else {
                return -1;
            }
        } catch(SQLException e) {
                    
            System.out.println("Exception is ;"+e + ": message is " + e.getMessage());
            return -1;
        }
        
        
    
    }
    
    public int isValid(String name, String pwd) {
       
        try {
            
            Connection connection = ds.getConnection();

            if (connection != null) {

                //query to see if there is a row in the DB with the given user credentials
                String query = "SELECT userID FROM user WHERE username = ? AND password = ?"; 
                pstmt = connection.prepareStatement(query);
                pstmt.setString(1, name);
                pstmt.setString(2,pwd);
                ResultSet rs1 = pstmt.executeQuery();
                
                //go to the first row in the result set
                rs1.next();
                //if the entry returns a result, the client id of the row is returned, else -1 ios returned
                if(rs1 != null)
                {
                    int clientID = rs1.getInt(1);
                    return clientID;
                }
                else
                {
                    return -1;
                }
            }
            else {
                return -1;
            }
        } catch(SQLException e) {
                    
            System.out.println("Exception is ;"+e + ": message is " + e.getMessage());
            return -1;
        }
        
        
    }
    
    // TODO (Optional steps 3 and 4) add a user with specified username and password
    public void addUser(String name, String pwd) {
       
        //TODO: implement this method so that the specified username and password are inserted into the database.

         try {
            
            Connection connection = ds.getConnection();

            if (connection != null) {
                //SQL query to insert the a row into the clients table with the given username and password
                pstmt = connection.prepareStatement("INSERT INTO clients ( username, password) VALUES (?,?)");
                pstmt.setString(1, name);
                pstmt.setString(2, pwd);
                int success = pstmt.executeUpdate();
                //if the insert is successful do nothing, else throw an SQl exception
                if(success>=1)
                {
                    
                }
                else
                {
                    throw new SQLException();
                }
            
            }
            
         }
            catch(SQLException e) {
                System.out.println("Exception is ;"+e + ": message is " + e.getMessage());
               
         }
        
    }
    
    //function to check if a user exists using the username
    public int doesUserExist(String username)
    {
        
        int clientID = 0;
        try{
            Connection connection = ds.getConnection();

            if (connection != null) {
                //prepared statement to avoid SQL injection
                pstmt = connection.prepareStatement("SELECT clientid FROM clients WHERE username = ?");
                pstmt.setString(1, username);
                ResultSet rs1 = pstmt.executeQuery();
                rs1.next();
                //if the user does exists return the client id, else return -1
                if(rs1 != null)
                {
                    clientID = rs1.getInt(1);
                    
                }
                else
                {
                    clientID = -1;
                }
            }
        }catch(SQLException e) {
                    
            System.out.println("Exception is ;"+e + ": message is " + e.getMessage());
            clientID =  -1;
        }
        return clientID;
    }
    
    public int getGroupID(int userID)
    {
       try {
            
            Connection connection = ds.getConnection();

            if (connection != null) {

                //query to see if there is a row in the DB with the given user credentials
                String query = "SELECT groupID FROM user WHERE userID =?"; 
                pstmt = connection.prepareStatement(query);
                pstmt.setInt(1, userID);
                ResultSet rs1 = pstmt.executeQuery();
                
                //go to the first row in the result set
                rs1.next();
                //if the entry returns a result, the client id of the row is returned, else -1 ios returned
                if(rs1 != null)
                {
                    int groupID = rs1.getInt(1);
                    return groupID;
                }
                else
                {
                    return -1;
                }
            }
            else {
                return -1;
            }
        } catch(SQLException e) {
                    
            System.out.println("Exception is ;"+e + ": message is " + e.getMessage());
            return -1;
        }
        
        
     
    }
}


