
package com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CoinHistory {

    @SerializedName("Response")
    @Expose
    private String response;
    @SerializedName("Type")
    @Expose
    private Integer type;
    @SerializedName("Aggregated")
    @Expose
    private Boolean aggregated;
    @SerializedName("Data")
    @Expose
    private List<Datum> data = new ArrayList<Datum>();
    @SerializedName("TimeTo")
    @Expose
    private Integer timeTo;
    @SerializedName("TimeFrom")
    @Expose
    private Integer timeFrom;
    @SerializedName("FirstValueInArray")
    @Expose
    private Boolean firstValueInArray;
    @SerializedName("ConversionType")
    @Expose
    private ConversionType conversionType;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Boolean getAggregated() {
        return aggregated;
    }

    public void setAggregated(Boolean aggregated) {
        this.aggregated = aggregated;
    }

    public List<Datum> getData() {
        return data;
    }

    public void setData(List<Datum> data) {
        this.data = data;
    }

    public Integer getTimeTo() {
        return timeTo;
    }

    public void setTimeTo(Integer timeTo) {
        this.timeTo = timeTo;
    }

    public Integer getTimeFrom() {
        return timeFrom;
    }

    public void setTimeFrom(Integer timeFrom) {
        this.timeFrom = timeFrom;
    }

    public Boolean getFirstValueInArray() {
        return firstValueInArray;
    }

    public void setFirstValueInArray(Boolean firstValueInArray) {
        this.firstValueInArray = firstValueInArray;
    }

    public ConversionType getConversionType() {
        return conversionType;
    }

    public void setConversionType(ConversionType conversionType) {
        this.conversionType = conversionType;
    }

}
