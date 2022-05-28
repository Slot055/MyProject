<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="windows-1251" %>
<%@ page import="ru.myOnlineShop.model.customer.ClientAccount,ru.myOnlineShop.model.constanta.StatusAccount" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="windows-1251">
</head>
<body>
<h1>����������� ��������</h1>
<h2>������� ���� ������</h2>
<%
    ClientAccount clientAccount = (ClientAccount) request.getSession().getAttribute("clientAccount");
    if (clientAccount == null) {
%>
<h3>������ ��������</h3>
<form action="/regAccount" method="post">
    <label for="login">�����:</label><br>
    <input type="text" id="login" name="login"><br>
    <label for="password">������:</label><br>
    <input type="text" id="password" name="password"/><br>
    <br>
    <br>
    <input type="submit" name="signup" value="���������">

    <p><input type="button" onclick="history.back();" value="�����"/></p>
    <p><a href="./">��������� �� ������� ��������</a></p>

</form>
<%
} else if (clientAccount.getStatusAccount().equals(StatusAccount.ADMIN)) {
%>
<h3>������ ��������</h3>
<form action="/regAccount" method="post">
    <label for="login">�����:</label><br>
    <input type="text" id="login" name="login"/><br>
    <label for="password">������:</label><br>
    <input type="text" id="password" name="password"/><br>
    <label for="statusAccount">������ ��������:</label><br>
    <input type="text" id="statusAccount" name="statusAccount"/><br>
    <br>
    <h3> ������ ������</h3>
    <label for="name">���:</label><br>
    <input type="text" id="name" name="name"/><br>
    <label for="lastName">�������:</label><br>
    <input type="text" id="lastName" name="lastName"/><br>
    <label for="gender">���:</label><br>
    <input type="text" id="gender" name="gender"/><br>
    <label for="age">�������(���):</label><br>
    <input type="text" id="age" name="age"/><br>
    <label for="phoneNumber">����� ��������:</label><br>
    <input type="text" id="phoneNumber" name="phoneNumber"/><br>
    <label for="email">����������� ����:</label><br>
    <input type="text" id="email" name="email"/><br>
    <br>
    <br>
    <input type="submit" name="signup" value="���������">
    <br>
    <br>
    <p><input type="button" onclick="history.back();" value="�����"/></p>
    <p><a href="./">��������� �� ������� ��������</a></p>

</form>
<%
    }
%>
</body>
</html>