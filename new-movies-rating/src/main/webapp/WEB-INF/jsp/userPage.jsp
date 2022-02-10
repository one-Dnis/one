<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>страница <c:out value="${userPageName}"/></title>
</head>
<body>
<h2>Страница: <c:out value="${userPageName}"/></h2>
<form action="MyController" method="post">
    <input type="hidden" name="command" value="banUser">

    <c:if test="${userPageName != 'admin' and userPageRole != 'banned'}">
    <button name="userPageName" value="${userPageName}">забанить <br/> ${userPageName}</button>
    </c:if>
</form>
<form action="MyController" method="post">
    <input type="hidden" name="command" value="unbanUser">
    <c:if test="${userPageRole eq 'banned'}">
        <button name="userPageName" value="${userPageName}">разбанить <br/> ${userPageName}</button>
    </c:if>
</form>
<p>
    <a href="MyController?command=goToMainPage">на главную</a>
</p>
</body>
</html>
