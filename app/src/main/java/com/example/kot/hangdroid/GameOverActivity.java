package com.example.kot.hangdroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class GameOverActivity extends AppCompatActivity {

    int mPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        int points = getIntent().getIntExtra("POINTS_IDENTIFIER",0);
        TextView textViewPoints = (TextView) findViewById(R.id.textViewPoints);
        textViewPoints.setText(String.valueOf(points));

        mPoints = points;


    }

    public void saveScore(View v){
        SharedPreferences myPreferences = getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);
        EditText editText = (EditText) findViewById(R.id.editTextName);
        String name = editText.getText().toString();

        SharedPreferences.Editor editor = myPreferences.edit();
        String previousScores = myPreferences.getString("SCORES","");
        editor.putString("SCORES",name + " " + mPoints + " POINTS\n" + previousScores);
        editor.commit();
        finish();
    }
}
