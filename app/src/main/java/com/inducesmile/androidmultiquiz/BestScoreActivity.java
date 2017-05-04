package com.inducesmile.androidmultiquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.pavlospt.CircleView;
import com.inducesmile.androidmultiquiz.helper.MySharedPreference;

public class BestScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_best_score);

        setTitle(getString(R.string.your_best_score));

        CircleView circleTitle = (CircleView)findViewById(R.id.your_best_score);
        circleTitle.setSubtitleText("");

        MySharedPreference sharedPreference = new MySharedPreference(BestScoreActivity.this);
        int bestScore = sharedPreference.getCurrentHighestQuizScore();

        circleTitle.setTitleText(String.valueOf(bestScore) + "%");
    }
}
