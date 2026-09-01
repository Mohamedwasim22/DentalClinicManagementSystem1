package com.dentalclinic.service;

import com.dentalclinic.dao.UserDAO;
import com.dentalclinic.model.User;
import java.util.List;

public class UserService {

    private final UserDAO userDAO;

    public UserService() {
        userDAO = new UserDAO();
    }

    // LOGIN
    public User login(String username, String password) {
        return userDAO.login(username, password);
    }

    // SAVE
    public boolean saveUser(User user) {
        return userDAO.addUser(user);
    }

    // UPDATE
    public boolean updateUser(User user) {
        return userDAO.updateUser(user);
    }

    // DELETE
    public boolean deleteUser(int id) {
        return userDAO.deleteUser(id);
    }

    // GET ALL
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    // SEARCH
    public List<User> searchUsers(String keyword) {
        return userDAO.searchUsers(keyword);
    }

    // NEXT ID
    public int getNextUserId() {
        return userDAO.getNextUserId();
    }
}