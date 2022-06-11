<%@ page import="ru.myOnlineShop.model.buy.Order" %><%--
  Created by IntelliJ IDEA.
  User: offic
  Date: 08.06.2022
  Time: 1:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<%
    Order order = (Order) request.getSession().getAttribute("order");
    if (order == null || order.getSum() == 0) {
        response.getWriter().print("У Вас нет действующих заказов");
        request.getRequestDispatcher("/notFound.jsp").include(request, response);
    } else {
%>
<form action="/regAccount/inputAccount/order" method="get">
    <h1 style="text-align:center">Заказ</h1>

    <style>div {
        display: inline-block;
        width: 19.8%;
    }</style>
    <div class=block><a href="./regAccount/inputAccount/order?command=payNow">Оплатить заказ</a></div>
    <div class=block><a href="./regAccount/inputAccount/order?command=deleteOrder"><br>Отменить заказ</a></div>
    <div class=block><a href="./regAccount/inputAccount/order?command=orderInfo"><br>Информация о заказе</a></div>
    <div class=block><a href="./regAccount/inputAccount/order?command=delivery"><br>Отправить на доставку</a></div>
    <div class=block><a href="/regAccount/inputAccount">В личный кабинет</a></div>
    <br>
    <br>
    <br>
    <div class=block><a href=" ../..">Вернуться на главную страницу</a></div>
</form>
<%
    }
%>
</body>
</html>