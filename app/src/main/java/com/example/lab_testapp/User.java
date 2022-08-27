package com.example.lab_testapp;

import com.google.firebase.database.Exclude;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class User implements Serializable {
    public String userName;
    public String patientID;

    public User() {
    }

    public User(String userName, String patientID) {
        this.userName = userName;
        this.patientID = patientID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPatientID() {
        return patientID;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    @Exclude
    public Map<String, Object> toMap() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("name", userName);
        result.put("patientID", patientID);
        return result;
    }
}
