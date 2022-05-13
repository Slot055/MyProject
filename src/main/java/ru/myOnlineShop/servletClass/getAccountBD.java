package ru.myOnlineShop.servletClass;

import ru.myOnlineShop.model.customer.ClientAccount;
import ru.myOnlineShop.model.customer.clientServise.clientAccountService.AccountServiceDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = {"/index",""})
public class getAccountBD extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ArrayList<ClientAccount> clientAccountBaseBD = AccountServiceDB.select();
        request.setAttribute("clientAccountBaseBD", clientAccountBaseBD);
        System.out.println("Connection to ProductDB succesfull!");

        getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}

