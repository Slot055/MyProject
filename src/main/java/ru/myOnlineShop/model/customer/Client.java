package ru.myOnlineShop.model.customer;

import java.util.Objects;

public class Client {
    private String name;
    private String lastName;
    private String gender;
    private int age;
    private String phoneNumber;
    private String email;

    public Client(String name, String lastName, String gender, int age, String phoneNumber, String email) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.email = email;

    }

    public Client() {

    }

    @Override
    public String toString() {
        return "Имя:" + getName() + " , " + "Фамилия:" + getLastName() + " , " +
                "Пол:" + getGender() + " , " + "Возраст:" + getAge() +
                " , " + "Номер телефона:" + getPhoneNumber() + " , " + "Email:" + getEmail();

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
