package com.gdgkazan.summer_school_2017.lessons.lesson_4.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.gdgkazan.summer_school_2017.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Timur Valiev
 */
public class IntentExampleActivity extends AppCompatActivity {

    public static final String EXTRA_INFO = "extra_info";

    @BindView(R.id.tvInfo) TextView mInfo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ac_intent_example);
        ButterKnife.bind(this);

        String info = getIntent().getStringExtra(EXTRA_INFO);
        mInfo.setText(info);
    }
}
