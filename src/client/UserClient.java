package client;

import dao.UserDAOImpl;

import java.util.Scanner;

public class UserClient {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        UserDAOImpl userDAO = new UserDAOImpl();

        while(true){
            System.out.println("-------------------------------------------------------");
            System.out.println("1) Register");
            System.out.println("2) Login");
            System.out.println("3) Forgot Password");
            System.out.println("4) Exit");
            System.out.println("-------------------------------------------------------");

            System.out.println("Enter Your Choice:");
            int choice = sc.nextInt();

            switch(choice){
                case 1:
                    // userDAO.addUser(); // Implement addUser
                    break;
                case 2:
                    System.out.println("Enter the Username:");
                    String uname = sc.next();
                    System.out.println("Enter the Password:");
                    String pass = sc.next();

                    // implement login feature by calling userDAO with the role
                    System.out.println("Invalid Username or Password");
                    break;
                case 3:
                    System.out.println("Enter Email:");
                    String email = sc.next();
                    // implement a forgot password method
                    break;
                case 4:
                    System.out.println("Thanks for Using the Insurance Management System!");
                    System.exit(0);
                default:
                    System.out.println("Please choose an option between 1 to 4");
            }
        }
    }
}
