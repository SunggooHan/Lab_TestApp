package com.example.lab_testapp;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {
    // List item
    private List<PatientItem> mItemList;

    // List view
    private ListView mListView;

    // ListView adapter
    private PatientArrayAdapter mPatientAdapter;

    private FirebaseDatabase database = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = database.getReference("Patient");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // List 설정
        bindList();

        // 수정 설정
        bindInfor();

        // 삽입 설정
        bindInsert();

        // 삭제 설정
        bindDelete();
    }

    /**
     * List 설정
     */
    private void bindList() {
        mItemList = new ArrayList<>();
        mItemList.add(new PatientItem("홍길동", "123456"));
        mListView = (ListView) findViewById(R.id.listview);

        // Adapter 추가
        mPatientAdapter = new PatientArrayAdapter(this, mItemList);
        mListView.setAdapter((ListAdapter) mPatientAdapter);

        // List item click event 처리
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> a_parent, View a_view, int a_position, long a_id) {
                final PatientItem item = (PatientItem) a_parent.getItemAtPosition(a_position);
                if (item == null) {
                    // 여기로 오면 header 나 footer 다.
                    if (a_position == 0) {
                        Toast.makeText(HomeActivity.this, "The header is selected", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(HomeActivity.this, "The footer is selected", Toast.LENGTH_SHORT).show();
                    }
                    return;
                }

                Toast.makeText(HomeActivity.this, item.getStrName() + " selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 삽입 설정
     */
    private void bindInsert() {
        findViewById(R.id.btn_insert).setOnClickListener(new View.OnClickListener() {
            String name;
            String number;
            @Override
            public void onClick(View v) {
                // Item 추가
                mItemList.add(new PatientItem(name, number + mItemList.size()));

                // List 반영
                mPatientAdapter.notifyDataSetChanged();
            }
        });
    }

    /**
     * 환자 정보보기 설정
     */
    private void bindInfor() {
        findViewById(R.id.btn_infor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });
    }

    /**
     * 삭제 설정
     */
    private void bindDelete() {
        findViewById(R.id.btn_delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final int position = mListView.getCheckedItemPosition();
                if (position == -1) {
                    Toast.makeText(HomeActivity.this, R.string.err_no_selected_item, Toast.LENGTH_SHORT).show();
                    return;
                }

                // 선택한 list item 삭제
                mItemList.remove(position);

                // 선택 항목 초기화
                mListView.setItemChecked(-1, true);

                // List 반영
                mPatientAdapter.notifyDataSetChanged();
            }
        });
    }
}