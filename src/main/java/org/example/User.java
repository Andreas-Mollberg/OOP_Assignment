package org.example;

public class User {

    // Create variables needed by the User class.
    private final int id;
    private final String name;
    private final String email;

    // Constructor to create a new user.
    public User(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }


    // Getter for id variable of user.
    public int getId() {
        return id;
    }

    // Getter for name variable of user.
    public String getName() {
        return name;
    }

    // Getter for email variable of user.
    public String getEmail() {
        return email;
    }

    // toString method in order to print a user.
    @Override
    public String toString() {
        return "ID: " + getId() + "\nNamn: " + getName() + "\nEmail: " + getEmail() + "\n";
    }
}


