package ru.myOnlineShop.service.clientServise.clientAccountService;
import ru.myOnlineShop.dao.ProductDAO;
import ru.myOnlineShop.model.constanta.StatusAccount;
import ru.myOnlineShop.model.customer.ClientAccount;
import ru.myOnlineShop.model.product.Product;
import ru.myOnlineShop.service.Servise;
import ru.myOnlineShop.dao.AccountDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class AccountService implements Servise {

    public AccountService() {

    }

    public StatusAccount getRoleByLoginPassword(final String login, final String password, HttpServletRequest request) {
        @SuppressWarnings("unchecked") final AtomicReference<AccountDAO> accountDataBase = (AtomicReference<AccountDAO>) request.getServletContext().getAttribute("accountDataBase");
        ArrayList<ClientAccount> clientAccountBase = accountDataBase.get().select();
        StatusAccount result = StatusAccount.UNKNOWN;
        for (ClientAccount clientAccount : clientAccountBase) {
            if (clientAccount.getLogin().equals(login) && clientAccount.getPassword().equals(password)) {
                result = clientAccount.getStatusAccount();
                request.getSession().setAttribute("clientAccount", clientAccount);
            }
        }

        return result;
    }

    public boolean clientAccountIsExist(final String login, final String password, HttpServletRequest request) {
        @SuppressWarnings("unchecked") final AtomicReference<AccountDAO> accountDataBase = (AtomicReference<AccountDAO>) request.getServletContext().getAttribute("accountDataBase");
        ArrayList<ClientAccount> clientAccountBase = accountDataBase.get().select();
        boolean result = false;
        for (ClientAccount clientAccount : clientAccountBase) {
            if (clientAccount.getLogin().equals(login) && clientAccount.getPassword().equals(password)) {
                result = true;
                break;
            }
        }

        return result;
    }
    public boolean repeatCheckAccount(HttpServletRequest request, HttpServletResponse response, String login) throws IOException {
        @SuppressWarnings("unchecked")
        AtomicReference<AccountDAO> accountDataBase = (AtomicReference<AccountDAO>) request.getServletContext().getAttribute("accountDataBase");
        ArrayList<ClientAccount> clientAccountBase = accountDataBase.get().select();
        for (ClientAccount s : clientAccountBase) {
            if (s.getLogin().equals(login)) {

                return true;
            }

        }
        return false;
    }
    public boolean repeatCheckProduct(HttpServletRequest request, HttpServletResponse response, String typeProduct,String categoryProduct,String groupProduct,String nameProduct,int price) throws IOException {
        @SuppressWarnings("unchecked")
        AtomicReference<ProductDAO> productDataBase = (AtomicReference<ProductDAO>) request.getServletContext().getAttribute("productDataBase");
        ArrayList<Product> productBase = productDataBase.get().select();
        for (Product p : productBase) {
            if (p.getTypeProduct().equals(typeProduct) && p.getCategoryProduct().equals(categoryProduct) &&
                    p.getGroupProduct().equals(groupProduct) && p.getNameProduct().equals(nameProduct) &&
                            p.getPrice() == price) {
                return true;
            }

        }
        return false;
    }

}