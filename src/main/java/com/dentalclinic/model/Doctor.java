/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dentalclinic.model;

public class Doctor {

    private int id;
    private String fullName;
    private String specialization;
    private String phone;
    private String email;
    private String address;

    public Doctor() {
    }

    public Doctor(String fullName, String specialization,
                  String phone, String email, String address) {

        this.fullName = fullName;
        this.specialization = specialization;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public Doctor(int id, String fullName, String specialization,
                  String phone, String email, String address) {

        this.id = id;
        this.fullName = fullName;
        this.specialization = specialization;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

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

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
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
}