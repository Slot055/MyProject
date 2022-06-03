<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page
        import="javax.servlet.http.HttpSession, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse,javax.servlet.http.HttpServlet" %>
<!DOCTYPE html>
<html>
<head>
</head>
<body>

    <form action="/onlineShop" method="get">
        <h1 style="text-align:center"><img src="${pageContext.request.contextPath }/images/Shop.jpg" width=300"></h1>
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
            <em id="timedisplay"></em>
        </h3>

        <%
            String s;
            HttpSession session1 = request.getSession();
            if ((session1.getAttribute("login")) != null && (session1.getAttribute("password")) != null) {
                s = "Аккаунт клиента";
            } else s = "Войти в аккаунт";
        %>
        <style>div {
            display: inline-block;
            width: 19.8%;
        }</style>
        <div class = block><a href="./onlineShop?command=info"> <img src="${pageContext.request.contextPath }/images/info.jpg" width=100"></a><br>Информация о магазине</div>
        <div class = block><a href="./onlineShop?command=authentification"><img src="${pageContext.request.contextPath }/images/account.png" width=80"></a><br><%out.print(s);%></div>
        <div class = block><a href="./onlineShop?command=catalog"><img src="${pageContext.request.contextPath }/images/catalog.jpg" width=100"></a><br>Каталог товаров</div>
        <div class = block><a href="./onlineShop?command=searchProduct"><img src="${pageContext.request.contextPath }/images/search.jpg" width=120"></a><br>Поиск товара</div>
        <div class = block><a href="./onlineShop?command=viewBasket"><img src="${pageContext.request.contextPath }/images/Basket.jpg" width=100"></a><br>Корзина товаров</div>

    </form>

</body>
</html>