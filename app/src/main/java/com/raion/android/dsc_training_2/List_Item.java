package com.raion.android.dsc_training_2;
public class List_Item {

    private String location, temperature;
    private int imgId;

    //constructor item yang akan dibuat
    public List_Item(String location, String temperature, int imgId) {
        this.location = location;
        this.temperature = temperature;
        this.imgId = imgId;
    }

    public int getImgId() {
        return imgId;
    }

    public String getLocation() {
        return location;
    }

    public String getTemperature() {
        return temperature+ (char) 0x00B0;
    }
}

