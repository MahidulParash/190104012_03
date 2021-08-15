package com.example.a190104012_03;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HospitalRecViewAdapter extends RecyclerView.Adapter<HospitalRecViewAdapter.ViewHolder> {

    private ArrayList<Hospital> hospitals = new ArrayList<>();
    private Context context;

    public HospitalRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @org.jetbrains.annotations.NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @org.jetbrains.annotations.NotNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.hospital_list_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull @org.jetbrains.annotations.NotNull HospitalRecViewAdapter.ViewHolder holder, int position) {
        holder.txtName.setText(hospitals.get(position).getName());
        holder.txtPhone.setText(hospitals.get(position).getPhone());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String phoneNumber = hospitals.get(position).getPhone();
                Uri uri = Uri.parse("tel:" + holder.txtPhone.getText().toString());
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                try{
                    context.startActivity(intent);
                }
                catch (SecurityException s){
                    Toast.makeText(context, "E R R O R", Toast.LENGTH_LONG)
                            .show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return hospitals.size();
    }

    public void setHospitals(ArrayList<Hospital> hospitals) {
        this.hospitals = hospitals;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private TextView txtName;
        private TextView txtPhone;
        private RelativeLayout parent;
        public ViewHolder(@NonNull @org.jetbrains.annotations.NotNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.hospitalName);
            txtPhone = itemView.findViewById(R.id.hospitalPhone);
            parent = itemView.findViewById(R.id.parent);
        }
    }
}
