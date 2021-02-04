package com.example.test2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test2.model.StationModel;

import java.util.List;

public class StationsActivity extends AppCompatActivity {
    public static String STATION_ID_BUNDLE = "STATION_ID_BUNDLE";

    StationsAdapter adapter;
    Presenter presenter;
    View loader;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loader = findViewById(R.id.loader);
        String stationId =  getIntent().getExtras().getString(STATION_ID_BUNDLE);

        presenter = new ViewModelProvider(this).get(Presenter.class);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        adapter = new StationsAdapter(new StationSelected() {
            @Override
            public void stationSelected(StationModel model) {
                navigateToStation(model);
            }
        });

        recyclerView.setAdapter(adapter);

        presenter.loadStations(stationId, new StationDetailLoadedCallback() {
            @Override
            public void detailsLoaded(List<StationModel> networks, Exception error) {
                loader.setVisibility(View.GONE);
                if (!networks.isEmpty()){
                    adapter.updateDataset(networks);
                }
            }
        });
    }

    private void navigateToStation(StationModel model){
        Toast.makeText(this, model.getName(), Toast.LENGTH_SHORT).show();
        //https://developer.android.com/guide/components/intents-common.html#Maps
        Uri uri = Uri.parse("geo:" + model.getLatitude() + "," + model.getLongitude());
        startActivity(new Intent(android.content.Intent.ACTION_VIEW, uri));

    }


}
