<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="ru.myOnlineShop.model.customer.ClientAccount" %>
<!DOCTYPE html>
<html>
<head>
    <title>Администратор</title>
</head>
<body>
<%
    ClientAccount clientAccount = (ClientAccount) request.getSession().getAttribute("clientAccount");
    String s = "";
    String command;
    command = request.getParameter("command");
    if (clientAccount != null)
        s = (clientAccount.getLogin());

    if ("account".equals(command))
        request.getRequestDispatcher("/regAccount/inputAccount/accountDataBaseAll").forward(request, response);
    else if("product".equals(command))
        request.getRequestDispatcher("/regAccount/inputAccount/productDataBaseAll").forward(request, response);
%>

<h1>Пользователь - <%out.print(s);%></h1>
<p><a href="/regAccount/inputAccount?command=account">База данных Аккаунтов пользователей</a></p>
<p><a href="/regAccount/inputAccount?command=product">База данных Товаров</a></p>

<p><a href="../">Вернуться на главную страницу</a></p>
<a href="<c:url value="/regAccount/inputAccount/logout"/>">Выход из аккаунта</a>
</body>
</html>