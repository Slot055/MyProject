<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="windows-1251"%>
<html>
<head>

</head>
<body>

<div>
    <form action="/regAccount/inputAccount" method="post">
        <h2 style="text-align:center">Вход в аккаунт</h2>

        <label for="login">Логин:</label><br>
        <input type="text" id="login" name="login"><br>
        <label for="password">Пароль:</label><br>
        <input type="text" id="password" name="password"><br>
        <br>
        <input type="submit" name="signup" value="Применить">
        <br>
        <p><a href="../authentificationAccount.jsp">Назад</a></p>
        <p><a href="../">Вернуться на главную страницу</a></p>

    </form>
</div>

</body>
</html>