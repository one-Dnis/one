<%--
  Created by IntelliJ IDEA.
  User: Dnis
  Date: 04.02.2022
  Time: 03:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить фильм</title>
</head>
<body>
<p>добавить новый фильм</p>
<form action="MyController" method="get">
    <input type="hidden" name="command" value="newMovie">
    Название:
    <input type="text" name="NEW_TITLE" value="">
    <br/>
    Тип:
    <label>
        <input type="radio" name="NEW_TYPE" value="Фильм" checked>
        Фильм
    </label>
    <label>
        <input type="radio" name="NEW_TYPE" value="Сериал">
        Сериал
    </label>
    <br/>
    <p>Год:<input type="number" name="NEW_YEAR" value="2000" min="1900" max="2022" step="1"></p>
    <br/>
    Описание:
    <textarea name="NEW_SHORT_DESCRIPTION"></textarea>
    <br/>
    <br/>
    <input type="submit" value="Добавить"/>
</form>
</body>
</html>
