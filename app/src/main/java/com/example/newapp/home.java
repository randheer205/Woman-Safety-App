package com.example.newapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link home#newInstance} factory method to
 * create an instance of this fragment.
 */
public class home extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public home() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment home.
     */
    // TODO: Rename and change types and number of parameters
    public static home newInstance(String param1, String param2) {
        home fragment = new home();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_home, container, false);
        TextView detailfnm=(TextView) v.findViewById(R.id.firstname);
        TextView detaillnm=(TextView) v.findViewById(R.id.lastname);
        TextView p1call=(TextView) v.findViewById(R.id.phone1);
        TextView p2call=(TextView) v.findViewById(R.id.phone2);
        TextView p3call=(TextView) v.findViewById(R.id.phone3);
        String fnm,lnm,p1,p2,p3;
        String pd[]=((MainActivity2) getActivity()).persondetails();
        fnm=pd[0];
        lnm=pd[1];
        p1=pd[2];
        p2=pd[3];
        p3=pd[4];
        System.out.println("THIS IS SPARTA : "+fnm);
        detailfnm.setText(fnm);
        detaillnm.setText(lnm);
        p1call.setText("IMP PHONE NUMBER 1 : "+p1);
        p2call.setText("IMP PHONE NUMBER 2 : "+p2);
        p3call.setText("IMP PHONE NUMBER 3 : "+p3);
        Button settingbutt=(Button)v.findViewById(R.id.setting_button);
        settingbutt.setOnClickListener(new View.OnClickListener()
                                      {
                                          @Override
                                          public void onClick(View view)
                                          {
                                              Intent intent=new Intent(getActivity(),MainActivity3.class);
                                              startActivity(intent);
                                          }
                                      }
        );
        return v;
    }
}