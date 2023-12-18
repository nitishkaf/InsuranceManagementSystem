package client;

import java.util.List;
import java.util.Scanner;

import model.Category;
import model.Policy;
import model.User;
import service.PolicyService;
import service.SubCategoryService;
import service.UserService;
import service.CategoryService;

public class AdminClient {
    private UserService userService;
    private CategoryService categoryService;
    private SubCategoryService subCategoryService;
    private PolicyService policyService;
    private Scanner sc;

    public AdminClient(UserService userService, CategoryService categoryService, SubCategoryService subCategoryService, PolicyService policyService) {
        this.userService = userService;
        this.categoryService = categoryService;
        this.subCategoryService = subCategoryService;
        this.policyService = policyService;
        this.sc = new Scanner(System.in);
    }


    public void runAdminInterface() {
        while (true) {
            System.out.println("Admin Menu:");
            System.out.println("1. View User List");
            System.out.println("2. Manage Categories");
            System.out.println("3. Manage Sub-Categories");
            System.out.println("4. Manage Policies");
            System.out.println("5. Logout");
            System.out.println("Enter choice:");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    viewUserList();
                    break;
                case 2:
                    manageCategories();
                    break;
                case 3:
                    manageSubCategories();
                    break;
                case 4:
                    managePolicies();
                    break;
                case 5:
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

    private void manageCategories() {
        while (true) {
            System.out.println("Category Management:");
            System.out.println("1. Add Category");
            System.out.println("2. View Categories");
            System.out.println("3. Update Category");
            System.out.println("4. Delete Category");
            System.out.println("5. Go Back");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addCategory();
                    break;
                case 2:
                    viewCategories();
                    break;
                case 3:
                    updateCategory();
                    break;
                case 4:
                    deleteCategory();
                    break;
                case 5:
                    return;
            }
        }
    }

        private void addCategory() {
            System.out.print("Enter Category Name: ");
            String name = sc.nextLine();
            Category category = new Category();
            category.setName(name);
            categoryService.addCategory(category);
            System.out.println("Category added successfully.");
        }

        private void viewCategories() {
            List<Category> categories = categoryService.getAllCategories();
            if (categories.isEmpty()) {
                System.out.println("No categories available.");
            } else {
                System.out.println("Categories:");
                for (Category category : categories) {
                    System.out.println("ID: " + category.getId() + ", Name: " + category.getName());
                }
            }
        }

        private void updateCategory() {
            System.out.print("Enter Category ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();
            Category category = categoryService.getCategoryById(id);
            if (category != null) {
                System.out.print("Enter new name for Category: ");
                String newName = sc.nextLine();
                category.setName(newName);
                categoryService.updateCategory(category);
                System.out.println("Category updated successfully.");
            } else {
                System.out.println("Category not found.");
            }
        }

        private void deleteCategory() {
            System.out.print("Enter Category ID to delete: ");
            int id = sc.nextInt();
            sc.nextLine();
            categoryService.deleteCategory(id);
            System.out.println("Category deleted successfully.");
        }

    private void manageSubCategories() {
    }

    private void managePolicies() {
        while (true) {
            System.out.println("Manage Policies:");
            System.out.println("1. Add Policy");
            System.out.println("2. View Policy");
            System.out.println("3. Update Policy");
            System.out.println("4. Delete Policy");
            System.out.println("5. Go Back");
            System.out.println("Enter choice:");

            int policyChoice = sc.nextInt();
            sc.nextLine();

            switch (policyChoice) {
                case 1:
                    addPolicy();
                    break;
                case 2:
                    viewPolicies();
                    break;
                case 3:
                    updatePolicy();
                    break;
                case 4:
                    deletePolicy();
                    break;
                case 5:
                    return;
            }
        }
    }

        private void addPolicy() {
            System.out.print("Enter Policy Name: ");
            String name = sc.nextLine();
            System.out.print("Enter Policy Description: ");
            String description = sc.nextLine();
            System.out.print("Enter Policy Price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            Policy policy = new Policy();
            policy.setName(name);
            policy.setDescription(description);
            policy.setPrice(price);
            policyService.addPolicy(policy);
            System.out.println("Policy added successfully.");
        }

        private void viewPolicies() {
            List<Policy> policies = policyService.getAllPolicies();
            if (policies.isEmpty()) {
                System.out.println("No policies available.");
            } else {
                System.out.println("Policies:");
                for (Policy policy : policies) {
                    System.out.println("ID: " + policy.getId() + ", Name: " + policy.getName() + ", Price: " + policy.getPrice());
                }
            }
        }

        private void updatePolicy() {
            System.out.print("Enter Policy ID to update: ");
            int id = sc.nextInt();
            sc.nextLine();
            Policy policy = policyService.getPolicyById(id);
            if (policy != null) {
                System.out.print("Enter new name for Policy: ");
                String newName = sc.nextLine();
                policy.setName(newName);
                policyService.updatePolicy(policy);
                System.out.println("Policy updated successfully.");
            } else {
                System.out.println("Policy not found.");
            }
        }

        private void deletePolicy() {
            System.out.print("Enter Policy ID to delete: ");
            int id = sc.nextInt();
            sc.nextLine();
            policyService.deletePolicy(id);
            System.out.println("Policy deleted successfully.");
        }
}
