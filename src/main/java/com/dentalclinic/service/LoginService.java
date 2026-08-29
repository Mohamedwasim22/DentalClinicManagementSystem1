/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dentalclinic.service;

import com.dentalclinic.dao.UserDAO;
import com.dentalclinic.model.User;

public class LoginService {

    private final UserDAO userDAO;

    public LoginService() {
        userDAO = new UserDAO();
    }

    public User login(String username, String password) {

        if (username == null || username.trim().isEmpty()) {
            return null;
        }

        if (password == null || password.trim().isEmpty()) {
            return null;
        }

        return userDAO.login(username, password);
    }
}
