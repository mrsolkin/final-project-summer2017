package com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API;
import com.gdgkazan.summer_school_2017.lessons.lesson_4.activities.DailyTemp;


import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


/**
 * @author Timur Valiev
 */
public interface WeatherService {

        @GET("forecast/daily")
        Call<DailyTemp> getWeather(@Query("id") int id);

}
