package com.gdgkazan.summer_school_2017.lessons.lesson_3.activities;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gdgkazan.summer_school_2017.R;
import com.gdgkazan.summer_school_2017.lessons.lesson_3.api.ApiFactory;
import com.gdgkazan.summer_school_2017.lessons.lesson_3.api.BeerService;
import com.gdgkazan.summer_school_2017.lessons.lesson_3.models.Beer;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * @author Timur Valiev
 */
public class BeersActivity extends AppCompatActivity {

    private ImageView beerImage;

    private TextView beerName;

    private TextView beerTagLine;

    private TextView beerAbv;

    private TextView beerIbu;

    private TextView beerSrm;

    private TextView beerDescription;

    private BeerService beerService;

    private ProgressDialog loadingDialog;

    @SerializedName("day")
    @Expose
    private Double day;
    @SerializedName("min")
    @Expose
    private Double min;
    @SerializedName("max")
    @Expose
    private Double max;
    @SerializedName("night")
    @Expose
    private Double night;
    @SerializedName("eve")
    @Expose
    private Double eve;
    @SerializedName("morn")
    @Expose
    private Double morn;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_beer);

        initViews();

        loadingDialog = ProgressDialog.show(this, "", getString(R.string.network_loading), true);

        // Создаем сервис через который будет выполняться запрос
        beerService = ApiFactory.getRetrofitInstance().create(BeerService.class);
        fetchBeerWithFilter("11-2012", 6);
    }

    private void initViews() {
        beerImage = (ImageView) findViewById(R.id.ivBeer);
        beerName = (TextView) findViewById(R.id.tvBeerName);
        beerTagLine = (TextView) findViewById(R.id.tvBeerTagLine);
        beerAbv = (TextView) findViewById(R.id.tvBeerAbv);
        beerIbu = (TextView) findViewById(R.id.tvBeerIbu);
        beerSrm = (TextView) findViewById(R.id.tvBeerSrm);
        beerDescription = (TextView) findViewById(R.id.tvBeerDescription);
    }

    private void fetchRandomBeer() {
        // Создаем экземпляр запроса со всем необходимыми настройками
        Call<List<Beer>> call = beerService.getRandomBeer();

        // Отображаем progress bar
        loadingDialog.show();

        // Выполняем запрос асинхронно
        call.enqueue(new Callback<List<Beer>>() {

            // В случае если запрос выполнился успешно, то мы переходим в метод onResponse(...)
            @Override
            public void onResponse(@NonNull Call<List<Beer>> call, @NonNull Response<List<Beer>> response) {
                if (response.isSuccessful()) {
                    // Если в ответ нам пришел код 2xx, то отображаем содержимое запроса
                    fillBeerInfo(response.body().get(0));

                } else {
                    // Если пришел код ошибки, то обрабатываем её
                    Toast.makeText(BeersActivity.this, R.string.network_error, Toast.LENGTH_SHORT).show();
                }

                // Скрываем progress bar
                loadingDialog.dismiss();
            }

            // Если запрос не удалось выполнить, например, на телефоне отсутствует подключение к интернету
            @Override
            public void onFailure(@NonNull Call<List<Beer>> call, @NonNull Throwable t) {
                // Скрываем progress bar
                loadingDialog.dismiss();

                Toast.makeText(BeersActivity.this, R.string.network_error, Toast.LENGTH_SHORT).show();
                Log.d("Error", t.getMessage());
            }
        });
    }

    private void fetchBeerWithFilter(String date, int abvGt) {
        // Создаем экземпляр запроса со всем необходимыми настройками
        Call<List<Beer>> call = beerService.getBeerWithFilter(date, abvGt);

        // Отображаем progress bar
        loadingDialog.show();

        // Выполняем запрос асинхронно
        call.enqueue(new Callback<List<Beer>>() {

            // В случае если запрос выполнился успешно, то мы переходим в метод onResponse(...)
            @Override
            public void onResponse(@NonNull Call<List<Beer>> call, @NonNull Response<List<Beer>> response) {
                if (response.isSuccessful()) {
                    // Если в ответ нам пришел код 2xx, то отображаем содержимое запроса
                    fillBeerInfo(response.body().get(0));

                } else {
                    // Если пришел код ошибки, то обрабатываем её
                    Toast.makeText(BeersActivity.this, R.string.network_error, Toast.LENGTH_SHORT).show();
                }

                // Скрываем progress bar
                loadingDialog.dismiss();
            }

            // Если запрос не удалось выполнить, например, на телефоне отсутствует подключение к интернету
            @Override
            public void onFailure(@NonNull Call<List<Beer>> call, @NonNull Throwable t) {
                // Скрываем progress bar
                loadingDialog.dismiss();

                Toast.makeText(BeersActivity.this, R.string.network_error, Toast.LENGTH_SHORT).show();
                Log.d("Error", t.getMessage());
            }
        });
    }


    private void fetchBeerById(long id) {
        // Создаем экземпляр запроса со всем необходимыми настройками
        Call<List<Beer>> call = beerService.getBeerById(id);

        // Отображаем progress bar
        loadingDialog.show();

        // Выполняем запрос асинхронно
        call.enqueue(new Callback<List<Beer>>() {

            // В случае если запрос выполнился успешно, то мы переходим в метод onResponse(...)
            @Override
            public void onResponse(@NonNull Call<List<Beer>> call, @NonNull Response<List<Beer>> response) {
                if (response.isSuccessful()) {
                    // Если в ответ нам пришел код 2xx, то отображаем содержимое запроса
                    fillBeerInfo(response.body().get(0));

                } else {
                    // Если пришел код ошибки, то обрабатываем её
                    Toast.makeText(BeersActivity.this, R.string.network_error, Toast.LENGTH_SHORT).show();
                }

                // Скрываем progress bar
                loadingDialog.dismiss();
            }

            // Если запрос не удалось выполнить, например, на телефоне отсутствует подключение к интернету
            @Override
            public void onFailure(@NonNull Call<List<Beer>> call, @NonNull Throwable t) {
                // Скрываем progress bar
                loadingDialog.dismiss();

                Toast.makeText(BeersActivity.this, R.string.network_error, Toast.LENGTH_SHORT).show();
                Log.d("Error", t.getMessage());
            }
        });
    }


    private void fillBeerInfo(@NonNull Beer beer) {
        Picasso.with(this)
                .load(beer.getImageUrl())
                .into(beerImage);

        beerName.setText(beer.getName());
        beerTagLine.setText(beer.getTagLine());
        beerAbv.setText(String.valueOf(beer.getAbv()));
        beerIbu.setText(String.valueOf(beer.getIbu()));
        beerSrm.setText(String.valueOf(beer.getSrm()));
        beerDescription.setText(beer.getDescription());
    }

}
