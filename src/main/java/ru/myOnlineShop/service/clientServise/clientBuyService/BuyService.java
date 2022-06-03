package ru.myOnlineShop.service.clientServise.clientBuyService;

import ru.myOnlineShop.model.customer.Basket;
import ru.myOnlineShop.model.product.Product;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

public class BuyService {
    private Product product;
    private Basket basket = null;
    private List<Basket> basketProducts;

    public BuyService() {

    }

    public List<Basket> addToBasket(HttpServletRequest request, int item, Product product) {

        if (request.getSession().getAttribute("basketProducts") == null) {
            basket = new Basket(product, 1);
            basketProducts = new ArrayList<>();
            basketProducts.add(basket);
        } else {
            @SuppressWarnings("unchecked")
            List<Basket> basketProducts = (List<Basket>) request.getSession().getAttribute("basketProducts");
            int index = isExist(item, basketProducts);
            if (index == -1) {
                basket = new Basket(product, 1);
                basketProducts.add(basket);
            } else {
                int quantityInBasket = basketProducts.get(index).getQuantityInBasket() + 1;
                basketProducts.get(index).setQuantityInBasket(quantityInBasket);
            }
        }

        return basketProducts;
    }

    public List<Basket> removeFromBasket(HttpServletRequest request, int item) {
        @SuppressWarnings("unchecked")
        List<Basket> basketProducts = (List<Basket>) request.getSession().getAttribute("basketProducts");
        int index = isExist(item, basketProducts);
        if (basketProducts.get(index).getQuantityInBasket() == 1) {
            basketProducts.remove(index);
        } else {
            int quantityInBasket = basketProducts.get(index).getQuantityInBasket() - 1;
            basketProducts.get(index).setQuantityInBasket(quantityInBasket);
        }
        request.getSession().setAttribute("basketProducts", basketProducts);

        return basketProducts;
    }

    private int isExist(int item, List<Basket> basketProducts) {
        for (int i = 0; i < basketProducts.size(); i++) {
            if (basketProducts.get(i).getProduct().getItem() == item) {
                return i;
            }
        }
        return -1;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Basket getBasket() {
        return basket;
    }

    public List<Basket> getBasketProducts() {
        return basketProducts;
    }

}
