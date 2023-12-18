package client;

import dao.UserDAOImpl;
import service.CategoryService;
import service.PolicyService;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        UserDAOImpl userDAO = new UserDAOImpl();
        UserService userService = new UserService(userDAO);
        CategoryService categoryService = new CategoryService();
        PolicyService policyService = new PolicyService();
        UserClient userClient = new UserClient(userService, categoryService, policyService);

        userClient.run();
    }
}
