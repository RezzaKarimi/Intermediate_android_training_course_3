package com.example.season9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.lifecycle.ViewModelProvider;

import android.content.ClipData;
import android.content.ClipDescription;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import app.*;

public class E05DragAndDrop extends AppCompatActivity {

    LinearLayout firstParent , targetParent;
    AppCompatImageView img ;
    AppCompatTextView text;
    public final String IMG_TAG = "IMG_TAG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e05_drag_and_drop);

        init();

    }
    private void init(){
       firstParent  = findViewById(R.id.firstParent);
       targetParent = findViewById(R.id.targetParent);
       img          = findViewById(R.id.image);
       text         = findViewById(R.id.text);

       img.setTag(IMG_TAG);

       /// long Click >>>>>>>>>>>>>>>>>>>>>>>>>
       img.setOnLongClickListener(new myLongClick());
       /// touch Click >>>>>>>>>>>>>>>>>>>>>>>>
//       img.setOnTouchListener(new myTouchListener());

       firstParent.setOnDragListener(new myDragListener());
       targetParent.setOnDragListener(new myDragListener());


    }






    private class myLongClick implements View.OnLongClickListener {

        @Override
        public boolean onLongClick(View v) {
            ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
            String[] mimeType = {ClipDescription.MIMETYPE_TEXT_PLAIN};
            ClipData data = new ClipData(v.getTag().toString() , mimeType , item);

            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data , shadowBuilder , v , 0);
            v.setVisibility(View.INVISIBLE);

            return true;
        }

    }

    private  class myTouchListener implements View.OnTouchListener{

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            ClipData.Item item = new ClipData.Item((CharSequence) v.getTag());
            String[] mimeType = {ClipDescription.MIMETYPE_TEXT_PLAIN};
            ClipData data = new ClipData(v.getTag().toString() , mimeType , item);

            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data , shadowBuilder , v , 0);
            v.setVisibility(View.INVISIBLE);
            return true;
        }
    }

    private class myDragListener implements View.OnDragListener {

        Drawable selected_Background     = getResources().getDrawable(R.drawable.selected_background);
        Drawable not_selected_Background = getResources().getDrawable(R.drawable.not_selected_background);
        @Override
        public boolean onDrag(View v, DragEvent event) {
            int action = event.getAction();
            switch (action){
                case DragEvent.ACTION_DRAG_ENTERED : {
                    v.setBackground(selected_Background);
                    break;
                }
                case DragEvent.ACTION_DRAG_EXITED :{
                    v.setBackground(not_selected_Background);
                    break;
                }

                case DragEvent.ACTION_DRAG_ENDED :{
                    v.setBackground(not_selected_Background);
                    break;

                }
                case DragEvent.ACTION_DROP :{
                    if (v == targetParent){
                        View view = (View) event.getLocalState();
                        ViewGroup viewGroup = (ViewGroup) view.getParent();
                        viewGroup.removeView(view);

                        text.setText("item Dropped");

                        LinearLayout container = (LinearLayout) v;
                        container.addView(view);
                        view.setVisibility(View.VISIBLE);

                    }else {
                        View view = (View) event.getLocalState();
                        ViewGroup viewGroup = (ViewGroup) view.getParent();
                        viewGroup.removeView(view);

                        LinearLayout layout = (LinearLayout) v;
                        layout.addView(view);
                        view.setVisibility(View.VISIBLE);
                        app.t("You cannot drop item here");
                        text.setText("Drop item here!!!!!!!!!!!!!!!!!!!!!!");

                    }
                }
            }
            return true;
        }
    }
}