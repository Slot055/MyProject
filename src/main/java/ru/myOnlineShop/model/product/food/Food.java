package ru.myOnlineShop.model.product.food;
import ru.myOnlineShop.model.product.Product;

public abstract class Food extends Product {
    private double expirationDate;

    public Food(String categoryProduct, String typeProduct, String nameProduct, double price, String description, int item, double expirationDate, int quantity) {
        super(categoryProduct, typeProduct, nameProduct, price, description, item, quantity);
        this.expirationDate = expirationDate;
    }

    public Food() {
    }

    public double getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(double expirationDate) {
        this.expirationDate = expirationDate;
    }
}
