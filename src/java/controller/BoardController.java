/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import data.DataStory;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.Integer.parseInt;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Board;
import model.Column;
import model.Users;
import model.Group;
import model.Story;

/**
 *
 * @author Jayshree
 */
public class BoardController extends HttpServlet
{

    HttpSession session;
    private Board board;
    private Group group;
    private Story story;
    private boolean forward = true;

    public void init()
    {

    }

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        session = request.getSession();
        String action = request.getPathInfo();
        RequestDispatcher dispatcher = null;
        if(action.equals("/viewBoard"))
        {
            board = new Board();
            group = (Group) session.getAttribute("userGroup");
            board.setBoardID(group.getBoardID());
            board.createBoard();
           
//            session.setAttribute("board", board);
//            this.getServletContext().setAttribute("board", board);
            session.setAttribute("group", group);
            this.getServletContext().setAttribute("group", group);
            
            String viewBoardAction = request.getParameter("viewBoardAction");
            String update = request.getParameter("update");
            if(viewBoardAction != null && viewBoardAction.equals("addColumn"))
            {                
                String columnName = request.getParameter("columnName");
                Column tmpColumn = new Column();
                tmpColumn.commitNewColumn(board.getBoardID(), columnName);
            }
            else if(viewBoardAction != null && viewBoardAction.equals("addStory"))
            {
                String storyDesc = request.getParameter("storyName");
                int storyUser = 0;
                Date completionDate = null;
                if(!request.getParameter("endDate").equals(""))
                {
                    try
                    {
                        completionDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("endDate"));
                    } catch (ParseException ex)
                    {
                        Logger.getLogger(BoardController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(request.getParameter("storyUserID") != null)
                {
                    storyUser = parseInt(request.getParameter("storyUserID"));
                }
                Story tmpStory = null;
                //get the right story to work with
                if(update != null && update.equals("true"))
                {
                    tmpStory = (Story)session.getAttribute("tmpStory");
                    tmpStory.updateName(storyDesc);
                }
                else
                {
                    tmpStory = new Story();
                    tmpStory.commitStory(storyDesc,board.getColumnIDAtPosition(0));
                }
                
                if(completionDate != null)
                {
                    tmpStory.enterCompletionDate(completionDate);
                }
                if(storyUser != 0)
                {
                    tmpStory.updateStoryUser(storyUser);
                }
                
                session.removeAttribute("tmpStory");
               response.sendRedirect("../viewBoard.jspx");
                forward = false;            
            }
            else if(viewBoardAction != null && viewBoardAction.equals("updateStory"))
            {
                String storyDesc = request.getParameter("storyName");
                int storyUser = 0;
                Date completionDate = null;
                if(!request.getParameter("endDate").equals(""))
                {
                    try
                    {
                        completionDate = new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("endDate"));
                    } catch (ParseException ex)
                    {
                        Logger.getLogger(BoardController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                if(request.getParameter("storyUserID") != null)
                {
                    storyUser = parseInt(request.getParameter("storyUserID"));
                }
                
                   Story tmpStory = (Story)session.getAttribute("tmpStory");
                    tmpStory.updateName(storyDesc);
                
                
                if(completionDate != null)
                {
                    tmpStory.enterCompletionDate(completionDate);
                }
                if(storyUser != 0)
                {
                    tmpStory.updateStoryUser(storyUser);
                }
                
                session.removeAttribute("tmpStory");
               response.sendRedirect("../viewBoard.jspx");
                forward = false;            
            }
            else if(viewBoardAction != null && viewBoardAction.equals("progressStory"))
            {
                int colID = Integer.parseInt(request.getParameter("columnID"));
                int newColID = colID + 1;
                int storyID = Integer.parseInt(request.getParameter("storyID"));
                story = board.getBoardColumn(colID).getStoryFromColumn(storyID);
                if(board.getBoardColumn(colID).getPosition() < 3)
                {
                   if(story.doesStoryHaveDependencies())
                   {
                       boolean canMove = true;
                       for(int i = 0; i < story.getDependencies().size(); i++)
                       {
                         int pos = board.getStorycolumnPositionByID(story.getDependencies().get(i));
                          if(pos < 3 )
                          {
                              //if the column position is not 3, the dependent story has not been worked on
                              //therefor set can Move to false, and come out of the for loop
                              canMove = false;
                              i = story.getDependencies().size();
                          }
                          
                       }
                       if(canMove)
                       {
                            board.getBoardColumn(colID).getStoryFromColumn(storyID).changeColumn(newColID);
                            board.getBoardColumn(colID).prepareColumn();
                            board.getBoardColumn(newColID).prepareColumn();
                       }
                   }
                   else
                   {
                        board.getBoardColumn(colID).getStoryFromColumn(storyID).changeColumn(newColID);
                        board.getBoardColumn(colID).prepareColumn();
                        board.getBoardColumn(newColID).prepareColumn();
                   }
                }
                else
                {
                    //story is in position 3 already, do not move forward
                }
                try
                {
                   
                } catch (Exception e)
                {
                    System.out.println("Exception message is " + e.getMessage());
                }
            }
             board.createBoard();
             session.setAttribute("sessionBoard", board);
            this.getServletContext().setAttribute("sessionBoard", board);
            if(forward){
            dispatcher = this.getServletContext().getRequestDispatcher("/viewBoard.jspx");
            }
        }
        else if(action.equals("/editStory"))
        {
            dispatcher = this.getServletContext().getRequestDispatcher("/editStory.jspx");
            session.getAttribute("tmpStory");
        }
        else if (action.equals("/createStory"))
        {
            session.removeAttribute("tmpStory");
            dispatcher = this.getServletContext().getRequestDispatcher("/createStory.jspx");
            session.getAttribute("tmpStory");
            
        }
        else if (action.equals("/createColumn"))
        {
            dispatcher = this.getServletContext().getRequestDispatcher("/createColumn.jspx");
        }
        else if(action.equals("/viewBoardSettings"))
        {
            dispatcher = this.getServletContext().getRequestDispatcher("/boardSetting.jspx");
        }
        else if(action.equals("/viewStoryDetails"))
        {
            story = new Story();
            int storyID = Integer.parseInt(request.getParameter("storyID"));
            int colID = Integer.parseInt(request.getParameter("columnID"));
            if(colID == 0)
            {
                DataStory ds = new DataStory();
                story = ds.getStoryDetailsByID(storyID);
            }
            else
            {
                board.getBoardColumn(colID).prepareColumn();
                story = board.getBoardColumn(colID).getStoryFromColumn(storyID);
            }
            session = request.getSession();
            //story.updateStory();
            session.setAttribute("tmpStory", story);
            this.getServletContext().setAttribute("tmpStory", story);
            
            dispatcher = this.getServletContext().getRequestDispatcher("/storyDetails.jspx");
        }
        else if(action.equals("/viewBacklog"))
        {
             dispatcher = this.getServletContext().getRequestDispatcher("/backlog.jspx");
        }

if(forward)
{
        dispatcher.forward(request, response);
}
forward = true;
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
