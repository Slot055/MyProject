package ru.myOnlineShop.servletClass.listener;

import dataBase.DataBaseService;
import ru.myOnlineShop.dao.ProductDAO;
import ru.myOnlineShop.service.AccountService;
import ru.myOnlineShop.dao.AccountDAO;
import ru.myOnlineShop.service.DeliveryService;
import ru.myOnlineShop.service.HistoryService;
import ru.myOnlineShop.service.clientServise.BuyService;
import ru.myOnlineShop.service.clientServise.CashService;
import ru.myOnlineShop.service.ProductService;


import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

@WebListener
public class ContextListener implements ServletContextListener {

    Connection connection;
    private AtomicReference<AccountDAO> accountDataBase;
    private AtomicReference<AccountService> accountService;
    private AtomicReference<ProductDAO> productDataBase;
    private AtomicReference<ProductService> productService;

    private AtomicReference<BuyService> buyService;

    private CashService cashService;

    private AtomicReference<DeliveryService> deliveryService;

    private HistoryService historyService;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        connection = DataBaseService.getConnection();
        accountDataBase = new AtomicReference<>(new AccountDAO());
        accountService = new AtomicReference<>(new AccountService());
        productService = new AtomicReference<>(new ProductService());
        productDataBase = new AtomicReference<>(new ProductDAO());
        buyService = new AtomicReference<>(new BuyService());
        cashService = new CashService();
        deliveryService = new AtomicReference<>(new DeliveryService());
        historyService = new HistoryService();
        final ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("connection", connection);
        servletContext.setAttribute("accountDataBase", accountDataBase);
        servletContext.setAttribute("accountService", accountService);
        servletContext.setAttribute("productService", productService);
        servletContext.setAttribute("productDataBase", productDataBase);
        servletContext.setAttribute("buyService", buyService);
        servletContext.setAttribute("cashService", cashService);
        servletContext.setAttribute("deliveryService",deliveryService);
        servletContext.setAttribute("historyService",historyService);

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
        productService = null;
        buyService = null;
        cashService = null;
        deliveryService = null;
        historyService = null;

    }
}
