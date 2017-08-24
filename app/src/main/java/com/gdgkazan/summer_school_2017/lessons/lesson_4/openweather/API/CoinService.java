package com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API;

import com.gdgkazan.summer_school_2017.lessons.lesson_4.activities.CoinInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by olgasmirnova on 20.08.17.
 */

public interface CoinService {

    @GET("ticker")
    Call<CoinInfo> getPrice(@Query("limit") int limit);

}
