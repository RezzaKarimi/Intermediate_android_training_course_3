package com.example.season9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import app.app;
import service.ForeGround;

public class E14Foreground extends AppCompatActivity {

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e14_foreground);

        init();
    }

    private void init(){
        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ForeGround.serviceStarted){
                    app.toasty("Service Already Running");
                }else {
                    Intent intent = new Intent(E14Foreground.this , ForeGround.class);
                    startService(intent);
                }


            }
        });
    }
}