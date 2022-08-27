package com.example.lab_testapp;

public class SignUpData {
    String name;
    String patientID;

    public SignUpData() {
    }

    //getter, setter 설정
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String schoolID) {
        this.patientID = schoolID;
    }

    public SignUpData(String name, String schoolID) {
        this.name = name;
        this.patientID = patientID;
    }
}