package ru.myOnlineShop.servletClass;

import ru.myOnlineShop.model.customer.ClientAccount;
import ru.myOnlineShop.model.customer.clientServise.clientAccountService.AccountService;
import ru.myOnlineShop.model.dataBaseProject.AccountDataBaseProject;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;


@WebServlet(urlPatterns = "/regAccount")
public class RegistrationAccountServlet extends HttpServlet {

    String command;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        command = request.getParameter("command");
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1251");

        if ("signIn".equals(command)) {
            response.sendRedirect("/regAccount/inputAccount");

        }

        if ("registration".equals(command)) {

            request.getRequestDispatcher("/registrationAccountForm.html").forward(request, response);

        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        @SuppressWarnings("unchecked")
        AtomicReference<AccountDataBaseProject> accountDataBase = (AtomicReference<AccountDataBaseProject>) getServletContext().getAttribute("accountDataBase");
        response.setContentType("text/html");
        response.setCharacterEncoding("windows-1251");
        AccountService accountService = new AccountService();
        ClientAccount clientAccount = accountService.registrationAccount(request, response);
        accountDataBase.get().add(clientAccount);
        response.getWriter().print(clientAccount);
        response.getWriter().print(accountDataBase.get().getClientAccountBase());

        response.getWriter().print("<html><head><p>Регистрация прошла успешно</a></p></body ></html > ");
        response.getWriter().print("<html><head><p><a href=./inputAccount.jsp>Войти в аккаунт</a></p></body></html>");
        response.getWriter().print("<html><head><p><a href=\"./\">Вернуться на главную страницу</a></p></body></html>");
    }


}
