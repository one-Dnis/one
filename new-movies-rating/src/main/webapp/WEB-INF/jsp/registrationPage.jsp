<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h2>Registration</h2>
<form action="MyController" method="post">
    <input type="hidden" name="command" value="registration">
    <p>
    Login:
    <input type="text" name="login" value="">
    </p>
    <p></p>
    Password:
    <input type="password" name="password" value="">
    </p>
    <p>
    Info:
    <input type="text" name="info" value="">
    </p>
    <p>
    <input type="submit" value="Enter"/>
    </p>
    <a href="MyController?command=goToMainPage">на главную</a>
</form>
<%--<%
    String errorMessage = (String)request.getAttribute("errorMessage");
    if (errorMessage != null) {
%>--%>
<h2>
    <%--<%
            System.out.println(errorMessage);
        }
    %>--%>
</h2>
</body>
</html>
