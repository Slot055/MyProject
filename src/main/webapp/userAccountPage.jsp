<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="windows-1251" %>
<%@ page import="ru.myOnlineShop.model.customer.ClientAccount" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>USER</title>
</head>
<body>
<%
    ClientAccount clientAccount = (ClientAccount) request.getSession().getAttribute("clientAccount");
    String s = "";
    String command;
    command = request.getParameter("command");
    if (clientAccount.getClient().getName().isBlank() && clientAccount.getClient().getLastName().isBlank() && clientAccount.getClient().getGender().isBlank() &&
            clientAccount.getClient().getAge().isBlank() && clientAccount.getClient().getPhoneNumber().isBlank() && clientAccount.getClient().getEmail().isBlank()) {
        s = ("������ ������ �� �������");
    } else {
        s = ("������� ������: " + clientAccount.getClient().toString());
    }
    if ("S".equals(command))
        out.println(s);
    String p = "";
    if (clientAccount.getClient().getName().isBlank()) {
        p = clientAccount.getLogin();
    } else p = clientAccount.getClient().getName();
%>
<h1>������������ - <%out.print(p);%></h1>

<p><a href="/regAccount/inputAccount?command=S">������ ������</a></p>
<p><a href="/editClientForm.jsp">�������������� ������ ������</a></p>
<p><a href="../">��������� �� ������� ��������</a></p>
<a href="/logout">����� �� ��������</a>
</body>
</html>