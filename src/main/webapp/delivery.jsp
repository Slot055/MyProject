<%--@elvariable id="delivery" type="ru.myOnlineShop.model.buy.Delivery"--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<title>Доставка</title>
</form>
<body>

<h2>Доставка заказа</h2>
<div>
        <h2 style="text-align:center">Данные для доставки</h2>
    <form action="<c:url value="/regAccount/inputAccount/delivery"/>" method="post">
        <label for="date">Дата доставки:</label><br>
        <input type="datetime-local" id="date" name="date" value="${delivery.dateTime}"/><br>
        <label for="address">Адрес доставки:</label><br>
        <input type="text" id="address" name="address" value="${delivery.address}"/><br>
        <br>
        <form method="post" action='<c:url value="/regAccount/inputAccount/delivery"/>'
              style="display:inline;">
            <input type="submit" value="Подтвердить">
        </form>
        <br>
    <p><input type="button" onclick="history.back();" value="Назад"/></p>
    <p><a href="/regAccount/inputAccount">В личный кабинет</a></p>
    <p><a href=" ../..">Вернуться на главную страницу</a></p>

    </form>
</div>

</body>
</html>