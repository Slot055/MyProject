<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: offic
  Date: 23.05.2022
  Time: 16:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <form action="<c:url value="/regAccount/inputAccount/productDataBaseAll"/>" method="get">
        <title>Список Товаров</title>
    </form>
<body>
<h2>Список Товаров</h2>
<p><a href="<c:url value="/sellerJSP/product/createProductDataBase.jsp"/>">Добавить новый товар</a></p>
<table cellpadding="2" cellspacing="3" border="2">
    <tr>
        <th>Артикул</th>
        <th>Тип</th>
        <th>Категория</th>
        <th>Группа</th>
        <th>Наименование</th>
        <th>Цена</th>
        <th>Описание</th>
        <th></th>
    </tr>
    <jsp:useBean id="productBase" scope="request" type="java.util.List"/>
    <c:forEach var="product" items="${productBase}">
        <tr>
            <td>${product.item}</td>
            <td>${product.typeProduct}</td>
            <td>${product.categoryProduct}</td>
            <td>${product.groupProduct}</td>
            <td>${product.nameProduct}</td>
            <td>${product.price}</td>
            <td>${product.description}</td>
            <td>
            <td>
                <a href='<c:url value="/regAccount/inputAccount/editProductDB?item=${product.item}" />'>Редактировать</a> |
                <form method="post" action='<c:url value="/regAccount/inputAccount/deleteProductDB" />' style="display:inline;">
                    <input type="hidden" name="item" value="${product.item}">
                    <input type="submit" value="Удалить">
                </form>
            </td>
        </tr>
    </c:forEach>
    <div>
        <p><a href="/regAccount/inputAccount">Вернуться на страницу аккаунта</a></p>
        <p><a href="../..">Вернуться на главную страницу</a></p>
    </div>
</table>
</body>
</html>
