package com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API;

import android.support.annotation.NonNull;

import com.gdgkazan.summer_school_2017.BuildConfig;

import java.io.IOException;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class WeatherInterceptor implements Interceptor {

    @Override
    public Response intercept(@NonNull Chain chain) throws IOException {
        Request original = chain.request();
        HttpUrl originalHttpUrl = original.url();

        HttpUrl url = originalHttpUrl.newBuilder()
                .addQueryParameter("appid", BuildConfig.WEATER_API_ID)
                .addQueryParameter("units", "metric").build();

        // Request customization: add request headers
        Request.Builder requestBuilder = original.newBuilder().url(url);

        Request request = requestBuilder.build();
        return chain.proceed(request);
    }
}