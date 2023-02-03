package com.example.season9;

import android.app.Activity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.AppCompatImageView;

import objects.CustomToastObject;

public class CustomToast {
    CustomToastObject object;
    Activity activity;

    public CustomToast(Activity activity , CustomToastObject object){
        this.activity = activity;
        this.object   = object;
    }

    public void show(){

        LayoutInflater inflater = LayoutInflater.from(activity);
        View toast = inflater.inflate(R.layout.custom_toast_layout , activity.findViewById(R.id.parent) );

        RelativeLayout parent   = toast.findViewById(R.id.parent);
        TextView          text  = toast.findViewById(R.id.text);
        AppCompatImageView icon = toast.findViewById(R.id.icon);

        parent.setBackgroundColor(activity.getResources().getColor(object.getBackGroundColor()));
        icon.setImageResource(object.getIcon());
        icon.setColorFilter(activity.getResources().getColor(object.getIconColor()));
        text.setText(object.getText());
        text.setTextColor(activity.getResources().getColor(object.getTextColor()));

        Toast newToast = new Toast(activity);
        newToast.setDuration(Toast.LENGTH_SHORT);
        newToast.setGravity(Gravity.BOTTOM , 0 , 70);
        newToast.setView(toast);
        newToast.show();

    }




}
