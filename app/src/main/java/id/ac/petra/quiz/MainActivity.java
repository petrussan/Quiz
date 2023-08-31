package id.ac.petra.quiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

//    private Question question1 = new Question(R.string.q1,true);
    private Question[] questionBank = new Question[] {
                new Question(R.string.q1,true),
                new Question(R.string.q2,true),
                new Question(R.string.q3,true),
                new Question(R.string.q4,true),
    };
    private int current = 0;
    private TextView tv1;
    private Button bTrue;
    private Button bFalse;
    private Button bNext;
    private Button bResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.textView);
        bTrue = findViewById(R.id.bTrue);
        bFalse = findViewById(R.id.bFalse);
        bNext = findViewById(R.id.bNext);
        bResult = findViewById(R.id.bResult);

        bTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
            }
        });
        bFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
            }
        });
        bNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                current = (current+1)%questionBank.length;
                updateQuestion();
            }
        });
        bResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),ResultActivity.class);
//                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.petra.ac.id"));
                startActivity(i);
            }
        });
        updateQuestion();
        //Toast.makeText(getApplicationContext(), R.string.welcome, Toast.LENGTH_LONG).show();

        //Toast.makeText(getApplicationContext(), questionBank[0].getResId(), Toast.LENGTH_LONG).show();
    }

    private void updateQuestion() {
        int question = questionBank[current].getResId();
        tv1.setText(question);
    }

    private void checkAnswer(boolean b) {
        boolean trueAnswer = questionBank[current].getAnswer();
        if (trueAnswer==b) {
            Toast.makeText(getApplicationContext(),R.string.responsetrue,Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(),R.string.responsefalse,Toast.LENGTH_LONG).show();
        }
    }
}