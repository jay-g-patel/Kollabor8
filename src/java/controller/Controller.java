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

/**
 *
 * @author Jayshree
 */
@WebServlet(name = "Controller", urlPatterns =
{
    "/Controller"
})
public class Controller extends HttpServlet
{

    private HttpSession session;

    private Users user;
    private Group group;

    public void init()
    {
        user = new Users();

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
        String action = request.getPathInfo();
        RequestDispatcher dispatcher = null;
        if (action.equals("/login"))
        {
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            int clientID = user.isValid(username, password);
            int userType = user.getUserType(clientID);

            if (userType == 1)
            {
                //if combination is valid a session is created here
                session = request.getSession();
                session.setAttribute("user", username);
                session.setMaxInactiveInterval(500);
                //creates a new lesson selection for the user and stores it in the session
                //redirect user to the lesson timetable view
                dispatcher = this.getServletContext().getRequestDispatcher("/adminPage.jspx");
            } 
            else if (userType > 1)
            {
                session = request.getSession();
                session.setAttribute("user", username);
                this.getServletContext().setAttribute("user", username);
                group = new Group(user.getGroupID(clientID));
                session.setAttribute("userGroup", group);
                this.getServletContext().setAttribute("userGroup", group);
                
                //creates a new lesson selection for the user and stores it in the session
                //redirect user to the lesson timetable view
                dispatcher = this.getServletContext().getRequestDispatcher("/groupUserPage.jspx");

            } 
            else if (userType < 1)
            {

                dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");

            }

        }
        
        else
        {
            dispatcher = this.getServletContext().getRequestDispatcher("/login.jsp");
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
