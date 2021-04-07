/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tailm.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tailm.answer.AnswerDAO;

/**
 *
 * @author DELL INC
 */
@WebServlet(name = "addNewAnswerServlet", urlPatterns = {"/addNewAnswerServlet"})
public class addNewAnswerServlet extends HttpServlet {

    private final String ADD_NEW_QUESTION_PAGE = "addNewQuestionPage";
    private final String LOAD_QUESTION = "loadQuestionAdmin";

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
        int lastRecordQuestionID = (int) request.getAttribute("LASTRECORD");
        String[] contentAnswer = request.getParameterValues("contentAnswer");
        String answerCorrect = request.getParameter("answerCorrect");
        String url = ADD_NEW_QUESTION_PAGE;
        try {
            boolean checkIsSuccess = true;
            AnswerDAO dao = new AnswerDAO();
            if (contentAnswer != null) {
                for (String answerContent : contentAnswer) {
                    if (!dao.addNewAnswer(lastRecordQuestionID, answerContent, false)) {
                        checkIsSuccess = false;
                    }
                }
                if (!dao.addNewAnswer(lastRecordQuestionID, answerCorrect, true)) {
                    checkIsSuccess = false;
                }
                if (checkIsSuccess) {
                    url = LOAD_QUESTION;
                }
            }

        } catch (NamingException ex) {
            log("updateAnswerServlet_NamingEx: " + ex.getMessage());
        } catch (SQLException ex) {
            log("updateAnswerServlet_SQLEx: " + ex.getMessage());
        } finally {
            response.sendRedirect(url);
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
