<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="windows-1251"%>
<%@ page import="javax.servlet.http.HttpSession,javax.servlet.http.HttpServletRequest,javax.servlet.http.HttpServletResponse"%>
<%@ page import="ru.myOnlineShop.model.customer.ClientAccount"%>
<%@ page import="ru.myOnlineShop.model.customer.Client"%>
<html>
<head>
    <meta charset="UTF-8">
</head>

<body>
<h1>������ ������ �������</h1>
<h2>
<%
ClientAccount clientAccount = (ClientAccount)request.getSession().getAttribute("clientAccount");
if(clientAccount !=null && clientAccount.getClient() != null){
        out.println("������������� ������� ������:");
        }else out.println("������ ���� ������:");
%>

</h2>

<div>
    <form action="/account" method="post">
        <label for="name">���:</label><br>
        <input type="text" id="name" name="name"><br>
        <label for="lastName">�������:</label><br>
        <input type="text" id="lastName" name="lastName"><br>
        <label for="gender">��� (�/�):</label><br>
        <input type="text" id="gender" name="gender"><br>
        <label for="age">������� (���):</label><br>
        <input type="text" id="age" name="age"><br>
        <label for="phoneNumber">����� �������� (10 ������ ��� ��������):</label><br>
        <input type="text" id="phoneNumber" name="phoneNumber"><br>
        <label for="email">Email:</label><br>
        <input type="text" id="email" name="email"><br>
        <br>
        <br>
        <input type="submit" name="signup" value="���������">

        <p><a href="./authentificationAccount.jsp">�����</a></p>
        <p><a href="./">��������� �� ������� ��������</a></p>

    </form>
</div>

</body>


</html>