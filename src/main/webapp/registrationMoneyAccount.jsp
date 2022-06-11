<%--@elvariable id="clientAccount" type="ru.myOnlineShop.model.customer.ClientAccount"--%>
<%--@elvariable id="cashAccount" type="ru.myOnlineShop.model.customer.CashAccount"--%>
<%@ page import="ru.myOnlineShop.model.customer.CashAccount" %>
<%@ page import="ru.myOnlineShop.model.customer.ClientAccount" %>
<%@ page import="ru.myOnlineShop.model.constanta.StatusAccount" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="windows-1251" %>
<html>
<head>
    <meta charset="UTF-8">
</head>

<body>

<%
    ClientAccount clientAccount = (ClientAccount) request.getSession().getAttribute("clientAccount");

    if (clientAccount == null || clientAccount.getStatusAccount() != StatusAccount.USER) {
        response.getWriter().print("��������� ���������� ����� ����� ������ ������ ��������");
        request.getRequestDispatcher("/notFound.jsp").include(request, response);
    } else if (clientAccount.getCashAccount() != null) {
        request.getRequestDispatcher("/regAccount/inputAccount/moneyAccount").forward(request,response);
    } else {
%>

<h1>����������� ���������� �����</h1>
<div>
    <form action="<c:url value="/regAccount/inputAccount/moneyAccount"/>" method="post">
        <label for="cardNumber">������� ����� ���������� �����(16-�� �������):</label><br>
        <input type="text" id="cardNumber" name="cardNumber" value="${clientAccount.cashAccount.cardNumber}"/><br>
        <br>
        <input type="submit" name="signup" value="���������">
        <br>
        <br>
        <p><input type="button" onclick="history.back();" value="�����"/></p>
        <p><a href="/">��������� �� ������� ��������</a></p>

    </form>
</div>

<%
    }
%>

</body>


</html>