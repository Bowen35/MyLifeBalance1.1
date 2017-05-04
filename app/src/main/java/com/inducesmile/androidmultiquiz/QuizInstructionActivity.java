package com.inducesmile.androidmultiquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.inducesmile.androidmultiquiz.helper.Helper;

public class QuizInstructionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_instruction);

        setTitle("Quiz Instruction");

        TextView instructionText = (TextView)findViewById(R.id.quiz_instruction);
        instructionText.setText(Helper.instruction);
    }
}
