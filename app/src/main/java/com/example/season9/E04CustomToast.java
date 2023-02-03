package com.example.season9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;

import com.prathameshmore.toastylibrary.Toasty;

import app.*;
import objects.CustomToastObject;

public class E04CustomToast extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e04_custom_toast);

        AppCompatTextView simpleToast = findViewById(R.id.simpleToast);
        AppCompatTextView customToast = findViewById(R.id.customToast);
        AppCompatTextView toasty      = findViewById(R.id.toasty);

        simpleToast.setOnClickListener(this);
        customToast.setOnClickListener(this);
        toasty.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.simpleToast:{

                app.t(getResources().getString(R.string.simpleText));
                break;
            }
            case R.id.customToast: {
                CustomToastObject object = new CustomToastObject(R.color.purple_700 , R.color.white , R.drawable.ic_baseline_create_24 , R.color.white , getResources().getString(R.string.simpleText));
                CustomToast toast = new CustomToast(this , object);
                toast.show();
                break;

            }
            case R.id.toasty: {
                app.toasty(getResources().getString(R.string.simpleText));
                break;
            }
        }
    }
}