package ru.myOnlineShop.model.constanta;

public enum StatusOrder {

    PURCHASED("��������"),

    CANCELLED("������");

    private final String name;

    StatusOrder(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

