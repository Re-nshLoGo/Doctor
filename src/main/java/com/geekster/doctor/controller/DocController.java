package com.geekster.doctor.controller;

import com.geekster.doctor.model.Doctor;
import com.geekster.doctor.service.DocService;
import com.geekster.doctor.util.DoctorValidator;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/doctor")
public class DocController {
    @Autowired
    DocService docService;
    @PostMapping("/doctor-add")
    public ResponseEntity<String> adddoc(@RequestBody String doctor){
        JSONObject json = new JSONObject(doctor);
        List<String> validationlist = DoctorValidator.docValidate(json);
        if (validationlist.isEmpty()){
            Doctor doctor1 = setDoctor(json);
            docService.save(doctor1);
            return new ResponseEntity<>("saved",HttpStatus.CREATED);
        }
        String [] arr = Arrays.copyOf(validationlist.toArray(),validationlist.size(),String[].class);
        return new ResponseEntity<>("please pass mandatory params"+Arrays.toString(arr),HttpStatus.BAD_REQUEST);
    }



    @GetMapping("/doctor")
    public List<Doctor> getAlldoc(@Nullable @RequestParam String docId){
        return docService.fetchAll(docId);
    }
    @GetMapping("/getby-exp")
    public List<Doctor> getbyExp(){
        return docService.experience();
    }
    private Doctor setDoctor(JSONObject json) {
        Doctor doctor = new Doctor();
        int id = json.getInt("doctorId");
        doctor.setDoctorId(id);
        String name = json.getString("docName");
        doctor.setDocName(name);
        String spec = json.getString("specializedIn");
        doctor.setSpecializedIn(spec);
        if(json.has("docExp")){
            int exp = json.getInt("docExp");
            doctor.setDocExp(exp);
        }
        return doctor;

    }

}
