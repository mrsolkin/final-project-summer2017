package com.gdgkazan.summer_school_2017.homeworks.homework_1.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gdgkazan.summer_school_2017.R;

/**
 * @author Timur Valiev
 */
public class FirstHomeworkActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_first_homework);

        initViews();
    }

    private void initViews() {
        findViewById(R.id.btnCalculator).setOnClickListener(this);
        findViewById(R.id.btnUserProfile).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCalculator:
                startActivity(new Intent(FirstHomeworkActivity.this, CalculatorActivity.class));
                break;
            case R.id.btnUserProfile:
                startActivity(new Intent(FirstHomeworkActivity.this, UserProfileActivity.class));
        }
    }
}
