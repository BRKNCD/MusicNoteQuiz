package com.example.android.musicnotequiz;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView scale;
    CheckBox answer1;
    CheckBox answer2;
    CheckBox answer3;
    CheckBox answer4;
    ImageButton submitButton;
    TextView result;

    List<Question> questionList;
    RecyclerView question;
    LinearLayoutManager recyclerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        scale = (ImageView) findViewById(R.id.image);
        answer1 = (CheckBox) findViewById(R.id.answer1);
        answer2 = (CheckBox) findViewById(R.id.answer2);
        answer3 = (CheckBox) findViewById(R.id.answer3);
        answer4 = (CheckBox) findViewById(R.id.answer4);
        submitButton = (ImageButton) findViewById(R.id.submit);
        result = (TextView) findViewById(R.id.result);

        // Initialize the RecyclerView & setHasFixedSize = true for better performance
        question = (RecyclerView) findViewById(R.id.question_recicleview);
        recyclerLayout = new LinearLayoutManager(this);
        question.setLayoutManager(recyclerLayout);
        question.setHasFixedSize(true);

        initializeData();
        initializeAdapter();

        submitButton.setOnClickListener( new View.OnClickListener()
        {
            public void onClick (View v){


                if (answer1.isChecked() && answer2.isChecked() && !answer3.isChecked() && !answer4.isChecked()){
                    result.setText("YOU WIN");
                }else{result.setText("YOU LOOSE");}
            }
        });
    }

    private void initializeData(){
        questionList = new ArrayList<>();
        questionList.add(new Question(R.drawable.ritaglio_0000, "C Major", "C minor", "F Major", "E Major"));
        questionList.add(new Question(R.drawable.ritaglio_0001, "C Major", "C minor", "F Major", "E Major"));
        questionList.add(new Question(R.drawable.ritaglio_0002, "C Major", "C minor", "F Major", "E Major"));
        questionList.add(new Question(R.drawable.ritaglio_0003, "C Major", "C minor", "F Major", "E Major"));
        questionList.add(new Question(R.drawable.ritaglio_0004, "C Major", "C minor", "F Major", "E Major"));
    }

    private void initializeAdapter(){
        QuestionAdapter adapter = new QuestionAdapter(questionList);
        question.setAdapter(adapter);
    }


}
