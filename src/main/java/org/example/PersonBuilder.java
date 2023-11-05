package org.example;

public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String address;
    protected boolean isSetName = false;
    protected boolean isSetSurname = false;
    protected boolean isSetAge = false;
    protected boolean isSetAddress = false;
    public PersonBuilder () {}
    public PersonBuilder(String surname) {
        this.setSurname(surname);
        isSetSurname = true;
    }

    public PersonBuilder (String surname, String address) {
        this.setSurname(surname);
        isSetSurname = true;
        this.setAddress(address);
        isSetAddress = true;
    }
    public PersonBuilder setName (String name) {
        this.name = name;
        isSetName = true;
        return this;
    }
    public PersonBuilder setSurname (String surname) {
        this.surname = surname;
        isSetSurname = true;
        return this;
    }
    public PersonBuilder setAge (int age) throws IllegalArgumentException {
        if (age <=0) {
            throw new IllegalArgumentException("Неверный возраст!");
        }
        this.age = age;
        isSetAge = true;
        return this;
    }
    public PersonBuilder setAddress(String address) {
        this.address = address;
        isSetAddress = true;
        return this;
    }
    public Person build() {
        if (!isSetName || !isSetSurname) {
            throw new IllegalStateException("Не все обязательные методы билдера были вызваны!");
        }
        Person obj = new Person(name, surname);
        if (isSetAddress) {
            obj.setAddress(address);
        }
        if (isSetAge) {
            obj.setAge(age);
        }
        return obj;
    }
}
