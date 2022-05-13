package ru.myOnlineShop.model.product;

public class Product implements Comparable<Product>{
    private String categoryProduct;
    private String typeProduct;
    private String nameProduct;
    private double price;
    private String description;
    private int item;
    private int quantity;

    public Product(String categoryProduct, String typeProduct, String nameProduct, double price,String description, int item,int quantity) {
        this.categoryProduct = categoryProduct;
        this.typeProduct = typeProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.description = description;
        this.item = item;
        this.quantity = quantity;
    }

    public Product() {
    }

    public int generateItem(Product product) {
        int id = product.hashCode() / 100000;
        if (id < 0) {
            int idFinal = Math.abs(-id);
            setItem(idFinal);
            return getItem();
        } else setItem(id);

        return getItem();

    }

    @Override
    public String toString() {
        return "Категория товара:" + categoryProduct + " , " + "Тип товара:" + typeProduct + " , " + "Наименование товара:" + nameProduct +
                " , " + "Цена:" + price + " , " + "Артикул:" + item + " , " + "Количество:" + quantity;
    }


    public void productInfo() {

    }

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public String getCategoryProduct() {
        return categoryProduct;
    }

    public void setCategoryProduct(String categoryProduct) {
        this.categoryProduct = categoryProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public int compareTo(Product product) {
        return (int) (this.getPrice() - product.getPrice());
    }
}
