/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tailm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Map;
import javax.naming.NamingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tailm.answer.AnswerDAO;
import tailm.question.QuestionDAO;
import tailm.question.QuestionDTO;

/**
 *
 * @author DELL INC
 */
@WebServlet(name = "addNewQuestionServlet", urlPatterns = {"/addNewQuestionServlet"})
public class addNewQuestionServlet extends HttpServlet {

    private final String ADD_NEW_QUESTION_PAGE = "addNewQuestionPage";
    private final String ADD_NEW_ANSWER = "addNewAnswer";
    
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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String email = request.getParameter("email");
        String questionContent = request.getParameter("questionContent");

        String subjectID = request.getParameter("subjectID");
        boolean status = Boolean.parseBoolean(request.getParameter("status"));
        String url = ADD_NEW_QUESTION_PAGE;
        try{
            QuestionDAO dao = new QuestionDAO();
            
            if(!dao.checkDuplicateQuestion(questionContent)){
                java.util.Date date = new java.util.Date();
                Date createDate = new Date(date.getTime());
                dao.addNewQuestion(new QuestionDTO(0, email, questionContent, createDate, subjectID, status));
                request.setAttribute("LASTRECORD", dao.getLastRecord());
                url = ADD_NEW_ANSWER;
            }else{
                request.setAttribute("DUPLICATE", "Question Content has been existed!!!");
            }
        } catch (NamingException ex) {
            log("updateAnswerServlet_NamingEx: " + ex.getMessage());
        } catch (SQLException ex) {
            log("updateAnswerServlet_SQLEx: " + ex.getMessage());
        } finally {
              ServletContext context = request.getServletContext();
            Map<String, String> listFilter = (Map<String, String>) context.getAttribute("FILTER");
            RequestDispatcher rd = request.getRequestDispatcher(listFilter.get(url));
            rd.forward(request, response);
            out.close();
        }
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
            throws ServletException, IOException {
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
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
