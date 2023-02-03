package com.example.season9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import app.Application;

public class E09ImageSwitcher extends AppCompatActivity implements View.OnClickListener {

    ImageSwitcher sw;
    AppCompatTextView previous , next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e09_image_switcher);
        init();
    }
    private void init(){
        sw       = findViewById(R.id.sw);
        previous = findViewById(R.id.previous);
        next     = findViewById(R.id.next);

        sw.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView myView = new ImageView(Application.getContext());
                myView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                myView.setImageResource(R.drawable.ic_baseline_image_24);

                myView.setLayoutParams(new
                        ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT));

                return myView;
            }
        });

        previous.setOnClickListener(this);
        next.setOnClickListener(this);

        Animation in  = AnimationUtils.loadAnimation(this , android.R.anim.fade_in);
        Animation out = AnimationUtils.loadAnimation(this , android.R.anim.fade_out);

        sw.setInAnimation(in);
        sw.setOutAnimation(out);

    }

    @Override
    public void onClick(View v) {
        if (v == next){
            sw.setImageResource(R.drawable.flower);
        }else {
            sw.setImageResource(R.drawable.gg);
        }
    }
}