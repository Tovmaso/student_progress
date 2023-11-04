<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../recourses/css/style.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Kelly+Slab&display=swap" rel="stylesheet">
    <script src="../recourses/js/functions.js"></script>
    <title>student</title>
</head>
<body>
<aside class="navigation">
    <a href="http://localhost:8080/" class="navigation-item">на главную</a>

</aside>

<main class="main">
    <h1 class="main-heading"> система управления студентами и их успеваемостью

    </h1>

    <div class="student-btns">
        <div class="student-btns1">
            <input onclick="progresStudents()" type="submit" class="student-btn" value="посмотреть успеваемость студента"/>
            <input onclick="modifyStudents()" type="submit" class="student-btn" value="модифицировать выбранного студента"/>
        </div>
        <div class="student-btns1">
            <form action="/student-create" method="get">
                <input type="submit" class="student-btn" value="создать студента"/>
            </form>
            <input type="submit" onclick="deleteStudents()"  class="student-btn" value="удалить выбранных студентов"/>
        </div>
    </div>
    <h2 class="heading-secondary">
        список студентов
    </h2>
    <table class="student-table" border="1">
        <tr>
            <th>&nbsp</th>
            <th>фамилия</th>
            <th>имя</th>
            <th>группа</th>
            <th>дата поступления</th>
        </tr>

        <c:forEach items="${students}" var="st">
            <tr>
                <td><input type="checkbox" id="" value="${st.id}" class="idStudent">
                </td>
                <td>${st.surname}</td>
                <td>${st.name}</td>
                <td>${st.group}</td>
                <td>${st.date}</td>
            </tr>
        </c:forEach>
    </table>
</main>
<aside class="logout">
    <a href="#" class="logout-btn">logout</a>
</aside>
<form action="/student-delete" method="post" id="formDelete">
    <input type="hidden" value="" id="hiddenDelete" name="hiddenDelete">
</form>
<form action="/student-modify" method="get" id="formModify">
    <input type="hidden" value="" id="hiddenModify" name="hiddenModify">
</form>
<form action="/student-progress" method="get" id="formProgress">
    <input type="hidden" value="" id="hiddenProgress" name="hiddenProgress">
</form>

</body>
</html>