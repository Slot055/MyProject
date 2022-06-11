<%@ page import="ru.myOnlineShop.model.buy.Order" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%
    Order order = (Order) request.getSession().getAttribute("order");
    if(order != null && order.getSum() != 0){
%>
<head>
    <meta charset="UTF-8">
    <title>Информация о заказе</title>
<body>
<h2>Дата заказа: <c:out value="${order.dateTime.toDate().toLocaleString()}"/></h2>
<h2>Ассортимент:</h2>
<table cellpadding="2" cellspacing="3" border="2">
    <tr>
        <th>Артикул</th>
        <th>Товар</th>
        <th>Наименование</th>
        <th>Цена</th>
        <th>Количество</th>
        <th>Ссылка на товар</th>

    </tr>


    <jsp:useBean id="listProducts" scope="session" type="java.util.List"/>
    <c:forEach var="basket" items="${listProducts}">
        <tr>
            <td>${basket.product.item}</td>
            <td>${basket.product.groupProduct }</td>
            <td>${basket.product.nameProduct}</td>
            <td>${basket.product.price}</td>
            <td>${basket.quantityInBasket}</td>
            <td><a href='<c:url  value="/cardProduct?item=${basket.product.item}"/>'>${basket.product.nameProduct}</a>
            </td>
        </tr>
    </c:forEach>
</table>
<h2>Сумма заказа: <c:out value="${order.sum} рублей."/></h2>
<c:if test="${order.check.pay == false}">
    <c:set var="status" value="Не оплачен"/>
</c:if>
<c:if test="${order.check.pay == true}">
    <c:set var="status" value="Оплачен"/>
</c:if>
<h2>Статус оплаты: <c:out value="${status}"/></h2>
<p><input type="button" onclick="history.back();" value="Назад"/></p>
<p><a href="/regAccount/inputAccount">В личный кабинет</a></p>
<p><a href=" ../..">Вернуться на главную страницу</a></p>
</body>
<%
    }else {
        response.getWriter().print("У Вас нет действующих заказов");
        request.getRequestDispatcher("/notFound.jsp").include(request,response);
    }
%>
</html>