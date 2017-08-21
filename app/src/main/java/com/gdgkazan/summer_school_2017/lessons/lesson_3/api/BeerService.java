package com.gdgkazan.summer_school_2017.lessons.lesson_3.api;

import com.gdgkazan.summer_school_2017.lessons.lesson_3.models.Beer;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * @author Timur Valiev
 */
public interface BeerService {

    @GET("beers/random")
    Call<List<Beer>> getRandomBeer();

    @GET("beers/{id}")
    Call<List<Beer>> getBeerById(@Path("id") long id);

    @GET("beers")
    Call<List<Beer>> getBeerWithFilter(@Query("brewed_before") String date,
                                       @Query("abv_gt") int abvGt);

}
