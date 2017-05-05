package com.inducesmile.androidmultiquiz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.inducesmile.androidmultiquiz.adapters.QuizResultAdapter;
import com.inducesmile.androidmultiquiz.entities.ResultObject;
import com.inducesmile.androidmultiquiz.entities.ScoreObject;

import java.util.List;

public class ResultAnalysisActivity extends AppCompatActivity {

    private static final String TAG = ResultAnalysisActivity.class.getSimpleName();

    private RecyclerView resultRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result_analysis);

        setTitle(getString(R.string.quiz_result_analysis));

        resultRecyclerView = (RecyclerView)findViewById(R.id.quiz_result_analysis);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(ResultAnalysisActivity.this);
        resultRecyclerView.setLayoutManager(linearLayoutManager);
        resultRecyclerView.setHasFixedSize(true);

        String mQuizResult = getIntent().getExtras().getString("RESULT");
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        ScoreObject storedResult = gson.fromJson(mQuizResult, ScoreObject.class);
        List<ResultObject> getStoredResults = storedResult.getQuizResultObject();
        if(getStoredResults != null){
            Log.d(TAG, " Result score " + getStoredResults.size());
        }

        QuizResultAdapter resultAdapter = new QuizResultAdapter(ResultAnalysisActivity.this, getStoredResults);
        resultRecyclerView.setAdapter(resultAdapter);

        Button homeButton = (Button)findViewById(R.id.home_button);
        assert homeButton != null;
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent retakeQuizIntent = new Intent(ResultAnalysisActivity.this, QuizCategoryActivity.class);
                startActivity(retakeQuizIntent);
            }
        });
    }
}
