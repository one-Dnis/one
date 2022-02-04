<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Administrator</title>
</head>
<body>
<h2>Admin page</h2>
<%--<table width="100%" cellspacing="0" cellpadding="5">
    <tr>
        <td width="200" valign="top">Левая колонка</td><td valign="top">Правая колонка</td>
    </tr>
</table>--%>
<a href="MyController?command=goToNewMoviePage">Добавить фильм</a>
<br/>

<%--
<table border="1">
    <tr>

        <td>Title</td>

        <td>Year</td>
--%>

    <%--</tr>
    <c:forEach var="movie" items="${movies}">
    <tr>
            &lt;%&ndash;<td><a href="https://ru.wikipedia.org/wiki/Очень_страшное_кино">Scary Movie</a></td>&ndash;%&gt;
        <td><c:out value="${movie.getTitle()}"/></td>

        <td><c:out value="${movie.getYear()}"/></td>


    </tr>
    </c:forEach>--%>
<p>Список пользователей</p>
    <table border="1">
        <tr>

            <td>Login</td>

            <td>Status</td>


        </tr>

        <c:forEach var="user" items="${users}">
        <tr>

            <td><a href="MyController?command=goToUserPage&userPageName=${user.getLogin()}"><c:out
                    value="${user.getLogin()}"/></a></td>

            <td><c:out value="${user.getRole()}"/></td>

           <%-- <td><c:out value="${user.getRank()}"/></td>--%>

        </tr>
        </c:forEach>
        <p>
        <a href="MyController?command=goToMainPage">на главную</a>
        </p>
</body>
</html>
