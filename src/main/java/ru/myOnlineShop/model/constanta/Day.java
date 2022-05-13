package ru.myOnlineShop.model.constanta;

public enum Day {

    MONDAY("Понедельник",1),
    TUESDAY("Вторник",2),
    WEDNESDAY("Среда",3),
    THURSDAY("Четверг",4),
    FRIDAY("Пятница",5);

    private final String name;
    private final int number;

    Day(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public int getNumber() {
        return number;
    }

}
