package org.example;

import java.util.ArrayList;

public class UserPrinter {

    public static void printUsers(ArrayList<User> users) {
        for (User user : users) {
            printUser(user);
        }
    }


    public static void printUser(User user) {
        System.out.println("ID: " + user.getId() + ", Namn: " + user.getName() + ", Email: " + user.getEmail());
    }
}