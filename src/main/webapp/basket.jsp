<%@ page import="ru.myOnlineShop.model.constanta.StatusAccount" %><%--@elvariable id="Math" type=""--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Корзина товаров</title>
</head>
<%
    StatusAccount statusAccount = (StatusAccount) request.getSession().getAttribute("statusAccount");
    if (statusAccount == StatusAccount.USER || statusAccount == StatusAccount.ADMIN) {
%>
<body>
<%--@elvariable id="basketProducts" type=""--%>
<c:if test="${basketProducts == null || basketProducts.size() == 0}">
    <%
        out.print("<h2>В корзине нет товаров</h2>");
    %>
</c:if>
<c:if test="${basketProducts != null && basketProducts.size() > 0}">
<h2>Корзина товаров</h2>
<table cellpadding="2" cellspacing="3" border="2">
    <tr>
        <th>Артикул</th>
        <th>Товар</th>
        <th>Наименование</th>
        <th>Цена</th>
        <th>Количество</th>
        <th>Сумма</th>
    </tr>
    <jsp:useBean id="basketProducts" scope="session" type="java.util.List"/>
    <c:forEach var="basket" items="${basketProducts}">
        <c:set var="total" value="${total + basket.product.price * basket.quantityInBasket}"></c:set>
        <tr>
            <td>${basket.product.item}</td>
            <td>${basket.product.groupProduct }</td>
            <td>${basket.product.nameProduct}</td>
            <td>${basket.product.price}</td>
            <td>${basket.quantityInBasket}</td>
            <td>${Math.round((basket.product.price * basket.quantityInBasket) * 100.0) / 100.0}</td>
            <td>
                <form method="get" action='<c:url value="/regAccount/inputAccount/basketProduct" />'
                      style="display:inline;">
                    <input type="hidden" name="item" value="${basket.product.item}">
                    <input type="submit" value="Добавить">
                </form>
            </td>
            <td>
                <form method="post" action='<c:url value="/regAccount/inputAccount/basketProduct" />'
                      style="display:inline;">
                    <input type="hidden" name="item" value="${basket.product.item}">
                    <input type="submit" value="Удалить">
                </form>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <td colspan="5" align="right">Сумма всех товаров:</td>
        <td>${Math.round(total * 100.0) / 100.0}</td>
        <td>
            <form method="get" action='<c:url value="/regAccount/inputAccount/buy" />'
                  style="display:inline;">
                <input type="submit" value="Купить">
            </form>
        </td>
    </tr>
    </c:if>
</table>
<p><input type="button" onclick="history.back();" value="Назад"/></p>
<p><a href="<c:url value="/onlineShop?command=catalog"/>">В каталог товаров</a></p>
<p><a href=" ../..">Вернуться на главную страницу</a></p>

</body>
<%
    } else {
        response.getWriter().print("Доступ к корзине имеют только зарегистрированные пользователи, пройдите процесс регистрации или войдите в аккаунт");
        request.getRequestDispatcher("/notFound.jsp").include(request, response);
    }
%>
</html>
