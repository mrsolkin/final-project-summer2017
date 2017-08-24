
package com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Datum {

    @SerializedName("time")
    @Expose
    private Integer time;
    @SerializedName("close")
    @Expose
    private float close;
    @SerializedName("high")
    @Expose
    private float high;
    @SerializedName("low")
    @Expose
    private float low;
    @SerializedName("open")
    @Expose
    private float open;
    @SerializedName("volumefrom")
    @Expose
    private float volumefrom;
    @SerializedName("volumeto")
    @Expose
    private float volumeto;

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
    }

    public float getClose() {
        return close;
    }

    public void setClose(float close) {
        this.close = close;
    }

    public float getHigh() {
        return high;
    }

    public void setHigh(float high) {
        this.high = high;
    }

    public float getLow() {
        return low;
    }

    public void setLow(float low) {
        this.low = low;
    }

    public float getOpen() {
        return open;
    }

    public void setOpen(float open) {
        this.open = open;
    }

    public float getVolumefrom() {
        return volumefrom;
    }

    public void setVolumefrom(float volumefrom) {
        this.volumefrom = volumefrom;
    }

    public float getVolumeto() {
        return volumeto;
    }

    public void setVolumeto(float volumeto) {
        this.volumeto = volumeto;
    }

}
