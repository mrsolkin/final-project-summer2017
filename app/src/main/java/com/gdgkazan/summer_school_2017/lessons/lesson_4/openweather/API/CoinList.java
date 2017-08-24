
package com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class CoinList {

    @SerializedName("Response")
    @Expose
    private String response;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("BaseImageUrl")
    @Expose
    private String baseImageUrl;
    @SerializedName("BaseLinkUrl")
    @Expose
    private String baseLinkUrl;
    @SerializedName("Type")
    @Expose
    private Integer type;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getBaseImageUrl() {
        return baseImageUrl;
    }

    public void setBaseImageUrl(String baseImageUrl) {
        this.baseImageUrl = baseImageUrl;
    }

    public String getBaseLinkUrl() {
        return baseLinkUrl;
    }

    public void setBaseLinkUrl(String baseLinkUrl) {
        this.baseLinkUrl = baseLinkUrl;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Map<String, DIGS> getData() {
        return Data;
    }

    public void setData(Map<String, DIGS> data) {
        Data = data;
    }

    @SerializedName("Data")
    Map<String, DIGS> Data;

    public static class CryptoCoin {
        @SerializedName("Id")
        public int Id;
        @SerializedName("Name")
        public String Name;
        @SerializedName("CoinName")
        public String CoinName;
        @SerializedName("ImageUrl")
        public String ImageUrl;
    }
}
