/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.sql.DataSource;

import data.DataBoard;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;

/**
 *
 * @author Jayshree
 */
public class Board
{

    public int boardID;
    public String boardName = "";
    public Column[] boardColumnsArray;
    public int groupID;
    private DataBoard dataBoard = new DataBoard();

    public Board()
    {

    }

    public int getBoardID()
    {
        return this.boardID;
    }

    public void setBoardID(int id)
    {
        this.boardID = id;
    }

    /**
     * Creates the board and all the things for it :)
     */
    public void createBoard()
    {
        ResultSet rsColRetrieval;
        int arrayID = 0;
        
        setBoardName(dataBoard.getBoardName(boardID));
        int colCount = dataBoard.getColumnCount(boardID);
        
        boardColumnsArray = new Column[colCount];
        rsColRetrieval = dataBoard.getBoardColumns(boardID);
        
        
        try{
            while( rsColRetrieval.next())
            {
                int columnID = rsColRetrieval.getInt(1);
                int position = rsColRetrieval.getInt(4);
                String description = rsColRetrieval.getString(3);
                Column tempColumn = new Column(columnID, position, description);
                tempColumn.prepareColumn();
                if(arrayID == 0)
                {
                    tempColumn.setToFirstColumn();
                }
                boardColumnsArray[arrayID] = tempColumn;
                arrayID++;
            }
        }
        catch(SQLException e){
        
        }
    }
    
    public int getColumnIDAtPosition(int i)
    {
        return boardColumnsArray[i].getColumnID();
    }

    public Column getBoardColumn(int colID)
    {
        Column column = null;
        for (Column col : boardColumnsArray)
        {
            if (col.columnID == colID)
            {
                column = col;
            }
        }
        return column;
    }

    public String getBoardName()
    {
        return this.boardName;
    }

    private void setBoardName(String name)
    {
        this.boardName = name;
    }

    public Column[] getBoardColumns()
    {

        return this.boardColumnsArray;
    }
    
    public int getColumnCount()
    {
        return this.boardColumnsArray.length;
    }

    public int getStorycolumnPositionByID(int id)
    {
        return dataBoard.getStorycolumnPositionByID(id);
    }
    
    public Story getStoryByID(int id)
    {
        int colID = getStorycolumnPositionByID(id);
        Story s = this.getBoardColumn(colID).getStoryFromColumn(id);
        return s;
    }
    
    public String getStoryNameByStringID(String idString)
    {
        int id = Integer.parseInt(idString);
        int colID = getStorycolumnPositionByID(id);
        Story s = this.getBoardColumn(colID).getStoryFromColumn(id);
        return s.getName();
    }
    
}
