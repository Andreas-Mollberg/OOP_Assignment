package org.example;

import java.util.ArrayList;

public class UserPrinter {

    public static void printUserList(ArrayList<User> users) {
        for (User user : users) {
            printUser(user);
        }
    }

    public static void printUser(User user) {
        System.out.println("ID: " + user.getID() + ", Name: " + user.getNAME() + ", Email: " + user.getEMAIL());
    }
}