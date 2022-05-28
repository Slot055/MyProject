<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="windows-1251" %>
<%@ page import="ru.myOnlineShop.model.customer.ClientAccount,ru.myOnlineShop.model.constanta.StatusAccount" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="windows-1251">
</head>
<body>
<h1>Регистрация аккаунта</h1>
<h2>Введите свои данные</h2>
<%
    ClientAccount clientAccount = (ClientAccount) request.getSession().getAttribute("clientAccount");
    if (clientAccount == null) {
%>
<h3>Данные Аккаунта</h3>
<form action="/regAccount" method="post">
    <label for="login">Логин:</label><br>
    <input type="text" id="login" name="login"><br>
    <label for="password">Пароль:</label><br>
    <input type="text" id="password" name="password"/><br>
    <br>
    <br>
    <input type="submit" name="signup" value="Отправить">

    <p><input type="button" onclick="history.back();" value="Назад"/></p>
    <p><a href="./">Вернуться на главную страницу</a></p>

</form>
<%
} else if (clientAccount.getStatusAccount().equals(StatusAccount.ADMIN)) {
%>
<h3>Данные Аккаунта</h3>
<form action="/regAccount" method="post">
    <label for="login">Логин:</label><br>
    <input type="text" id="login" name="login"/><br>
    <label for="password">Пароль:</label><br>
    <input type="text" id="password" name="password"/><br>
    <label for="statusAccount">Статус Аккаунта:</label><br>
    <input type="text" id="statusAccount" name="statusAccount"/><br>
    <br>
    <h3> Личные данные</h3>
    <label for="name">Имя:</label><br>
    <input type="text" id="name" name="name"/><br>
    <label for="lastName">Фамилия:</label><br>
    <input type="text" id="lastName" name="lastName"/><br>
    <label for="gender">Пол:</label><br>
    <input type="text" id="gender" name="gender"/><br>
    <label for="age">Возраст(Лет):</label><br>
    <input type="text" id="age" name="age"/><br>
    <label for="phoneNumber">Номер телефона:</label><br>
    <input type="text" id="phoneNumber" name="phoneNumber"/><br>
    <label for="email">Электронная пота:</label><br>
    <input type="text" id="email" name="email"/><br>
    <br>
    <br>
    <input type="submit" name="signup" value="Отправить">
    <br>
    <br>
    <p><input type="button" onclick="history.back();" value="Назад"/></p>
    <p><a href="./">Вернуться на главную страницу</a></p>

</form>
<%
    }
%>
</body>
</html>