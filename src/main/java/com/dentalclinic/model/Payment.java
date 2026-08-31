package com.dentalclinic.model;

public class Payment {

    private int id;
    private int patientId;
    private String paymentDate;
    private double amount;
    private String paymentMethod;
    private String status;
    private String description;

    // =========================
    // EMPTY CONSTRUCTOR
    // =========================
    public Payment() {
    }

    // =========================
    // CONSTRUCTOR WITHOUT ID
    // =========================
    public Payment(
            int patientId,
            String paymentDate,
            double amount,
            String paymentMethod,
            String status,
            String description) {

        this.patientId = patientId;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.description = description;
    }

    // =========================
    // CONSTRUCTOR WITH ID
    // =========================
    public Payment(
            int id,
            int patientId,
            String paymentDate,
            double amount,
            String paymentMethod,
            String status,
            String description) {

        this.id = id;
        this.patientId = patientId;
        this.paymentDate = paymentDate;
        this.amount = amount;
        this.paymentMethod = paymentMethod;
        this.status = status;
        this.description = description;
    }

    // =========================
    // GETTERS & SETTERS
    // =========================

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}