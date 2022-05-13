package ru.myOnlineShop.model.constanta;

public enum StatusAccount {

    ADMIN("Администратор"),
    USER("Пользователь"),
    UNKNOWN("Неизвестный");

    private final String name;

    StatusAccount(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
