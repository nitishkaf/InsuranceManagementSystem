package client;

import dao.PolicyDAOImpl;
import dao.UserDAOImpl;
import service.CategoryService;
import service.PolicyService;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        UserDAOImpl userDAO = new UserDAOImpl();
        UserService userService = new UserService(userDAO);
        CategoryService categoryService = new CategoryService();
        PolicyDAOImpl policyDAO = new PolicyDAOImpl();
        PolicyService policyService = new PolicyService(policyDAO);
        UserClient userClient = new UserClient(userService, categoryService, policyService);

        userClient.run();
    }
}
