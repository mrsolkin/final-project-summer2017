package com.gdgkazan.summer_school_2017;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.gdgkazan.summer_school_2017.homeworks.homework_1.activities.FirstHomeworkActivity;
import com.gdgkazan.summer_school_2017.lessons.lesson_1.FirstLessonActivity;
import com.gdgkazan.summer_school_2017.lessons.lesson_2.SecondLessonActivity;
import com.gdgkazan.summer_school_2017.lessons.lesson_3.activities.BeersActivity;
import com.gdgkazan.summer_school_2017.lessons.lesson_4.activities.FourthLessonActivity;
import com.gdgkazan.summer_school_2017.lessons.lesson_4.activities.WeatherActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_main);

        initViews();
    }

    private void initViews() {
        findViewById(R.id.llLesson1).setOnClickListener(this);
        findViewById(R.id.llLesson2).setOnClickListener(this);
        findViewById(R.id.llLesson3).setOnClickListener(this);
        findViewById(R.id.llLesson4).setOnClickListener(this);
        findViewById(R.id.llHomework1).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.llLesson1:
                startActivity(new Intent(MainActivity.this, FirstLessonActivity.class));
                break;
            case R.id.llLesson2:
                startActivity(new Intent(MainActivity.this, SecondLessonActivity.class));
                break;
            case R.id.llLesson3:
                startActivity(new Intent(MainActivity.this, WeatherActivity.class));
                break;
            case R.id.llLesson4:
                startActivity(new Intent(MainActivity.this, FourthLessonActivity.class));
                break;
            case R.id.llHomework1:
                startActivity(new Intent(MainActivity.this, FirstHomeworkActivity.class));
                break;
        }
    }
}
