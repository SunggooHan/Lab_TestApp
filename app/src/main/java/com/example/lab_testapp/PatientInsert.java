package com.example.lab_testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class PatientInsert extends AppCompatActivity {
    // List item
    private List<PatientItem> mItemList;

    // List view
    private ListView mListView;

    // ListView adapter
    private PatientArrayAdapter mPatientAdapter;

    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference databaseReference = database.getReference("Patient");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_insert);

        Button button_back = findViewById(R.id.Back);
        Button button_insert = findViewById(R.id.complete);

        EditText editName = findViewById(R.id.editName);
        EditText editID = findViewById(R.id.editID);

        //환자 정보 입력 및 리스트 수정
        button_insert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if (!editName.getText().toString().equals("") && !editID.getText().toString().equals("")) {
                    createUser(editName.getText().toString(), editID.getText().toString());

                    databaseReference.child("회원").addValueEventListener(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            databaseReference.child("회원").child("회원이름").setValue(editName.getText().toString());
                            databaseReference.child("회원").child("회원번호").setValue(editID.getText().toString());
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError error) {
                        }
                    });

                    finish();
                } else {
                    Toast.makeText(PatientInsert.this, "모든 정보를 입력해주세요", Toast.LENGTH_LONG).show();
                }
            }
        });



        button_back.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) { finish(); }
        });
    }

    private void createUser(String name, String ID) {
        // 환자정보입력 성공시
        PatientItem patientItem = new PatientItem(name, ID);
    }
}