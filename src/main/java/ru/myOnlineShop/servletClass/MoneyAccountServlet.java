package ru.myOnlineShop.servletClass;

import ru.myOnlineShop.model.customer.CashAccount;
import ru.myOnlineShop.model.customer.ClientAccount;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/regAccount/inputAccount/moneyAccount")
public class MoneyAccountServlet extends HttpServlet {
    private ClientAccount clientAccount;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        clientAccount = (ClientAccount) request.getSession().getAttribute("clientAccount");
        if (clientAccount == null)
            response.sendRedirect("/regAccount/inputAccount");
        else {
            if (clientAccount.getCashAccount() == null) {
                request.getRequestDispatcher("/registrationMoneyAccount.jsp").forward(request, response);
            } else
                request.getRequestDispatcher("/moneyAccount.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1251");
        long cardNumber = Long.parseLong(request.getParameter("cardNumber"));
        clientAccount = (ClientAccount) request.getSession().getAttribute("clientAccount");
        if (clientAccount == null)
            request.getRequestDispatcher("/regAccount/inputAccount").forward(request, response);
        else {

            if (request.getParameter("cardNumber").length() < 16 || request.getParameter("cardNumber").length() > 16) {
                response.getWriter().print("Вы ввели некорректный номер карты, попробуйте снова");
                request.getRequestDispatcher("/notFound.jsp").include(request, response);
            } else
                clientAccount.setCashAccount(new CashAccount(cardNumber, 0.00));
            request.getSession().setAttribute("clientAccount", clientAccount);
            request.getRequestDispatcher("/moneyAccount.jsp").forward(request, response);
        }
    }
}
