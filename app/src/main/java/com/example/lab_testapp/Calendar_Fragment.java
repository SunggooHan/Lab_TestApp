package com.example.lab_testapp;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.Toast;

public class Calendar_Fragment extends Fragment {

    private CalendarView calendarView;
    private Context context;
    HomeActivity activity;

    public void onAttach(Context context){
        super.onAttach(context);
        activity = (HomeActivity) getActivity();
    }

    public void onDetach(){
        super.onDetach();
        activity = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_calendar, container, false);
        calendarView = (CalendarView) v.findViewById(R.id.calendar);

        context =  container.getContext();

        calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView calendarView, int i, int i1, int i2) {
                Log.i("디버깅", "선택한 날짜는 " + i + "년 " + (i1 + 1) + "월 " + i2 + "일");
                Toast.makeText(context, "선택한 날짜는 " + i + "년 " + (i1 + 1) + "월 " + i2 + "일", Toast.LENGTH_SHORT).show();
                activity.onFragmentChange(1);
            }
        });

        // Inflate the layout for this fragment
        return v;
    }
}