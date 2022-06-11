package ru.myOnlineShop.model.buy;
import ru.myOnlineShop.model.customer.ClientAccount;
import java.util.HashMap;
import java.util.Map;

public class HistoryOrders {

    private ClientAccount clientAccount;

    private Map<Integer, Order> oldOrders = new HashMap<>();

    public HistoryOrders(ClientAccount clientAccount, Map<Integer, Order> oldOrders) {
        this.clientAccount = clientAccount;
        this.oldOrders = oldOrders;
    }

    public HistoryOrders(){

    }


    public ClientAccount getClientAccount() {
        return clientAccount;
    }

    public void setClientAccount(ClientAccount clientAccount) {
        this.clientAccount = clientAccount;
    }

    public Map<Integer, Order> getOldOrders() {
        return oldOrders;
    }

    public void setOldOrders(Map<Integer, Order> oldOrders) {
        this.oldOrders = oldOrders;
    }


}
