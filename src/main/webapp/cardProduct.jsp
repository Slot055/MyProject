<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <form action="<c:url value="/catalog"/>" method="get">
        <title>Карта товара</title>
    </form>
<body>
<h2>Карта товара</h2>
<table cellpadding="2" cellspacing="3" border="2">
    <tr>
        <th>Артикул</th>
        <th>Товар</th>
        <th>Наименование</th>
        <th>Цена</th>
        <th>Описание</th>
        <th>Остаток на складе</th>
    </tr>
    <jsp:useBean id="product" scope="request" type="ru.myOnlineShop.model.product.Product"/>
        <tr>
            <td>${product.item}</td>
            <td>${product.groupProduct }</td>
            <td>${product.nameProduct}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>${product.quantity}</td>
        </tr>
</table>
<p><input type="button" onclick="history.back();" value="Назад"/></p>
<p><a href=" ../..">Вернуться на главную страницу</a></p>
</body>
</html>