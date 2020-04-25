<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Удалить пользователя</title>
</head>
<body>

Вы действительно хотите удалить пользователя ${param.id}?
<%--<form action="/users/${param.id}" method="post">--%>
<form action="/users/delete" method="post">
<input type="hidden" name="id" value="${param.id}">
<input type="hidden" name="_method" value="delete">
<input type="submit" value="Удалить">
</form>

</body>
</html>
