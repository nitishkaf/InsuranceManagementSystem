package client;

import service.UserService;
import model.User;
import java.util.Scanner;

public class UserClient {
    private UserService userService;

    public UserClient(UserService userService) {
        this.userService = userService;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("-------------------------------------------------------");
            System.out.println("1) Register");
            System.out.println("2) Login");
            System.out.println("3) Forgot Password");
            System.out.println("4) Exit");
            System.out.println("-------------------------------------------------------");

            System.out.println("Enter Your Choice:");
            int choice = sc.nextInt();
            sc.nextLine(); // Consume the newline left-over

            switch (choice) {
                case 1:
                    registerUser(sc);
                    break;
                case 2:
                    loginUser(sc);
                    break;
                case 3:
                    // Forgot password logic
                    break;
                case 4:
                    System.out.println("Thanks for Using the Insurance Management System!");
                    System.exit(0);
                default:
                    System.out.println("Please choose an option between 1 to 4");
            }
        }
    }

    private void registerUser(Scanner sc) {
        System.out.println("Enter First Name:");
        String firstName = sc.nextLine();
        System.out.println("Enter Last Name:");
        String lastName = sc.nextLine();
        System.out.println("Enter Email:");
        String email = sc.nextLine();
        System.out.println("Enter Username:");
        String username = sc.nextLine();
        System.out.println("Enter Password:");
        String password = sc.nextLine();

        User newUser = new User(); // Assuming a constructor without parameters
        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmail(email);
        newUser.setUserName(username);
        newUser.setPassword(password);

        userService.registerUser(newUser);
        System.out.println("Registration Successful!");
    }

    private void loginUser(Scanner sc) {
        System.out.println("Enter Username:");
        String username = sc.nextLine();
        System.out.println("Enter Password:");
        String password = sc.nextLine();

        if (userService.logicUser(username, password)) {
            System.out.println("Login Successful!");
        } else {
            System.out.println("Invalid Username or Password.");
        }
    }
}