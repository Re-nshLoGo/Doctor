package com.geekster.doctor.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tbl_doctor")
public class Doctor {
    @Id
    @Column(name = "doc_id")
    private Integer doctorId;
    @Column(name = "doc_name")
    private String docName;
    @Column(name = "doc_exp")
    private int docExp;
    @Column(name = "specialized_in")
    private String specializedIn;

    public Doctor() {
    }

    public Doctor(int doctorId, String docName, int docExp, String specializedIn) {
        this.doctorId = doctorId;
        this.docName = docName;
        this.docExp = docExp;
        this.specializedIn = specializedIn;
    }

    public int getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(int doctorId) {
        this.doctorId = doctorId;
    }

    public String getDocName() {
        return docName;
    }

    public void setDocName(String docName) {
        this.docName = docName;
    }

    public int getDocExp() {
        return docExp;
    }

    public void setDocExp(int docExp) {
        this.docExp = docExp;
    }

    public String getSpecializedIn() {
        return specializedIn;
    }

    public void setSpecializedIn(String specializedIn) {
        this.specializedIn = specializedIn;
    }
}
