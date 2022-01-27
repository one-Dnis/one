<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration</title>
</head>
<body>
<h2>Registration</h2>
<form action="MyController" method="get">
    <input type="hidden" name="command" value="registration">
    Login:
    <input type="text" name="login" value="">
    <br/>
    Password:
    <input type="password" name="password" value="">
    <br/>
    Info:
    <input type="text" name="info" value="">
    <input type="submit" value="Enter"/>
    <br/>
    <br/>
    <a href="MyController?command=goToMainPage">на главную</a>
</form>
<%
    String errorMessage = (String)request.getAttribute("errorMessage");
    if (errorMessage != null) {
%>
<h2>
    <%
            System.out.println(errorMessage);
        }
    %>
</h2>
</body>
</html>
