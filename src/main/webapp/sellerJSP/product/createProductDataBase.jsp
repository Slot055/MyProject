<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: offic
  Date: 23.05.2022
  Time: 17:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h1>Форма заведения товаров в Базу Данных</h1>
<h2>Заполните спецификацию для нового товара</h2>

<div>
    <h3>"*" - отмечены поля обязательные для заполнения</h3>
    <form action="<c:url value="/createProductDB"/>" method="post">
        <label for="typeProduct">Тип *:</label><br>
        <input type="text" id="typeProduct" name="typeProduct"/><br>
        <label for="categoryProduct">Категория *:</label><br>
        <input type="text" id="categoryProduct" name="categoryProduct"/><br>
        <label for="groupProduct">Группа *:</label><br>
        <input type="text" id="groupProduct" name="groupProduct"/><br>
        <label for="nameProduct">Наименование *:</label><br>
        <input type="text" id="nameProduct" name="nameProduct"/><br>
        <label for="price">Цена *:</label><br>
        <input type="text" id="price" name="price"/><br>
        <label for="description">Описание:</label><br>
        <input type="text" id="description" name="description"/><br>
        <label for="quantity">Количество в наличии *:</label><br>
        <input type="text" id="quantity" name="quantity"/><br>
        <br>
        <br>
        <input type="submit" name="signup" value="Отправить">
        <br>
        <br>
        <p><input type="button" onclick="history.back();" value="Назад"/></p>
        <p><a href="../..">Вернуться на главную страницу</a></p>

    </form>
</div>

</body>
