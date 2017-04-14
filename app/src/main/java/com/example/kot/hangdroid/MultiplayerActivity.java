package com.example.kot.hangdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MultiplayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplayer);

        Button mybuttonPlay =(Button) findViewById(R.id.buttonPlay);

        mybuttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText = (EditText) findViewById(R.id.editTextWord);
                String wordToGuess = editText.getText().toString();

                editText.setText("");

                Intent myIntent = new Intent (getApplicationContext(), GameMultiActivity.class);
                myIntent.putExtra("Word_Identifier",wordToGuess);
                startActivity(myIntent);
            }
        });
        //mybuttonPlay.setOnClickListener((View.OnClickListener) this);
    }
/*
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonPlay:


                break;


        }

    }
*/

}
