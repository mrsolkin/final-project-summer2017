package com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API;

import android.support.annotation.NonNull;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.gdgkazan.summer_school_2017.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class ApiFactory {

    private static final String API_FOR_LIST = "https://www.cryptocompare.com/api/";

    private static final String API_FOR_HISTORY = "https://min-api.cryptocompare.com/";

    private static Retrofit sRetrofit_list;
    private static Retrofit sRetrofit_history;

    private static OkHttpClient sHttpClient;

    private ApiFactory() {
        throw new IllegalStateException("Final class can not be instantiated");
    }

    @NonNull
    public static Retrofit getRetrofitInstance(Retrofit sRetrofit, String api_url) {
        if (sRetrofit == null) {
            sRetrofit = new Retrofit.Builder()
                    .baseUrl(api_url)
                    .client(sHttpClient == null ? sHttpClient = provideClient() : sHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return sRetrofit;
    }

    public static Retrofit getsRetrofitInstanceForList(){
        return getRetrofitInstance(sRetrofit_list, API_FOR_LIST);
    }

    public static Retrofit getsRetrofitInstanceForHistory(){
        return getRetrofitInstance(sRetrofit_history, API_FOR_HISTORY);
    }

    private static OkHttpClient provideClient() {
        final OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            builder.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
            builder.addNetworkInterceptor(new StethoInterceptor());
        }
        builder.addInterceptor(new WeatherInterceptor());
        return builder.build();
    }
}



