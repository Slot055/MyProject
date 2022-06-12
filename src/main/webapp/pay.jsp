<%--@elvariable id="clientAccount" type="ru.myOnlineShop.model.customer.ClientAccount"--%>
<%--@elvariable id="order" type="java.util.IntSummaryStatistics"--%>
<%@ page import="ru.myOnlineShop.model.customer.ClientAccount" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="windows-1251" %>
<%--
  Created by IntelliJ IDEA.
  User: offic
  Date: 09.06.2022
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<html>
<%
    ClientAccount clientAccount = (ClientAccount) request.getSession().getAttribute("clientAccount");

    if (clientAccount == null)
        response.sendRedirect("/regAccount/inputAccount");
%>
<head>
    <title>Оплата</title>
    <h1> Оплата заказа </h1>

    <h3>Сумма на счёте: <c:out value="${Math.round(clientAccount.cashAccount.cash * 100.0) / 100.0}"/></h3>
    <h3>Сумма заказа: <c:out value="${Math.round(order.sum * 100.0) / 100.0}"/></h3>
    <br>
    <br>
    <form method="post" action='<c:url value="/regAccount/inputAccount/pay"/>'
          style="display:inline;">
        <input type="submit" value="Оплатить">
    </form>
    <p><input type="button" onclick="history.back();" value="Назад"/></p>
    <p><a href=" ../..">Вернуться на главную страницу</a></p>

</head>
<body>

</body>
</html>
