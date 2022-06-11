package ru.myOnlineShop.model.buy;
import org.joda.time.DateTime;
import ru.myOnlineShop.model.constanta.StatusOrder;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Order implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private int numberOrder;
    private double sum;
    private ArrayList<Basket> listProducts;
    private DateTime dateTime;
    private Check check;

    private StatusOrder statusOrder;

    public Order(int numberOrder, DateTime dateTime, ArrayList<Basket> listProducts, Double sum, Check check,StatusOrder statusOrder) {
        this.numberOrder = numberOrder;
        this.dateTime = dateTime;
        this.listProducts = listProducts;
        this.sum = sum;
        this.check = check;
        this.statusOrder = statusOrder;
    }

    public Order() {

    }

    public int generateNumberOrder() {
        Random random = new Random();
        int id = random.nextInt();
        if (id < 0) {
            int idFinal = Math.abs(-id);
            setNumberOrder(idFinal);
            return getNumberOrder();
        } else setNumberOrder(id);

        return getNumberOrder();

    }


    public int getNumberOrder() {
        return numberOrder;
    }

    public void setNumberOrder(int numberOrder) {
        this.numberOrder = numberOrder;
    }

    public ArrayList<Basket> getListProducts() {
        return listProducts;
    }

    public void setListProducts(ArrayList<Basket> listProducts) {
        this.listProducts = listProducts;
    }

    public DateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(DateTime dateTime) {
        this.dateTime = dateTime;
    }

    public double getSum() {
        return sum;
    }

    public void setSum(double sum) {
        this.sum = sum;
    }

    public Check getCheck() {
        return check;
    }

    public void setCheck(Check check) {
        this.check = check;
    }

    public StatusOrder getStatusOrder() {
        return statusOrder;
    }

    public void setStatusOrder(StatusOrder statusOrder) {
        this.statusOrder = statusOrder;
    }
}
