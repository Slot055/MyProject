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
        <h3>Форма редактирования данных Аккаунта</h3>
           <form action="/account" method="post">
           <input type="hidden" value="${clientAccount.idAccount}" name="idAccount" />
               <label for="login">Логин:</label><br>
               <input type="text" id="login" name="login" value "${clientAccount.login}" /><br>
               <label for="password">Пароль:</label><br>
               <input type="text" id="password" name="password" value "${clientAccount.password}" /><br>
               <br>
        <h3>Форма редактирования Личных данных</h3>
                       <label for="name">Имя:</label><br>
                       <input type="text" id="name" name="name" value "${clientAccount.getClient().getName()}" /><br>
                       <label for="lastName">Фамилия:</label><br>
                       <input type="text" id="lastName" name="lastName" value "${clientAccount.getClient().getLastName()}" /><br>
                       <label for="gender">Пол:</label><br>
                       <input type="text" id="gender" name="gender" value "${clientAccount.getClient().getGender()}" /><br>
                       <label for="age">Возраст(Лет):</label><br>
                       <input type="text" id="age" name="age" value "${clientAccount.getClient().getAge()}" /><br>
                       <label for="phoneNumber">Номер телефона:</label><br>
                       <input type="text" id="phoneNumber" name="phoneNumber" value "${clientAccount.getClient().getPhoneNumber()}" /><br>
                       <label for="email">Электронная пота:</label><br>
                       <input type="text" id="email" name="email" value "${clientAccount.getClient().getEmail()}" /><br>
               <br>
               <br>
               <input type="submit" name="signup" value="Отправить">
               <br>
               <br>
               <p><input type="button" onclick="history.back();" value="Назад"/></p>
               <p><a href="./">Вернуться на главную страницу</a></p>

           </form>
      </div>

</body>


</html>