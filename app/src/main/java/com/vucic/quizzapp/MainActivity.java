package com.vucic.quizzapp;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button answer1Button, answer2Button, answer3Button;
    TextView questionTextView;
    TextView pointsTextView;
    TextView timerTextView;
    Question currentQuestion;
    int currentQuestionIndex = 0;
    List<Question> questions;
    int points = 0;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUI();
        questions = Question.getAllQuestions();
        Question question = questions.get(currentQuestionIndex);
        currentQuestion = question;
        displayQuestion(question);
        startTimer();
    }

    private void startTimer() {
        countDownTimer = new CountDownTimer(10000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                updateTime(millisUntilFinished);
            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();
    }

    private void updateTime(long millisUntilFinished) {
        timerTextView.setText("Time: " + (millisUntilFinished / 1000));
    }

    private void displayQuestion(Question question) {
        questionTextView.setText(question.getText());
        answer1Button.setText(question.getAnswer1().getText());
        answer2Button.setText(question.getAnswer2().getText());
        answer3Button.setText(question.getAnswer3().getText());
    }

    private void setupUI() {
        questionTextView = findViewById(R.id.questionTextView);
        answer1Button = findViewById(R.id.answer1Button);
        answer2Button = findViewById(R.id.answer2Button);
        answer3Button = findViewById(R.id.answer3Button);
        pointsTextView = findViewById(R.id.pointsTextView);
        timerTextView = findViewById(R.id.timerTextView);
        pointsTextView.setText("Points: 0");

        answer1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestion.getAnswer1().isCorrect()) {
                    correctAnswer();
                } else {
                    incorrectAnswer();
                }
            }
        });
        answer2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestion.getAnswer2().isCorrect()) {
                    correctAnswer();
                } else {
                    incorrectAnswer();
                }
            }
        });
        answer3Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentQuestion.getAnswer3().isCorrect()) {
                    correctAnswer();
                } else {
                    incorrectAnswer();
                }
            }
        });
    }

    private void correctAnswer() {
        changePoints(5);
        moveToNextQuestion();
        Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
    }

    private void changePoints(int toAdd) {
        points += toAdd;
        pointsTextView.setText("Points: " + points);
    }

    private void moveToNextQuestion() {
        currentQuestionIndex++;
        if (currentQuestionIndex >= questions.size()) {
            Toast.makeText(this, "End", Toast.LENGTH_SHORT).show();
        } else {
            currentQuestion = questions.get(currentQuestionIndex);
            displayQuestion(currentQuestion);
        }
    }

    private void incorrectAnswer() {
        changePoints(-3);
        moveToNextQuestion();
        Toast.makeText(this, "Incorrect", Toast.LENGTH_SHORT).show();
    }
}