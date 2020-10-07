package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class AllTrainingActivity extends AppCompatActivity {
    private static final String TAG = "AllTrainingActivity";

    private RecyclerView recyclerView;
    private TrainingRecViewAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_training);
        adapter = new TrainingRecViewAdapter(this);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter.setTrainings(Utils.getAllTrainings());
    }
}
