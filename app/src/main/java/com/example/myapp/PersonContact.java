package com.example.myapp;

public class PersonContact {
    private String name;
    private String birthday;
    private int phoneno;

    public PersonContact(String name, String birthday, int phoneno) {
        this.name = name;
        this.birthday = birthday;
        this.phoneno = phoneno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public int getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(int phoneno) {
        this.phoneno = phoneno;
    }
}
