# OOP Assignment

This is an assignment to create a simple console application
that handles a list of users.
The application is to be written in Java and make use of
object orientated principles and data structure.

In addition there is to be documentation on how to install and run
the application in a Linux/Ubuntu environment and a analysis 
and documentation of how clean code principles were applied.


## How to install and run this application in Linux/Ubuntu

First control that your apt is updated by typing:

`sudo apt update`

And then to check if Java is installed type:

`javac -version`

If java is installed you will be shown which version is installed.
or you will get a list of versions that can be installed.

If Java is not installed, type:

`sudo apt install default-jdk`

Verify that the installation worked by once again typing:
`javac -version`

If you want to update a newer version of Java, type:

`sudo apt update`

to see a list of available packages and versions.
Then type:

`sudo apt upgrade`

and all your software will be updated to the latest version.

In order to compile and run this project navigate to the
directory that holds the .java files for the project and type:

`javac *.java`

After that, to run the application type:
`java Main.java`



## Application of Clean Code principles for this project

For this project I have applied clean code principles for naming to class, method and variable names.
Due to this I have managed to avoid superfluous comments explaining the code to myself and people around my
experience level in Java.

### Example:
```java
case 2:
    // User .trim to account for unexpected whitespaces.
    System.out.println("Input the name of the new user: ");
    String userNameToAdd = scanner.nextLine().trim();
    System.out.println("Input the email of the new user: ");
    String userEmailToAdd = scanner.nextLine().trim();

    userList.addUser(userNameToAdd, userEmailToAdd);
    break;
```

For this segment I have limited my comment to explaining my use of .trim since it's not obvious to other people around 
my own experience level.
The variables
``userNameToAdd`` and ``userEmailToAdd`` are named in a way that clearly explain what they contain and are used for.

The method ``addUser`` is likewise clearly named in such a way that it is obvious what it does.


The classes themselves are named clearly for their purpose, there are four classes named:
`Main` `User` `UserList` and `UserPrinter`.

`Main` contains the menu navigation and certain exception checks. <br>
`User` contains everything about the User objects.<br>
`UserList` manages the functions around the list of users.<br>
`UserPrinter` handles printing of specific users or all users in the list.

### Example
```java
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
```
In this example I try to keep adhering to clear and obvious naming conventions that means no need for comments even for 
people that are still fairly new to coding, addUser as the method name and newUserId, nextUserId, userName and userEmail
as the name of variables and newUser as the name of the User object.

### Example
```java
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
```
The one area where I deemed it prudent to add more comments was error handling. At my current experience level it is still
very much a learning area and I had to use multiple try/catches in order to catch incorrect inputs from the user
and output a message about just what they did wrong.
