/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.dentalclinic.service;

import com.dentalclinic.dao.PatientDAO;
import com.dentalclinic.model.Patient;
import java.util.List;

public class PatientService {

    private PatientDAO patientDAO;

    public PatientService() {
        patientDAO = new PatientDAO();
    }

    public boolean savePatient(Patient patient) {
        return patientDAO.addPatient(patient);
    }
    public List<Patient> getAllPatients() {
    return patientDAO.getAllPatients();
}

public List<Patient> searchPatients(String keyword) {
    return patientDAO.searchPatients(keyword);
}
}


