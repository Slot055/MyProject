<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="windows-1251" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
</head>
<body>

<div>
    <form action="<c:url value="/catalog"/>" method="post">
        <h1 style="text-align:center">Поиск товара</h1>
        <h2>Выберите критерий поиска:</h2>

        <div>
            <form>
                <label for="typeProduct">Тип:</label><br>
                <input type="text" id="typeProduct" name="typeProduct"><br>
                <label for="categoryProduct">Категория:</label><br>
                <input type="text" id="categoryProduct" name="categoryProduct"><br>
                <label for="groupProduct">Группа:</label><br>
                <input type="text" id="groupProduct" name="groupProduct"><br>
                <label for="nameProduct">Наименование:</label><br>
                <input type="text" id="nameProduct" name="nameProduct"><br>

                <br>
                <label for="minPrice">Минимальная цена:</label><br>
                <input type="text" id="minPrice" name="minPrice" value="${0}"/><br>
                <label for="maxPrice">Максимальная цена:</label><br>
                <input type="text" id="maxPrice" name="maxPrice" value="${0}"/><br>
                <br>
                <input type="submit" name="signup" value="Применить">

            </form>
        </div>
        <br>
        <p><input type="button" onclick="history.back();" value="Назад"/></p>
        <p><a href="./">Вернуться на главную страницу</a></p>
    </form>
</div>

</body>
</html>