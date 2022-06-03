<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="windows-1251" %>

<!DOCTYPE html>
<html>
<head>
    <%
        HttpSession session1 = request.getSession();
        if ((session1.getAttribute("login")) != null && (session1.getAttribute("password")) != null) {
            response.sendRedirect("/regAccount/inputAccount");
        }
    %>
</head>
<body>
<div>
    <form action="<c:url value="/regAccount"/>" method="get">
        <h2 style="text-align:center">Авторизация</h2>

        <p style="text-align:center"><a href="./regAccount?command=signIn">Вход в аккаунт</a></p>
        <p style="text-align:center"><a href="./regAccount?command=registration">Регистрация аккаунта</a></p>
        <br>
        <p><a href="./">Вернуться на главную страницу</a></p>

    </form>
</div>

</body>
</html>