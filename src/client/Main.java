package client;

import dao.CategoryDAOImpl;
import dao.PolicyDAOImpl;
import dao.SubCategoryDAOImpl;
import dao.UserDAOImpl;
import service.CategoryService;
import service.PolicyService;
import service.SubCategoryService;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        UserDAOImpl userDAO = new UserDAOImpl();
        UserService userService = new UserService(userDAO);
        CategoryDAOImpl categoryDAO = new CategoryDAOImpl();
        CategoryService categoryService = new CategoryService(categoryDAO);
        SubCategoryDAOImpl subCategoryDAO = new SubCategoryDAOImpl();
        SubCategoryService subCategoryService = new SubCategoryService(subCategoryDAO);
        PolicyDAOImpl policyDAO = new PolicyDAOImpl();
        PolicyService policyService = new PolicyService(policyDAO);
        UserClient userClient = new UserClient(userService, categoryService, subCategoryService, policyService);

        userClient.run();
    }
}
