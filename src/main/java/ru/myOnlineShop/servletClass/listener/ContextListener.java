package ru.myOnlineShop.servletClass.listener;

import dataBase.DataBaseService;
import ru.myOnlineShop.dao.ProductDAO;
import ru.myOnlineShop.service.clientServise.clientAccountService.AccountService;
import ru.myOnlineShop.dao.AccountDAO;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicReference;

@WebListener
public class ContextListener implements ServletContextListener {

    Connection connection;
    private AtomicReference<AccountDAO> accountDataBase;
    private AtomicReference<AccountService> accountService;
    private AtomicReference<ProductDAO> productDataBase;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        connection = DataBaseService.getConnection();
        accountDataBase = new AtomicReference<>(new AccountDAO());
        accountService = new AtomicReference<>(new AccountService());
        productDataBase = new AtomicReference<>(new ProductDAO());
        final ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("connection",connection);
        servletContext.setAttribute("accountDataBase", accountDataBase);
        servletContext.setAttribute("accountService", accountService);
        servletContext.setAttribute("productDataBase",productDataBase);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            connection.close();
            System.out.println("Connection close");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        accountDataBase = null;
        accountService = null;
        productDataBase = null;
    }
}
