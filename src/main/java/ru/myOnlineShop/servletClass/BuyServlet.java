package ru.myOnlineShop.servletClass;

import ru.myOnlineShop.model.buy.Basket;
import ru.myOnlineShop.model.buy.Order;
import ru.myOnlineShop.service.clientServise.BuyService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;


@WebServlet(urlPatterns = "/regAccount/inputAccount/buy")
public class BuyServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1251");
        Order order = (Order) request.getSession().getAttribute("order");
        @SuppressWarnings("unchecked")
        AtomicReference<BuyService> buyService = (AtomicReference<BuyService>) getServletContext().getAttribute("buyService");
        @SuppressWarnings("unchecked")
        List<Basket> basketProducts = (List<Basket>) request.getSession().getAttribute("basketProducts");
        if (order == null) {
            if (basketProducts != null && basketProducts.size() > 0) {
                order = buyService.get().orderActions(basketProducts, false);
                request.getSession().setAttribute("order", order);
                basketProducts.clear();
                List<Basket> listProducts = order.getListProducts();
                request.getSession().setAttribute("listProducts", listProducts);
                response.sendRedirect("/order.jsp");
            } else {
                response.getWriter().print("Возникла непредвиденная ошибка, товары в корзине не найдены, сформируйте корзину заново");
                response.getWriter().print("<html><head><p><a href=\"/\">Вернуться на главную страницу</a></p></body></html>");
            }

        } else {
            response.getWriter().print("У Вас имеется незавершённый заказ, пожалуйста завершите оформление заказа");
            request.getRequestDispatcher("/notFound.jsp").include(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
