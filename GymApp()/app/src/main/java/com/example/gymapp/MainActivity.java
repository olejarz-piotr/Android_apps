package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private Button btnSeePlan, btnActivities,btnAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Utils.initializeAll();
        initViews();
        setOnClickListeners();

    }

    private void setOnClickListeners() {
        Log.d(TAG, "setOnClickListeners: ");
        btnActivities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AllTrainingActivity.class);
                startActivity(intent);
            }
        });

        btnSeePlan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,PlanActivity.class);
                startActivity(intent);
            }
        });

    }

    private void initViews(){


        btnSeePlan=findViewById(R.id.btnSeeYourPlan);
        btnAbout=findViewById(R.id.btnAbout);
        btnActivities=findViewById(R.id.btnAllActivities);
    }

}
