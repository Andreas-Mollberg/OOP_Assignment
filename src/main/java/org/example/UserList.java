package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UserList {

    // Create an ArrayList of users.
    private final ArrayList<User> userList;
    private int nextUserId; // Variable to allocate unique user ids.

    // Constructor for UserList.
    public UserList(){
        userList = new ArrayList<>();
        nextUserId = 1;
    }

    // Method to add a new user to the list.
    public void addUser(String userName, String email) {
        // Create a variable for the new user's id and assign the value of nextUserId to it.
        int newUserId = nextUserId;
        nextUserId++;  // increment the value of nextUserId by one.

        User newUser = new User(newUserId, userName, email);
        userList.add(newUser);
    }

    // Method to remove user from the list by id variable.
    public void removeUser(int id){
        User userToRemove = searchUserById(id);
        if (userToRemove != null){
            userList.remove(userToRemove);
        }
    }

    // Method to search user by id variable.
    public User searchUserById(int id){
        for (User user : userList){
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }

    // Method to sort userList.
    public void sortUsers() {
        userList.sort(Comparator.comparing(User::getName));

    }

    // Getter for the userList.
    public ArrayList<User> getUserList() {
        return userList;
    }


}
