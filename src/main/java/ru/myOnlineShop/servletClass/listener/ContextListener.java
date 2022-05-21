package ru.myOnlineShop.servletClass.listener;

import ru.myOnlineShop.model.customer.ClientAccount;
import ru.myOnlineShop.model.dao.AccountDAO;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

@WebListener
public class ContextListener implements ServletContextListener {

    private AtomicReference<AccountDAO> accountDataBase;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        accountDataBase = new AtomicReference<>(new AccountDAO());
        ArrayList<ClientAccount> clientAccountBase = accountDataBase.get().select();
        final ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("accountDataBase", accountDataBase);
        servletContext.setAttribute("clientAccountBase", clientAccountBase);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        accountDataBase = null;
    }
}
