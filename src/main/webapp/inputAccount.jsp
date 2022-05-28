<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="windows-1251" %>
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
    <form action="/regAccount/inputAccount" method="post">
        <h2 style="text-align:center">Вход в аккаунт</h2>

        <label for="login">Логин:</label><br>
        <input type="text" id="login" name="login"><br>
        <label for="password">Пароль:</label><br>
        <input type="text" id="password" name="password"><br>
        <br>
        <input type="submit" name="signup" value="Применить">
        <br>
        <p><a href="../authentificationAccount.jsp">Назад</a></p>
        <p><a href="../">Вернуться на главную страницу</a></p>

    </form>
</div>

</body>
</html>