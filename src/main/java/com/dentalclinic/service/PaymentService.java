package com.dentalclinic.service;

import com.dentalclinic.dao.PaymentDAO;
import com.dentalclinic.model.Payment;

import java.util.List;

public class PaymentService {

    private PaymentDAO paymentDAO;

    public PaymentService() {
        paymentDAO = new PaymentDAO();
    }

    // GET NEXT PAYMENT ID
    public int getNextPaymentId() {
        return paymentDAO.getNextPaymentId();
    }

    // SAVE PAYMENT
    public boolean savePayment(Payment payment) {
        return paymentDAO.addPayment(payment);
    }

    // GET ALL PAYMENTS
    public List<Payment> getAllPayments() {
        return paymentDAO.getAllPayments();
    }

    // UPDATE PAYMENT
    public boolean updatePayment(Payment payment) {
        return paymentDAO.updatePayment(payment);
    }

    // DELETE PAYMENT
    public boolean deletePayment(int id) {
        return paymentDAO.deletePayment(id);
    }
}