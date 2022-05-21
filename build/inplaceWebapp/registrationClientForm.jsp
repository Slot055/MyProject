<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="windows-1251"%>
<%@ page import="javax.servlet.http.HttpSession,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse"%>
<%@ page import="ru.myOnlineShop.model.customer.ClientAccount"%>
<%@ page import="ru.myOnlineShop.model.customer.Client"%>
<html>
<head>
    <meta charset="UTF-8">
</head>

<body>
<h1>Личные данные клиента</h1>
<h2>
<%
ClientAccount clientAccount = (ClientAccount)request.getSession().getAttribute("clientAccount");
if(clientAccount !=null && clientAccount.getClient() != null){
        out.println("Редактировать текущие данные:");
        }else out.println("Ввести свои данные:");
%>

</h2>

<div>
    <form action="/account" method="post">
        <label for="name">Имя:</label><br>
        <input type="text" id="name" name="name"><br>
        <label for="lastName">Фамилия:</label><br>
        <input type="text" id="lastName" name="lastName"><br>
        <label for="gender">Пол (М/Ж):</label><br>
        <input type="text" id="gender" name="gender"><br>
        <label for="age">Возраст (лет):</label><br>
        <input type="text" id="age" name="age"><br>
        <label for="phoneNumber">Номер телефона (10 знаков без пробелов):</label><br>
        <input type="text" id="phoneNumber" name="phoneNumber"><br>
        <label for="email">Email:</label><br>
        <input type="text" id="email" name="email"><br>
        <br>
        <br>
        <input type="submit" name="signup" value="Отправить">

        <p><a href="./authentificationAccount.jsp">Назад</a></p>
        <p><a href="./">Вернуться на главную страницу</a></p>

    </form>
</div>

</body>


</html>