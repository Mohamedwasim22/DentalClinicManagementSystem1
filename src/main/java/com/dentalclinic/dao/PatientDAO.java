package com.dentalclinic.dao;

import com.dentalclinic.model.Patient;
import com.dentalclinic.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.dentalclinic.model.Patient;



public class PatientDAO {

    // =========================
    // ADD PATIENT
    // =========================
    public boolean addPatient(Patient patient) {

        String sql = "INSERT INTO patients "
                + "(full_name, age, gender, phone, email, address, register_date) "
                + "VALUES (?, ?, ?, ?, ?, ?, CURDATE())";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setString(1, patient.getFullName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());
            ps.setString(5, patient.getEmail());
            ps.setString(6, patient.getAddress());

            int rowsInserted = ps.executeUpdate();

            return rowsInserted > 0;

        } catch (SQLException e) {

            System.out.println("Error adding patient: " + e.getMessage());

            return false;
        }
    }


    // =========================
    // GET ALL PATIENTS
    // =========================
    public List<Patient> getAllPatients() {

        List<Patient> patients = new ArrayList<>();

        String sql = "SELECT * FROM patients ORDER BY id DESC";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Patient patient = new Patient(
                        rs.getInt("id"),
                        rs.getString("full_name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("phone"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getString("register_date")
                );

                patients.add(patient);
            }

        } catch (SQLException e) {

            System.out.println("Error getting patients: " + e.getMessage());
        }

        return patients;
    }


    // =========================
    // UPDATE PATIENT
    // =========================
   


    // =========================
    // DELETE PATIENT
    // =========================
    public boolean deletePatient(int id) {

        String sql = "DELETE FROM patients WHERE id = ?";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            int rowsDeleted = ps.executeUpdate();

            return rowsDeleted > 0;

        } catch (SQLException e) {

            System.out.println("Error deleting patient: " + e.getMessage());

            return false;
        }
    }
    public boolean updatePatient(Patient patient) {

    String sql = "UPDATE patients SET "
            + "full_name = ?, "
            + "age = ?, "
            + "gender = ?, "
            + "phone = ?, "
            + "email = ?, "
            + "address = ? "
            + "WHERE id = ?";

    try (
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)
    ) {

        ps.setString(1, patient.getFullName());
        ps.setInt(2, patient.getAge());
        ps.setString(3, patient.getGender());
        ps.setString(4, patient.getPhone());
        ps.setString(5, patient.getEmail());
        ps.setString(6, patient.getAddress());
        ps.setInt(7, patient.getId());

        return ps.executeUpdate() > 0;

    } catch (SQLException e) {

        System.out.println("Error updating patient: " + e.getMessage());
        return false;
    }
}
    public List<Patient> searchPatients(String keyword) {

    List<Patient> patientList = new ArrayList<>();

    String sql = "SELECT * FROM patients "
            + "WHERE full_name LIKE ? "
            + "OR phone LIKE ? "
            + "OR email LIKE ?";

    try (
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql)
    ) {

        String searchKeyword = "%" + keyword + "%";

        ps.setString(1, searchKeyword);
        ps.setString(2, searchKeyword);
        ps.setString(3, searchKeyword);

        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

            Patient patient = new Patient();

            patient.setId(rs.getInt("id"));
            patient.setFullName(rs.getString("full_name"));
            patient.setAge(rs.getInt("age"));
            patient.setGender(rs.getString("gender"));
            patient.setPhone(rs.getString("phone"));
            patient.setEmail(rs.getString("email"));
            patient.setAddress(rs.getString("address"));
            patient.setRegisterDate(rs.getString("register_date"));

            patientList.add(patient);
        }

    } catch (SQLException e) {
        System.out.println("Error searching patients: " + e.getMessage());
    }

    return patientList;
}
    public List<Patient> getPatientListForComboBox() {

    List<Patient> patients = new ArrayList<>();

    String sql = "SELECT id, full_name FROM patients ORDER BY full_name";

    try (Connection con = DBConnection.getConnection();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {

            Patient patient = new Patient();

            patient.setId(rs.getInt("id"));
            patient.setFullName(rs.getString("full_name"));

            patients.add(patient);
        }

    } catch (SQLException e) {
        System.out.println("Error loading patients: " + e.getMessage());
    }

    return patients;
}
}
