<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page
        import="javax.servlet.http.HttpSession, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,javax.servlet.http.HttpServlet" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

<div>
    <form action="/onlineShop" method="get">
        <h1 style="text-align:center">OnlineShop</h1>
        <h2 style="text-align:center">Интернет - магазин</h2>
        <script type="text/javascript">
            function getDate() {
                var date = new Date();
                var hours = date.getHours();
                var minutes = date.getMinutes();
                var seconds = date.getSeconds();
                if (hours < 10) {
                    hours = '0' + hours;
                }
                if (minutes < 10) {
                    minutes = '0' + minutes;
                }
                if (seconds < 10) {
                    seconds = '0' + seconds;
                }

                document.getElementById('timedisplay').innerHTML = hours + ':' + minutes + ':' + seconds;
            }

            setInterval(getDate, 0);


        </script>
        <h3 style="text-align:center">Время:
            <div id="timedisplay"></div>
        </h3>
        <%
            String s;
            HttpSession session1 = request.getSession();
            if ((session1.getAttribute("login")) != null && (session1.getAttribute("password")) != null) {
                s = "Аккаунт клиента";
            } else s = "Войти в аккаунт";
        %>
        <p style="text-align:center"><a href="./onlineShop?command=info">Информация о магазине</a></p>
        <p style="text-align:center"><a href="./onlineShop?command=authentification"><%out.print(s);%></a></p>
        <p style="text-align:center"><a href="./onlineShop?command=catalog">Каталог товаров</a></p>
        <p style="text-align:center"><a href="./onlineShop?command=searchProduct">Поиск товара</a></p>
        <p style="text-align:center"><a href="./onlineShop?command=basket">Корзина товаров</a></p>

    </form>
</div>

</body>
</html>