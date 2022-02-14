<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Administrator</title>
</head>
<body>
<h2>Admin page</h2>
<a href="MainController?command=goToNewMoviePage">Добавить фильм</a>
<br/>
<p>Список пользователей</p>
    <table border="1">
        <tr>

            <td>Login</td>

            <td>Status</td>

            <td>Rank</td>


        </tr>

        <c:forEach var="user" items="${users}">
        <tr>

            <td><a href="MainController?command=goToUserPage&userPageName=${user.getLogin()}&userPageRole=${user.getRole()}"><c:out
                    value="${user.getLogin()}"/></a></td>

            <td><c:out value="${user.getRole()}"/></td>
            <td><c:out value="${user.getRank()}"/></td>

           <%-- <td><c:out value="${user.getRank()}"/></td>--%>

        </tr>
        </c:forEach>
        <p>
        <a href="MainController?command=goToMainPage">на главную</a>
        </p>
</body>
</html>
