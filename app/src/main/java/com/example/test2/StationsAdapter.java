package com.example.test2;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test2.model.StationModel;

import java.util.ArrayList;
import java.util.List;

interface StationSelected {
    void stationSelected(StationModel model);
}

public class StationsAdapter extends RecyclerView.Adapter<NetworkAdapter.ViewHolder> {
    private StationSelected mCallback;
    private List<StationModel> mItems = new ArrayList<>();

    public StationsAdapter(StationSelected callback){
        mCallback = callback;
    }

    public void updateDataset(List<StationModel> items) {
        mItems.clear();
        mItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NetworkAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull NetworkAdapter.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
