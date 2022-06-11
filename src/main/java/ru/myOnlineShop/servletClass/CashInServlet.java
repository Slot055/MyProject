package ru.myOnlineShop.servletClass;
import ru.myOnlineShop.model.customer.ClientAccount;
import ru.myOnlineShop.service.clientServise.CashService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/regAccount/inputAccount/cashIn")
public class CashInServlet extends HttpServlet {

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
                request.getRequestDispatcher("/cashIn.jsp").forward(request, response);
        }

    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        clientAccount = (ClientAccount) request.getSession().getAttribute("clientAccount");
        double cash = Double.parseDouble(request.getParameter("cash"));
        CashService cashService = (CashService) getServletContext().getAttribute("cashService");
        cashService.cashIn(clientAccount, cash);
        request.getSession().setAttribute("clientAccount", clientAccount);
        response.sendRedirect("/moneyAccount.jsp");

    }

}

