package com.example.kf.thetest.sqlite;

public class Person {
    private Integer personid;
    private String name;
    private String phone;

    public Person() {
    }

    public Person(Integer id, String name, String phone) {
        this.personid = id;
        this.name = name;
        this.phone = phone;
    }

    public Integer getId() {
        return personid;
    }

    public void setId(Integer id) {
        this.personid = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Person [id=" + personid + ", name=" + name + ", phone=" + phone + "]";
    }
}
