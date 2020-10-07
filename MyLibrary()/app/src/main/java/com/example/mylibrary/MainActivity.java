package com.example.mylibrary;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Button btnSeeAll, btnCurrentlyReading, btnWantToRead, btnAlreadyRead, btnAbout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(R.anim.in, R.anim.out);
        initWidgets();
        setOnClickListeners();
    }

    private void setOnClickListeners(){
        btnSeeAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,AllBooksActivity.class);
                startActivity(intent);
            }
        });

        btnAlreadyRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, AlreadyReadActivity.class);
           startActivity(intent);

            }
        });

        btnWantToRead.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, WantToActivity.class);
                startActivity(intent);
            }
        });

        btnCurrentlyReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CurrentlyReadingActivity.class);
                startActivity(intent);
            }
        });
        
        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aboutTapped();
            }
        });


    }
    private void aboutTapped(){
        Log.d(TAG, "aboutTapped: started");
        AlertDialog.Builder builder = new AlertDialog.Builder(this).setTitle("About My Library App").setMessage("My first android application \n" +
                "created with Android tutorials \n" +
                "\n Piotr Olejarz");
    builder.create().show();

    }
    

    private void initWidgets() {
        btnSeeAll = findViewById(R.id.btnAllBooks);
        btnCurrentlyReading = findViewById(R.id.btnCurrent);
        btnWantToRead = findViewById(R.id.btnWantTo);
        btnAlreadyRead = findViewById(R.id.btnAlready);
        btnAbout = findViewById(R.id.btnAbout);

    }
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.close_in,R.anim.close_out);
    }

}
