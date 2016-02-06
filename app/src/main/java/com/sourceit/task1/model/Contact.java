package com.sourceit.task1.model;

/**
 * Created by User on 04.02.2016.
 */
public class Contact {
    private String name;
    private String email;
    private String adress;
    private int image;

    public Contact(String name, String email, String adress, int image) {
        this.name = name;
        this.email = email;
        this.adress = adress;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAdress() {
        return adress;
    }

    public int getImage() {
        return image;
    }
}