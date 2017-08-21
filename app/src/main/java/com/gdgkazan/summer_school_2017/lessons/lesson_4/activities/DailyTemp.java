package com.gdgkazan.summer_school_2017.lessons.lesson_4.activities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by olgasmirnova on 19.08.17.
 */

    public class DailyTemp {

        @SerializedName("list") public List<Forecast> list;
        public static class Forecast{
            @SerializedName("dt") public long dt;
            @SerializedName("temp") public Temp temp;
            public static class Temp {
                @SerializedName("day") public double day;
                @SerializedName("eve") public double eve;
                @SerializedName("night") public double night;
                @SerializedName("morn") public double morn;
            }
    }
}
