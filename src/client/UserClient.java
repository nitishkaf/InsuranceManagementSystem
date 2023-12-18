package client;

import service.CategoryService;
import service.PolicyService;
import service.UserService;
import model.User;
import java.util.Scanner;

public class UserClient {
    private UserService userService;
    private CategoryService categoryService;
    private PolicyService policyService;

    public UserClient(UserService userService, CategoryService categoryService, PolicyService policyService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.policyService = policyService;
    }

    public void run() {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

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
                    forgotPassword(sc);
                    break;
                case 4:
                    running = false;
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

        User newUser = new User();
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

        User user = userService.logicUser(username, password);

        if (user != null){
            System.out.println("Login Successful!");
            if("Admin".equals(user.getRoleName())){
                AdminClient adminClient = new AdminClient(userService);
                adminClient.runAdminInterface();
            }
            if ("Customer".equals(user.getRoleName())) {
                CustomerClient customerClient = new CustomerClient(categoryService, policyService, user);
                customerClient.runCustomerInterface();
            }
        } else {
            System.out.println("Invalid Username or Password.");
        }
    }

    private void forgotPassword(Scanner sc) {
        System.out.println("Enter your Username:");
        String username = sc.nextLine();

        User user = userService.getUserByUsername(username);
        if (user != null) {
            System.out.println("Enter your new password:");
            String newPassword = sc.nextLine();
            user.setPassword(newPassword);
            userService.updateUser(user);
            System.out.println("Password successfully updated.");
        } else {
            System.out.println("User not found.");
        }
    }

}