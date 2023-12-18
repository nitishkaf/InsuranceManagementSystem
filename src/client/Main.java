package client;

import dao.UserDAOImpl;
import service.UserService;

public class Main {
    public static void main(String[] args) {
        UserDAOImpl userDAO = new UserDAOImpl();
        UserService userService = new UserService(userDAO);
        UserClient userClient = new UserClient(userService);

        userClient.run();
    }
}
