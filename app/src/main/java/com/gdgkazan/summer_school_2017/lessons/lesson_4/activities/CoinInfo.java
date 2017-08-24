package com.gdgkazan.summer_school_2017.lessons.lesson_4.activities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by olgasmirnova on 21.08.17.
 */

public class CoinInfo {
    @SerializedName("name")
    public String name;
    @SerializedName("symbol")
    public String symbol;
    @SerializedName("price_usd")
    public String price_usd;
    @SerializedName("last_updated")
    public String last_updated;
    @SerializedName("percent_change_1h")
    public String percent_change_1h;
    @SerializedName("percent_change_24h")
    public String percent_change_24h;
    @SerializedName("percent_change_7d")
    public String percent_change_7d;
}
