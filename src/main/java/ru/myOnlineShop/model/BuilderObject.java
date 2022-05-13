package ru.myOnlineShop.model;

import org.joda.time.DateTime;
import ru.myOnlineShop.model.customer.Client;
import ru.myOnlineShop.model.customer.ClientAccount;
import ru.myOnlineShop.model.customer.clientServise.clientAccountService.AccountService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

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
        Client client = new Client(cName, cLastName, cGender, Integer.parseInt(cAge), cPhoneNumber, cEmail);


        return client;
    }

    public static ClientAccount buildClientAccount(HttpServletRequest request, HttpServletResponse response) {
        String aLogin = request.getParameter("login");
        String aPassword = request.getParameter("password");
        ClientAccount clientAccount = new ClientAccount(aLogin, aPassword,-1,null,null);

        return clientAccount;
    }

}
