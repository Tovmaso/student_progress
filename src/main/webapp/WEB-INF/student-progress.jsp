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
    <a href="#" class="navigation-item">на главную</a>
    <a href="#" class="navigation-item">назад</a>
</aside>
<main class="main">
    <h1 class="main-heading"> система управления студентами и их успеваемостью</h1>
    <h2 class="heading-secondary">отображена успеваемость для следующего студента:</h2>
    <div class="container">
        <table class="student-table" border="1">
            <tr>
                <th>фамилия</th>
                <th> имя</th>
                <th> группа</th>
                <th> дата поступления</th>
            </tr>
            <tr>
                <td>${student.surname}</td>
                <td>${student.name}</td>
                <td>${student.group}</td>
                <td>${student.date}</td>
            </tr>
        </table>
    </div>
    <section class="semestr-note">
        <div>
            <table class="disciplina-note" border="1">
                <tr>
                    <th>дисциплина</th>
                    <th>оценка</th>
                </tr>
                <c:forEach items="${marks}" var="m">
                    <tr>
                        <td>${m.discipline.discipline}</td>
                        <td>${m.mark}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <div class="choice-semestr">
            <h2> выбрать семестр : </h2>
            <form action="/student-progress" method="get">
                <select border="1" name="selectedTermId">
                    <c:forEach items="${terms}" var="t">
                        <c:choose>
                            <c:when test="${t.id == selected}">
                                <option SELECTED value="${t.id}" class="choice">${t.term}</option>
                            </c:when>
                            <c:otherwise>
                                <option value="${t.id}" class="choice">${t.term}</option>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </select>
                <form action="/student-progress" method="get">
                    <input type="hidden" name="hiddenProgress" value="${student.id}">
                    <input type="submit" class="choice-btn" value="выбрать">
                </form>
        </div>
    </section>
</main>
<aside class="logout">
    <a href="#" class="logout-btn">logout</a>
</aside>
</body>
</html>