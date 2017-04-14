package com.example.kot.hangdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button myButtonStart = (Button) findViewById(R.id.buttonSingle);
        myButtonStart.setOnClickListener((View.OnClickListener) this);

        Button myButtonMulti = (Button) findViewById(R.id.buttonMulti);
        myButtonMulti.setOnClickListener((View.OnClickListener) this);

        Button myButtonScores = (Button) findViewById(R.id.buttonScores);
        myButtonScores.setOnClickListener((View.OnClickListener) this);

        Button myButtonQuit = (Button) findViewById(R.id.buttonQuit);
        myButtonQuit.setOnClickListener((View.OnClickListener) this);

    }


    @Override
    public void onClick(View v) {
        Intent myIntent = new Intent();
        switch (v.getId()){

            case R.id.buttonSingle:
                myIntent = new Intent(this,GameActivity.class);
                startActivity(myIntent);
                break;
            case R.id.buttonMulti:
                myIntent = new Intent (this, MultiplayerActivity.class);
                startActivity(myIntent);
                break;
            case R.id.buttonScores:
                myIntent = new Intent (this, ScoresActivity.class);
                startActivity(myIntent);
                break;
            case R.id.buttonQuit:
                android.os.Process.killProcess(android.os.Process.myPid());
                break;

        }

    }
/*
    public void startSinglePlayerGame(View v){
        Intent myIntent = new Intent(this,GameActivity.class);
        startActivity(myIntent);
    }

    public void startMultiGame(View v){
        Intent myIntent = new Intent (this, MultiplayerActivity.class);
        startActivity(myIntent);
    }

    public void openScores(View v){
        Intent myIntent = new Intent (this, ScoresActivity.class);
        startActivity(myIntent);
    }



    public void quitApp(View v){
        //getActivity(this).finish();
        //System.exit(0);

        android.os.Process.killProcess(android.os.Process.myPid());
    }
    */

}
