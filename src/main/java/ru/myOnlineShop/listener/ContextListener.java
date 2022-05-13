package ru.myOnlineShop.listener;

import ru.myOnlineShop.model.constanta.StatusAccount;
import ru.myOnlineShop.model.customer.ClientAccount;
import ru.myOnlineShop.model.dataBaseProject.AccountDataBaseProject;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicReference;

@WebListener
public class ContextListener implements ServletContextListener {

    private AtomicReference<AccountDataBaseProject> accountDataBase;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        accountDataBase = new AtomicReference<>(new AccountDataBaseProject());
        accountDataBase.get().getClientAccountBase().add(new ClientAccount("Admin", "Admin", 10000000, StatusAccount.ADMIN,null));
        accountDataBase.get().getClientAccountBase().add(new ClientAccount("User","User",20000000,StatusAccount.USER,null));
        final ServletContext servletContext = sce.getServletContext();
        servletContext.setAttribute("accountDataBase", accountDataBase);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        accountDataBase = null;
    }
}
