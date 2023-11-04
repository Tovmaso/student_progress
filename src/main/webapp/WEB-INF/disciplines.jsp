
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../recourses/css/style.css">
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Kelly+Slab&display=swap" rel="stylesheet">
    <title>disciplines</title>
</head>
<body>
<aside class="navigation">
    <a href="http://localhost:8080/" class="navigation-item">на главную</a>

</aside>

<main class="main">
    <h1 class="main-heading"> система управления студентами и их успеваемостью</h1>
    <h2 class="heading-secondary">список дисциплин</h2>

    <div class="container">
        <table class="discipline-table" border="1">
            <tr>
                <th>&nbsp</th>
                <th> название дисциплин</th>
            </tr>

            <c:forEach items="${discipline}" var="d">
            <tr>
                <td><input type="checkbox" id="" value="${d.id}" class="idToDiscipline">
                <td>${d.discipline}</td>
            </tr>
            </c:forEach>
        </table>
        <div class="discipline-btns">
            <form action="/discipline-create" method="get">
                <input type="submit" class="student-btn" value="создать дисципилну"/>
            </form>
            <input type="submit" onclick="modifyDiscipline()"  class="student-btn" value="модифицировать дисциплину"/>
            <input type="submit" onclick="deleteDiscipline()"  class="student-btn" value="удалить выбранную дисциплину"/>
        </div>
    </div>
</main>
<aside class="logout">
    <a href="#" class="logout-btn">logout</a>
</aside>
<form action="/discipline-delete" method="post" id="formDeleteDiscipline">
    <input type="hidden" value="" id="hiddenDeleteDiscipline" name="hiddenDeleteDiscipline">
</form>
<form action="/discipline-modify-modify" method="get" id="formModifyDiscipline">
    <input type="hidden" value="" id="hiddenModifyDiscipline" name="hiddenModifyDiscipline">
</form>
</body>
</html>