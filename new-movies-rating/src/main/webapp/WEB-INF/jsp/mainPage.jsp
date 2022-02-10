<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>MyMoviesRating</title>
</head>
<body>
<h2>Movies rating</h2>
<p>
    <c:if test="${empty userName}">
        Вы вошли как гость
    </c:if>
    <c:if test="${not empty userName}">
        Вы вошли как:${userName}
    </c:if>
</p>
<p>
<table border="1">
    <tr>
       <%-- <td>Place</td>--%>

        <td>Список фильмов</td>
    </tr>
    <c:forEach var="movie" items="${movies}">
        <tr>
            <%--<td>number</td>--%>

            <td><a href="MyController?command=goToMoviePage&movieTitle=${movie.getTitle()}"><c:out value="${movie.getTitle()}"/></a>
            </td>
        </tr>
    </c:forEach>
</table>
</p>
<%--<a href="MyController?command=goToMessagePage&message=hello">message page</a>--%>
<%--<c:set var="userName" scope="session" value="${userName}"/>
<c:set var="role" scope="session" value="${role}"/>--%>
<c:if test="${empty role}">
    <p>
        <a href="MyController?command=goToAuthorizationPage">войти</a>
    </p>
</c:if>
<c:if test="${role eq 'banned'}">
    <p>
        <a href="MyController?command=endSession">выйти</a>
    </p>
</c:if>
<c:if test="${not empty role and role eq 'admin'}">
    <p>
    <a href="MyController?command=endSession">выйти</a>
    </p>
    <p>
    <a href="MyController?command=goToAdministratorPage">admin page</a>
    </p>
</c:if>
<c:if test="${not empty role and role eq 'user'}">
    <p>
        <a href="MyController?command=endSession">выйти</a>
    </p>
</c:if>
</body>
</html>