package com.geekster.doctor.model;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "patient_tbl")
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer patientId;
    private String name;
    private Integer age;
    private String phone;
    private String deasestype;
    private String gender;
    @JoinColumn(name = "doc_id")
    @ManyToOne
    private Doctor docId;
    private Timestamp admitDate;

    public Patient() {
    }

    public Patient(Integer patientId, String name, Integer age, String phone, String deasestype, String gender, Doctor docId, Timestamp admitDate) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.deasestype = deasestype;
        this.gender = gender;
        this.docId = docId;
        this.admitDate = admitDate;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDeasestype() {
        return deasestype;
    }

    public void setDeasestype(String deasestype) {
        this.deasestype = deasestype;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Doctor getDocId() {
        return docId;
    }

    public void setDocId(Doctor docId) {
        this.docId = docId;
    }

    public Timestamp getAdmitDate() {
        return admitDate;
    }

    public void setAdmitDate(Timestamp admitDate) {
        this.admitDate = admitDate;
    }
}
