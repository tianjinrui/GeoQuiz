package com.example.a65175.geoquiz;

/**
 * Created by 65175 on 2017/10/15.
 */

public class Question {
    private int mTextResId;
    private boolean mAnswerTrue;

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }

    public int getTextResId() {

        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public Question(int textResId, boolean answerTrue){
        mAnswerTrue=answerTrue;
        mTextResId=textResId;
    }
}
