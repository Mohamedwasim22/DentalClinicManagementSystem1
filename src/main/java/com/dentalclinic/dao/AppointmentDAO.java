package com.dentalclinic.dao;

import com.dentalclinic.model.Appointment;
import com.dentalclinic.util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import java.sql.Time;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

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

            // =========================
            // DATE
            // yyyy-MM-dd
            // =========================

            LocalDate date = LocalDate.parse(
                    appointment.getAppointmentDate(),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd")
            );

            ps.setDate(3, Date.valueOf(date));

            // =========================
            // TIME
            // =========================

            String timeText =
                    appointment.getAppointmentTime().trim();

            LocalTime time;

            try {

                // Example: 11:00 AM
                time = LocalTime.parse(
                        timeText,
                        DateTimeFormatter.ofPattern("hh:mm a")
                );

            } catch (Exception e) {

                // Example: 11:00
                time = LocalTime.parse(
                        timeText,
                        DateTimeFormatter.ofPattern("HH:mm")
                );
            }

            ps.setTime(4, Time.valueOf(time));

            // =========================
            // STATUS
            // =========================

            ps.setString(
                    5,
                    appointment.getStatus()
            );

            // =========================
            // NOTES / REASON
            // =========================

            ps.setString(
                    6,
                    appointment.getNotes()
            );

            // =========================
            // EXECUTE
            // =========================

            int result = ps.executeUpdate();

            System.out.println(
                    "Appointment Insert Result: " + result
            );

            return result > 0;

        } catch (Exception e) {

            System.out.println(
                    "======================================"
            );

            System.out.println(
                    "ERROR ADDING APPOINTMENT"
            );

            System.out.println(
                    "======================================"
            );

            e.printStackTrace();

            return false;
        }
    }


    // =========================
    // GET ALL APPOINTMENTS
    // =========================
    public List<Appointment> getAllAppointments() {

        List<Appointment> appointments =
                new ArrayList<>();

        String sql =
                "SELECT * FROM appointments ORDER BY id DESC";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps =
                    conn.prepareStatement(sql);
            ResultSet rs =
                    ps.executeQuery()
        ) {

            while (rs.next()) {

                Appointment appointment =
                        new Appointment(
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
                    "Error getting appointments: "
                    + e.getMessage()
            );

            e.printStackTrace();
        }

        return appointments;
    }


    // =========================
    // UPDATE APPOINTMENT
    // =========================
    public boolean updateAppointment(
            Appointment appointment) {

        String sql =
                "UPDATE appointments SET "
                + "patient_id = ?, "
                + "doctor_id = ?, "
                + "appointment_date = ?, "
                + "appointment_time = ?, "
                + "status = ?, "
                + "notes = ? "
                + "WHERE id = ?";

        try (
            Connection conn = DBConnection.getConnection();
            PreparedStatement ps =
                    conn.prepareStatement(sql)
        ) {

            ps.setInt(
                    1,
                    appointment.getPatientId()
            );

            ps.setInt(
                    2,
                    appointment.getDoctorId()
            );

            // DATE

            LocalDate date = LocalDate.parse(
                    appointment.getAppointmentDate(),
                    DateTimeFormatter.ofPattern("yyyy-MM-dd")
            );

            ps.setDate(
                    3,
                    Date.valueOf(date)
            );

            // TIME

            String timeText =
                    appointment.getAppointmentTime().trim();

            LocalTime time;

            try {

                time = LocalTime.parse(
                        timeText,
                        DateTimeFormatter.ofPattern("hh:mm a")
                );

            } catch (Exception e) {

                time = LocalTime.parse(
                        timeText,
                        DateTimeFormatter.ofPattern("HH:mm")
                );
            }

            ps.setTime(
                    4,
                    Time.valueOf(time)
            );

            // STATUS

            ps.setString(
                    5,
                    appointment.getStatus()
            );

            // NOTES

            ps.setString(
                    6,
                    appointment.getNotes()
            );

            // ID

            ps.setInt(
                    7,
                    appointment.getId()
            );

            int result = ps.executeUpdate();

            System.out.println(
                    "Appointment Update Result: "
                    + result
            );

            return result > 0;

        } catch (Exception e) {

            System.out.println(
                    "======================================"
            );

            System.out.println(
                    "ERROR UPDATING APPOINTMENT"
            );

            System.out.println(
                    "======================================"
            );

            e.printStackTrace();

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
            PreparedStatement ps =
                    conn.prepareStatement(sql)
        ) {

            ps.setInt(1, id);

            int result = ps.executeUpdate();

            System.out.println(
                    "Appointment Delete Result: "
                    + result
            );

            return result > 0;

        } catch (SQLException e) {

            System.out.println(
                    "Error deleting appointment: "
                    + e.getMessage()
            );

            e.printStackTrace();

            return false;
        }
    }
}