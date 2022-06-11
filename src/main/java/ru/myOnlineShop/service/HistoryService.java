package ru.myOnlineShop.service;

import ru.myOnlineShop.model.BuilderObject;
import ru.myOnlineShop.model.buy.HistoryOrders;
import ru.myOnlineShop.model.buy.Order;
import ru.myOnlineShop.model.customer.ClientAccount;

import java.util.Map;

public class HistoryService {

    private HistoryOrders historyOrders;

    public HistoryService(HistoryOrders historyOrders) {
        this.historyOrders = historyOrders;

    }

    public HistoryService() {

    }

    public HistoryOrders addToHistoryOrders(ClientAccount clientAccount, Order order) {
        if (historyOrders == null) {
            HistoryOrders historyOrders = BuilderObject.buildHistoryOrders(clientAccount);
            historyOrders.getOldOrders().put(order.getNumberOrder(), order);
            return historyOrders;
        } else historyOrders.getOldOrders().put(order.getNumberOrder(), order);

        return historyOrders;
    }


    public HistoryOrders getHistoryOrders() {
        return historyOrders;
    }

    public void setHistoryOrders(HistoryOrders historyOrders) {
        this.historyOrders = historyOrders;
    }
}
