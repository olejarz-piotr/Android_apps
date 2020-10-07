package com.example.calendar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewAlarmActivity extends AppCompatActivity {
    private static final String TAG = "AddNewAlarmActivity";
private Button btnAddAlarm;
private EditText edtTxtHours, edtTxtMinutes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_alarm);

    btnAddAlarm = findViewById(R.id.AddAlarm);
    edtTxtHours=findViewById(R.id.edTxtHour);
    edtTxtMinutes=findViewById(R.id.edTxtMinute);


    btnAddAlarm.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            addNewAlarm();
        }
    });
    }
    
    private void addNewAlarm(){
        Log.d(TAG, "addNewAlarm: started");
        int hours=Integer.valueOf(edtTxtHours.getText().toString());
        int minutes = Integer.valueOf(edtTxtMinutes.getText().toString());
        Bundle bundle = new Bundle();
        bundle.putInt(getString(R.string.hours), hours);
        bundle.putInt(getString(R.string.minutes), minutes);

        Intent intent = new Intent(AddNewAlarmActivity.this, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra(getString(R.string.bundle),bundle);
        startActivity(intent);
    }


}
