package ru.myOnlineShop.model;

import org.joda.time.DateTime;

public class OnlineShop {
    private String name;
    private String workHours;
    private String webAdress;
    private String phone;

    public OnlineShop(String name, String workHours, String webAdress, String phone) {
        this.name = name;
        this.workHours = workHours;
        this.webAdress = webAdress;
        this.phone = phone;
    }

    public String infoStore() {
        String info = ("***********************************" + "<br><br>" + "Магазин: " + getName() + "<br><br>" + "Время работы магазина: "
                + getWorkHours() + "<br><br>" + "Сайт: " + getWebAdress() + "<br><br>" + "Телефон: " + getPhone() + "<br><br>" +
                "***********************************");
        return info;
    }


    public String getTimeStore(DateTime date) {
        String timeStore = "";
        if (date.getHourOfDay() < 8) {
            timeStore = ("Сервисные службы недоступны" + "<br>" + "<br>" + "Сервис будет доступен через " + (7 - date.getHourOfDay()) +
                    " час(ов) : " + (60 - date.getMinuteOfHour()) + " минут(ы)");
            // System.exit(0);
        } else if (date.getHourOfDay() < 23) {
            timeStore = ("Сервисные службы магазина будут доступны в течение " + (22 - date.getHourOfDay()) +  " час(ов) : "
                    + (60 - date.getMinuteOfHour()) + " минут(ы)");
        } else {
            timeStore = ("Сервисные службы недоступны" + "<br>" + "<br>" + "Сервис будет доступен через " + (31 - date.getHourOfDay()) +
                    " час(ов) : " + (60 - date.getMinuteOfHour()) + " минут(ы)");
            // System.exit(0);
        }
        return timeStore;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWorkHours() {
        return workHours;
    }

    public void setWorkHours(String workHours) {
        this.workHours = workHours;
    }

    public String getWebAdress() {
        return webAdress;
    }

    public void setWebAdress(String webAdress) {
        this.webAdress = webAdress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}

