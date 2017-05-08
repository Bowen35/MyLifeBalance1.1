package com.inducesmile.androidmultiquiz.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.inducesmile.androidmultiquiz.R;

public class QuizResultViewHolder extends RecyclerView.ViewHolder{

    public ImageView imageMark;

    public TextView questionNum;

    public TextView mainQuestion;

    public TextView yourAnswer;



    public QuizResultViewHolder(View itemView) {
        super(itemView);

        imageMark = (ImageView)itemView.findViewById(R.id.question_icon);
        questionNum = (TextView)itemView.findViewById(R.id.question_number);
        mainQuestion = (TextView)itemView.findViewById(R.id.real_question);
        yourAnswer = (TextView)itemView.findViewById(R.id.your_answer);
    }
}
