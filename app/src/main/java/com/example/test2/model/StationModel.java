package com.example.test2.model;

public class StationModel {
    private Integer empty_slots;
    private StationExtraModel extra;
    private Integer free_bikes;
    private Double latitude;
    private Double longitude;
    private String name;
    private String timeStamp;

    public Integer getEmpty_slots() {
        return empty_slots;
    }

    public void setEmpty_slots(Integer empty_slots) {
        this.empty_slots = empty_slots;
    }

    public StationExtraModel getExtra() {
        return extra;
    }

    public void setExtra(StationExtraModel extra) {
        this.extra = extra;
    }

    public Integer getFree_bikes() {
        return free_bikes;
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
        return name;
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
