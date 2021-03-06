package ru.myOnlineShop.model;

import org.joda.time.DateTime;
import ru.myOnlineShop.model.buy.Basket;
import ru.myOnlineShop.model.buy.Check;
import ru.myOnlineShop.model.buy.HistoryOrders;
import ru.myOnlineShop.model.buy.Order;
import ru.myOnlineShop.model.constanta.StatusAccount;
import ru.myOnlineShop.model.constanta.StatusOrder;
import ru.myOnlineShop.model.customer.Client;
import ru.myOnlineShop.model.customer.ClientAccount;
import ru.myOnlineShop.model.product.Product;
import ru.myOnlineShop.service.AccountService;
import ru.myOnlineShop.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

public class BuilderObject {

    public static OnlineShop buildOnlineShop() {
        OnlineShop onlineShop = new OnlineShop("MyShop", "08:00-23:00", "www.OnlineShop.ru", "8(800)123-45-67");

        return onlineShop;
    }

    public static Client buildClient(HttpServletRequest request, HttpServletResponse response) {
        String name = request.getParameter("name");
        String lastName = request.getParameter("lastName");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String phoneNumber = request.getParameter("phoneNumber");
        String email = request.getParameter("email");
        Client client = new Client(name, lastName, gender, age, phoneNumber, email);


        return client;
    }

    public static ClientAccount buildClientAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        ClientAccount clientAccount;
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        @SuppressWarnings("unchecked")
        AtomicReference<AccountService> accountService = (AtomicReference<AccountService>) request.getServletContext().getAttribute("accountService");
        if (accountService.get().repeatCheckAccount(request, response, login)) return null;
        else {
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

    public static Product buildProduct(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Product product;
        @SuppressWarnings("unchecked")
        AtomicReference<ProductService> productService = (AtomicReference<ProductService>) request.getServletContext().getAttribute("productService");
        int item = Integer.parseInt(request.getParameter("item"));
        String typeProduct = request.getParameter("typeProduct");
        String categoryProduct = request.getParameter("categoryProduct");
        String groupProduct = request.getParameter("groupProduct");
        String nameProduct = request.getParameter("nameProduct");
        double price = Double.parseDouble(request.getParameter("price"));
        String description = request.getParameter("description");

        if (productService.get().repeatCheckProduct(request, typeProduct, categoryProduct, groupProduct, nameProduct, (int) price))
            return null;
        else {
            product = new Product(item, typeProduct, categoryProduct, groupProduct, nameProduct, price, description);
            return product;
        }
    }

    public static Order buildOrder(List<Basket> basketProducts) {
        Order order = new Order();
        order.setNumberOrder(order.generateNumberOrder());
        order.setDateTime(new DateTime().toDateTime());
        order.setListProducts(new ArrayList<>(basketProducts));
        double sum = 0;
        for (Basket b : order.getListProducts()) {
            sum += b.getProduct().getPrice() * b.getQuantityInBasket();
        }
        order.setSum(sum);
        return order;
    }

    public static Check buildCheck(boolean pay) {
        Check check = new Check(pay);
        return check;
    }

    public static HistoryOrders buildHistoryOrders(ClientAccount clientAccount) {

        HistoryOrders historyOrders = new HistoryOrders();
        historyOrders.setClientAccount(clientAccount);
        historyOrders.setOldOrders(historyOrders.getOldOrders());

        return historyOrders;
    }

}



