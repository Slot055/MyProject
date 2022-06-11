<%@ page import="ru.myOnlineShop.model.customer.ClientAccount" %>
<%@ page import="ru.myOnlineShop.model.constanta.StatusAccount" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: offic
  Date: 09.06.2022
  Time: 16:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%
    ClientAccount clientAccount = (ClientAccount) request.getSession().getAttribute("clientAccount");

    if (clientAccount == null)
       response.sendRedirect("/regAccount/inputAccount");

    else if (clientAccount.getStatusAccount() != StatusAccount.USER) {
        response.getWriter().print("Привязать банковскую карту может только клиент магазина");
        request.getRequestDispatcher("/notFound.jsp").include(request, response);

    } else {
%>
<head>
    <title>Финансы</title>
    <h1> Финансовый счёт </h1>
    <%--@elvariable id="clientAccount" type="ru.myOnlineShop.model.customer.ClientAccount"--%>
    <h3>Номер карты: <c:out value="${clientAccount.cashAccount.cardNumber}"/></h3>
    <h3>Сумма на счёте: <c:out value="${clientAccount.cashAccount.cash}"/> рублей.</h3>
    <br>
    <br>
    <p><input type="button" onclick="history.back();" value="Назад"/></p>
    <p><a href="/regAccount/inputAccount/cashIn">Пополнить счёт</a></p>
    <p><a href="/regAccount/inputAccount">В личный кабинет</a></p>
    <p><a href=" ../..">Вернуться на главную страницу</a></p>

</head>
<%
    }
%>
</body>
</html>
