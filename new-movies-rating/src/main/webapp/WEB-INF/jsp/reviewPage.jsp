<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Отзыв на <c:out value="${movieTitle}"/></title>
</head>
<h2>Отзыв на <c:out value="${movieTitle}"/></h2>
<body>
<form action="MainController" method="get">
    <input type="hidden" name="command" value="newReview">
    <input type="hidden" name="movieTitle" value="${movieTitle}">

    <p>Оцените фильм:<input type="number" name="mark" value="5" min="1" max="10" step="1"></p>
    Оставьте отзыв:
    <br/>
    <textarea name="movieReview"></textarea>
    <br/>
    <br/>
    <input type="submit" value="Оставить отзыв"/>
</form>
</body>
</html>
