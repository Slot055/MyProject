package ru.myOnlineShop.model.product;

public class Product implements Comparable<Product> {
    private int item;
    private String typeProduct;
    private String categoryProduct;
    private String groupProduct;
    private String nameProduct;
    private double price;
    private String description;
    private int quantity;

    public Product(int item, String typeProduct, String categoryProduct, String groupProduct, String nameProduct, double price, String description, int quantity) {
        this.item = item;
        this.typeProduct = typeProduct;
        this.categoryProduct = categoryProduct;
        this.groupProduct = groupProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public Product(String typeProduct, String categoryProduct, String groupProduct, String nameProduct, double price, String description, int quantity) {
        this.typeProduct = typeProduct;
        this.categoryProduct = categoryProduct;
        this.groupProduct = groupProduct;
        this.nameProduct = nameProduct;
        this.price = price;
        this.description = description;
        this.quantity = quantity;
    }

    public Product() {
    }

    @Override
    public String toString() {
        return "Тип товара:" + typeProduct + " , " + "Категория товара:" + categoryProduct + " , " + "Наименование товара:" + nameProduct +
                " , " + "Цена:" + price + " , " + "Описание:" + description + " , " + "Количество:" + quantity;
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

    public String getGroupProduct() {
        return groupProduct;
    }

    public void setGroupProduct(String groupProduct) {
        this.groupProduct = groupProduct;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
