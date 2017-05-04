package com.inducesmile.androidmultiquiz.adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.inducesmile.androidmultiquiz.MainQuizActivity;
import com.inducesmile.androidmultiquiz.R;
import com.inducesmile.androidmultiquiz.entities.CategoryObject;

import java.util.List;

public class QuizCategoryAdapter extends RecyclerView.Adapter<QuizCategoryViewHolder>{

    private Context context;

    private List<CategoryObject> quizCategoryObject;

    public QuizCategoryAdapter(Context context, List<CategoryObject> quizCategoryObject) {
        this.context = context;
        this.quizCategoryObject = quizCategoryObject;
    }

    @Override
    public QuizCategoryViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.quiz_category_list, parent, false);
        QuizCategoryViewHolder quizCategoryHolder = new QuizCategoryViewHolder(layoutView);
        return quizCategoryHolder;
    }

    @Override
    public void onBindViewHolder(final QuizCategoryViewHolder holder, int position) {
        CategoryObject catObject = quizCategoryObject.get(position);
        final String catName = quizCategoryObject.get(position).getQuizCategoryName();
        final int id = catObject.getId();
        holder.categoryName.setText(catName);

        int imageResource = getResourseId(context, catObject.getQuizCategoryImagePath(), "drawable", context.getPackageName());
        holder.categoryImage.setImageResource(imageResource);

        holder.mItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainQuizIntent = new Intent(context, MainQuizActivity.class);
                mainQuizIntent.putExtra("QUIZ_CATEGORY_NAME", catName);
                mainQuizIntent.putExtra("QUIZ_CATEGORY_ID", id);
                context.startActivity(mainQuizIntent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return quizCategoryObject.size();
    }

    public static int getResourseId(Context context, String pVariableName, String pResourcename, String pPackageName) throws RuntimeException {
        try {
            return context.getResources().getIdentifier(pVariableName, pResourcename, pPackageName);
        } catch (Exception e) {
            throw new RuntimeException("Error getting Resource ID.", e);
        }
    }
}
