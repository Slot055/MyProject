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
        <h1 style="text-align:center">����� ������</h1>
        <h2>�������� �������� ������:</h2>

        <div>
            <form>
                <label for="typeProduct">���:</label><br>
                <input type="text" id="typeProduct" name="typeProduct"><br>
                <label for="categoryProduct">���������:</label><br>
                <input type="text" id="categoryProduct" name="categoryProduct"><br>
                <label for="groupProduct">������:</label><br>
                <input type="text" id="groupProduct" name="groupProduct"><br>
                <label for="nameProduct">������������:</label><br>
                <input type="text" id="nameProduct" name="nameProduct"><br>

                <br>
                <label for="minPrice">����������� ����:</label><br>
                <input type="text" id="minPrice" name="minPrice" value="${0}"/><br>
                <label for="maxPrice">������������ ����:</label><br>
                <input type="text" id="maxPrice" name="maxPrice" value="${0}"/><br>
                <br>
                <input type="submit" name="signup" value="���������">

            </form>
        </div>
        <br>
        <p><input type="button" onclick="history.back();" value="�����"/></p>
        <p><a href="./">��������� �� ������� ��������</a></p>
    </form>
</div>

</body>
</html>