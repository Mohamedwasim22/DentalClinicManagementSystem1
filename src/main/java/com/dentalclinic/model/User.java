package com.dentalclinic.model;

public class User {

    private int id;
    private String username;
    private String password;
    private String role;
    private String status;

    // =========================
    // EMPTY CONSTRUCTOR
    // =========================
    public User() {
    }

    // =========================
    // CONSTRUCTOR WITHOUT ID
    // =========================
    public User(String username, String password, String role, String status) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    // =========================
    // CONSTRUCTOR WITH ID
    // =========================
    public User(int id, String username, String password,
                String role, String status) {

        this.id = id;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    // =========================
    // GETTERS
    // =========================

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public String getStatus() {
        return status;
    }

    // =========================
    // SETTERS
    // =========================

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return username;
    }
}