package com.example.android.musicnotequiz;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.QuestionViewHolder> {

    // THOSE ARE FOR CHECK THE ANSWERS IN THE CHECKBOX
    private LayoutInflater inflater;
    public static ArrayList<Question> questionStoreArray;
    private Context ctx;


    public static class QuestionViewHolder extends RecyclerView.ViewHolder {

        // declaring my Views
        ImageView scale;
        CheckBox answer1;
        CheckBox answer2;
        CheckBox answer3;
        CheckBox answer4;

        // Initialize my Views
        QuestionViewHolder(View itemView) {
            super(itemView);
            answer1 = (CheckBox) itemView.findViewById(R.id.answer1);
            answer2 = (CheckBox) itemView.findViewById(R.id.answer2);
            answer3 = (CheckBox) itemView.findViewById(R.id.answer3);
            answer4 = (CheckBox) itemView.findViewById(R.id.answer4);
            scale   = (ImageView) itemView.findViewById(R.id.image_view);
        }
    }

    // List containing Question object with my entire View inflated by ImageView, TextView, and four CheckBox
    List<Question> questionList;

    QuestionAdapter(List<Question> questionList) {
        this.questionList = questionList;
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public QuestionViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item, viewGroup, false);
        QuestionViewHolder pvh = new QuestionViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final QuestionViewHolder questionViewHolder, int i) {
        questionViewHolder.answer1.setText(questionList.get(i).answer1);
        questionViewHolder.answer2.setText(questionList.get(i).answer2);
        questionViewHolder.answer3.setText(questionList.get(i).answer3);
        questionViewHolder.answer4.setText(questionList.get(i).answer4);
        questionViewHolder.scale.setImageResource(questionList.get(i).scaleIdentifier);

        //in some cases, it will prevent unwanted situations
        questionViewHolder.answer1.setOnCheckedChangeListener(null);

        //if true, your checkbox will be selected, else unselected
        questionViewHolder.answer1.setChecked(questionList.get(i).isSelected());

        questionViewHolder.answer1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                questionList.get(questionViewHolder.getAdapterPosition()).setSelected(isChecked);
            }
        });
    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }
}