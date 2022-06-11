package ru.myOnlineShop.model.customer;

import java.io.Serial;
import java.io.Serializable;

public class CashAccount implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private long cardNumber;
    private double cash;

    public CashAccount(long cardNumber, double cash) {
        this.cardNumber = cardNumber;
        this.cash = cash;
    }

    public CashAccount() {

    }

    public long getCardNumber() {
        return cardNumber;
    }

    public double getCash() {
        return cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }
}
