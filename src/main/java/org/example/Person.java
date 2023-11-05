package org.example;

import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;
    protected boolean isSetAge = false;
    protected boolean isSetAddress = false;
    public Person (String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
    public Person (String name, String surname, int age) throws IllegalArgumentException {
        this.name = name;
        this.surname = surname;
        if (age <=0) {
            throw new IllegalArgumentException("Неверный возраст!");
        }
        this.age = age;
        isSetAge = true;
    }
    public void happyBirthday () {
        if (isSetAge) {
            age += 1;
        }
    }
    public boolean hasAddress() {
        return isSetAddress;
    }
    public boolean hasAge() {
        return isSetAge;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getName() {
        return name;
    }
    public String getSurname() {
        return surname;
    }
    public int getAge() {
        return age;
    }
    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return name + " " + surname + (hasAge()?"\nВозраст: " + age : "") + (hasAddress()? "\nАдрес: " + address : "");
    }
    public PersonBuilder newChildBuilder() {
        if (isSetAddress) {
            return new PersonBuilder(surname, address);
        } else {
            return new PersonBuilder(surname);
        }
    }
    public void setAge(int age) {
        if (isSetAge == false) {
            if (age > 0) {
                this.age = age;
            } else {
                throw new IllegalArgumentException("Задан неверный возраст!");
            }
        }
    }


}
