<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <form action="<c:url value="/regAccount/inputAccount/historyOrders"/>" method="get">
        <title>Список Товаров</title>
    </form>
<body>
<h2>Список Товаров</h2>
<table cellpadding="2" cellspacing="3" border="2">
    <tr>
        <th>Номер заказа</th>
        <th>Дата заказа</th>
        <th>Сумма заказа</th>
        <th>Статус заказа</th>
        <th></th>
    </tr>


    <jsp:useBean id="value" scope="session" type="java.util.List"/>
    <c:forEach var="order" items="${value}">
        <tr>
            <td>${order.numberOrder}</td>
            <td>${order.dateTime}</td>
            <td>${order.sum}</td>
            <td>${order.statusOrder.name}</td>
            <td>
        </tr>
    </c:forEach>
    <div>
        <p><a href="/regAccount/inputAccount">Вернуться на страницу аккаунта</a></p>
        <p><a href="../..">Вернуться на главную страницу</a></p>
    </div>
</table>
</body>
</html>
