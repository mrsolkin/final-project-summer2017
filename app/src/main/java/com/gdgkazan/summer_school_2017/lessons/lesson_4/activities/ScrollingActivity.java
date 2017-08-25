package com.gdgkazan.summer_school_2017.lessons.lesson_4.activities;

import android.content.Intent;
import android.graphics.Color;
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
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

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
    @BindView(R.id.fab)
    FloatingActionButton mFab;

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

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_SEND);
                i.setType("text/plain");
                i.putExtra(Intent.EXTRA_TEXT, "Text"); // тут text заменить на то что хотим расшарить
//                i.putExtra(Intent.EXTRA_SUBJECT, "Subject");
                i = Intent.createChooser(i, "Отправить текущий курс");
                startActivity(i);
            }
        });
    }

    private void setupChart() {
//        mLineChart.setDrawBarShadow(false);
//        mLineChart.setDrawValueAboveBar(true);

        mLineChart.getDescription().setEnabled(false);

        // Если на экране отображается больше 60 значение, то подписи будут скрываться
        mLineChart.setMaxVisibleValueCount(60);
        mLineChart.setDrawGridBackground(false);
//        mLineChart.setBorderColor(Color.YELLOW);
//        mLineChart.setBorderWidth((float) 0.5);
//        mLineChart.setBackgroundColor(Color.YELLOW);
        // Устанавливаем что ось x будет подстраиваться под максимальное значение
//        mLineChart.setFitBars(true);
        XAxis xAxis = mLineChart.getXAxis();
//        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd MMM");
                return sdf.format(new Date(new Float(value).longValue()));
            }
        });
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
                    entries.add(new Entry(datum.getTime()*1000L, datum.getClose()));
                }

                float coinprice = mHistory.getData().get(mHistory.getData().size()-1).getClose();
                name_symbol.setText("1"+name+" = "+String.format("%.4f", coinprice)+"$");

                LineDataSet dataSet = new LineDataSet(entries, "Test lbl");
                dataSet.disableDashedLine();
                dataSet.setLineWidth(2f);
                dataSet.setDrawCircles(false);
                dataSet.setColor(Color.BLUE);
                dataSet.setDrawFilled(true);
                dataSet.setFillColor(Color.BLUE);
                dataSet.setFillAlpha(65);
                dataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
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
