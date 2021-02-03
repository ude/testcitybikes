package com.example.test2.model;

import java.util.List;

public class StationWrapper {
    String name;
    List<StationModel> stations;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<StationModel> getStations() {
        return stations;
    }

    public void setStations(List<StationModel> stations) {
        this.stations = stations;
    }
}
