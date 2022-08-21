package com.example.lab_testapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {
    private FragmentManager fragmentManager = getSupportFragmentManager();
    private Home_Fragment fragmentHome = new Home_Fragment();
    private Calendar_Fragment fragmentCalendar = new Calendar_Fragment();
    private Chart_Fragment fragmentChart = new Chart_Fragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.menu_frame_layout, fragmentHome).commitAllowingStateLoss();

        BottomNavigationView bottomNavigationView = findViewById(R.id.menu_bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new ItemSelectedListener());

    }

    class ItemSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            FragmentTransaction transaction = fragmentManager.beginTransaction();

            switch (menuItem.getItemId()) {
                case R.id.page_home:
                    transaction.replace(R.id.menu_frame_layout, fragmentHome).commitAllowingStateLoss();
                    break;
                case R.id.page_calendar:
                    transaction.replace(R.id.menu_frame_layout, fragmentCalendar).commitAllowingStateLoss();
                    break;
                case R.id.page_chart:
                    transaction.replace(R.id.menu_frame_layout, fragmentChart).commitAllowingStateLoss();
                    break;

            }

            return true;
        }
    }
}