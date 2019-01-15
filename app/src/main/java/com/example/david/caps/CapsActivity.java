package com.example.david.caps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.lang.reflect.Field;

public class CapsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.caps_layout);
        ask();
        qNum = 1;
        score = 0;
        log = "";
    }
    private Game game;
    private String question;
    private String answer;
    private int score;
    private int qNum;
    private String log;

    private void ask()
    {
        game = new Game();
        String[] lines = game.qa().split("\\n");
        question = lines[0];
        answer = lines[1];
        ((TextView)findViewById(R.id.question)).setText(question);
    }

    public void onDone(View v)
    {
        qNum+=1;
        ((TextView)findViewById(R.id.qNum)).setText("Q# "+qNum);
        if (qNum==10)
        {
            ((TextView)findViewById(R.id.qNum)).setText("Game Over!");
            findViewById(R.id.done).setEnabled(false);
            //finish();
        }
        if (((EditText)findViewById(R.id.answer)).getText().toString().equalsIgnoreCase(answer))
        {
            score+=1;
            ((TextView)findViewById(R.id.score)).setText("SCORE = "+score);
        }
        log += "Q# "+(qNum-1)+":"+question+"\nYour answer:"
        +((EditText)findViewById(R.id.answer)).getText().toString().toUpperCase()+"\n"+"Correct answer:"+answer+"\n\n";
        ((TextView)findViewById(R.id.log)).setText(log);
        ask();
    }
}
