<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="clientAccount" scope="request" type="ru.myOnlineShop.model.customer.ClientAccount"/>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h1>Форма редактирования данных</h1>
<h2>Введите новые данные</h2>

<div>
    <h3>Форма редактирования данных Аккаунта</h3>
    <form action="<c:url value="/regAccount/inputAccount/editAccountDB"/>" method="post">
        <input type="hidden" value="${clientAccount.idAccount}" name="idAccount"/>
        <label for="login">Логин:</label><br>
        <input type="text" id="login" name="login" value="${clientAccount.login}" /><br>
        <label for="password">Пароль:</label><br>
        <input type="text" id="password" name="password" value="${clientAccount.password}" /><br>
        <label for="statusAccount">Статус Аккаунта:</label><br>
        <input type="text" id="statusAccount" name="statusAccount" value="${clientAccount.statusAccount}" /><br>
        <br>
        <p>Форма редактирования Личных данных</p>
        <label for="name">Имя:</label><br>
        <input type="text" id="name" name="name" value="${clientAccount.client.name}" /><br>
        <label for="lastName">Фамилия:</label><br>
        <input type="text" id="lastName" name="lastName" value="${clientAccount.client.lastName}" /><br>
        <label for="gender">Пол:</label><br>
        <input type="text" id="gender" name="gender" value="${clientAccount.client.gender}" /><br>
        <label for="age">Возраст(Лет):</label><br>
        <input type="text" id="age" name="age" value="${clientAccount.client.age}" /><br>
        <label for="phoneNumber">Номер телефона:</label><br>
        <input type="text" id="phoneNumber" name="phoneNumber" value="${clientAccount.client.phoneNumber}"
        /><br>
        <label for="email">Электронная пота:</label><br>
        <input type="text" id="email" name="email" value="${clientAccount.client.email}" /><br>
        <br>
        <br>
        <input type="submit" name="signup" value="Отправить">
        <br>
        <br>
        <p><input type="button" onclick="history.back();" value="Назад"/></p>
        <p><a href="../..">Вернуться на главную страницу</a></p>

    </form>
</div>

</body>


</html>