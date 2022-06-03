package ru.myOnlineShop.model.customer;

import ru.myOnlineShop.model.product.Product;

import java.io.Serial;
import java.io.Serializable;

public class Basket implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
    private Product product;
    private int quantityInBasket;

    public Basket(Product product, int quantityInBasket) {
        this.product = product;
        this.quantityInBasket = quantityInBasket;
    }

    public Basket() {

    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantityInBasket() {
        return quantityInBasket;
    }

    public void setQuantityInBasket(int quantityInBasket) {
        this.quantityInBasket = quantityInBasket;
    }
}
