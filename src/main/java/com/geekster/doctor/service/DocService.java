package com.geekster.doctor.service;

import com.geekster.doctor.dao.DocRepository;
import com.geekster.doctor.model.Doctor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocService {

    @Autowired
    DocRepository docRepository;

    public Doctor savedoc(Doctor doctor) {
        return docRepository.save(doctor);
    }
    public void save(Doctor doctor) {
        docRepository.save(doctor);
    }

    public List<Doctor> fetchAll(String id) {
        List<Doctor> doctorList;
        if(null != id){
            doctorList = new ArrayList<>();
            doctorList.add(docRepository.findById(Integer.valueOf(id)).get());
        }else {
            doctorList = (List<Doctor>) docRepository.findAll();
        }
        return doctorList;
    }

    public List<Doctor> experience() {
        List<Doctor> alldoc = (List<Doctor>) docRepository.findAll();
        List<Doctor> docByExp = new ArrayList<>();
        for (Doctor doctor : alldoc){
            if (doctor.getDocExp()>10){
                docByExp.add(doctor);
            }
        }
        return docByExp;
    }


}
