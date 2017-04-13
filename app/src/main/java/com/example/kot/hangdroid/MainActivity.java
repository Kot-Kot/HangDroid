package com.example.kot.hangdroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
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

}
