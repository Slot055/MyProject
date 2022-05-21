package ru.myOnlineShop.servletClass;

import ru.myOnlineShop.model.constanta.StatusAccount;
import ru.myOnlineShop.model.customer.Client;
import ru.myOnlineShop.model.customer.ClientAccount;
import ru.myOnlineShop.model.customer.clientServise.clientAccountService.AccountService;
import ru.myOnlineShop.model.dao.AccountDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(urlPatterns = "/account")
public class EditUserAccountServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            response.setContentType("text/html");
            response.setCharacterEncoding("windows-1251");
            @SuppressWarnings("unchecked")
            AtomicReference<AccountDAO> accountDataBase = (AtomicReference<AccountDAO>) getServletContext().getAttribute("accountDataBase");
            int idAccount = Integer.parseInt(request.getParameter("idAccount"));
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            StatusAccount statusAccount = StatusAccount.USER;
            Client client = new Client(request.getParameter("name"), request.getParameter("lastName"), request.getParameter("gender"),
                    request.getParameter("age"), request.getParameter("phoneNumber"), request.getParameter("email"));

            ClientAccount clientAccount = new ClientAccount(idAccount, login, password, statusAccount, client);
            accountDataBase.get().update(clientAccount);
            response.getWriter().print("<html><head><p>Личные данные сохранены</a></p></body ></html >");
            response.getWriter().print("<html><head><p><a href=\"./regAccount/inputAccount\">В личный кабинет</a></p></body></html>");
            response.getWriter().print("<html><head><p><a href=\"./\">Вернуться на главную страницу</a></p></body></html>");
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
        }

    }
}
