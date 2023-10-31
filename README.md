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
    System.out.println("Namn på ny användare: ");
    String userNameToAdd = scanner.nextLine().trim();
    System.out.println("Email för ny användare: ");
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
public void addUser(String userName, String email) {
    if (userName.isBlank() || email.isBlank()) {
        System.out.println("Namn eller email kan inte vara blanka.");
    } else {
        int newUserId = nextUserId;
        nextUserId++;
        latestUserId++;


        User newUser = new User(newUserId, userName, email);
        userList.add(newUser);
        System.out.println(userName + " har lagts till.");
    }
}
```
