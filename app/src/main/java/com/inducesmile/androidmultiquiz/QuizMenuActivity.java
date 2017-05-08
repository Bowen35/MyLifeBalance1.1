package com.inducesmile.androidmultiquiz;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class QuizMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_menu);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ActionBar actionBar = getSupportActionBar();
        if(null != actionBar){
            actionBar.hide();
        }

        Button selectQuiz = (Button)findViewById(R.id.start_quiz_button);
        assert selectQuiz != null;
        selectQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent quizCategoryIntent = new Intent(QuizMenuActivity.this, QuizCategoryActivity.class);
                startActivity(quizCategoryIntent);
            }
        });

        Button quizInstruction = (Button)findViewById(R.id.quiz_instruction_button);
        assert quizInstruction != null;
        quizInstruction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent instructionIntent = new Intent(QuizMenuActivity.this, QuizInstructionActivity.class);
                startActivity(instructionIntent);
            }
        });

//        Button bestQuiz = (Button)findViewById(R.id.quiz_score_button);
//        assert bestQuiz != null;
//        bestQuiz.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent bestScoreIntent = new Intent(QuizMenuActivity.this, BestScoreActivity.class);
//                startActivity(bestScoreIntent);
//            }
//        });
    }
}
