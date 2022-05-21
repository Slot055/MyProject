<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>
<%@ page import="javax.servlet.http.HttpServletResponse"%>
<%@ page import="javax.servlet.http.HttpServlet,ru.myOnlineShop.model.customer.ClientAccount"%>
<%@ page import="ru.myOnlineShop.model.customer.Client"%>
<!DOCTYPE html>
<html>
<head>
          <title>ADMIN</title>
</head>
<body>
<%
ClientAccount clientAccount = (ClientAccount)request.getSession().getAttribute("clientAccount");
String s = "";
String command;
command = request.getParameter("command");
if(clientAccount != null)
s = (clientAccount.getLogin());

if("S".equals(command))
request.getRequestDispatcher("/accountDataBaseAll").forward(request,response);
%>

<h1>Пользователь - <%out.print(s);%></h1>
<p><a href="/regAccount/inputAccount?command=S">База данных Аккаунтов пользователей</a></p>

<p><a href="../">Вернуться на главную страницу</a></p>
<a href="/logout">Выход из аккаунта</a>
</body>
</html>