package org.example;

import java.util.ArrayList;
import java.util.Comparator;

public class UserList {


    private final ArrayList<User> userList;
    private int nextUserId; // Variable to allocate unique user ids.


    public UserList() {
        userList = new ArrayList<>();
        nextUserId = 1;
    }


    public void addUser(String userName, String email) {
        // Create a variable for the new user's id and assign the value of nextUserId to it.
        int newUserId = nextUserId;
        nextUserId++;

        User newUser = new User(newUserId, userName, email);
        userList.add(newUser);
    }


    public void removeUser(int id) {
        User userToRemove = searchUserById(id);
        if (userToRemove != null) {
            userList.remove(userToRemove);
        }
    }


    public User searchUserById(int id) {
        for (User user : userList) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }


    public void sortUsers() {
        userList.sort(Comparator.comparing(User::getName));
    }


    public ArrayList<User> getUserList() {
        return userList;
    }


}
