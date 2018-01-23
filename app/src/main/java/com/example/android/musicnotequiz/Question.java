package com.example.android.musicnotequiz;

public class Question {

    // This will point the actual View
    int scaleIdentifier;

    // Text to be showed on each CheckBox
    String answer1;
    String answer2;
    String answer3;
    String answer4;

    // scaleIdentifier will point to the view, the Strings set text for each CheckBox
    Question(int scaleIdentifier, String answer1, String answer2, String answer3, String answer4) {
        this.scaleIdentifier = scaleIdentifier;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
    }

    private boolean isSelected;

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean selected) {
        isSelected = selected;
    }

}
