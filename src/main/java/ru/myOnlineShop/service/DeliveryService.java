package ru.myOnlineShop.service;
import ru.myOnlineShop.model.buy.Delivery;
import ru.myOnlineShop.model.buy.Order;


public class DeliveryService {

    private Order order;

    public DeliveryService() {

    }

    public Delivery getDelivery(String dateTime,String address, Order order) {
        if (order.getCheck().isPay()) {
           Delivery delivery = new Delivery(dateTime,address, order);
            return delivery;
        } else
            return null;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

}
