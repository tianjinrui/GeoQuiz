package com.example.a65175.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class QuizActivity extends AppCompatActivity implements View.OnClickListener{
    private Button mTrueButton;
    private Button mFalseButton;
    private TextView mQuestionTextView;
    private Button mNextButton;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mFalseButton= (Button) findViewById(R.id.false_button);
        mTrueButton=(Button)findViewById(R.id.true_button);
        mFalseButton.setOnClickListener(this);
        mTrueButton.setOnClickListener(this);
         toast=new Toast(getApplicationContext());


    }

     

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.false_button:
                toast=Toast.makeText(getApplicationContext(), "hello", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.TOP,0,0);
                toast.show();
                break;
        }


    }
}
