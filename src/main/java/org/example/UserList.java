package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class UserList {

    private ArrayList<User> users;

    public UserList(){
        users = new ArrayList<>();
    }

    public void addUser(String userName, String email) {
        int newUserId = 1;

        for (User user : users) {
            if (user.getId() >= newUserId) {
                newUserId = user.getId() + 1;
            }
        }

        User newUser = new User(newUserId, userName, email);
        users.add(newUser);
    }
    public void removeUser(int id){
        User userToRemove = null;
        for (User user : users) {
                if (user.getId() == id){
                    userToRemove = user;
                    break;
                }
        }
        if (userToRemove != null){
            users.remove(userToRemove);
        }
    }

    public User searchUserById(int id){
        for (User user : users){
            if (user.getId() == id){
                return user;
            }
        }
        return null;
    }
    public void sortUsers() {
        Collections.sort(users, Comparator.comparing(User::getName));

    }

    public ArrayList<User> getUsers() {
        return users;
    }

    @Override
    public String toString() {
        return "UserList{" +
                "users=" + users +
                '}';
    }
}
