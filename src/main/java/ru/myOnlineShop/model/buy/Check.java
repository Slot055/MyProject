package ru.myOnlineShop.model.buy;

import java.io.Serial;
import java.io.Serializable;

public class Check implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private boolean pay;
    private Order order;

    public Check(Order order, boolean pay) {
        this.order = order;
        this.pay = pay;
    }

    public Check(boolean pay) {
        this.pay = pay;
    }

    public Check() {

    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public boolean isPay() {
        return pay;
    }

    public void setPay(boolean pay) {
        this.pay = pay;
    }
}
