<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Authorization</title>
</head>
<body>
<h2>Authorization</h2>
<form action="MyController" method="post">
    <input type="hidden" name="command" value="authorization">
    <table>
        <tr>
            <td>Login:</td>
            <td><input type="text" name="login" value=""></td>
        <tr/>
        <tr>
            <td>Password:</td>
            <td><input type="password" name="password" value=""><td/>
        <tr/>
        <tr>
        <td align="right" colspan="2"><input type="submit" value="Enter"/>
        </tr>
    </table>
</form>
<br/>
<a href="MyController?command=goToRegistrationPage">Don't have an account?</a>
<a href="MyController?command=goToMainPage">на главную</a>
</body>
</html>
