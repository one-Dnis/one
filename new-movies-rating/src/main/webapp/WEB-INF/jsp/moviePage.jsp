<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title><c:out value="${movieTitle}"/></title>
</head>
<body>
<h1><c:out value="${movieTitle}"/></h1>
<h4><c:out value="${movieType}"/></h4>
<h4><c:out value="${movieYear}"/> год</h4>
<p>Описание:<c:out value="${movieDescription}"/></p>
<p>Рейтинг:
    <c:if test="${movieRating eq 0}" var="testif">
        никто не оценил
    </c:if>
    <c:if test="${movieRating != 0}" var="testif">
        <fmt:formatNumber minFractionDigits="1" maxFractionDigits="1" value ="${movieRating}" />
    </c:if>
</p>
<c:if test="${not empty userName}">

    <p>
        <a href="MainController?command=goToReviewPage&movieTitle=${movieTitle}">
            <button>Оставить отзыв</button>
        </a>
    </p>
</c:if>
<c:if test="${not empty reviewList}">
<table>
    <tr>
        <td>отзывы</td>
    </tr>
    <c:forEach var="review" items="${reviewList}">
        <tr>
            <td>${review.getUser()}:${review.getReview()}</td>
        </tr>
    </c:forEach>
</table>
</c:if>
<p>
<c:if test="${empty reviewList}">
    нет отзывов
</c:if>
</p>
<div>
    <a href="MainController?command=goToMainPage">на главную</a>
</div>
</body>
</html>
