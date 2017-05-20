package com.inducesmile.androidmultiquiz.entities;

public class QuestionObject {

    private int id;

    private String question;

    private String options;



    public QuestionObject(int id, String question, String options) {
        this.id = id;
        this.question = question;
        this.options = options;

    }

    public int getId() {
        return id;
    }

    public String getQuestion() {
        return question;
    }

    public String getOptions() {
        return options;
    }



    public String[] convertOptionsToStringArray(String options) {
        String[] allOptions = options.split(",");
        return allOptions;
    }


}
