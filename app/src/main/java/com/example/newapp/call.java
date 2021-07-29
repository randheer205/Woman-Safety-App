package com.example.newapp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;

import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.view.MotionEvent;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link call#newInstance} factory method to
 * create an instance of this fragment.
 */
public class call extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    public call() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment call.
     */
    // TODO: Rename and change types and number of parameters
    public static call newInstance(String param1, String param2) {
        call fragment = new call();
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
        View v=inflater.inflate(R.layout.fragment_call, container, false);
        String pd[]=((MainActivity2) getActivity()).persondetails();
        final  String person1_pn=pd[2];
        final String person2_pn=pd[3];
        final String person3_pn=pd[4];
        final String person1_nm=pd[5];
        final String person2_nm=pd[6];
        final String person3_nm=pd[7];
        final String ambpn="108";
        final String sospn="100";
        ImageButton p1call=(ImageButton) v.findViewById(R.id.person1);
        ImageButton p2call=(ImageButton) v.findViewById(R.id.person2);
        ImageButton p3call=(ImageButton) v.findViewById(R.id.person3);
        ImageButton ambulancecall=(ImageButton) v.findViewById(R.id.ambulance);
        ImageButton soscall=(ImageButton) v.findViewById(R.id.sos_call);
        TextView p1nm=(TextView)v.findViewById(R.id.person1_name);
        TextView p2nm=(TextView)v.findViewById(R.id.person2_name);
        TextView p3nm=(TextView)v.findViewById(R.id.person3_name);
        p1nm.setText(person1_nm);
        p2nm.setText(person2_nm);
        p3nm.setText(person3_nm);
        p1call.setOnClickListener(new View.OnClickListener()
                                  {
                                      @SuppressLint("MissingPermission")
                                      public void onClick(View arg)
                                      {
                                          Intent callintent= new Intent(Intent.ACTION_CALL);
                                          callintent.setData(Uri.parse("tel:"+person1_pn));
                                          startActivity(callintent);
                                      }
                                  }
        );
        p2call.setOnClickListener(new View.OnClickListener()
                                  {
                                      @SuppressLint("MissingPermission")
                                      public void onClick(View arg)
                                      {
                                          Intent callintent= new Intent(Intent.ACTION_CALL);
                                          callintent.setData(Uri.parse("tel:"+person2_pn));
                                          startActivity(callintent);
                                      }
                                  }
        );
        p3call.setOnClickListener(new View.OnClickListener()
                                  {
                                      @SuppressLint("MissingPermission")
                                      public void onClick(View arg)
                                      {
                                          Intent callintent= new Intent(Intent.ACTION_CALL);
                                          callintent.setData(Uri.parse("tel:"+person3_pn));
                                          startActivity(callintent);
                                      }
                                  }
        );
        ambulancecall.setOnClickListener(new View.OnClickListener()
                                  {
                                      @SuppressLint("MissingPermission")
                                      public void onClick(View arg)
                                      {
                                          Intent callintent= new Intent(Intent.ACTION_CALL);
                                          callintent.setData(Uri.parse("tel:"+ambpn));
                                          startActivity(callintent);
                                      }
                                  }
        );
        soscall.setOnClickListener(new View.OnClickListener()
                                         {
                                             @SuppressLint("MissingPermission")
                                             public void onClick(View arg)
                                             {
                                                 Intent callintent= new Intent(Intent.ACTION_CALL);
                                                 callintent.setData(Uri.parse("tel:"+sospn));
                                                 startActivity(callintent);
                                             }
                                         }
        );

        //inflater.inflate(R.layout.fragment_call, container, false);
        return v;
    }

    public void onLongPress(MotionEvent e)  {
        ((MainActivity2) getActivity()).playsound();
    }

}