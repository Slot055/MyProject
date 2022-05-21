package ru.myOnlineShop.model;
import ru.myOnlineShop.model.constanta.StatusAccount;
import ru.myOnlineShop.model.customer.Client;
import ru.myOnlineShop.model.customer.ClientAccount;
import ru.myOnlineShop.model.dao.AccountDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class BuilderObject {

    public static OnlineShop buildOnlineShop() {
        OnlineShop onlineShop = new OnlineShop("MyShop", "08:00-23:00", "www.OnlineShop.ru", "8(800)123-45-67");

        return onlineShop;
    }

    public static Client buildClient(HttpServletRequest request, HttpServletResponse response) {
        String cName = request.getParameter("name");
        String cLastName = request.getParameter("lastName");
        String cGender = request.getParameter("gender");
        String cAge = request.getParameter("age");
        String cPhoneNumber = request.getParameter("phoneNumber");
        String cEmail = request.getParameter("email");
        Client client = new Client(cName, cLastName, cGender, cAge, cPhoneNumber, cEmail);


        return client;
    }

    public static ClientAccount buildClientAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        ClientAccount clientAccount;
        @SuppressWarnings("unchecked")
        AtomicReference<AccountDAO> accountDataBase = (AtomicReference<AccountDAO>) request.getServletContext().getAttribute("accountDataBase");
        ArrayList<ClientAccount> clientAccountBase = accountDataBase.get().select();
        for (ClientAccount s : clientAccountBase) {
            if (s.getLogin().equals(login)) {
                response.getWriter().print("<html><head><p>Логин " + "*" + s.getLogin() + "* уже зарегистрирован в системе, выберите другой логин</a></p></body ></html > ");

                return null;
            }

        }
        try {
            if (request.getParameter("statusAccount") != null) {
                StatusAccount statusAccount = StatusAccount.valueOf(request.getParameter("statusAccount").toUpperCase());
                clientAccount = new ClientAccount(login, password, statusAccount, buildClient(request, response));

            } else {
                clientAccount = new ClientAccount(login, password, StatusAccount.USER, buildClient(request, response));

            }
        } catch (IllegalArgumentException e) {
            clientAccount = new ClientAccount(login, password, StatusAccount.USER, buildClient(request, response));
        }
        return clientAccount;
    }

}



