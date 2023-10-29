package org.example;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        UserList userList = new UserList();

        // Add example users to the ArrayList in the userList class
        userList.addUser("Geetika", "Geetika@example.com");
        userList.addUser("Adam", "Adam@example.com");
        userList.addUser("Linus", "Linus@example.com");


        // Create a boolean to verify if the program should keep running or not through a while-loop.
        boolean shouldExit = false;
        while (!shouldExit) {

            // Display a simple menu to the user with the inputs for each function.
            System.out.println("Ange ditt val (1-5): \n");
            System.out.println("1. Visa användare. " +
                    "\n2. Lägg till användare. " +
                    "\n3. Ta bort användare. " +
                    "\n4. Sök efter användare med id. " +
                    "\n5. Stäng programmet.");

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

                            // Call method based on user inputs.
                            userList.addUser(userNameToAdd, userEmailToAdd);
                            break;

                        case 3:
                            try {
                            // Ask for and create a variable based on user input.
                            System.out.println("Id för användaren som ska tas bort: ");

                            // Get user input as string and convert to int in order to easier avoid and catch
                            // exceptions due to invalid inputs.
                            String idToRemoveInput = scanner.nextLine();
                            int idToRemove = Integer.parseInt(idToRemoveInput);

                            // Call method to identify user by id.
                            var userToRemove = userList.searchUserById(idToRemove);

                            if (userToRemove != null) {
                                userList.removeUser(idToRemove);
                                // Print the name of the user that was removed.
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
                                // Ask for and create a variable based on user input.
                                System.out.println("Ange id för användaren som ska sökas upp: ");

                                // Get user input as string and convert to int in order to easier avoid and catch
                                // exceptions due to invalid inputs.
                                String idToSearchForInput = scanner.nextLine();
                                int idToSearchFor = Integer.parseInt(idToSearchForInput);

                                // Call method to identify user by id and then print the information for that user
                                // through another method.
                                var foundUser = userList.searchUserById(idToSearchFor);

                                // Check if input id is in the list, print user if it is, else print user not found.
                                if (foundUser != null) {
                                    UserPrinter.printUser(foundUser);
                                } else {
                                    System.out.println("Användaren hittades inte.");
                                }
                            // Catch invalid inputs and display message to notify user.
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