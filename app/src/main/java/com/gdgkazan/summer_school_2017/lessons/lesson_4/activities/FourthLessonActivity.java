package com.gdgkazan.summer_school_2017.lessons.lesson_4.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.gdgkazan.summer_school_2017.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Timur Valiev
 */
public class FourthLessonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_fourth_lesson);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnIntent)
    public void openIntentExampleScreen() {
        Intent intent = new Intent(this, IntentExampleActivity.class);
        intent.putExtra(IntentExampleActivity.EXTRA_INFO, "Текст для отображения на экране");
        startActivity(intent);
    }

    @OnClick(R.id.btnCharts)
    public void openChartsScreen() {
        startActivity(new Intent(this, ChartsExampleActivity.class));
    }
}
