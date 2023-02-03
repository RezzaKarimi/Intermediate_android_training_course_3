package com.example.season9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;

import com.adamstyrc.cookiecutter.CookieCutterImageView;
import com.adamstyrc.cookiecutter.CookieCutterShape;
import app.*;

public class E06ImageCropper extends AppCompatActivity implements View.OnClickListener {

    CookieCutterImageView ivCrop ;
    AppCompatTextView crop , cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e06_image_cropper);

        ivCrop = findViewById(R.id.ivCrop);
        crop   = findViewById(R.id.crop);
        cancel = findViewById(R.id.cancel);


        crop.setOnClickListener(this);
        cancel.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if (v == cancel){
            finish();
        }else if (v == crop){

//            Bitmap resultBitmap = Bitmap.createBitmap(ivCrop.getCroppedBitmap() ,
//            0 , 0, ivCrop.getCroppedBitmap().getWidth() -1 ,ivCrop.getCroppedBitmap().getHeight() - 1);

            ivCrop.setImageBitmap(ivCrop.getCroppedBitmap());
        }
    }
}