package ru.myOnlineShop.servletClass.adminServletClass;
import ru.myOnlineShop.model.customer.ClientAccount;
import ru.myOnlineShop.dao.AccountDAO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(urlPatterns = "/regAccount/inputAccount/accountDataBaseAll")
public class ListAccountDataBaseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        @SuppressWarnings("unchecked")
        AtomicReference<AccountDAO> accountDataBase = (AtomicReference<AccountDAO>) getServletContext().getAttribute("accountDataBase");
        ArrayList<ClientAccount> clientAccountBase = accountDataBase.get().select(request);
        request.setAttribute("clientAccountBase", clientAccountBase);

        getServletContext().getRequestDispatcher("/sellerJSP/account/accountDataBaseAll.jsp").forward(request, response);
    }
}

