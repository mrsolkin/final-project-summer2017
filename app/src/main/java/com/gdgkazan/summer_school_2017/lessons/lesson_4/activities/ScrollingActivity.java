package com.gdgkazan.summer_school_2017.lessons.lesson_4.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.gdgkazan.summer_school_2017.R;
import com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API.ApiFactory;
import com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API.CoinHistory;
import com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API.CryptocoinHistoryService;
import com.gdgkazan.summer_school_2017.lessons.lesson_4.openweather.API.Datum;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.gdgkazan.summer_school_2017.R.id.fab;

public class ScrollingActivity extends AppCompatActivity {
    private String name;
    private String symbol;
    private String price;

    @BindView(R.id.name_symbol) public TextView name_symbol;
    @BindView(R.id.barChart)
    LineChart mLineChart;

    public static final String KEY_COIN_NAME = "COIN_NAME";
    public static final String KEY_COIN_PRICE = "COIN_PRICE";
    public static final String KEY_COIN_SYMBOL = "COIN_SYMBOL";

    public ScrollingActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this);
        Intent intent = getIntent();
        name = intent.getStringExtra(KEY_COIN_NAME);
//        price = intent.getStringExtra(KEY_COIN_PRICE);
        symbol = intent.getStringExtra(KEY_COIN_SYMBOL);
        setTitle(symbol+" ("+name+")");
        name_symbol.setText("1"+name+" = "+price+"$");
        setupChart();
        getCryptocoinsHistory();

//        FloatingActionButton fab = (FloatingActionButton) findViewById(fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
    }

    private void setupChart() {
//        mLineChart.setDrawBarShadow(false);
//        mLineChart.setDrawValueAboveBar(true);

        mLineChart.getDescription().setEnabled(false);

        // Если на экране отображается больше 60 значение, то подписи будут скрываться
        mLineChart.setMaxVisibleValueCount(60);

        mLineChart.setDrawGridBackground(false);

        // Устанавливаем что ось x будет подстраиваться под максимальное значение
//        mLineChart.setFitBars(true);
    }

    void getCryptocoinsHistory() {
            CryptocoinHistoryService service = ApiFactory
                    .getsRetrofitInstanceForHistory()
                    .create(CryptocoinHistoryService.class);

        service.getMinuteHistory(name, "USD", "CCCAGG", 3, 60).enqueue(new Callback<CoinHistory>() {
            @Override
            public void onResponse(Call<CoinHistory> call, Response<CoinHistory> response) {
                CoinHistory mHistory = response.body();

                List<Entry> entries = new ArrayList<Entry>();
                for (Datum datum: mHistory.getData()) {
                    entries.add(new Entry(datum.getTime(), datum.getClose()));
                }

                float coinprice = mHistory.getData().get(mHistory.getData().size()-1).getClose();
                name_symbol.setText("1"+name+" = "+String.format("%.4f", coinprice)+"$");

                LineDataSet dataSet = new LineDataSet(entries, "Test lbl");
                LineData lineData = new LineData(dataSet);
                mLineChart.setData(lineData);
                mLineChart.invalidate();
            }

            @Override
            public void onFailure(Call<CoinHistory> call, Throwable t) {
                Toast.makeText(ScrollingActivity.this, "Не удалось получить данные", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
