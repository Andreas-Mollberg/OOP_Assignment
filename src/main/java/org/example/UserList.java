package org.example;

import java.util.ArrayList;
import java.util.Comparator;

public class UserList {
    private final ArrayList<User> userList;

    // Used to allocate unique user ids.
    private int nextUserId;
    private int latestUserId = 0;

    public UserList() {
        userList = new ArrayList<>();
        nextUserId = 1;
    }

    public void addUser(String userName, String userEmail) {
        if (userName.isBlank() || userEmail.isBlank()) {
            System.out.println("Name or email cannot be empty.");
        } else {
            int newUserId = nextUserId;
            nextUserId++;
            latestUserId++;


            User newUser = new User(newUserId, userName, userEmail);
            userList.add(newUser);
            System.out.println(userName + " has been added.");
        }
    }

    public void removeUser(int id) {
        if (id >= 1 && id <= latestUserId) {
            User userToRemove = searchUserById(id);
            userList.remove(userToRemove);
            System.out.println(userToRemove.getNAME() + " has been removed");
        } else {
            System.out.println("Incorrect id.");
        }
    }

    public User searchUserById(int id) {
        try {
            if (id <= 0 || id > latestUserId) {
                System.out.println("Incorrect id.");
                return null;
            }

            for (User user : userList) {
                if (user.getID() == id) {
                    return user;
                }
            }

            System.out.println("The user with id " + id + " was not found.");
            return null;
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Something went wrong when searching for the user.");
            e.printStackTrace();
            System.out.println("Incorrect input of id");
            return null;
        }
    }

    public int getLatestUserId() {
        return latestUserId;
    }

    public void sortUsers() {
        userList.sort(Comparator.comparing(User::getNAME));
    }

    public ArrayList<User> getUserList() {
        return userList;
    }
}
