package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.util.Util;

import java.util.ArrayList;

public class PlanActivity extends AppCompatActivity {

    private static final String TAG = "PlanActivity";
    private RecyclerView mondayRecView, tuesdayRecView, wednesdayRecView, thursdayRecView, fridayRecView, saturdayRecView, sundayRecView;
    private RelativeLayout notAddedAPlanRelLayout;
    private Button btnAddAPlan;
    private NestedScrollView nestedScrollView;
    private TextView mondayEdit, tuesdayEdit, wednesdayEdit, thursdayEdit, fridayEdit, saturdayEdit, sundayEdit;


    private PlanRecViewAdapter mondayAdapter, tuesdayAdapter, wednesdayAdapter, thursdayAdapter, fridayAdapter, saturdayAdapter, sundayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plan);
        initViews();
        initAdapters();

        initRecViews();

        if(Utils.getUsersPlans().size()>0){
            notAddedAPlanRelLayout.setVisibility(View.GONE);
            nestedScrollView.setVisibility(View.VISIBLE);
        }else {
            notAddedAPlanRelLayout.setVisibility(View.VISIBLE);
            nestedScrollView.setVisibility(View.GONE);
        }
    }

    private void initRecViews() {
        Log.d(TAG, "initRecViews: started");
        mondayRecView.setAdapter(mondayAdapter);
        mondayRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<Plan>mondayPlans = new ArrayList<>();
        for (Plan plan: Utils.getUsersPlans()
        ) { if(plan.getDay().equals("Monday")){
            mondayPlans.add(plan);
        }

        }
        mondayAdapter.setPlans(mondayPlans);


        tuesdayRecView.setAdapter(tuesdayAdapter);
        tuesdayRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        ArrayList<Plan>tuesdayPlans = new ArrayList<>();
        for (Plan plan: Utils.getUsersPlans()
        ) { if(plan.getDay().equals("Tuesday")){
            tuesdayPlans.add(plan);
        }

        }
        tuesdayAdapter.setPlans(tuesdayPlans);



        wednesdayRecView.setAdapter(wednesdayAdapter);
        wednesdayRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<Plan>wednesdayPlans = new ArrayList<>();
        for (Plan plan: Utils.getUsersPlans()
        ) { if(plan.getDay().equals("Wednesday")){
            wednesdayPlans.add(plan);
        }

        }
        wednesdayAdapter.setPlans(wednesdayPlans);


        thursdayRecView.setAdapter(thursdayAdapter);
        thursdayRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<Plan>thursdayPlans = new ArrayList<>();
        for (Plan plan: Utils.getUsersPlans()
        ) { if(plan.getDay().equals("Thursday")){
            thursdayPlans.add(plan);
        }

        }
        thursdayAdapter.setPlans(thursdayPlans);


        fridayRecView.setAdapter(fridayAdapter);
        fridayRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<Plan>fridayPlans = new ArrayList<>();
        for (Plan plan: Utils.getUsersPlans()
        ) { if(plan.getDay().equals("Friday")){
            fridayPlans.add(plan);
        }

        }
        fridayAdapter.setPlans(fridayPlans);


        saturdayRecView.setAdapter(saturdayAdapter);
        saturdayRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<Plan>saturdayPlans = new ArrayList<>();
        for (Plan plan: Utils.getUsersPlans()) {
            if(plan.getDay().equals("Saturday")){
                saturdayPlans.add(plan);
            }

        }
        saturdayAdapter.setPlans(saturdayPlans);


        sundayRecView.setAdapter(sundayAdapter);
        sundayRecView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));

        ArrayList<Plan>sundayPlans = new ArrayList<>();
        for (Plan plan: Utils.getUsersPlans()
        ) { if(plan.getDay().equals("Sunday")){
            sundayPlans.add(plan);
        }

        }
        sundayAdapter.setPlans(sundayPlans);


    }

    private void initViews() {


        Log.d(TAG, "initViews: started");
        mondayRecView = findViewById(R.id.mondayRecView);
        tuesdayRecView = findViewById(R.id.tuesdayRecView);
        wednesdayRecView = findViewById(R.id.wednesdayRecView);
        thursdayRecView = findViewById(R.id.thursdayRecView);
        fridayRecView = findViewById(R.id.fridayRecView);
        saturdayRecView = findViewById(R.id.saturdayRecView);
        sundayRecView = findViewById(R.id.sundayRecView);
        notAddedAPlanRelLayout = findViewById(R.id.notAddedPlanRelLayout);
        btnAddAPlan = findViewById(R.id.btnAddAPlan);
        nestedScrollView = findViewById(R.id.nestedScrollView);
        mondayEdit = findViewById(R.id.editMondayPlan);
        tuesdayEdit = findViewById(R.id.editTuesdayPlan);
        wednesdayEdit = findViewById(R.id.editWednesdayPlan);
        thursdayEdit = findViewById(R.id.editThursdayPlan);
        fridayEdit = findViewById(R.id.editFridayPlan);
        saturdayEdit = findViewById(R.id.editSaturdayPlan);
        sundayEdit = findViewById(R.id.editSundayPlan);


    }

private void initAdapters(){
    Log.d(TAG, "initAdapters: started");
    mondayAdapter=new PlanRecViewAdapter(this);
    tuesdayAdapter=new PlanRecViewAdapter(this);
    wednesdayAdapter=new PlanRecViewAdapter(this);
    thursdayAdapter=new PlanRecViewAdapter(this);
    fridayAdapter=new PlanRecViewAdapter(this);
    saturdayAdapter=new PlanRecViewAdapter(this);
    sundayAdapter=new PlanRecViewAdapter(this);


}

    @Override
    public void onBackPressed() {
        Intent intent=new Intent(this,MainActivity.class);
        startActivity(intent);
        super.onBackPressed();
    }
}