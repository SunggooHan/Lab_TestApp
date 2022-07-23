package com.example.lab_testapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

public class PatientArrayAdapter extends ArrayAdapter<PatientItem> {
    private static final int LAYOUT_RESOURCE_ID = R.layout.patient_list_item;

    private Context mContext;
    private List<PatientItem> mItemList;

    public PatientArrayAdapter(Context a_context, List<PatientItem> a_itemList) {
        super(a_context, LAYOUT_RESOURCE_ID, a_itemList);

        mContext = a_context;
        mItemList = a_itemList;
    }

    @Override
    public View getView(int a_position, View a_convertView, ViewGroup a_parent) {
        patientViewHolder viewHolder;
        if (a_convertView == null) {
            a_convertView = LayoutInflater.from(mContext).inflate(LAYOUT_RESOURCE_ID, a_parent, false);

            viewHolder = new patientViewHolder(a_convertView);
            a_convertView.setTag(viewHolder);
        } else {
            viewHolder = (patientViewHolder) a_convertView.getTag();
        }

        final PatientItem patientItem = mItemList.get(a_position);

        // 환자이름 설정
        viewHolder.patientName.setText(patientItem.getStrName());

        // 환자번호 설정
        viewHolder.patientNumber.setText(patientItem.getStrNumber());

        return a_convertView;
    }
}
