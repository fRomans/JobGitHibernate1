<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Список пользователей</title>
</head>
<body>
<table border="2">
    <tr>
        <td>id</td>
        <td>name</td>
        <td>password</td>
        <td>money</td>
    </tr>
    <c:forEach items="${users}" var = "user">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getName()}</td>
            <td>${user.getPassword()}</td>
            <td>${user.getMoney()}</td>
            <td>
                <form action = "updateUser.jsp" method="post">
                    <input type="hidden" name="id" value="${user.getId()}">
                    <input type="hidden" name="name" value="${user.getName()}">
                    <input type="hidden" name="password" value="${user.getPassword()}">
                    <input type="hidden" name="money" value="${user.getMoney()}">
                    <input type="submit" value="Изменить" style="float:left">
                </form>
                <form action="deleteUser.jsp" method="post">
                    <input type="hidden" name="id" value="${user.getId()}">
                    <input type="submit" value="Удалить" style="float:left">
                </form></td>
        </tr>
    </c:forEach>
</table>

<form action = "addUser.jsp">
    <input type="submit" value="Добавить нового пользователя">
</form>
</body>
</html>