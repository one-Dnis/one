<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="localization.locale" var="loc"/>

    <fmt:message bundle="${loc}" key="locale.PASSWORD" var="password_title"/>
    <fmt:message bundle="${loc}" key="locale.LOGIN" var="login_title"/>
    <fmt:message bundle="${loc}" key="locale.ENTER_BUTTON" var="enter_button"/>
    <fmt:message bundle="${loc}" key="locale.MAIN_PAGE" var="main_page"/>
    <fmt:message bundle="${loc}" key="locale.AUTHORIZATION_BUTTON" var="authorization_title"/>
    <fmt:message bundle="${loc}" key="locale.REGISTRATION_STATUS" var="registration_status"/>

    <title>${authorization_title}</title>
</head>
<body>
<h2>${authorization_title}</h2>
<form action="MainController" method="post">
    <input type="hidden" name="command" value="authorization">
    <table>
        <tr>
            <td>${login_title}:</td>
            <td><input type="text" name="login" value=""></td>
        <tr/>
        <tr>
            <td>${password_title}:</td>
            <td><input type="password" name="password" value=""><td/>
        <tr/>
        <tr>
        <td align="right" colspan="2"><input type="submit" value="${enter_button}"/>
        </tr>
    </table>
</form>
<br/>
<a href="MainController?command=goToRegistrationPage">${registration_status}</a>
<a href="MainController?command=goToMainPage">${main_page}</a>
</body>
</html>
