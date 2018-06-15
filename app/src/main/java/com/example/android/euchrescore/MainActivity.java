package com.example.android.euchrescore;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Displays a toast when a player name entry field has been left blank
     * before tapping the "begin game" button
     */
    public void makeToast() {
        Toast.makeText(getApplicationContext(), "Please enter all player names", Toast.LENGTH_LONG).show();
    }

    /**
     * Called to begin the score keeping activity when pressing the "begin game" button
     *
     * @param view
     */
    public void startGame(View view) {

        // creates objects for player names entered into EditText fields
        EditText playerOneAnswer = findViewById(R.id.enterPlayerOne);
        EditText playerTwoAnswer = findViewById(R.id.enterPlayerTwo);
        EditText playerThreeAnswer = findViewById(R.id.enterPlayerThree);
        EditText playerFourAnswer = findViewById(R.id.enterPlayerFour);

        /**
         * Checks for blank player name entry fields
         * Displays a toast to ask for all player names before beginning scoring activity
         */
        if (playerOneAnswer.getText().toString().equalsIgnoreCase("")) {
            makeToast();
        } else if (playerTwoAnswer.getText().toString().equalsIgnoreCase("")) {
            makeToast();
        } else if (playerThreeAnswer.getText().toString().equalsIgnoreCase("")) {
            makeToast();
        } else if (playerFourAnswer.getText().toString().equalsIgnoreCase("")) {
            makeToast();
        } else {

            // Stores entered player names as string variables
            String playerOne = playerOneAnswer.getText().toString();
            String playerTwo = playerTwoAnswer.getText().toString();
            String playerThree = playerThreeAnswer.getText().toString();
            String playerFour = playerFourAnswer.getText().toString();

            // Starts and transfers player names to score keeping activity
            Intent startScoring = new Intent(MainActivity.this, ScoringActivity.class);
            startScoring.putExtra("playerOne", playerOne);
            startScoring.putExtra("playerTwo", playerTwo);
            startScoring.putExtra("playerThree", playerThree);
            startScoring.putExtra("playerFour", playerFour);
            startActivity(startScoring);
        }


    }


}
