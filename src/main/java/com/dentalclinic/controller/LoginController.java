/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dentalclinic.controller;

import com.dentalclinic.model.User;
import com.dentalclinic.service.UserService;

public class LoginController {

    private final UserService loginService;

    public LoginController() {
        loginService = new UserService();
    }

    public User login(String username, String password) {
        return loginService.login(username, password);
    }
}
