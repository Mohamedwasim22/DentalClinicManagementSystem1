/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dentalclinic.dao;

import com.dentalclinic.model.Doctor;
import com.dentalclinic.util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAO {

    // ADD DOCTOR
    public boolean addDoctor(Doctor doctor) {

        String sql = "INSERT INTO doctors "
                + "(full_name, specialization, phone, email, address) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, doctor.getFullName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getPhone());
            ps.setString(4, doctor.getEmail());
            ps.setString(5, doctor.getAddress());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error adding doctor: " + e.getMessage());
            return false;
        }
    }

    // GET ALL DOCTORS
    public List<Doctor> getAllDoctors() {

        List<Doctor> doctors = new ArrayList<>();

        String sql = "SELECT * FROM doctors ORDER BY id DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Doctor doctor = new Doctor(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getString("specialization"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address")
                );

                doctors.add(doctor);
            }

        } catch (SQLException e) {
            System.out.println("Error loading doctors: " + e.getMessage());
        }

        return doctors;
    }

    // UPDATE DOCTOR
    public boolean updateDoctor(Doctor doctor) {

        String sql = "UPDATE doctors SET "
                + "full_name=?, specialization=?, phone=?, "
                + "email=?, address=? "
                + "WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, doctor.getFullName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getPhone());
            ps.setString(4, doctor.getEmail());
            ps.setString(5, doctor.getAddress());
            ps.setInt(6, doctor.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error updating doctor: " + e.getMessage());
            return false;
        }
    }

    // DELETE DOCTOR
    public boolean deleteDoctor(int id) {

        String sql = "DELETE FROM doctors WHERE id=?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Error deleting doctor: " + e.getMessage());
            return false;
        }
    }

    // SEARCH DOCTORS
    public List<Doctor> searchDoctors(String keyword) {

        List<Doctor> doctors = new ArrayList<>();

        String sql = "SELECT * FROM doctors "
                + "WHERE full_name LIKE ? "
                + "OR specialization LIKE ? "
                + "OR phone LIKE ? "
                + "OR email LIKE ? "
                + "ORDER BY id DESC";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            String search = "%" + keyword + "%";

            ps.setString(1, search);
            ps.setString(2, search);
            ps.setString(3, search);
            ps.setString(4, search);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Doctor doctor = new Doctor(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getString("specialization"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address")
                );

                doctors.add(doctor);
            }

        } catch (SQLException e) {
            System.out.println("Error searching doctors: " + e.getMessage());
        }

        return doctors;
    }
}