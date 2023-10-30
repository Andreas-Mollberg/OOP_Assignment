package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UserList userList = new UserList();

        // Add example users
        userList.addUser("Geetika", "Geetika@example.com");
        userList.addUser("Adam", "Adam@example.com");
        userList.addUser("Linus", "Linus@example.com");



        boolean shouldExit = false;
        while (!shouldExit) {


            System.out.println("Ange ditt val (1-5): \n");
            System.out.println("""
                    1. Visa användare.\s
                    2. Lägg till användare.\s
                    3. Ta bort användare.\s
                    4. Sök efter användare med id.\s
                    5. Stäng programmet.""");

            try {
                // Get user input as string and convert to int in order to easier avoid and catch
                // exceptions due to invalid inputs.
                String input = scanner.nextLine();
                int selectedOption = Integer.parseInt(input);

                // Extra check to make sure the user does not enter a menu option outside the range.
                if (selectedOption >= 1 && selectedOption <= 5) {
                    switch (selectedOption) {
                        case 1:
                            userList.sortUsers();
                            UserPrinter.printUsers(userList.getUserList());
                            break;

                        case 2:
                            // Ask for and create variables based on user input.
                            // User .trim to account for unexpected whitespaces.
                            System.out.println("Namn på ny användare: ");
                            String userNameToAdd = scanner.nextLine().trim();
                            System.out.println("Email för ny användare: ");
                            String userEmailToAdd = scanner.nextLine().trim();

                            userList.addUser(userNameToAdd, userEmailToAdd);
                            break;

                        case 3:
                            try {

                            System.out.println("Id för användaren som ska tas bort: ");

                            // Get user input as string and convert to int in order to easier avoid and catch
                            // exceptions due to invalid inputs.
                            String idToRemoveInput = scanner.nextLine();
                            int idToRemove = Integer.parseInt(idToRemoveInput);

                            var userToRemove = userList.searchUserById(idToRemove);

                            if (userToRemove != null) {
                                userList.removeUser(idToRemove);

                                System.out.println(userToRemove.getName() + " har tagits bort.");
                            } else {
                                System.out.println("Användaren hittades inte.");
                            }
                            }catch (NumberFormatException e) {
                                System.out.println("Ogiltigt tecken. Ange ett giltigt ID.");
                            }
                            break;

                        case 4:
                            try {
                                System.out.println("Ange id för användaren som ska sökas upp: ");

                                // Get user input as string and convert to int in order to easier avoid and catch
                                // exceptions due to invalid inputs.
                                String idToSearchForInput = scanner.nextLine();
                                int idToSearchFor = Integer.parseInt(idToSearchForInput);
                                
                                var foundUser = userList.searchUserById(idToSearchFor);

                                if (foundUser != null) {
                                    UserPrinter.printUser(foundUser);
                                } else {
                                    System.out.println("Användaren hittades inte.");
                                }

                            }catch (NumberFormatException e) {
                                System.out.println("Ogiltigt tecken. Ange ett giltigt ID.");
                            }
                            break;
                        case 5:
                            // Flag the boolean shouldExit to true in order to close the program.
                            shouldExit = true;
                            break;

                        // Default message in case the user enters a menu option that's not valid.
                        default:
                            System.out.println("Felaktigt val. Försök igen.");
                            break;
                    }

                // Message to display in case the user inputs a valid number but outside the range.
                } else {
                    System.out.println("Ogiltigt nummer. Ange ett tal mellan 1 och 5");
                }
            // Catch and display a message in case the user inputs an invalid input.
            } catch (NumberFormatException e) {
                System.out.println("Ogiltigt tecken. Försök igen.");
            }
        }

    }


}