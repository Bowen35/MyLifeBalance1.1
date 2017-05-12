package com.inducesmile.androidmultiquiz.entities;

/**
 * Created by Sandman on 12/05/2017.
 */

public class Client {
    private String name;
    private String email;

    public Client() {}

    public Client(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
