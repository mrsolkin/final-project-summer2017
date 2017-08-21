package com.gdgkazan.summer_school_2017.lessons.lesson_4.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gdgkazan.summer_school_2017.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Timur Valiev
 */
public class ChartsExampleActivity extends AppCompatActivity {

    @BindView(R.id.barChart) BarChart mBarChart;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_charts_exapmle);
        ButterKnife.bind(this);

        setupChart();
        addDataToChart();

    }

    private void addDataToChart() {
        List<BarEntry> entries = new ArrayList<>();
        entries.add(new BarEntry(0f, 30f));
        entries.add(new BarEntry(1f, 80f));
        entries.add(new BarEntry(2f, 60f));
        entries.add(new BarEntry(3f, 50f));
        // gap of 2f
        entries.add(new BarEntry(5f, 70f));
        entries.add(new BarEntry(6f, 60f));


        BarDataSet set = new BarDataSet(entries, "Test bar data set");

        BarData data = new BarData(set);
        // устанавливаем ширину полосок графика
        data.setBarWidth(0.9f);
        mBarChart.setData(data);
        mBarChart.invalidate(); // refresh
    }

    private void setupChart() {
        mBarChart.setDrawBarShadow(false);
        mBarChart.setDrawValueAboveBar(true);

        mBarChart.getDescription().setEnabled(false);

        // Если на экране отображается больше 60 значение, то подписи будут скрываться
        mBarChart.setMaxVisibleValueCount(60);

        mBarChart.setDrawGridBackground(false);

        // Устанавливаем что ось x будет подстраиваться под максимальное значение
        mBarChart.setFitBars(true);
    }

}
