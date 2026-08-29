
package com.dentalclinic.service;

import com.dentalclinic.dao.AppointmentDAO;
import com.dentalclinic.model.Appointment;

import java.util.List;

public class AppointmentService {

    private AppointmentDAO appointmentDAO;

    public AppointmentService() {
        appointmentDAO = new AppointmentDAO();
    }

    // =========================
    // SAVE APPOINTMENT
    // =========================
    public boolean saveAppointment(Appointment appointment) {

        return appointmentDAO.addAppointment(appointment);
    }

    // =========================
    // GET ALL APPOINTMENTS
    // =========================
    public List<Appointment> getAllAppointments() {

        return appointmentDAO.getAllAppointments();
    }

    // =========================
    // UPDATE APPOINTMENT
    // =========================
    public boolean updateAppointment(Appointment appointment) {

        return appointmentDAO.updateAppointment(appointment);
    }

    // =========================
    // DELETE APPOINTMENT
    // =========================
    public boolean deleteAppointment(int id) {

        return appointmentDAO.deleteAppointment(id);
    }

    public List<Appointment> searchAppointments(String keyword) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

