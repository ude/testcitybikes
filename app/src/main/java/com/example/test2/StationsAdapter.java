package com.example.test2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.test2.model.StationModel;

import java.util.ArrayList;
import java.util.List;

interface StationSelected {
    void stationSelected(StationModel model);
}

interface ItemClicked{
    void onItemPressed(Integer position);
}

public class StationsAdapter extends RecyclerView.Adapter<StationsAdapter.ViewHolder> {
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
    public StationsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.station_item_layout, null);
        itemView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        return new StationsAdapter.ViewHolder(itemView, new ItemClicked() {
            @Override
            public void onItemPressed(Integer position) {
                mCallback.stationSelected(mItems.get(position));
            }
        });
    }

    @Override
    public void onBindViewHolder(@NonNull StationsAdapter.ViewHolder holder, int position) {
        holder.bind(mItems.get(position));

    }

    @Override
    public int getItemCount() {
        return mItems.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView nameTextView;
        CustomGraphView graphView;
        public ViewHolder(@NonNull View itemView, ItemClicked callback) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    callback.onItemPressed(getAdapterPosition());
                }
            });
            nameTextView = itemView.findViewById(R.id.station_name);
            graphView = itemView.findViewById(R.id.graph_view);
        }

        public void bind(StationModel model){
            nameTextView.setText(model.getName());
            graphView.setSlots(model.getFree_bikes(), model.getFree_bikes() + model.getEmpty_slots(), true);
        }


    }
}
