<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="windows-1251"%>
<%@ page import="javax.servlet.http.HttpSession, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,javax.servlet.http.HttpServlet"%>
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
    <form action="/regAccount" method="get">
        <h2 style="text-align:center">�����������</h2>

        <p style="text-align:center"><a href="./regAccount?command=signIn">���� � �������</a></p>
        <p style="text-align:center"><a href="./regAccount?command=registration">����������� ��������</a></p>
        <br>
        <p><a href="./">��������� �� ������� ��������</a></p>

    </form>
</div>

</body>
</html>