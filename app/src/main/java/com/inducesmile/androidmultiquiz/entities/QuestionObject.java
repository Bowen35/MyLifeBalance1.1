package com.inducesmile.androidmultiquiz.entities;

public class QuestionObject {

    private int id;

    private String question;

    private String options;

    private String answer;

    public QuestionObject(int id, String question, String options, String answer) {
        this.id = id;
        this.question = question;
        this.options = options;
        this.answer = answer;
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

    public String getAnswer() {
        return answer;
    }

    public String[] convertOptionsToStringArray(String options) {
        String[] allOptions = options.split(",");
        return allOptions;
    }

    public boolean isAnswerCorrect(String[] options, String answer) {
        for (int i = 0; i < options.length; i++) {
            if (options[i].equals(answer)) {
                return true;
            }
        }
        return false;
    }
}
