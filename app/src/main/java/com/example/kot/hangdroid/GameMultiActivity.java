package com.example.kot.hangdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class GameMultiActivity extends AppCompatActivity {

    String mWord;
    int mFailCounter = 0;
    int mGuessedLetters = 0;
    int mPoints = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_game);

        String wordSent = getIntent().getStringExtra("Word_Identifier");
        mWord = wordSent;
        createTextViews(wordSent);

    }




    public void introduceLetter(View v){
        EditText myEditText = (EditText) findViewById(R.id.editTextLetter);
        String letter = myEditText.getText().toString();
        myEditText.setText("");

        Log.d("MYLOG","The letter is" + letter);
        if (letter.length() > 0){
            checkLetter(letter.toUpperCase());
        } else {
            Toast.makeText(this,"Please introduce letter", Toast.LENGTH_SHORT).show();
        }
    }
    public void checkLetter(String introducedLetter){

        char charIntroduced = introducedLetter.toUpperCase().charAt(0);
        boolean letterGuessed = false;
        boolean repeatedLetter = false;

        LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutLetters);
        for (int ii = 0; ii < layoutLetters.getChildCount(); ii++){
            TextView currentTextView = (TextView) layoutLetters.getChildAt(ii);
            if (currentTextView.getText().charAt(0) == charIntroduced){
                repeatedLetter = true;
            }
        }

        for (int i = 0 ; i < mWord.length(); i++){

            char charFromTheWord = mWord.toUpperCase().charAt(i);


            if (charFromTheWord == charIntroduced & repeatedLetter != true) {
                letterGuessed = true;
                showLettersAtIndex(i, charIntroduced);
                mGuessedLetters++;

            }
        }



        if (repeatedLetter == true){
            Toast.makeText(this,"This word has contained such letter already", Toast.LENGTH_SHORT).show();
            repeatedLetter = false;
        }else if (letterGuessed == false ){

            TextView textViewFailed = (TextView) findViewById(R.id.textViewForFailedLetters);
            String stringFailed = textViewFailed.getText().toString();
            boolean failedRepeatedLetter = false;

            for (int i=15; i < stringFailed.length();i++){
                if (stringFailed.charAt(i)==charIntroduced){
                    failedRepeatedLetter = true;
                    break;

                }
            }
            if (failedRepeatedLetter == false){
                letterFailed(Character.toString(charIntroduced));
            }else{
                Toast.makeText(this, "Be careful! You have already done this mistake", Toast.LENGTH_SHORT).show();
            }


        }
        if (mGuessedLetters == mWord.length()){
            finish();
            //Intent myIntent = new Intent(this,MultiplayerActivity.class);
            //startActivity(myIntent);

        }
    }


    public void createTextViews(String word){

        LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutLetters);



        for (int i = 0; i < word.length(); i++){
            TextView newTextView = (TextView) getLayoutInflater().inflate(R.layout.textview,null);
            layoutLetters.addView(newTextView);
        }

    }

    public void clearScreen(){
        TextView textViewFailed = (TextView) findViewById(R.id.textViewForFailedLetters);
        textViewFailed.setText("Wrong letters: ");

        mGuessedLetters = 0;
        mFailCounter  = 0;

        LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutLetters);
        layoutLetters.removeAllViews();
        //for (int i = 0; i < layoutLetters.getChildCount(); i++){
            //TextView currentTextView = (TextView) layoutLetters.getChildAt(i);
            //currentTextView.setText("_");
       // }

        ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setImageResource(R.drawable.android0);
    }

    public void letterFailed (String letterFailed){

        TextView textViewFailed = (TextView) findViewById(R.id.textViewForFailedLetters);
        String previousFail = textViewFailed.getText().toString();
        textViewFailed.setText(previousFail+letterFailed);

        mFailCounter++;
        ImageView imageView = (ImageView) findViewById(R.id.imageView2);

        if (mFailCounter == 1){
            imageView.setImageResource(R.drawable.android1);
        }else if (mFailCounter == 2){
            imageView.setImageResource(R.drawable.android2);
        }else if (mFailCounter == 3){
            imageView.setImageResource(R.drawable.android3);
        }else if (mFailCounter == 4){
            imageView.setImageResource(R.drawable.android4);
        }else if (mFailCounter == 5) {
            imageView.setImageResource(R.drawable.android5);
        }else if (mFailCounter == 6) {
            imageView.setImageResource(R.drawable.android6);
        }else if (mFailCounter == 7) {
            imageView.setImageResource(R.drawable.android7);
        }else if (mFailCounter == 8) {
            Intent gameOverIntent = new Intent(this, GameOverActivity.class);

            gameOverIntent.putExtra("POINTS_IDENTIFIER",mPoints);

            startActivity(gameOverIntent);

        }


    }



    public void showLettersAtIndex(int position, char letterGuessed){

        LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.layoutLetters);
        TextView textView = (TextView) layoutLetter.getChildAt(position);
        textView.setText(Character.toString(letterGuessed));



    }
}
