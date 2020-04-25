<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Добавить нового пользователя</title>
</head>
<body>
<form action = "/users" method="post">
<%--    <input required type="text" name="id" placeholder="идентификатор">--%>
    <input required type="text" name="name" placeholder="имя">
    <input required type="text" name="password" placeholder="пароль">
    <input required type="text" name="money" placeholder="деньги">


    <input type="submit" value="Сохранить">
</form>
</body>
</html>