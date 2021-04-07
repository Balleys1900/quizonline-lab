<%-- 
    Document   : addNewQuestion
    Created on : Feb 19, 2021, 8:59:36 AM
    Author     : DELL INC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <title>Add Question Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/header.css">
        <link rel="stylesheet" href="./css/manageQuizAdmin.css">
    </head>

    <body>

        <c:set var="user" value="${sessionScope.USER}"/>

        <div class="header">
            <a href="#" class="logo">Quiz Online</a>
            <div class="header-right">
                <a href="loadQuestionAdmin">Home</a>
                <a style="color: red;" >Welcome, ${user.name}</a>
                <a class="active" href="#">Add New Question</a>
            </div>
        </div>
        <div style="margin-top: 40px;"></div>
        <div style="width: 80%;margin: auto;">
            <form action="addNewQuestion">
                <input type="hidden" name="email" value="${user.email}" />
                <div class="input-group input-group-lg">
                    <div class="input-group-prepend">
                        <span class="input-group-text" id="inputGroup-sizing-lg">Question Content</span>
                    </div>
                    <input name="questionContent" type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm"
                           value="">
                </div>


                <div class="groupAnswer">

                    <div style="margin-top: 10px;"></div>


                    <div class="input-group-prepend">
                        <span style="color: green;font-size: 18px;" class="input-group-text" id="inputGroup-sizing-lg">Content
                            Answer</span>
                    </div>
                    <input name="contentAnswer" type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" value="" required>
                    <input name="contentAnswer" type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" value="" required>
                    <input name="contentAnswer" type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm" value="" required>

                    <div class="input-group input-group-lg">
                        <div class="input-group-prepend">
                            <span style="color: blue;" class="input-group-text" id="inputGroup-sizing-lg">Answer Correct</span>
                        </div>
                        <input name="answerCorrect" type="text" class="form-control" aria-label="Large" aria-describedby="inputGroup-sizing-sm"
                               value="">
                    </div>
                </div>
                Subject
                <select class="custom-select" name="subjectID">
                    <option value="PRJ321">PRJ321</option>
                    <option value="PRJ311">PRJ311</option>
                </select>
                Status
                <select class="custom-select" name="status">
                    <option value="true">Active</option>
                    <option value="false">InActive</option>
                </select>
                <div class="dropdown-divider"></div>
                <div style="margin-top: 20px;"></div>
                <div style="margin: auto; width: 80%;">
                    <button  type="submit" class="btn btn-outline-info btn-lg btn-block">Add New Question</button>
                </div>
                <div style="margin-top: 20px;"></div>
            </form>
        </div>           


    </body>
</html>
