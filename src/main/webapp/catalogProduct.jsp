<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <form action="<c:url value="/catalog"/>" & <c:url value="/cardProduct"/> method="get">
        <title>Каталог Товаров</title>
    </form>
<body>

<h2>Каталог Товаров</h2>
<p><a href="<c:url value="/searchProduct.jsp"/>">Поиск товара</a></p>
<table>
    <jsp:useBean id="productBase" scope="request" type="java.util.List"/>
    <jsp:useBean id="productBaseSet" scope="request" type="java.util.Set"/>
    <c:forEach var="product" items="${productBase}">
        <tr>
            <c:if test="${pageContext.request.getParameter('command') == 'catalog'}">
                <c:set var="info" value="Тип товара"/>
                <c:set var="typeProduct" value="${productBaseSet.add(product.typeProduct)}"/>
                <c:if test="${typeProduct}">
                    <td>
                        <a href='<c:url  value="/catalog?typeProduct=${product.typeProduct}"/>'>${product.typeProduct}</a>
                    </td>
                </c:if>
            </c:if>
            <c:if test="${pageContext.request.getParameter('typeProduct').equals(product.typeProduct)}">
                <c:set var="info" value="Категория товара"/>
                <c:set var="categoryProduct" value="${productBaseSet.add(product.categoryProduct)}"/>
                <c:if test="${categoryProduct}">
                    <td>
                        <a href='<c:url  value="/catalog?categoryProduct=${product.categoryProduct}"/>'>${product.categoryProduct}</a>
                    </td>
                </c:if>
            </c:if>
            <c:if test="${pageContext.request.getParameter('categoryProduct').equals(product.categoryProduct)}">
                <c:set var="info" value="Группа товара"/>
                <c:set var="groupProduct" value="${productBaseSet.add(product.groupProduct)}"/>
                <c:if test="${groupProduct}">
                    <td>
                        <a href='<c:url  value="/catalog?groupProduct=${product.groupProduct}"/>'>${product.groupProduct}</a>
                    </td>
                </c:if>
            </c:if>
            <c:if test="${pageContext.request.getParameter('groupProduct').equals(product.groupProduct)}">
                <c:set var="info" value="Наименование товара"/>
                <td><a href='<c:url  value="/catalog?nameProduct=${product.nameProduct}"/>'>${product.nameProduct}</a>
                </td>
            </c:if>
            <c:if test="${pageContext.request.getParameter('nameProduct').equals(product.nameProduct)}">
                <c:set var="info" value="Карточка товара"/>
                <td>
                <td>
                    <a href='<c:url  value="/cardProduct?item=${product.item}"/>'>Наименование: ${product.nameProduct} Цена: ${product.price}</a>
                </td>
            </c:if>
            <td>
            <td>
            </td>
        </tr>
    </c:forEach>
    <c:out value="${info}"/>
</table>

<div>
    <p><input type="button" onclick="history.back();" value="Назад"/></p>
    <p><a href=" ../..">Вернуться на главную страницу</a></p>
</div>
</body>
</html>