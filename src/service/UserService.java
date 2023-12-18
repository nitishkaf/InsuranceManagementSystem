package service;

import dao.UserDAO;
import model.User;

public class UserService {
    private UserDAO userDAO;
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(User user) {
        userDAO.addUser(user);
    }

    public boolean logicUser(String username, String password) {
        User user = userDAO.getUserByUsername(username); // Use the instance to call the method
        return user != null && user.getPassword().equals(password);
    }
}
