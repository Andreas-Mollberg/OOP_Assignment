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


            System.out.println("Input selection: \n");
            System.out.println("""
                    1. Show users.\s
                    2. Add user.\s
                    3. Delete user.\s
                    4. Search for user by id.\s
                    5. Exit the application.""");

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
                            UserPrinter.printUserList(userList.getUserList());
                            break;

                        case 2:
                            // User .trim to account for unexpected whitespaces.
                            System.out.println("Input the name of the new user: ");
                            String userNameToAdd = scanner.nextLine().trim();
                            System.out.println("Input the email of the new user: ");
                            String userEmailToAdd = scanner.nextLine().trim();

                            userList.addUser(userNameToAdd, userEmailToAdd);
                            break;

                        case 3:
                            try {

                                System.out.println("Input the id of the user you wish to delete: ");

                                // Get user input as string and convert to int in order to easier avoid and catch
                                // exceptions due to invalid inputs.
                                String idToRemoveInput = scanner.nextLine();
                                int idToRemove = Integer.parseInt(idToRemoveInput);

                                userList.removeUser(idToRemove);

                            } catch (NumberFormatException e) {
                                System.out.println("Invalid character. Please enter a valid id.");
                            }
                            break;

                        case 4:
                            try {
                                System.out.println("Input the id of the character you wish to search for: ");

                                // Get user input as string and convert to int in order to easier avoid and catch
                                // exceptions due to invalid inputs.
                                String idToSearchForInput = scanner.nextLine();
                                int idToSearchFor = Integer.parseInt(idToSearchForInput);

                                var foundUser = userList.searchUserById(idToSearchFor);
                                UserPrinter.printUser(foundUser);

                            } catch (NumberFormatException e) {
                                System.out.println("Invalid character. Please enter a valid id.");
                            }
                            break;

                        case 5:
                            // Flag the boolean shouldExit to true in order to close the program.
                            shouldExit = true;
                            break;

                        // Default message in case the user enters a menu option that's not valid.
                        default:
                            System.out.println("Invalid input. Please try again.");
                            break;
                    }

                    // Message to display in case the user inputs a valid number but outside the range.
                } else {
                    System.out.println("Invalid number, enter a number between 1 and 5.");
                }
                // Catch and display a message in case the user inputs an invalid input.
            } catch (NumberFormatException e) {
                System.out.println("Invalid character. Please try again.");
            }
        }

    }


}