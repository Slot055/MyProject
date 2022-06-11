package ru.myOnlineShop.model.buy;
import org.joda.time.DateTime;
import java.io.Serial;
import java.io.Serializable;
public class Delivery implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    private String dateTime;
    private String address;
    private Order order;

    public Delivery(String dateTime, String address, Order order) {
        this.dateTime = dateTime;
        this.address = address;
        this.order = order;
    }

    public Delivery() {

    }

    public Delivery deliveryInfo() {

        return null;
    }

    @Override
    public String toString() {
        return "Delivery{" +
                "dateTime='" + dateTime + '\'' +
                ", address='" + address + '\'' +
                ", order=" + order +
                '}';
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public Order getOrder() {
        return order;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
