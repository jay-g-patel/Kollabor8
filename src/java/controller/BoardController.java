/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
        if (action.equals("/progressStory"))
        {
            int colID = Integer.parseInt(request.getParameter("columnID"));
            int newColID = colID + 1;
            int storyID = Integer.parseInt(request.getParameter("storyID"));
            try
            {
                board.getBoardColumn(colID).getStoryFromColumn(storyID).changeColumn(newColID);
                board.getBoardColumn(colID).prepareColumn();
                board.getBoardColumn(newColID).prepareColumn();
            } catch (Exception e)
            {
                System.out.println("Exception message is " + e.getMessage());
            }
            dispatcher = this.getServletContext().getRequestDispatcher("/viewBoard.jspx");
        } else if (action.equals("/viewBoard"))
        {
            String c = request.getParameter("addColumn");
            if(c != null && c.equals("true"))
            {
                
                String columnName = request.getParameter("columnName");
                Column tmpColumn = new Column();
                tmpColumn.commitNewColumn(board.getBoardID(), columnName);
                
            }
            String s = request.getParameter("addStory");
            if(s != null && s.equals("true"))
            {
                String storyDesc = request.getParameter("storyName");
                Story tmpStory = new Story();
                tmpStory.commitStory(storyDesc,board.getColumnIDAtPosition(0));
                response.sendRedirect("../viewBoard.jspx");
                forward = false;            
            }
            board = new Board();
            group = (Group) session.getAttribute("userGroup");
            board.setBoardID(group.getBoardID());
            board.createBoard();
            session.setAttribute("sessionBoard", board);
            this.getServletContext().setAttribute("sessionBoard", board);
            if(forward){
            dispatcher = this.getServletContext().getRequestDispatcher("/viewBoard.jspx");
            }
        }
        else if (action.equals("/createStory"))
        {
            dispatcher = this.getServletContext().getRequestDispatcher("/createStory.jspx");
        }
        else if (action.equals("/createColumn"))
        {
            dispatcher = this.getServletContext().getRequestDispatcher("/createColumn.jspx");
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
