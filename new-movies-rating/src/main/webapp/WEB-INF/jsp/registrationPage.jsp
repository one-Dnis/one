<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="localization.locale" var="loc"/>

    <fmt:message bundle="${loc}" key="locale.PASSWORD" var="password_title"/>
    <fmt:message bundle="${loc}" key="locale.LOGIN" var="login_title"/>
    <fmt:message bundle="${loc}" key="locale.REGISTRATION_BUTTON" var="registration_button"/>
    <fmt:message bundle="${loc}" key="locale.MAIN_PAGE" var="main_page"/>
    <fmt:message bundle="${loc}" key="locale.REGISTRATION_TITLE" var="registration_title"/>
    <fmt:message bundle="${loc}" key="locale.INFO_TITLE" var="info_title"/>

    <title>${registration_title}</title>
</head>
<body>
<h2>${registration_title}</h2>
<form action="MainController" method="post">
    <input type="hidden" name="command" value="registration">
    <p>
    ${login_title}:
    <input type="text" name="login" value="">
    </p>
    <p></p>
    ${password_title}:
    <input type="password" name="password" value="">
    </p>
    <p>
    ${info_title}:
    <input type="text" name="info" value="">
    </p>
    <p>
    <input type="submit" value="${registration_button}"/>
    </p>
    <a href="MainController?command=goToMainPage">${main_page}</a>
</form>
</body>
</html>
