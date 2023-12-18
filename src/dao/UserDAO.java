package dao;

import model.User;

import java.util.List;

public interface UserDAO {

    User getUserByUsername(String username);

    void addUser(User user);

    void updateUser(User updatedUser);

    List<User> getAllUsers();
}
