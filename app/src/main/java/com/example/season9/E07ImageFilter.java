package com.example.season9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import net.alhazmy13.imagefilter.ImageFilter;

import java.util.ArrayList;
import java.util.List;

import adapter.E07ImageFilterAdapter;
import intefaces.ImageFilterListener;

public class E07ImageFilter extends AppCompatActivity implements ImageFilterListener {

    AppCompatImageView before , after;
    RecyclerView recyclerView;
    List<String> list;
    E07ImageFilterAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e07_image_filter);

        init();
    }

    private void init(){
        before       = findViewById(R.id.before);
        after        = findViewById(R.id.after);
        recyclerView = findViewById(R.id.recyclerView);
        list         = prepareData();
        adapter      = new E07ImageFilterAdapter(this, list, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));



    }

    private List<String> prepareData() {
        List<String> object = new ArrayList<>();
        object.add("GRAY");
        object.add("RELIEF");
        object.add("AVERAGE_BLUR");
        object.add("OIL");
        object.add("NEON");
        object.add("PIXELATE");
        object.add("TV");
        object.add("INVERT");
        object.add("BLOCK");
        object.add("OLD");
        object.add("SHARPEN");
        object.add("LIGHT");
        object.add("LIGHT");
        object.add("HDR");
        object.add("GAUSSIAN_BLUR");
        object.add("SOFT_GLOW");
        object.add("SKETCH");
        object.add("MOTION_BLUR");
        object.add("GOTHAM");
        return object;
    }



    @Override
    public void filterSelected(String filter) {
        Bitmap bitmap = ((BitmapDrawable)before.getDrawable()).getBitmap();
        Bitmap filterBitmap = ImageFilter.applyFilter(bitmap , ImageFilter.Filter.valueOf(filter));
        after.setImageBitmap(filterBitmap);
    }
}