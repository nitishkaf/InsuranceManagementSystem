package service;

import dao.UserDAO;
import model.User;

import java.util.List;

public class UserService {
    private UserDAO userDAO;
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public void registerUser(User user) {
        userDAO.addUser(user);
    }

    public User logicUser(String username, String password) {
        User user = userDAO.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            return user;
        }
        return null;
    }

    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public List<User> getAllUsers(){
        return userDAO.getAllUsers();
    }
}
