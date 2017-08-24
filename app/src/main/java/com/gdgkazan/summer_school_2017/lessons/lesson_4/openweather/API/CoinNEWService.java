package com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API;

import com.gdgkazan.summer_school_2017.lessons.lesson_4.activities.CoinInfo;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by olgasmirnova on 24.08.17.
 */

public interface CoinNEWService {

    @GET("data/histoday")
    Call<CoinInfo> getStory(@Query("fsym") String fsym,
                            @Query("tsym") String tsym,
                            @Query("e") String e,
                            @Query("aggregate") int aggregate,
                            @Query("limit") int limit);
}
