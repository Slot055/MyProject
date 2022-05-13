package ru.myOnlineShop.model.customer.clientServise.clientBuyService;

import ru.myOnlineShop.model.customer.Client;
import ru.myOnlineShop.model.customer.clientServise.ClientServise;
import ru.myOnlineShop.model.product.Product;

public class BuyService implements ClientServise {
    private Product product;

    public BuyService() {

    }

    @Override
    public int generateId(Object object) {
        product = (Product) object;
        int id = product.hashCode() / 10000;
        if (id < 0) {
            int idFinal = Math.abs(-id);
            product.setItem(idFinal);
            return product.getItem();
        } else product.setItem(id);

        return product.getItem();
    }

}
