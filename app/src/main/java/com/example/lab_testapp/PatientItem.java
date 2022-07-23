package com.example.lab_testapp;

public class PatientItem {
    public PatientItem(String a_patName, String a_patNumber) {
        mStrName = a_patName;
        mStrNumber = a_patNumber;
    }

    private String mStrName;
    private String mStrNumber;

    public void setStrName(String a_patName) {
        mStrName = a_patName;
    }

    public String getStrName() { return mStrName; }

    public void setStrNumber(String a_patNumber) {
        mStrNumber = a_patNumber;
    }

    public String getStrNumber() {
        return mStrNumber;
    }
}
