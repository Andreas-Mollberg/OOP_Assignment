package org.example;

import java.util.ArrayList;

public class UserPrinter {

    // Method to print each user in the userList object.
    public static void printUsers(ArrayList<User> users) {
        for (User user : users) {
            printUser(user);
        }
    }

    // Method to print the full info one one user object.
    public static void printUser(User user) {
        System.out.println("ID: " + user.getId() + ", Namn: " + user.getName() + ", Email: " + user.getEmail());
    }
}