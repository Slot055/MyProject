package ru.myOnlineShop.model.constanta;

public enum StatusAccount {

    ADMIN("�������������"),
    USER("������������"),
    UNKNOWN("�����������");

    private final String name;

    StatusAccount(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
