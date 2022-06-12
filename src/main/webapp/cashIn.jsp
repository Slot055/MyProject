<%--@elvariable id="clientAccount" type="ru.myOnlineShop.model.customer.ClientAccount"--%>
<%--@elvariable id="cashAccount" type="ru.myOnlineShop.model.customer.CashAccount"--%>
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
        response.getWriter().print("��������� ���� ����� ������ ������ ��������");
        request.getRequestDispatcher("/notFound.jsp").include(request, response);
    } else {
%>

<h1>����������� ���������� �����</h1>
<div>
    <form action="<c:url value="/regAccount/inputAccount/cashIn"/>" method="post">
        <label for="cash">������� ����� ����������:</label><br>
        <input type="text" id="cash" name="cash" value="${Math.round(clientAccount.cashAccount.cash * 100.0) / 100.0}"/><br>
        <br>
        <input type="submit" name="signup" value="���������">
        <br>
        <br>
        <p><input type="button" onclick="history.back();" value="�����"/></p>
        <p><a href="/regAccount/inputAccount">� ������ �������</a></p>
        <p><a href="/">��������� �� ������� ��������</a></p>

    </form>
</div>

<%
    }
%>

</body>


</html>
