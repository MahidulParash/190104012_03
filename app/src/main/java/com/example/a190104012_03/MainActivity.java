package com.example.a190104012_03;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView hospitalRecView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        hospitalRecView = findViewById(R.id.hospital);
        ArrayList<Hospital> hospitals = new ArrayList<>();
        hospitals.add(new Hospital("Abir General Hospital", "+880-2-8360780"));
        hospitals.add(new Hospital("Ad-Din Hospital", "+880-2-9353391"));
        hospitals.add(new Hospital("Al Noor Eye Hospital", "+880-2-8124348"));
        hospitals.add(new Hospital("Apollo Hospital", "+880-1971276556"));
        hospitals.add(new Hospital("Bangladesh Eye Hospital Ltd", "+880-2-8651950"));
        hospitals.add(new Hospital("Bangladesh Medical college Hospital", "+880-2-9120792"));
        hospitals.add(new Hospital("Brain & Life Hospital", "+8801919-031449"));
        hospitals.add(new Hospital("City General Hospital", "+880-2-9120862"));
        hospitals.add(new Hospital("City Hospital Ltd", "+880-2-8617852"));
        hospitals.add(new Hospital("Dhaka Community Hospital", "+880-2-8314887"));
        hospitals.add(new Hospital("Dhaka Medical College Hospital", "+880-2-8626812"));
        hospitals.add(new Hospital("Greenland Hospital Limited", "+880-1714012239"));
        hospitals.add(new Hospital("Ibn Sina Hospital", "+880-2-8119513"));
        hospitals.add(new Hospital("Labaid Specialized Hospital", "+880-2-9676356"));
        hospitals.add(new Hospital("Mukti Mental Hospital", "+880-2-9896165"));
        hospitals.add(new Hospital("Rushmono General Hospital", "+880-2-9357354"));
        hospitals.add(new Hospital("SQUARE Hospitals Ltd", "+880-2-8142431"));
        hospitals.add(new Hospital("The Eye Pavilion Ltd", "+880-1711616875"));
        hospitals.add(new Hospital("Uttara Central Hospital", "+880-2-8911551"));
        hospitals.add(new Hospital("Uttara Crescent Clinic", "+880-17116432633"));


        HospitalRecViewAdapter adapter = new HospitalRecViewAdapter(this);
        adapter.setHospitals(hospitals);
        hospitalRecView.setAdapter(adapter);
        hospitalRecView.setLayoutManager(new GridLayoutManager(this, 1));
    }
}