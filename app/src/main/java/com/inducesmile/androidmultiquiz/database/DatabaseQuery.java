package com.inducesmile.androidmultiquiz.database;


import android.content.Context;
import android.database.Cursor;

import com.inducesmile.androidmultiquiz.entities.CategoryObject;
import com.inducesmile.androidmultiquiz.entities.QuestionObject;

import java.util.ArrayList;
import java.util.List;

public class DatabaseQuery extends DatabaseObject{

    public DatabaseQuery(Context context) {
        super(context);
    }

    public List<CategoryObject> getAllQuizCategory(){
        List<CategoryObject> categoryList = new ArrayList<CategoryObject>();
        String query = "select * from category";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                int categoryId = cursor.getInt(cursor.getColumnIndexOrThrow("id"));
                String name = cursor.getString(cursor.getColumnIndexOrThrow("name"));
                String image = cursor.getString(cursor.getColumnIndexOrThrow("image"));
                categoryList.add(new CategoryObject(categoryId, name, image));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return categoryList;
    }

    public List<QuestionObject> getQuizQuestionsById(int id){
        List<QuestionObject> quizQuestionList = new ArrayList<QuestionObject>();
        String query = "select * from quiz where id =" +  id;
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                int quiz_id = cursor.getInt(cursor.getColumnIndexOrThrow("quiz_id"));
                String question = cursor.getString(cursor.getColumnIndexOrThrow("question"));
                String options = cursor.getString(cursor.getColumnIndexOrThrow("options"));
                String answer = cursor.getString(cursor.getColumnIndexOrThrow("answer"));
                quizQuestionList.add(new QuestionObject(quiz_id, question, options, answer));
            }while(cursor.moveToNext());
        }
        cursor.close();
        return quizQuestionList;
    }

    /*public List<FavouriteObject> getFavoriteNews(){
        List<FavouriteObject> favoriteObject = new ArrayList<FavouriteObject>();
        String query = "select * from favorite";
        Cursor cursor = this.getDbConnection().rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                int id = cursor.getInt(0);
                String favorite = cursor.getString(cursor.getColumnIndexOrThrow("favorite"));
                favoriteObject.add(new FavouriteObject(id, favorite));
            }while (cursor.moveToNext());
        }
        cursor.close();
        return favoriteObject;
    }

    public void addNewRecipeFavorite(String favorite){
        ContentValues values = new ContentValues();
        values.put("favorite", favorite);
        getDbConnection().insert("favorite", null, values);
    }

    public boolean deleteFavorite(int id){
        return getDbConnection().delete("favorite", "id = " + id, null) > 0;
    }*/
}
