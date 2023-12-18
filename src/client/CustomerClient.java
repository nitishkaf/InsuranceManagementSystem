package client;

import java.util.List;
import java.util.Scanner;

import model.Category;
import model.Policy;
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
        List<Category> categories = categoryService.getAllCategories();
        if (categories.isEmpty()) {
            System.out.println("No categories available.");
        } else {
            System.out.println("Categories:");
            for (Category category : categories) {
                System.out.println(category.getId() + ": " + category.getName());
            }
        }
    }


    private void viewSubCategories() {
    }

    private void applyForPolicy() {
        List<Policy> policies = policyService.getAllPolicies();
        for (Policy policy : policies) {
            System.out.println(policy.getId() + ": " + policy.getName());
        }

        System.out.println("Enter the ID of the policy to apply for:");
        int policyId = sc.nextInt();
        sc.nextLine();

        Policy selectedPolicy = policyService.getPolicyById(policyId);
        if (selectedPolicy != null) {
            policyService.applyForPolicy(loggedInUser, selectedPolicy);
        } else {
            System.out.println("Policy not found.");
        }
    }



    private void viewMyPolicies() {
        List<Policy> myPolicies = policyService.getPoliciesByUser(loggedInUser);
        if (myPolicies.isEmpty()) {
            System.out.println("You currently have no policies.");
        } else {
            System.out.println("Your Policies:");
            for (Policy policy : myPolicies) {
                System.out.println("Policy ID: " + policy.getId() + ", Name: " + policy.getName() + ", Description: " + policy.getDescription());
            }
        }
    }

}
