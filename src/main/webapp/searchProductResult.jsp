<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <form action="<c:url value="/catalog"/>" method="get">
        <title>Результат поиска</title>
    </form>
<body>

<h2>Список товаров по результатам поиска</h2>
<table>
    <jsp:useBean id="productLot" scope="request" type="java.util.List"/>
    <c:forEach var="product" items="${productLot}">
        <tr>

            <td>
                <a href='<c:url  value="/cardProduct?item=${product.item}"/>'>Продукт: ${product.groupProduct} Наименование: ${product.nameProduct} Цена: ${product.price}</a>
            </td>

            <td>
            <td>
            </td>
        </tr>
    </c:forEach>
</table>

<div>
    <p><input type="button" onclick="history.back();" value="Назад"/></p>
    <p><a href=" ../..">Вернуться на главную страницу</a></p>
</div>
</body>
</html>