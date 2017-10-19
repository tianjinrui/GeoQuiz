package com.example.a65175.geoquiz;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class QuizActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mTrueButton;
    private Button mFalseButton;
    private TextView mQuestionTextView;
    private ImageButton mNextButton;
    private ImageButton mPreviousButton;
    private  Button mCheatButton;
    private static final String KEY_INDEX="index";
    private static final int REQUEST_CODE_CHEAT=0;
    private Question [] questionBank=new Question[]{
            new Question(R.string.question_africa,false),
            new Question(R.string.question_americas,true),
            new Question(R.string.question_asia,true),
            new Question(R.string.question_australia,true),
            new Question(R.string.question_mideast,false),
            new Question(R.string.question_oceans,true)
    };
    private int mCurrentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        init();
        setOnclickListener();//initial listener;
       if(savedInstanceState!=null){
            mCurrentIndex=savedInstanceState.getInt(KEY_INDEX);
        }
        updateQuestion();

    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt(KEY_INDEX,mCurrentIndex);
    }

    private  void checkAnswer(boolean userPressedTrue){
        boolean answerTrue=questionBank[mCurrentIndex].isAnswerTrue();
        int messageResId;
        if(answerTrue==userPressedTrue){
            messageResId=R.string.true_button;
        }else{
            messageResId=R.string.false_button;
        }
        Toast.makeText(this, messageResId, Toast.LENGTH_SHORT).show();


    }
    public void setOnclickListener(){
        mFalseButton.setOnClickListener(this);
        mTrueButton.setOnClickListener(this);
        mNextButton.setOnClickListener(this);
        mPreviousButton.setOnClickListener(this);
        mCheatButton.setOnClickListener(this);
    }
    public void init(){
        mFalseButton= (Button) findViewById(R.id.false_button);
        mTrueButton=(Button)findViewById(R.id.true_button);
        mQuestionTextView=(TextView)findViewById(R.id.Question_text_view);
        mNextButton=(ImageButton) findViewById(R.id.next_button);
        mPreviousButton=(ImageButton)findViewById(R.id.prev_button);
        mCheatButton=(Button)findViewById(R.id.cheat_button);

    }
    private void updateQuestion(){
        int question=questionBank[mCurrentIndex].getTextResId();
        mQuestionTextView.setText(question);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.false_button:
                checkAnswer(false);
                break;
            case R.id.true_button:
                checkAnswer(true);
                break;
            case R.id.next_button:
                mCurrentIndex=(mCurrentIndex+1)%questionBank.length;
                updateQuestion();
                break;
            case R.id.prev_button:
                mCurrentIndex=(questionBank.length+mCurrentIndex-1)%questionBank.length;
                updateQuestion();
                break;
            case R.id.cheat_button:
                //Intent intent=new Intent(QuizActivity.this,CheatActivity.class);
                boolean answerTrue=questionBank[mCurrentIndex].isAnswerTrue();
                Intent intent=CheatActivity.newIntent(QuizActivity.this,answerTrue);
                startActivity(intent);
                startActivityForResult(intent ,REQUEST_CODE_CHEAT);

        }


    }
}
