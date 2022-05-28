package ru.myOnlineShop.servletClass.adminServletClass;
import ru.myOnlineShop.model.BuilderObject;
import ru.myOnlineShop.model.constanta.StatusAccount;
import ru.myOnlineShop.model.customer.Client;
import ru.myOnlineShop.model.customer.ClientAccount;
import ru.myOnlineShop.dao.AccountDAO;
import ru.myOnlineShop.service.clientServise.clientAccountService.AccountService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

@WebServlet(urlPatterns = "/editAccountDB")
public class EditAccountDataBaseServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            @SuppressWarnings("unchecked")
            AtomicReference<AccountDAO> accountDataBase = (AtomicReference<AccountDAO>) getServletContext().getAttribute("accountDataBase");
            int idAccount = Integer.parseInt(request.getParameter("idAccount"));
            ClientAccount clientAccount = accountDataBase.get().selectOne(idAccount);
            if (clientAccount != null) {
                request.setAttribute("clientAccount", clientAccount);
                getServletContext().getRequestDispatcher("/editClientAccountAll.jsp").forward(request, response);
            } else {
                getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
            }
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1251");
        try {
            @SuppressWarnings("unchecked")
            AtomicReference<AccountDAO> accountDataBase = (AtomicReference<AccountDAO>) getServletContext().getAttribute("accountDataBase");
            @SuppressWarnings("unchecked")
            AtomicReference<AccountService> accountService = (AtomicReference<AccountService>) request.getServletContext().getAttribute("accountService");
            int idAccount = Integer.parseInt(request.getParameter("idAccount"));
            String login = request.getParameter("login");
            String password = request.getParameter("password");
            StatusAccount statusAccount = StatusAccount.valueOf(request.getParameter("statusAccount"));
            Client client = BuilderObject.buildClient(request, response);

            if (accountService.get().repeatCheckAccount(request, response, login)) {
                response.getWriter().print("<html><head><p>Логин " + "*" + login + "* уже зарегистрирован в системе, выберите другой логин</a></p></body ></html > ");
                response.getWriter().print("<p><input type=\"button\" onclick=\"history.back();\" value=\"Назад\"/></p>");
                response.getWriter().print("<html><head><p><a href=\"/accountDataBaseAll\">К списку аккаунтов пользователей</a></p></body></html>");

            } else {
                ClientAccount clientAccount = new ClientAccount(idAccount, login, password, statusAccount, client);
                accountDataBase.get().update(clientAccount);
                response.sendRedirect(request.getContextPath() + "/accountDataBaseAll");
            }
        } catch (Exception ex) {
            getServletContext().getRequestDispatcher("/notFound.jsp").forward(request, response);
        }
    }
}

