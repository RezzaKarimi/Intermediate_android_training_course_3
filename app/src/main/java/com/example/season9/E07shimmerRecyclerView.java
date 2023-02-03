package com.example.season9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.os.Handler;

import com.cooltechworks.views.shimmer.ShimmerRecyclerView;

import java.util.ArrayList;
import java.util.List;

import adapter.E07ShimmerAdapter;
import app.Application;
import objects.ShimmerObjects;

public class E07shimmerRecyclerView extends AppCompatActivity {

    ShimmerRecyclerView shimmer;
    E07ShimmerAdapter adapter;
    List<ShimmerObjects> list = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e07shimmer_recycler_view);

        shimmer = findViewById(R.id.shimmer_recycler_view);
        list    = prepareData();
        adapter = new E07ShimmerAdapter(this , list);


        shimmer.showShimmerAdapter();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                shimmer.setAdapter(adapter);
                shimmer.setLayoutManager(new LinearLayoutManager(Application.getContext()));
            }
        },5000);

    }

    private List<ShimmerObjects> prepareData() {
        ShimmerObjects objects = new ShimmerObjects(R.drawable.gg , "gol" , "parpar" , "trhran");
        list.add(objects);

        ShimmerObjects objects1 = new ShimmerObjects(R.drawable.gg , "bol" , "bol" , "trhran");
        list.add(objects1);
        return list;
    }
}