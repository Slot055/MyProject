<%--@elvariable id="order" type="java.util.IntSummaryStatistics"--%>
<%--@elvariable id="clientAccount" type="ru.myOnlineShop.model.customer.ClientAccount"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="windows-1251" %>
<%@ page import="ru.myOnlineShop.model.customer.ClientAccount" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Клиент</title>
</head>
<body>
<%
    ClientAccount clientAccount = (ClientAccount) request.getSession().getAttribute("clientAccount");
    if (clientAccount == null) {
        request.getRequestDispatcher("/regAccount/inputAccount").forward(request, response);
    }
    String s = "";
    String command;
    command = request.getParameter("command");
    if (clientAccount.getClient().getName() == null && clientAccount.getClient().getLastName() == null && clientAccount.getClient().getGender() == null &&
            clientAccount.getClient().getAge() == null && clientAccount.getClient().getPhoneNumber() == null && clientAccount.getClient().getEmail() == null) {
        s = ("Личные данные не найдены");
    } else {
        s = ("Текущие данные: " + clientAccount.getClient().toString());
    }
    if ("S".equals(command))
        out.println(s);
    String p = "";
    if (clientAccount.getClient().getName() == null) {
        p = clientAccount.getLogin();
    } else p = clientAccount.getClient().getName();
%>
<h1>Пользователь - <%out.print(p);%></h1>

<p><a href="/regAccount/inputAccount?command=S">Личные данные</a></p>
<p><a href="<c:url value="/editClientForm.jsp"/>">Редактирование личных данных</a></p>
<p><a href="<c:url value="/order.jsp"/>">Заказы</a>
    <c:if test="${order==null}"><c:out value="* Текущих заказов нет *"/></c:if>
    <c:if test="${order !=null}"><c:out value="* на сумму: ${order.sum} рублей.*"/></c:if></p>
<p><a href="<c:url value="/regAccount/inputAccount/historyOrders"/>">История заказов</a></p>
<p><a href="<c:url value="/regAccount/inputAccount/moneyAccount"/>">Финансы</a>
    <c:if test="${clientAccount.cashAccount != null}"><c:out
            value="* ${clientAccount.cashAccount.cash} рублей. *"/></c:if></p>
<p><a href="../">Вернуться на главную страницу</a></p>
<p><a href="<c:url value="/regAccount/inputAccount/logout"/>">Выход из аккаунта</a></p>
</body>
</html>