<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="windows-1251" %>
<%@ page import="ru.myOnlineShop.model.customer.ClientAccount" %>
<html>
<head>
    <meta charset="UTF-8">
</head>

<body>
<h1>?????? ?????? ???????</h1>
<h2>
    <%
        ClientAccount clientAccount = (ClientAccount) request.getSession().getAttribute("clientAccount");
        if (clientAccount != null && clientAccount.getClient() != null) {
            out.println("????????????? ??????? ??????:");
        } else out.println("?????? ???? ??????:");
    %>

</h2>

<div>
    <h3>????? ?????????????? ?????? ????????</h3>
    <form action="<c:url value="/regAccount/inputAccount/account"/>" method="post">
        <input type="hidden" value="${clientAccount.idAccount}" name="idAccount"/>
        <label for="login">?????:</label><br>
        <input type="text" id="login" name="login" value="${clientAccount.login}" /><br>
        <label for="password">??????:</label><br>
        <input type="text" id="password" name="password" value="${clientAccount.password}" /><br>
        <br>
        <h3>????? ?????????????? ?????? ??????</h3>
        <label for="name">???:</label><br>
        <input type="text" id="name" name="name" value="${clientAccount.getClient().getName()}" /><br>
        <label for="lastName">???????:</label><br>
        <input type="text" id="lastName" name="lastName" value="${clientAccount.getClient().getLastName()}" /><br>
        <label for="gender">???:</label><br>
        <input type="text" id="gender" name="gender" value="${clientAccount.getClient().getGender()}" /><br>
        <label for="age">???????(???):</label><br>
        <input type="text" id="age" name="age" value="${clientAccount.getClient().getAge()}" /><br>
        <label for="phoneNumber">????? ????????:</label><br>
        <input type="text" id="phoneNumber" name="phoneNumber" value="${clientAccount.getClient().getPhoneNumber()}"
        /><br>
        <label for="email">??????????? ????:</label><br>
        <input type="text" id="email" name="email" value="${clientAccount.getClient().getEmail()}" /><br>
        <br>
        <br>
        <input type="submit" name="signup" value="?????????">
        <br>
        <br>
        <p><input type="button" onclick="history.back();" value="?????"/></p>
        <p><a href="./">????????? ?? ??????? ????????</a></p>

    </form>
</div>

</body>


</html>