<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<h2>Authorization</h2>
<form action="MyController" method="post">
    <input type="hidden" name="command" value="authorization">
    <p>
    Login:
    <input type="text" name="login" value="">
    </p>
    <p>
    Password:
    <input type="password" name="password" value="">
    </p>
    <input type="submit" value="Enter"/>
</form>
<br/>
<a href="MyController?command=goToRegistrationPage">Don't have an account?</a>
<a href="MyController?command=goToMainPage">на главную</a>
</body>
</html>
