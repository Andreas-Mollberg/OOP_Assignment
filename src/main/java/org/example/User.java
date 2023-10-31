package org.example;

public class User {

    private final int ID;
    private final String NAME;
    private final String EMAIL;

    public User(int id, String name, String email) {
        this.ID = id;
        this.NAME = name;
        this.EMAIL = email;
    }

    public int getID() {
        return ID;
    }

    public String getNAME() {
        return NAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

}


