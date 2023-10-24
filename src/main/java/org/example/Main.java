package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UserList userList = new UserList();

        userList.addUser("Geetika", "Geetika@example.com");
        userList.addUser("Adam", "Adam@example.com");
        userList.addUser("Linus", "Linus@example.com");



        ArrayList<User> users = userList.getUsers();

        while (true) {
            System.out.println("Ange ditt val: \n");
            System.out.println("""
                    1. Visa användare.\s
                    2. Lägg till användare.\s
                    3. Ta bort användare.\s
                    4. Sök efter användare med id.\s
                    5. Stäng programmet.""");
            try {
                String input = scanner.nextLine();
                int switcher = Integer.parseInt(input);

                switch (switcher) {


                    case 1:
                        userList.sortUsers();
                        for (User user : users) {
                            System.out.println("ID: " + user.getId() + ", Namn: " + user.getName() + ", Email: " + user.getEmail());
                        }
                        break;

                    case 2:
                        System.out.println("Namn på ny användare: ");
                        String userNameToAdd = scanner.nextLine().trim();
                        System.out.println("Email för ny användare: ");
                        String userEmailToAdd = scanner.nextLine().trim();

                        userList.addUser(userNameToAdd, userEmailToAdd);
                        break;

                    case 3:
                        System.out.println("Id för användaren som ska tas bort: ");
                        String idToRemoveInput = scanner.nextLine();
                        int idToRemove = Integer.parseInt(idToRemoveInput);

                        var userToRemove = userList.searchUserById(idToRemove);
                        userList.removeUser(idToRemove);
                        System.out.println(userToRemove.getName() + " har tagits bort.");
                        break;

                    case 4:
                        System.out.println("Ange id för användaren som ska sökas upp: ");
                        String idToSearchForInput = scanner.nextLine();
                        int idToSearchFor = Integer.parseInt(idToSearchForInput);
                        var foundUser = userList.searchUserById(idToSearchFor);
                        System.out.println(foundUser.toString());

                        break;
                    case 5:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Felaktigt val. Försök igen.");
                        break;
                }


            } catch (NumberFormatException e) {
                System.out.println("Ogiltigt tecken. Försök igen.");
            }
        }

    }


}