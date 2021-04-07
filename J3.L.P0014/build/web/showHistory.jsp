<%-- 
    Document   : showHistory
    Created on : Feb 20, 2021, 9:31:35 PM
    Author     : DELL INC
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
              integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <link rel="stylesheet" href="./css/header.css">
        <title>History Page</title>
    </head>
    <body>
        <c:set var="user" value="${sessionScope.USER}"/>
        <div class="header">
            <a href="" class="logo">Quiz Online</a>
            <div class="header-right">
                <a href="loadQuestionAdmin">Home</a>
                <a style="color: red;" >Welcome, ${user.name}</a>
                <a href="addNewQuestionPage">Add New Question</a>
                <a class="active" href="#">Show History</a>
                <a href="logout">Log out</a>
            </div>
        </div>    
        <div style="margin-top: 40px;"></div>
        <div style="width: 80%; margin: auto;">
            <form action="showHistoryQuiz">
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <button class="btn btn-outline-primary" type="submit">Search</button>
                    </div>
                    <select class="custom-select" id="inputGroupSelect03" name="subjectID">
                        <option value="prj321">PRJ321</option>
                        <option value="prj311">PRJ311</option>
                    </select>
                </div>
            </form>

        </div>
        <c:set var="list" value="${requestScope.LISTRESULT}"/>
        <c:if test="${not empty list}">
            <table class="table">
                <thead>
                    <tr>
                        <th scope="col">#</th>
                        <th scope="col">Email</th>
                        <th scope="col">subjectID</th>
                        <th scope="col">Date Take Quiz</th>
                        <th scope="col">Time Take Quiz</th>
                        <th scope="col">Answer Correct</th>
                        <th scope="col">Total Question</th>
                        <th scope="col">Score</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dto" items="${list}" varStatus="counter">
                        <tr>
                            <th scope="row">${counter.count}.</th>
                            <td>${dto.email}</td>
                            <td>${dto.subjectID}</td>
                            <td>${dto.dateTakeQuiz}</td>
                            <td>${dto.timeTakeQuiz}</td>
                            <td>${dto.numberCorrect}</td>
                            <td>${dto.numberQuestion}</td>
                            <td>${dto.score}</td>
                        </tr>
                    </c:forEach>

                </tbody>
            </table>
        </c:if>

    </body>
</html>
