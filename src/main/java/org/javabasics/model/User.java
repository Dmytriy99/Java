package org.javabasics.model;

public class User {
    private int id;
    private String name;
    private String surname;
    private String date;
    private String adress;
    private String userId;

    public User(int id, String name, String surname, String date, String adress, String userId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.date = date;
        this.adress = adress;
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDate() {
        return date;
    }

    public String getAdress() {
        return adress;
    }

    public String getUserid() {
        return userId;
    }
}
