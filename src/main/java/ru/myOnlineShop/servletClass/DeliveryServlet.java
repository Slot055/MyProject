package ru.myOnlineShop.servletClass;
import ru.myOnlineShop.model.buy.Delivery;
import ru.myOnlineShop.model.buy.Order;
import ru.myOnlineShop.model.constanta.StatusOrder;
import ru.myOnlineShop.model.customer.ClientAccount;
import ru.myOnlineShop.service.DeliveryService;
import ru.myOnlineShop.service.HistoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(urlPatterns = "/regAccount/inputAccount/delivery")
public class DeliveryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Order order = (Order) request.getSession().getAttribute("order");
        if (order.getCheck().isPay()) {
            request.getRequestDispatcher("/delivery.jsp").forward(request, response);
        } else {
            response.getWriter().print("На доставку принимаются только оплаченные заказы");
            request.getRequestDispatcher("/notFound.jsp").include(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1251");
        @SuppressWarnings("unchecked")
        AtomicReference<DeliveryService> deliveryService = (AtomicReference<DeliveryService>) getServletContext().getAttribute("deliveryService");
        ClientAccount clientAccount = (ClientAccount) getServletContext().getAttribute("clientAccount");
        HistoryService historyService = (HistoryService) getServletContext().getAttribute("historyService");
        Order order = (Order) request.getSession().getAttribute("order");
        String dateTime = request.getParameter("date");
        String address = request.getParameter("address");
        Delivery delivery = deliveryService.get().getDelivery(dateTime, address, order);
        request.getSession().setAttribute("delivery", delivery);
        order.setStatusOrder(StatusOrder.PURCHASED);
        historyService.setHistoryOrders(historyService.addToHistoryOrders(clientAccount, order));
        request.getSession().setAttribute("historyService", historyService);
        order.getListProducts().clear();
        request.getSession().removeAttribute("order");
        response.getWriter().print("Заказ отправлен на доставку");
        request.getRequestDispatcher("/notFound.jsp").include(request, response);

    }
}
