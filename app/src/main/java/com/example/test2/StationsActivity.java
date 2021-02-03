package com.example.test2;

import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test2.model.StationModel;

public class StationsActivity extends AppCompatActivity {
    public static String STATION_ID_BUNDLE = "STATION_ID_BUNDLE";

    StationsAdapter adapter;
    Presenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String stationId =  getIntent().getExtras().getString(STATION_ID_BUNDLE);


        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapter = new StationsAdapter(new StationSelected() {
            @Override
            public void stationSelected(StationModel model) {
                Toast.makeText(StationsActivity.this, model.toString(), Toast.LENGTH_SHORT).show();
            }
        });

        recyclerView.setAdapter(adapter);


    }
}
