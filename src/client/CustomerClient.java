package client;

import java.util.Scanner;
import service.CategoryService;
import service.PolicyService;
import model.User;

public class CustomerClient {
    private CategoryService categoryService;
    private PolicyService policyService;
    private User loggedInUser;
    private Scanner sc;

    public CustomerClient(CategoryService categoryService, PolicyService policyService, User loggedInUser) {
        this.categoryService = categoryService;
        this.policyService = policyService;
        this.loggedInUser = loggedInUser;
        this.sc = new Scanner(System.in);
    }

    public void runCustomerInterface() {
        while (true) {
            System.out.println("Customer Menu:");
            System.out.println("1. View Categories");
            System.out.println("2. View Sub-Categories");
            System.out.println("3. Apply for a Policy");
            System.out.println("4. View My Policies");
            System.out.println("5. Logout");
            System.out.println("Enter choice:");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewCategories();
                    break;
                case 2:
                    viewSubCategories();
                    break;
                case 3:
                    applyForPolicy();
                    break;
                case 4:
                    viewMyPolicies();
                    break;
                case 5:
                    return;
            }
        }
    }

    private void viewCategories() {
    }

    private void viewSubCategories() {
    }

    private void applyForPolicy() {
    }

    private void viewMyPolicies() {
    }
}
