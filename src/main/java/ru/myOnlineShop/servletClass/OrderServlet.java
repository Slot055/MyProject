package ru.myOnlineShop.servletClass;

import ru.myOnlineShop.model.buy.HistoryOrders;
import ru.myOnlineShop.model.buy.Order;
import ru.myOnlineShop.model.constanta.StatusOrder;
import ru.myOnlineShop.model.customer.ClientAccount;
import ru.myOnlineShop.service.HistoryService;
import ru.myOnlineShop.service.clientServise.CashService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/regAccount/inputAccount/order")
public class OrderServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1251");
        ClientAccount clientAccount = (ClientAccount) request.getSession().getAttribute("clientAccount");
        Order order = (Order) request.getSession().getAttribute("order");
        CashService cashService = (CashService) getServletContext().getAttribute("cashService");
        HistoryService historyService = (HistoryService) getServletContext().getAttribute("historyService");
        String command;
        command = request.getParameter("command");
        if ("payNow".equals(command)) {
            if (order != null && order.getSum() != 0 && order.getCheck().isPay()) {
                response.getWriter().print("Вы уже оплатили данный заказ");
                request.getRequestDispatcher("/notFound.jsp").include(request, response);
            } else request.getRequestDispatcher("/regAccount/inputAccount/pay").forward(request, response);

        } else if ("deleteOrder".equals(command)) {
            String info = "";
            if (order != null) {
                if (order.getCheck().isPay()) {
                    cashService.cashIn(clientAccount, order.getSum());
                    info = " ,средства за оплату заказа вернулись на счёт";
                }
                order.setStatusOrder(StatusOrder.CANCELLED);
                historyService.setHistoryOrders(historyService.addToHistoryOrders(clientAccount, order));
                request.getSession().setAttribute("historyService", historyService);

                order.getListProducts().clear();
                request.getSession().removeAttribute("order");
                response.getWriter().print("Вы отменили заказ" + info);
                response.getWriter().print("<html><head><p><a href=\"/regAccount/inputAccount\">В личный кабинет</a></p></body></html>");
                response.getWriter().print("<html><head><p><a href=\"/\">Вернуться на главную страницу</a></p></body></html>");
            } else {
                response.getWriter().print("У Вас нет действующих заказов");
                request.getRequestDispatcher("/notFound.jsp").include(request, response);
            }
        } else if ("orderInfo".equals(command)) {
            request.getRequestDispatcher("/orderInfo.jsp").forward(request, response);

        } else if ("delivery".equals(command)) {

            request.getRequestDispatcher("/regAccount/inputAccount/delivery").forward(request, response);


        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


    }
}
