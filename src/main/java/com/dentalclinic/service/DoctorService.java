/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dentalclinic.service;

import com.dentalclinic.dao.DoctorDAO;
import com.dentalclinic.model.Doctor;

import java.util.List;

public class DoctorService {

    private final DoctorDAO doctorDAO = new DoctorDAO();

    public boolean saveDoctor(Doctor doctor) {
        return doctorDAO.addDoctor(doctor);
    }

    public List<Doctor> getAllDoctors() {
        return doctorDAO.getAllDoctors();
    }

    public boolean updateDoctor(Doctor doctor) {
        return doctorDAO.updateDoctor(doctor);
    }

    public boolean deleteDoctor(int id) {
        return doctorDAO.deleteDoctor(id);
    }

    public List<Doctor> searchDoctors(String keyword) {
        return doctorDAO.searchDoctors(keyword);
    }
}