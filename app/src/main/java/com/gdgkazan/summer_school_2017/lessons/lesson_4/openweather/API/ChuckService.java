package com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API;

import com.gdgkazan.summer_school_2017.lessons.lesson_4.activities.ChuckJoke;
import com.gdgkazan.summer_school_2017.lessons.lesson_4.activities.DailyTemp;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by olgasmirnova on 20.08.17.
 */

public interface ChuckService {

    @GET("jokes/random/30")
    Call<ChuckJoke> getJoke(@Query("firstName") String name, @Query("lastName") String surname);

}
