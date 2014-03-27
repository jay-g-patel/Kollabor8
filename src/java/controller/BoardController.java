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
            board = new Board();
            group = (Group) session.getAttribute("userGroup");
            board.setBoardID(group.getBoardID());
            board.createBoard();
            session.setAttribute("sessionBoard", board);
            this.getServletContext().setAttribute("sessionBoard", board);
            dispatcher = this.getServletContext().getRequestDispatcher("/viewBoard.jspx");
        }
        else if (action.equals("/addStory"))
        {
            String storyDesc = request.getParameter("storyDesc");
            Story tmpStory = new Story();
            tmpStory.setName(storyDesc);
            tmpStory.setColumnID(board.getColumnIDAtPosition(0));
            tmpStory.commitStory();
            try
            {
                for(int i=0; i<board.getColumnCount(); i++)
                {
                    int x = board.getColumnIDAtPosition(i);
                    board.getBoardColumn(x).prepareColumn();
                }
            }
            catch (Exception e)
            {
                System.out.println("Exception message is " + e.getMessage());
            }
            dispatcher = this.getServletContext().getRequestDispatcher("/viewBoard.jspx");
        }

        dispatcher.forward(request, response);
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
