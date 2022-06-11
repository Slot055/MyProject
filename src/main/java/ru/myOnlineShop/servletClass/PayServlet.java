package ru.myOnlineShop.servletClass;
import ru.myOnlineShop.model.buy.Order;
import ru.myOnlineShop.model.customer.ClientAccount;
import ru.myOnlineShop.service.clientServise.BuyService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;


@WebServlet(urlPatterns = "/regAccount/inputAccount/pay")
public class PayServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        getServletContext().getRequestDispatcher("/pay.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1251");
        @SuppressWarnings("unchecked")
        AtomicReference<BuyService> buyService = (AtomicReference<BuyService>) getServletContext().getAttribute("buyService");
        ClientAccount clientAccount = (ClientAccount) request.getSession().getAttribute("clientAccount");
        Order order = (Order) request.getSession().getAttribute("order");
        if (order != null && order.getSum() != 0 && order.getCheck().isPay()) {
            response.getWriter().print("Вы уже оплатили данный заказ");
            request.getRequestDispatcher("/notFound.jsp").include(request, response);
        } else if (order != null && order.getSum() != 0 && !order.getCheck().isPay()) {
            if (clientAccount.getCashAccount() != null) {
                if (clientAccount.getCashAccount().getCash() > order.getSum()) {
                    order = buyService.get().pay(clientAccount, order);
                    request.getSession().setAttribute("order", order);
                    response.sendRedirect("/orderInfo.jsp");
                } else {
                    response.getWriter().print("Не хватает средств на счёте для оплаты заказа, пожалуйста пополните счёт");
                    request.getRequestDispatcher("/notFound.jsp").include(request, response);
                }
            } else {
                response.getWriter().print("Банковская карта не зарегистрирована, пожалуйста зарегистрируйте карту");
                request.getRequestDispatcher("/notFound.jsp").include(request, response);
            }
        } else {
            response.getWriter().print("У Вас нет действующих заказов");
            request.getRequestDispatcher("/notFound.jsp").include(request, response);
        }
    }
}

