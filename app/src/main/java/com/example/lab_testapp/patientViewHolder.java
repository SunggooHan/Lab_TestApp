package com.example.lab_testapp;

import android.view.View;
import android.widget.TextView;

public class patientViewHolder {
    public TextView patientName;
    public TextView patientNumber;

    public patientViewHolder(View a_view) {
        patientName = a_view.findViewById(R.id.name);
        patientNumber = a_view.findViewById(R.id.num);
    }
}
