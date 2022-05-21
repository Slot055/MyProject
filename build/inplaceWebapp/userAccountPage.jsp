<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="windows-1251"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="javax.servlet.http.HttpServlet,ru.myOnlineShop.model.customer.ClientAccount"%>
<%@ page import="ru.myOnlineShop.model.customer.Client"%>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>USER</title>
</head>
<body>
<%
ClientAccount clientAccount = (ClientAccount)request.getSession().getAttribute("clientAccount");
String s = "";
String command;
command = request.getParameter("command");
if(clientAccount.getClient().getName() == null && clientAccount.getClient().getLastName() == null && clientAccount.getClient().getGender() == null &&
clientAccount.getClient().getAge() == null && clientAccount.getClient().getPhoneNumber() == null && clientAccount.getClient().getEmail() == null){
s = ("Личные данные не найдены");
} else {
s = ("Текущие данные: " + clientAccount.getClient().toString());
}
if("S".equals(command))
out.println(s);
String p = "";
if(clientAccount.getClient().getName() == null || clientAccount.getClient().getName().isBlank()){
p = clientAccount.getLogin();
} else p = clientAccount.getClient().getName();
%>
<h1>Пользователь - <%out.print(p);%></h1>

<p><a href="/regAccount/inputAccount?command=S">Личные данные</a></p>
<p><a href="/editClientForm.jsp">Редактирование личных данных</a></p>
<p><a href="../">Вернуться на главную страницу</a></p>
<a href="/logout">Выход из аккаунта</a>
</body>
</html>