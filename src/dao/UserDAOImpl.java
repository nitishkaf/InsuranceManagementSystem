package dao;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    private List<User> users = new ArrayList<>();

    @Override
    public void addUser(User user){
        users.add(user);
    }

    @Override
    public User getUserByUsername(String username){
        return users.stream().filter(user -> user.getUserName().equals(username)).findFirst().orElse(null);
    }

    @Override
    public void updateUser(User updatedUser) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getUserName().equals(updatedUser.getUserName())) {
                users.set(i, updatedUser);
                break;
            }
        }
    }

    @Override
    public List<User> getAllUsers(){
        return new ArrayList<>(users);
    }
}
