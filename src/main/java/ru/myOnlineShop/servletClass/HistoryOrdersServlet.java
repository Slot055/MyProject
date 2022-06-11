package ru.myOnlineShop.servletClass;
import ru.myOnlineShop.model.buy.Order;
import ru.myOnlineShop.service.HistoryService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

@WebServlet(urlPatterns = "/regAccount/inputAccount/historyOrders")
public class HistoryOrdersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1251");
        HistoryService historyService = (HistoryService) request.getSession().getAttribute("historyService");

        if (historyService != null && historyService.getHistoryOrders() != null) {
            ArrayList<Integer> key = new ArrayList<>();
            ArrayList<Order> value = new ArrayList<>();
            for (Map.Entry<Integer, Order> entry : historyService.getHistoryOrders().getOldOrders().entrySet()) {
                Integer numberOrder = entry.getKey();
                key.add(numberOrder);
                Order order = entry.getValue();
                value.add(order);

            }
            request.getSession().setAttribute("key", key);
            request.getSession().setAttribute("value", value);
            request.getRequestDispatcher("/historyOrders.jsp").include(request, response);
        } else
            response.getWriter().print("Вы ещё не сделали ни одного заказа");
        request.getRequestDispatcher("/notFound.jsp").include(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
