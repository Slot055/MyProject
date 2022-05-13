<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<form action="/" method="get">
<title>ClientAccount</title>
</head>
<body>
<h2>ClientAccount List</h2>
<p><a href='<c:url value="/create" />'>Create new</a></p>
<table>
<tr><th>Login</th><th>Password</th><th>IdAccount</th><th>StatusAccount</th><th>Client</th><th></th></tr>
<c:forEach var="clientAccountBD" items="${clientAccountBaseBD}">
 <tr><td>${clientAccountBD.login}</td>
    <td>${clientAccountBD.password}</td>
    <td>${clientAccountBD.idAccount}</td>
    <td>${clientAccountBD.statusAccount}</td>
    <td>${clientAccountBD.client}</td>
    <td>
    <a href='<c:url value="/edit?id=${clientAccountBD.idAccount}" />'>Edit</a> |
    <form method="post" action='<c:url value="/delete" />' style="display:inline;">
        <input type="hidden" name="idAccount" value="${clientAccountBD.idAccount}">
        <input type="submit" value="Delete">
    </form>
 </td></tr>
</c:forEach>
</table>
</body>
</html>
