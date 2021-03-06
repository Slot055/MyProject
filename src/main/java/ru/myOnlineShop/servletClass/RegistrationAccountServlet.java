package ru.myOnlineShop.servletClass;

import ru.myOnlineShop.model.BuilderObject;
import ru.myOnlineShop.model.customer.ClientAccount;
import ru.myOnlineShop.dao.AccountDAO;

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

            request.getRequestDispatcher("/registrationAccountForm.jsp").forward(request, response);

        }


    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        try {
            response.setContentType("text/html");
            response.setCharacterEncoding("windows-1251");
            @SuppressWarnings("unchecked")
            AtomicReference<AccountDAO> accountDataBase = (AtomicReference<AccountDAO>) getServletContext().getAttribute("accountDataBase");
            ClientAccount clientAccount = BuilderObject.buildClientAccount(request, response);
            if (clientAccount != null) {
                accountDataBase.get().insert(clientAccount,request);
                response.getWriter().print(clientAccount);
                response.getWriter().print("<html><head><p>??????????? ?????? ???????</a></p></body ></html > ");
                if (request.getSession().getAttribute("clientAccount") != null) {
                    response.getWriter().print("<html><head><p><a href=\"/regAccount/inputAccount/accountDataBaseAll\">? ?????? ????????? ?????????????</a></p></body></html>");
                } else {
                    response.getWriter().print("<html><head><p><a href=./inputAccount.jsp>????? ? ???????</a></p></body></html>");
                }
                response.getWriter().print("<html><head><p><a href=\"./\">????????? ?? ??????? ????????</a></p></body></html>");
            } else {
                response.getWriter().print("<html><head><p>????? ??? ??????????????? ? ???????, ???????? ?????? ?????</a></p></body ></html > ");
                response.getWriter().print("<html><head><p>??????????? ?? ?????????, ????????? ??????? ???????????</a></p></body ></html > ");
                response.getWriter().print("<html><head><p><a href=\"./registrationAccountForm.jsp\">?? ???????? ???????????</a></p></body></html>");
                response.getWriter().print("<html><head><p><a href=./regAccount/inputAccount>????? ? ???????</a></p></body></html>");
                response.getWriter().print("<html><head><p><a href=\"./\">????????? ?? ??????? ????????</a></p></body></html>");
            }
        } catch (Exception ex) {
            System.out.println(ex);
            getServletContext().getRequestDispatcher("/registrationAccountForm.jsp").forward(request, response);
        }


    }


}
