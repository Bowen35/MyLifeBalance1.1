package com.inducesmile.androidmultiquiz;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;

import com.inducesmile.androidmultiquiz.adapters.QuizCategoryAdapter;
import com.inducesmile.androidmultiquiz.database.DatabaseQuery;
import com.inducesmile.androidmultiquiz.entities.CategoryObject;

import java.util.List;

public class QuizCategoryActivity extends AppCompatActivity {

    private static final String TAG = QuizCategoryActivity.class.getSimpleName();

    private RecyclerView quizRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_category);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(Html.fromHtml("<font color='#e1c8d6'>Quiz Categories</font>"));
        //setTitle(getString(R.string.quiz_category));

        DatabaseQuery dbQuery = new DatabaseQuery(QuizCategoryActivity.this);
        List<CategoryObject> categoryData = dbQuery.getAllQuizCategory();

        quizRecyclerView = (RecyclerView)findViewById(R.id.quiz_category);
        GridLayoutManager mGrid = new GridLayoutManager(this, 2);
        quizRecyclerView.setLayoutManager(mGrid);
        quizRecyclerView.setHasFixedSize(true);

        QuizCategoryAdapter mAdapter = new QuizCategoryAdapter(QuizCategoryActivity.this, categoryData);
        quizRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onBackPressed() {
        Intent backIntent = new Intent(QuizCategoryActivity.this, QuizMenuActivity.class);
        startActivity(backIntent);
    }
}
