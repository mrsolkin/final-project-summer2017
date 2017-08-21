package com.gdgkazan.summer_school_2017.lessons.lesson_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.gdgkazan.summer_school_2017.R;

/**
 * @author Timur Valiev
 */
public class FirstLessonActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_first_lesson);

        initViews();
    }

    private void initViews() {
        findViewById(R.id.btnFrameLayout).setOnClickListener(this);
        findViewById(R.id.btnLinearLayout).setOnClickListener(this);
        findViewById(R.id.btnRelativeLayout).setOnClickListener(this);
        findViewById(R.id.btnMargin).setOnClickListener(this);
        findViewById(R.id.btnPadding).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnFrameLayout:
                startActivity(new Intent(FirstLessonActivity.this, FrameLayoutActivity.class));
                break;

            case R.id.btnLinearLayout:
                startActivity(new Intent(FirstLessonActivity.this, LinearLayoutActivity.class));
                break;

            case R.id.btnRelativeLayout:
                startActivity(new Intent(FirstLessonActivity.this, RelativeLayoutActivity.class));
                break;

            case R.id.btnMargin:
                startActivity(new Intent(FirstLessonActivity.this, MarginActivity.class));
                break;

            case R.id.btnPadding:
                startActivity(new Intent(FirstLessonActivity.this, PaddingActivity.class));
                break;
        }
    }
}
