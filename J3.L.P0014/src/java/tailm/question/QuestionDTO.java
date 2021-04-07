/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tailm.question;

import java.io.Serializable;
import java.sql.Date;

/**
 *
 * @author DELL INC
 */
public class QuestionDTO implements Serializable{
    private int questionID;
    private String email;
    private String questionContent;
    private Date createDate;
    private String subjectID;
    private boolean status;

    public QuestionDTO(int questionID, String email, String questionContent, Date createDate, String subjectID, boolean status) {
        this.questionID = questionID;
        this.email = email;
        this.questionContent = questionContent;
        this.createDate = createDate;
        this.subjectID = subjectID;
        this.status = status;
    }

    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }
   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getQuestionContent() {
        return questionContent;
    }

    public void setQuestionContent(String questionContent) {
        this.questionContent = questionContent;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getSubjectID() {
        return subjectID;
    }

    public void setSubjectID(String subjectID) {
        this.subjectID = subjectID;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    
}
