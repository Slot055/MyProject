<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="windows-1251"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<form action="/accountDataBaseAll" method="get">
<title>ClientAccount</title>
</head>
<body>
<h2>Список Аккаунтов</h2>
<p><a href='<c:url value="/registrationAccountForm.jsp" />'>Добавить новый аккаунт</a></p>
<table>
<tr><th>IdAccount</th><th>Login</th><th>Password</th><th>StatusAccount</th><th>Имя</th><th>Фамилия</th>
<th>Пол</th><th>Возраст</th><th>Номер телефона</th><th>Электронная почта</th><th></th></tr>
<c:forEach var="clientAccount" items="${clientAccountBase}">
 <tr><td>${clientAccount.idAccount}</td>
    <td>${clientAccount.login}</td>
    <td>${clientAccount.password}</td>
    <td>${clientAccount.statusAccount}</td>
    <td>${clientAccount.client.getName()}</td>
     <td>${clientAccount.client.getLastName()}</td>
      <td>${clientAccount.client.getGender()}</td>
       <td>${clientAccount.client.getAge()}</td>
        <td>${clientAccount.client.getPhoneNumber()}</td>
         <td>${clientAccount.client.getEmail()}</td>
    <td>
    <td>
    <a href='<c:url value="/editAccountDB?idAccount=${clientAccount.idAccount}" />'>Редактировать</a> |
    <form method="post" action='<c:url value="/deleteAccountDB" />' style="display:inline;">
        <input type="hidden" name="idAccount" value="${clientAccount.idAccount}">
        <input type="submit" value="Удалить">
    </form>
 </td></tr>
</c:forEach>
<div>
<p><input type="button" onclick="history.back();" value="Назад"/></p>
<p><a href="/regAccount/inputAccount">Вернуться на страницу аккаунта</a></p>
<p><a href="../">Вернуться на главную страницу</a></p>
</div>
</table>
</body>
</html>
