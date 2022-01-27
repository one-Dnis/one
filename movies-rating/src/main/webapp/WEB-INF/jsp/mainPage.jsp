<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>MyMoviesRating</title>
</head>
<body>
<h2>Movies rating</h2>

<table border="1">
    <tr>
        <td>Place</td>

        <td>Title</td>

        <td>Year</td>

        <td>Short description</td>

        <td>Rank<td>
    </tr>
    <c:forEach var="movie" items="${movies}">
    <tr>
        <td>number</td>

        <td><c:out value="${movie.getTitle()}"/></td>

        <td><c:out value="${movie.getYear()}"/></td>

        <td><c:out value="${movie.getShortDescription()}"/></td>

        <td>rank</td>
    </tr>
    </c:forEach>

    <%--<%
        String regInfo = request.getParameter("registrationInfo");
        if (regInfo != null) {
    %>
<h2>
    <%
        System.out.println(regInfo);
        }
    %>
</h2>--%>



<c:set var="role" scope="session" value="${role}"/> <%--value чудом заработало--%>
    <c:if test="${empty role}" var="testif">
    <a href="MyController?command=goToAuthorizationPage">войти</a>
    </c:if>
    <c:if test="${not empty role and role eq 'admin'}" var="testif">
        <a href="MyController?command=goToAdministratorPage">admin page</a>
        <a href="MyController?command=endSession">выйти</a>
    </c:if>
    <c:if test="${not empty role and role eq 'user'}" var="testif">
    <a href="MyController?command=endSession">выйти</a>
    </c:if>

</body>
</html>