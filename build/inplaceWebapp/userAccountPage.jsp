<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="windows-1251"%>
<%@ page import="javax.servlet.http.HttpSession,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse"%>
<%@ page import="javax.servlet.http.HttpServlet,ru.myOnlineShop.model.customer.ClientAccount,javax.servlet.annotation.WebServlet"%>
<%@ page import="ru.myOnlineShop.model.customer.clientServise.clientAccountService.AccountService,ru.myOnlineShop.model.customer.Client"%>
<%@ page import="ru.myOnlineShop.model.dataBaseProject.AccountDataBaseProject,java.util.concurrent.atomic.AtomicReference,ru.myOnlineShop.model.BuilderObject"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>USER</title>
</head>
<body>
<%
ClientAccount clientAccount = (ClientAccount)request.getSession().getAttribute("clientAccount");
String command;
command = request.getParameter("command");
if(clientAccount != null){
String s = ("Текущие данные: " + clientAccount.toString());
if("S".equals(command))
out.println(s);
} else {response.getWriter().print("Ваша сессия завершена, необходима повторная авторизация");
response.getWriter().print("<html><head><p><a href=\"/logout\">Вернуться на главную страницу</a></p></body></html>");
  //response.sendRedirect("/logout");
}
%>
<%
String p;
if(clientAccount.getClient() != null){
p = clientAccount.getClient().getName();
} else p = clientAccount.getLogin();
%>
<h1>Пользователь - <%out.print(p);%></h1>

<p><a href="/regAccount/inputAccount?command=S">Личные данные</a></p>
<p><a href="/registrationClientForm.jsp">Редактирование личных данных</a></p>
<p><a href="../">Вернуться на главную страницу</a></p>
<a href="/logout">Выход из аккаунта</a>
</body>
</html>