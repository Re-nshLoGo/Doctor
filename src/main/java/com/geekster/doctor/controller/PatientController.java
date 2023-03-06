package com.geekster.doctor.controller;

import com.geekster.doctor.dao.DocRepository;
import com.geekster.doctor.exception.RecordNotFound;
import com.geekster.doctor.model.Doctor;
import com.geekster.doctor.model.Patient;
import com.geekster.doctor.service.PatientService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
public class PatientController {
    @Autowired
    PatientService patientService;
    @Autowired
    DocRepository docRepository;
    @GetMapping("getall-patient")
    public List<Patient> getAll(){
        return patientService.getAll();
    }
    @GetMapping("get-patient")
    public List<Patient> getbyId(@RequestParam int docId , @RequestParam int patId) throws RecordNotFound {
        return patientService.getbydocId(docId,patId);
    }
    @PostMapping("admit-patient")
    public ResponseEntity<String> add(@RequestBody String reqpatient) {
        JSONObject json = new JSONObject(reqpatient);
        Patient patient = setPatient(json);
        patientService.save(patient);

        return new ResponseEntity<>("patient admited", HttpStatus.CREATED);
    }

    private Patient setPatient(JSONObject json) {
        Patient patient = new Patient();
        patient.setPatientId(json.getInt("patientId"));
        patient.setName(json.getString("name"));
        patient.setAge(json.getInt("age"));
        patient.setPhone(json.getString("phone"));
        patient.setDeasestype(json.getString("deasestype"));
        patient.setGender(json.getString("gender"));
        Timestamp curtime = new Timestamp(System.currentTimeMillis());
        patient.setAdmitDate(curtime);
        Integer docid = json.getInt("docId");
        Doctor doctor = docRepository.findById(docid).get();
        patient.setDocId(doctor);
        return patient;

    }
}
