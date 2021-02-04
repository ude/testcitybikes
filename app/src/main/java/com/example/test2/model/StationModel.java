package com.example.test2.model;

public class StationModel {
    private Integer empty_slots;
    //    private StationExtraModel extra;
    private Integer free_bikes;
    private Double latitude;
    private Double longitude;
    private String name;
    private String timeStamp;

    public Integer getEmpty_slots() {
        if (empty_slots != null) {
            return empty_slots;
        } else {
            return 0;
        }
    }

    public void setEmpty_slots(Integer empty_slots) {
        this.empty_slots = empty_slots;
    }

    public Integer getFree_bikes() {
        if (free_bikes != null) {
            return free_bikes;
        } else {
            return 0;
        }
    }

    public void setFree_bikes(Integer free_bikes) {
        this.free_bikes = free_bikes;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getName() {
        if (name != null) {
            return name;
        }else{
            return "Sin nombre";
        }

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
}
