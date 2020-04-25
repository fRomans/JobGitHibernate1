<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Изменить данные пользователя</title>
</head>
<body>

Редактировать пользователя

<form action="/users/update" method="post">
    <input type="hidden" name = "id" value="${param.id}">
    <input type="text" name="name" value="${param.name}" placeholder=${param.name}>
    <input type="text" name="password" value="${param.password}" placeholder=${param.password}>
    <input type="text" name="money" value="${param.money}" placeholder=${param.money}>
    <input type="hidden" name="_method" value="put">
    <input type="submit" value="Обновить">
</form>

</body>
</html>
