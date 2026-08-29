
package com.dentalclinic.dao;

import com.dentalclinic.model.Appointment;
import com.dentalclinic.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentDAO {

    // =========================
    // ADD APPOINTMENT
    // =========================
    public boolean addAppointment(Appointment appointment) {

        String sql = "INSERT INTO appointments "
                + "(patient_id, doctor_id, appointment_date, "
                + "appointment_time, status, notes) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setString(3, appointment.getAppointmentDate());
            ps.setString(4, appointment.getAppointmentTime());
            ps.setString(5, appointment.getStatus());
            ps.setString(6, appointment.getNotes());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error adding appointment: " + e.getMessage()
            );

            return false;
        }
    }


    // =========================
    // GET ALL APPOINTMENTS
    // =========================
    public List<Appointment> getAllAppointments() {

        List<Appointment> appointments = new ArrayList<>();

        String sql = "SELECT * FROM appointments ORDER BY id DESC";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {

            while (rs.next()) {

                Appointment appointment = new Appointment(
                        rs.getInt("id"),
                        rs.getInt("patient_id"),
                        rs.getInt("doctor_id"),
                        rs.getString("appointment_date"),
                        rs.getString("appointment_time"),
                        rs.getString("status"),
                        rs.getString("notes")
                );

                appointments.add(appointment);
            }

        } catch (SQLException e) {

            System.out.println(
                    "Error getting appointments: " + e.getMessage()
            );
        }

        return appointments;
    }


    // =========================
    // UPDATE APPOINTMENT
    // =========================
    public boolean updateAppointment(Appointment appointment) {

        String sql = "UPDATE appointments SET "
                + "patient_id = ?, "
                + "doctor_id = ?, "
                + "appointment_date = ?, "
                + "appointment_time = ?, "
                + "status = ?, "
                + "notes = ? "
                + "WHERE id = ?";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setString(3, appointment.getAppointmentDate());
            ps.setString(4, appointment.getAppointmentTime());
            ps.setString(5, appointment.getStatus());
            ps.setString(6, appointment.getNotes());
            ps.setInt(7, appointment.getId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error updating appointment: " + e.getMessage()
            );

            return false;
        }
    }


    // =========================
    // DELETE APPOINTMENT
    // =========================
    public boolean deleteAppointment(int id) {

        String sql =
                "DELETE FROM appointments WHERE id = ?";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps = conn.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error deleting appointment: " + e.getMessage()
            );

            return false;
        }
    }
}
