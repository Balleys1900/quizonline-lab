/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tailm.quizdetail;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.naming.NamingException;
import tailm.utilities.DBHelpers;

/**
 *
 * @author DELL INC
 */
public class QuizDetailDAO implements Serializable {

    public boolean insertNewQuizDetails(int quizID, int questionID, String questionContent, int answerID, String answerUserChoose) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBHelpers.makeConnection();
            if (con != null) {
                String sql = "INSERT INTO quizDetail(quizID, questionID, questionContent, answerID, answerUserChoose) "
                        + "VALUES(?, ?, ?, ?, ?)";
                ps = con.prepareStatement(sql);
                ps.setInt(1, quizID);
                ps.setInt(2, questionID);
                ps.setString(3, questionContent);
                ps.setInt(4, answerID);
                ps.setString(5, answerUserChoose);
                int rs = ps.executeUpdate();
                if (rs > 0) {
                    return true;
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
        return false;
    }

    public boolean updateQuizDetail(int quizID, int questionID, String questionContent, int answerID, String answerUserChoose) throws SQLException, NamingException {
        Connection con = null;
        PreparedStatement ps = null;
        try {
            con = DBHelpers.makeConnection();
            if (con != null) {
                String sql = "UPDATE quizDetail SET answerID = ?, answerUserChoose = ? "
                        + "WHERE quizID  = ? AND questionID = ? ";
                ps = con.prepareStatement(sql);
                ps.setInt(1, answerID);
                ps.setString(2, answerUserChoose);
                ps.setInt(3, quizID);
                ps.setInt(4, questionID);
                int rs = ps.executeUpdate();
                if (rs > 0) {
                    return true;
                }
            }
        } finally {
            if (con != null) {
                con.close();
            }
            if (ps != null) {
                ps.close();
            }
        }
        return false;
    }
}
