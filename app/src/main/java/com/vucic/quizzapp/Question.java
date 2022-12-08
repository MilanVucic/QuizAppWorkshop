package com.vucic.quizzapp;

import java.util.ArrayList;
import java.util.List;

public class Question {
    private String text;
    private Answer answer1;
    private Answer answer2;
    private Answer answer3;

    public Question(String text, Answer answer1, Answer answer2, Answer answer3) {
        this.text = text;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Answer getAnswer1() {
        return answer1;
    }

    public void setAnswer1(Answer answer1) {
        this.answer1 = answer1;
    }

    public Answer getAnswer2() {
        return answer2;
    }

    public void setAnswer2(Answer answer2) {
        this.answer2 = answer2;
    }

    public Answer getAnswer3() {
        return answer3;
    }

    public void setAnswer3(Answer answer3) {
        this.answer3 = answer3;
    }

    public static List<Question> getAllQuestions() {
        List<Question> list = new ArrayList<>();
        list.add(new Question("What is the height of the Eiffel Tower?", new Answer("324m", true),
                new Answer("899m", false),  new Answer("50m", false)));
        list.add(new Question("What is the capital of Serbia?", new Answer("Cairo", false),
                new Answer("Belgrade", true),  new Answer("Podgorica", false)));
        list.add(new Question("What is the largest country by population?", new Answer("India", false),
                new Answer("USA", false),  new Answer("China", true)));
        return list;
    }
}
