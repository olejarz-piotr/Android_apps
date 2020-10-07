package com.example.gymapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class TrainingActivity extends AppCompatActivity implements AskForDetailsDialog.GetDetails {
    private static final String TAG = "TrainingActivity";
    private ImageView trainingImage;
    private TextView trainingName,trainingLongDesc;
    private Button btnAddToPlan;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        initViews();

        Intent intent =getIntent();
        try {
            final GymTraining incomingTraining = intent.getParcelableExtra("training");
            trainingName.setText(incomingTraining.getName());
            trainingLongDesc.setText(incomingTraining.getLongDesc());
            Glide.with(this).asBitmap().load(incomingTraining.getImageUrl()).into(trainingImage);


            btnAddToPlan.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    AskForDetailsDialog askForDetailsDialog = new AskForDetailsDialog();
                    Bundle bundle = new Bundle();
                    bundle.putParcelable("training", incomingTraining);
                    askForDetailsDialog.setArguments(bundle);
                    askForDetailsDialog.show(getSupportFragmentManager(),"ask for details");



                }
            });

        }catch (NullPointerException e){
            e.getMessage();
        }

    }

    private void initViews(){

        trainingImage=findViewById(R.id.trainingImage);
        trainingName=findViewById(R.id.trainingName);
        trainingLongDesc=findViewById(R.id.trainingLongDesc);
        btnAddToPlan=findViewById(R.id.btnAddToPlan);
    }

    @Override
    public void onGettingDetailsResult(Plan plan) {

        Log.d(TAG, "onGettingDetailsResult: we have a plan");
        Utils.addToUsersPlan(plan);
        Intent intent = new Intent(this,PlanActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("plan",plan);
        startActivity(intent);
    }
}
