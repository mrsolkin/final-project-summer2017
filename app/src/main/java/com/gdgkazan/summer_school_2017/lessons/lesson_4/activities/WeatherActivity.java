package com.gdgkazan.summer_school_2017.lessons.lesson_4.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.gdgkazan.summer_school_2017.R;
import com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API.ApiFactory;
import com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API.WeatherService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.gdgkazan.summer_school_2017.R.layout.weather;

/**
 * Created by olgasmirnova on 19.08.17.
 */

public class WeatherActivity extends AppCompatActivity{

    private TextView CityName;

    private TextView morn;

    private TextView day;

    private TextView eve;

    private TextView night;

    private TextView date;

    private ProgressDialog loadingDialog;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(weather);

        initViews();

        getTemp();
    }

    private void initViews() {
        day = (TextView) findViewById(R.id.day);
        morn = (TextView) findViewById(R.id.morn);
        eve = (TextView) findViewById(R.id.eve);
        night = (TextView) findViewById(R.id.night);
        date = (TextView) findViewById(R.id.date);
    }

  private void getTemp() {

      WeatherService service = ApiFactory.getRetrofitInstance().create(WeatherService.class);
      service.getWeather(551487).enqueue(new Callback<DailyTemp>() {
          @Override
          public void onResponse(Call<DailyTemp> call, Response<DailyTemp> response) {
              DailyTemp daily = response.body();
              day.setText(String.valueOf(daily.list.get(0).temp.day));
              morn.setText(String.valueOf(daily.list.get(0).temp.morn));
              eve.setText(String.valueOf(daily.list.get(0).temp.eve));
              night.setText(String.valueOf(daily.list.get(0).temp.night));

          }

          @Override
          public void onFailure(Call<DailyTemp> call, Throwable t) {

          }
      });


  }

}
