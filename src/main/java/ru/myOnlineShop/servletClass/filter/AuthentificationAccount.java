package ru.myOnlineShop.servletClass.filter;
import ru.myOnlineShop.model.constanta.StatusAccount;
import ru.myOnlineShop.service.clientServise.clientAccountService.AccountService;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;
import static java.util.Objects.nonNull;

@WebFilter(urlPatterns = "/regAccount/inputAccount")
public class AuthentificationAccount implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain) throws IOException, ServletException {
        final HttpServletRequest req = (HttpServletRequest) request;
        final HttpServletResponse res = (HttpServletResponse) response;

        final String login = req.getParameter("login");
        final String password = req.getParameter("password");
        @SuppressWarnings("unchecked")
        final AtomicReference<AccountService> accountService = (AtomicReference<AccountService>) req.getServletContext().getAttribute("accountService");
        final HttpSession session = req.getSession();
        session.getAttribute("clientAccount");
        if (nonNull(session.getAttribute("login")) && nonNull(session.getAttribute("password"))) {
            final StatusAccount statusAccount = (StatusAccount) session.getAttribute("statusAccount");
            moveToMenu(req, res, statusAccount);

        } else if (accountService.get().clientAccountIsExist(login, password, req)) {

            final StatusAccount statusAccount = accountService.get().getRoleByLoginPassword(login, password, req);
            req.getSession().setAttribute("login", login);
            req.getSession().setAttribute("password", password);
            req.getSession().setAttribute("statusAccount", statusAccount);
            moveToMenu(req, res, statusAccount);

        } else {
            moveToMenu(req, res, StatusAccount.UNKNOWN);
        }
    }

    public void moveToMenu(final HttpServletRequest req, final HttpServletResponse res, final StatusAccount statusAccount) throws ServletException, IOException {
        if (statusAccount.equals(StatusAccount.ADMIN)) {

            req.getRequestDispatcher("/adminAccountPage.jsp").forward(req, res);
        } else if (statusAccount.equals(StatusAccount.USER)) {

            req.getRequestDispatcher("/userAccountPage.jsp").forward(req, res);
        } else req.getRequestDispatcher("/inputAccount.jsp").forward(req, res);


    }


    @Override
    public void destroy() {

    }
}
