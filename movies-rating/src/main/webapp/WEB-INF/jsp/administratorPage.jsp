<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Administrator</title>
</head>
<body>
<h2>Страничка администратора</h2>
<%--<table width="100%" cellspacing="0" cellpadding="5">
    <tr>
        <td width="200" valign="top">Левая колонка</td><td valign="top">Правая колонка</td>
    </tr>
</table>--%>
<table border="1">
    <tr>

        <td>Title</td>

        <td>Year</td>

    </tr>
    <c:forEach var="movie" items="${movies}">
    <tr>

        <td><c:out value="${movie.getTitle()}"/></td>

        <td><c:out value="${movie.getYear()}"/></td>


    </tr>
    </c:forEach>
<a href="MyController?command=goToMainPage">на главную</a>
</body>
</html>
