package com.example.season9;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import com.ramotion.foldingcell.FoldingCell;

import java.util.ArrayList;
import java.util.List;

import adapter.E11Adapter;

public class E11FoldingCell extends AppCompatActivity {

    RecyclerView recyclerView;
    List<String> list ;
    E11Adapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e11_folding_cell);
        init();
    }

    private void init(){
        recyclerView = findViewById(R.id.recyclerView);
        list = prepareData();
        adapter = new E11Adapter(this , list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
    private List<String> prepareData(){
        List<String> object = new ArrayList<>();
        object.add("Reza");
        object.add("Mammad");
        object.add("Mohsen");
        object.add("Mori");
        object.add("Reza");
        object.add("Mammad");
        object.add("Mohsen");
        object.add("Mori");
        object.add("Reza");
        object.add("Mammad");
        object.add("Mohsen");
        object.add("Mori");

        return object;
    }
}