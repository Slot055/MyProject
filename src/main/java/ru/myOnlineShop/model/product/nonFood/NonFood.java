package ru.myOnlineShop.model.product.nonFood;

import ru.myOnlineShop.model.product.Product;

public abstract class NonFood extends Product {

        public NonFood(String categoryProduct, String typeProduct, String nameProduct, double price,String description, int item, int quantity) {
            super(categoryProduct, typeProduct, nameProduct, price, description,item, quantity);
        }

        public NonFood(){

        }

    }
