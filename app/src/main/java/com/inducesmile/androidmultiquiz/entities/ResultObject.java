package com.inducesmile.androidmultiquiz.entities;


public class ResultObject {

    private String questionNumber;

    private String questionTitle;

    private String selectedAnswer;


    public ResultObject(String questionNumber, String questionTitle, String selectedAnswer) {
        this.questionNumber = questionNumber;
        this.questionTitle = questionTitle;
        this.selectedAnswer = selectedAnswer;

    }

    public String getQuestionNumber() {
        return questionNumber;
    }

    public String getQuestionTitle() {
        return questionTitle;
    }

    public String getSelectedAnswer() {
        return selectedAnswer;
    }
}
