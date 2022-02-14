<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<html>
<head>

    <fmt:setLocale value="${sessionScope.locale}"/>
    <fmt:setBundle basename="localization.locale" var="loc"/>

    <fmt:message bundle="${loc}" key="locale.LOC_BUTTON_NAME_EN" var="en_button"/>
    <fmt:message bundle="${loc}" key="locale.LOC_BUTTON_NAME_RU" var="ru_button"/>
    <fmt:message bundle="${loc}" key="locale.MOVIES_RATING_TITLE" var="movies_rating_title"/>
    <fmt:message bundle="${loc}" key="locale.MOVIES_LIST" var="movies_list_title"/>
    <fmt:message bundle="${loc}" key="locale.RANK_TITLE" var="rank_title"/>
    <fmt:message bundle="${loc}" key="locale.PLACE_TITLE" var="place_title"/>
    <fmt:message bundle="${loc}" key="locale.AUTHORIZATION_TITLE" var="authorization_title"/>
    <fmt:message bundle="${loc}" key="locale.LOGOUT_TITLE" var="logout_title"/>
    <fmt:message bundle="${loc}" key="locale.ADMIN_PAGE_TITLE" var="admin_page_title"/>
    <fmt:message bundle="${loc}" key="locale.AUTHORIZATION_EMPTY_STATUS" var="authorization_empty"/>
    <fmt:message bundle="${loc}" key="locale.AUTHORIZATION_NOT_EMPTY_STATUS" var="authorization_not_empry"/>

    <title>${movies_rating_title}</title>
</head>
<body>
<h2>${movies_rating_title}</h2>
<p>
    <c:if test="${empty userName}">
        ${authorization_empty}
    </c:if>
    <c:if test="${not empty userName}">
        ${authorization_not_empry}:${userName}
    </c:if>
</p>
<p>
<table border="1">
    <tr>
        <td align="middle">${place_title}</td>
        <td>${movies_list_title}</td>
        <td align="middle">${rank_title}</td>
    </tr>
    <c:forEach var="movie" items="${movies}">
        <tr>
            <td align="middle">${movies.indexOf(movie) + 1}</td>

            <td><a href="MainController?command=goToMoviePage&movieTitle=${movie.getTitle()}"><c:out value="${movie.getTitle()}"/></a></td>

            <td align="middle">
                <c:if test="${movie.getRating() eq 0}">
                    -
                </c:if>
                <c:if test="${movie.getRating() != 0}">
                    <fmt:formatNumber minFractionDigits="1" maxFractionDigits="1" value ="${movie.getRating()}" />
                </c:if>
            </td>
        </tr>
    </c:forEach>
</table>
</p>
<c:if test="${empty role}">
    <p>
        <a href="MainController?command=goToAuthorizationPage">${authorization_title}</a>
    </p>
</c:if>
<c:if test="${role eq 'banned'}">
    <p>
        <a href="MainController?command=endSession">${logout_title}</a>
    </p>
</c:if>
<c:if test="${not empty role and role eq 'admin'}">
    <p>
    <a href="MainController?command=endSession">${logout_title}</a>
    </p>
    <p>
    <a href="MainController?command=goToAdministratorPage">${admin_page_title}</a>
    </p>
</c:if>
<c:if test="${not empty role and role eq 'user'}">
    <p>
        <a href="MainController?command=endSession">${logout_title}</a>
    </p>
</c:if>
<table>
    <tr>
<form action="MainController" method="post">
    <input type="hidden" name="command" value="locale"/>
    <button name="locale" value="ru">${ru_button}</button>
</form>
    </tr>
    <tr>
<form action="MainController" method="post">
    <input type="hidden" name="command" value="locale"/>
    <button name="locale" value="en">${en_button}</button>
</form>
    </tr>
</table>
</body>
</html>