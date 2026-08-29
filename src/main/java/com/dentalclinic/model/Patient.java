/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.dentalclinic.model;

public class Patient {

    private int id;
    private String fullName;
    private int age;
    private String gender;
    private String phone;
    private String email;
    private String address;
    private String registerDate;

    // Empty Constructor
    public Patient() {
    }

    // Constructor without ID
    public Patient(String fullName, int age, String gender,
                   String phone, String email,
                   String address, String registerDate) {

        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.registerDate = registerDate;
    }

    // Constructor with ID
    public Patient(int id, String fullName, int age, String gender,
                   String phone, String email,
                   String address, String registerDate) {

        this.id = id;
        this.fullName = fullName;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.registerDate = registerDate;
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(String registerDate) {
        this.registerDate = registerDate;
    }
}


