package com.geekster.doctor.service;

import com.geekster.doctor.dao.PatientRepo;
import com.geekster.doctor.exception.RecordNotFound;
import com.geekster.doctor.model.Doctor;
import com.geekster.doctor.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class PatientService {
    @Autowired
    PatientRepo patientRepo;
    public List<Patient> getAll() {
        return patientRepo.findAll();
    }

    public void save(Patient patient) {
        patientRepo.save(patient);
    }

    public List<Patient> getbydocId(int docId, int patId) throws RecordNotFound {
       List<Patient> patientList = new ArrayList<>();
       Patient patient = patientRepo.findById(patId).get();
       Doctor doctor = patient.getDocId();
       if(doctor.getDoctorId()==docId){
           patientList.add(patient);
       }else {
           throw new RecordNotFound("Not Fount");
       }
       return patientList;
    }
}
