<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="windows-1251"%>
<html>
<head>

</head>
<body>

<div>
    <form action="/regAccount/inputAccount" method="post">
        <h2 style="text-align:center">���� � �������</h2>

        <label for="login">�����:</label><br>
        <input type="text" id="login" name="login"><br>
        <label for="password">������:</label><br>
        <input type="text" id="password" name="password"><br>
        <br>
        <input type="submit" name="signup" value="���������">
        <br>
        <p><a href="../authentificationAccount.jsp">�����</a></p>
        <p><a href="../">��������� �� ������� ��������</a></p>

    </form>
</div>

</body>
</html>