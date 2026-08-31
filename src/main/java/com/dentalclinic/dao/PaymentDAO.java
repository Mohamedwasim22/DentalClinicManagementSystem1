package com.dentalclinic.dao;

import com.dentalclinic.model.Payment;
import com.dentalclinic.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

public class PaymentDAO {

    // =========================
    // GET NEXT PAYMENT ID
    // =========================
    public int getNextPaymentId() {

        String sql =
                "SELECT COALESCE(MAX(id), 0) + 1 FROM payments";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps =
                    conn.prepareStatement(sql);
            ResultSet rs =
                    ps.executeQuery()
        ) {

            if (rs.next()) {
                return rs.getInt(1);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error getting next payment ID: "
                    + e.getMessage()
            );
        }

        return 1;
    }


    // =========================
    // ADD PAYMENT
    // =========================
    public boolean addPayment(Payment payment) {

        String sql =
                "INSERT INTO payments "
                + "(patient_id, payment_date, amount, "
                + "payment_method, status, description) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps =
                    conn.prepareStatement(sql)
        ) {

            ps.setInt(
                    1,
                    payment.getPatientId()
            );

            ps.setString(
                    2,
                    payment.getPaymentDate()
            );

            ps.setDouble(
                    3,
                    payment.getAmount()
            );

            ps.setString(
                    4,
                    payment.getPaymentMethod()
            );

            ps.setString(
                    5,
                    payment.getStatus()
            );

            ps.setString(
                    6,
                    payment.getDescription()
            );

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error adding payment: "
                    + e.getMessage()
            );

            e.printStackTrace();

            return false;
        }
    }


    // =========================
    // GET ALL PAYMENTS
    // =========================
    public List<Payment> getAllPayments() {

        List<Payment> payments =
                new ArrayList<>();

        String sql =
                "SELECT * FROM payments ORDER BY id DESC";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps =
                    conn.prepareStatement(sql);
            ResultSet rs =
                    ps.executeQuery()
        ) {

            while (rs.next()) {

                Payment payment =
                        new Payment(
                                rs.getInt("id"),
                                rs.getInt("patient_id"),
                                rs.getString("payment_date"),
                                rs.getDouble("amount"),
                                rs.getString("payment_method"),
                                rs.getString("status"),
                                rs.getString("description")
                        );

                payments.add(payment);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error getting payments: "
                    + e.getMessage()
            );

            e.printStackTrace();
        }

        return payments;
    }


    // =========================
    // UPDATE PAYMENT
    // =========================
    public boolean updatePayment(Payment payment) {

        String sql =
                "UPDATE payments SET "
                + "patient_id = ?, "
                + "payment_date = ?, "
                + "amount = ?, "
                + "payment_method = ?, "
                + "status = ?, "
                + "description = ? "
                + "WHERE id = ?";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps =
                    conn.prepareStatement(sql)
        ) {

            ps.setInt(
                    1,
                    payment.getPatientId()
            );

            ps.setString(
                    2,
                    payment.getPaymentDate()
            );

            ps.setDouble(
                    3,
                    payment.getAmount()
            );

            ps.setString(
                    4,
                    payment.getPaymentMethod()
            );

            ps.setString(
                    5,
                    payment.getStatus()
            );

            ps.setString(
                    6,
                    payment.getDescription()
            );

            ps.setInt(
                    7,
                    payment.getId()
            );

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error updating payment: "
                    + e.getMessage()
            );

            e.printStackTrace();

            return false;
        }
    }


    // =========================
    // DELETE PAYMENT
    // =========================
    public boolean deletePayment(int id) {

        String sql =
                "DELETE FROM payments WHERE id = ?";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps =
                    conn.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error deleting payment: "
                    + e.getMessage()
            );

            e.printStackTrace();

            return false;
        }
    }
}