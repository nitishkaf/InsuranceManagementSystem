package client;

import service.UserService;

import java.util.Scanner;

public class AdminClient {
    private UserService userService;

    public AdminClient(UserService userService){
        this.userService = userService;
    }

    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter username: ");
        String username = scanner.nextLine();
        System.out.println("Enter password");
        String password = scanner.next();
    }
}
