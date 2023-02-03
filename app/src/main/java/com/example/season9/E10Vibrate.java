package com.example.season9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;

import app.app;

public class E10Vibrate extends AppCompatActivity implements View.OnClickListener {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e10_vibrate);

        button = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrator.hasVibrator()){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
                vibrator.vibrate(VibrationEffect.createOneShot(200 , VibrationEffect.DEFAULT_AMPLITUDE));
                app.toasty("Above 26");
            }else {
                long[] pattern = {0, 100, 100 , 500 , 100 , 1000 };
                vibrator.vibrate(pattern , 0);
                app.toasty("Below 26");
            }

        }else app.toasty("No Vibrate");

    }
}