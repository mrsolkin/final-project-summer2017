
package com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ConversionType {

    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("conversionSymbol")
    @Expose
    private String conversionSymbol;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getConversionSymbol() {
        return conversionSymbol;
    }

    public void setConversionSymbol(String conversionSymbol) {
        this.conversionSymbol = conversionSymbol;
    }

}
