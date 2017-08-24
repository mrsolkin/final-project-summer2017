package com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface CryptocoinHistoryService {

    @GET("data/histominute")
    Call<CoinHistory> getMinuteHistory(@Query("fsym") String fromSymbol,
                                       @Query("tsym") String toSymbol,
                                       @Query("e") String exhangeName,
                                       @Query("aggregate") int aggregate,
                                       @Query("limit") int limit);
}
