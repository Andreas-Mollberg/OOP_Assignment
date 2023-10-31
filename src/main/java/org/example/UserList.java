package org.example;

import java.util.ArrayList;
import java.util.Comparator;

public class UserList {
    private final ArrayList<User> userList;
    private int nextUserId; // Used to allocate unique user ids.

    public UserList() {
        userList = new ArrayList<>();
        nextUserId = 1;
    }

    public void addUser(String userName, String email) {
        if (userName.isBlank() || email.isBlank()) {
            System.out.println("Namn eller email kan inte vara blanka.");
        } else {
            int newUserId = nextUserId;
            nextUserId++;

            User newUser = new User(newUserId, userName, email);
            userList.add(newUser);
            System.out.println(userName + " har lagts till.");
        }
    }

    public void removeUser(int id) {
        if (id >= 1 && id <= userList.size()) {
            User userToRemove = searchUserById(id);
            userList.remove(userToRemove);
            System.out.println(userToRemove.getNAME() + " har tagits bort.");
        } else {
            System.out.println("Felaktigt id.");
        }
    }

    public User searchUserById(int id) {
        try {
            if (id <= 0 || id > userList.size()) {
                System.out.println("Felaktigt id.");
                return null;
            }

            for (User user : userList) {
                if (user.getID() == id) {
                    return user;
                }
            }

            System.out.println("Användaren med id " + id + " hittades inte.");
            return null;
        } catch (Exception e) {
            System.out.println("Något gick fel vid sökning av användaren.");
            e.printStackTrace();
            System.out.println("Felaktig inmatning av id.");
            return null;
        }
    }


    public void sortUsers() {
        userList.sort(Comparator.comparing(User::getNAME));
    }

    public ArrayList<User> getUserList() {
        return userList;
    }
}
