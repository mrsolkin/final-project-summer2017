package com.gdgkazan.summer_school_2017.lessons.lesson_4.activities;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by olgasmirnova on 21.08.17.
 */

public class ChuckJoke {

    @SerializedName("value") public List<Value> list;
    public static class Value {
        @SerializedName("joke")
        public String joke;
    }
}
