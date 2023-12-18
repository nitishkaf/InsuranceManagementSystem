package client;

import java.util.List;
import java.util.Scanner;

import model.User;
import service.UserService;

public class AdminClient {
    private UserService userService;
    private Scanner sc;

    public AdminClient(UserService userService) {
        this.userService = userService;
        this.sc = new Scanner(System.in);
    }

    public void runAdminInterface() {
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. View User List");
            System.out.println("2. Manage Categories");
            System.out.println("3. Go back");
            System.out.println("Enter choice:");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    viewUserList();
                    break;
                case 3:
                    return;

            }
        }
    }

    private void viewUserList() {
        List<User> users = userService.getAllUsers();
        if (users.isEmpty()) {
            System.out.println("No users found");
        } else {
            System.out.println("User List: ");
            for(User user: users) {
                System.out.println("ID: " + user.getUid() + " , Name: " + user.getFirstName() + " " + user.getLastName() + ", Username: " + user.getUserName());
            }
        }
    }
}
