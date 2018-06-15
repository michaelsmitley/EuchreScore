package com.example.android.euchrescore;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ScoringActivity extends AppCompatActivity {

    /**
     * This initializes the team scores to zero and declares String variables
     * for use in a switch. The switch is designed to convert the actual score
     * to a string that corresponds to a specific playing card in a special
     * playing cards font used to display scores. Player strings store the
     * values of player names entered in the main activity
     */
    int scoreUs = 0;
    int scoreThem = 0;
    String scoreUsEquiv;
    String scoreThemEquiv;
    String playerOne;
    String playerTwo;
    String playerThree;
    String playerFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scoring);

        /**
         * Retrieve player names entered in main activity, store them as variables
         */

        Bundle bundle = getIntent().getExtras();
        playerOne = bundle.getString("playerOne");
        playerTwo = bundle.getString("playerTwo");
        playerThree = bundle.getString("playerThree");
        playerFour = bundle.getString("playerFour");

        /**
         * Displays player names entered in the main activity on this activity
         * as team names below the score cards
         */

        TextView playerOneName = (TextView) findViewById(R.id.player_one_name);
        playerOneName.setText(String.valueOf(playerOne));
        TextView playerTwoName = (TextView) findViewById(R.id.player_two_name);
        playerTwoName.setText(String.valueOf(playerTwo));
        TextView playerThreeName = (TextView) findViewById(R.id.player_three_name);
        playerThreeName.setText(String.valueOf(playerThree));
        TextView playerFourName = (TextView) findViewById(R.id.player_four_name);
        playerFourName.setText(String.valueOf(playerFour));


    }

    // Establishes "0" as the minimum possible score

    public void minScore() {
        if (scoreUs < 0) {
            scoreUs = 0;
        } else {
            scoreUs = scoreUs;
        }

        if (scoreThem < 0) {
            scoreThem = 0;
        } else {
            scoreThem = scoreThem;
        }
    }

    // Establishes "10" as the maximum possible score

    public void maxScore() {
        if (scoreUs > 10) {
            scoreUs = 10;
        } else {
            scoreUs = scoreUs;
        }

        if (scoreThem > 10) {
            scoreThem = 10;
        } else {
            scoreThem = scoreThem;
        }
    }

    /**
     * This method converts the actual score integer to the string that displays
     * the corresponding playing card in the playing cards font
     */
    public void convertScore() {

        int scus = scoreUs;
        switch (scus) {
            case 0:
                scoreUsEquiv = "?";
                break;
            case 1:
                scoreUsEquiv = "a";
                break;
            case 2:
                scoreUsEquiv = "b";
                break;
            case 3:
                scoreUsEquiv = "c";
                break;
            case 4:
                scoreUsEquiv = "d";
                break;
            case 5:
                scoreUsEquiv = "e";
                break;
            case 6:
                scoreUsEquiv = "f";
                break;
            case 7:
                scoreUsEquiv = "g";
                break;
            case 8:
                scoreUsEquiv = "h";
                break;
            case 9:
                scoreUsEquiv = "i";
                break;
            case 10:
                scoreUsEquiv = "j";
                break;
            default:
                scoreUsEquiv = "j";
        }

        int scthem = scoreThem;
        switch (scthem) {
            case 0:
                scoreThemEquiv = "?";
                break;
            case 1:
                scoreThemEquiv = "N";
                break;
            case 2:
                scoreThemEquiv = "O";
                break;
            case 3:
                scoreThemEquiv = "P";
                break;
            case 4:
                scoreThemEquiv = "Q";
                break;
            case 5:
                scoreThemEquiv = "R";
                break;
            case 6:
                scoreThemEquiv = "S";
                break;
            case 7:
                scoreThemEquiv = "T";
                break;
            case 8:
                scoreThemEquiv = "U";
                break;
            case 9:
                scoreThemEquiv = "V";
                break;
            case 10:
                scoreThemEquiv = "W";
                break;
            default:
                scoreThemEquiv = "W";
        }
    }

    /**
     * Adds four points to the current score of Team Us
     * Limits the score to "10"
     * Converts the points to corresponding playing card string output
     * Displays a playing card equivalent to the actual score
     * Checks to see if the score is enough to win
     * Displays a winner toast if the game has been won
     */
    public void addFourForUs(View v) {
        scoreUs = scoreUs + 4;
        maxScore();
        convertScore();
        displayForUs(scoreUsEquiv);
        checkWin();

    }

    /**
     * Adds two points to the current score of Team Us
     * Limits the score to "10"
     * Converts the points to corresponding playing card string output
     * Displays a playing card equivalent to the actual score
     * Checks to see if the score is enough to win
     * Displays a winner toast if the game has been won
     */
    public void addTwoForUs(View v) {
        scoreUs = scoreUs + 2;
        maxScore();
        convertScore();
        displayForUs(scoreUsEquiv);
        checkWin();

    }

    /**
     * Adds one point to the current score of Team Us
     * Limits the score to "10"
     * Converts the points to corresponding playing card string output
     * Displays a playing card equivalent to the actual score
     * Checks to see if the score is enough to win
     * Displays a winner toast if the game has been won
     */
    public void addOneForUs(View v) {
        scoreUs = scoreUs + 1;
        maxScore();
        convertScore();
        displayForUs(scoreUsEquiv);
        checkWin();

    }

    /**
     * Subtracts one point to the current score of Team Us
     * Limits the score to "0"
     * Converts the points to corresponding playing card string output
     * Displays a playing card equivalent to the actual score
     * Re-enables scoring buttons after having been disabled by winning score
     */

    public void subtractOneFromUs(View v) {
        scoreUs = scoreUs - 1;
        minScore();
        convertScore();
        displayForUs(scoreUsEquiv);
        enableButtons();

    }

    /**
     * Displays Team Us score playing card in the designated XML text view
     */
    public void displayForUs(String score) {

        TextView scoreView = (TextView) findViewById(R.id.score_us);
        convertScore();

        scoreView.setText(String.valueOf(score));

    }

    /**
     * Adds four points to the current score of Team Them
     * Limits score to "10"
     * Converts the points to corresponding playing card string output
     * Displays a playing card equivalent to the actual score
     * Checks to see if the score is enough to win
     * Displays a winner toast if the game has been won
     */
    public void addFourForThem(View v) {
        scoreThem = scoreThem + 4;
        maxScore();
        convertScore();
        displayForThem(scoreThemEquiv);
        checkWin();

    }

    /**
     * Adds two points to the current score of Team Them
     * Limits the score to "10"
     * Converts the points to corresponding playing card string output
     * Displays a playing card equivalent to the actual score
     * Checks to see if the score is enough to win
     * Displays a winner toast if the game has been won
     */
    public void addTwoForThem(View v) {
        scoreThem = scoreThem + 2;
        maxScore();
        convertScore();
        displayForThem(scoreThemEquiv);
        checkWin();

    }

    /**
     * Adds one point to the current score of Team Them
     * Limits the score to "10"
     * Converts the points to corresponding playing card string output
     * Displays a playing card equivalent to the actual score
     * Checks to see if the score is enough to win
     * Displays a winner toast if the game has been won
     */
    public void addOneForThem(View v) {
        scoreThem = scoreThem + 1;
        maxScore();
        convertScore();
        displayForThem(scoreThemEquiv);
        checkWin();

    }

    /**
     * Subtracts one point to the current score of Team Us
     * Limits the score to "0"
     * Converts the points to corresponding playing card string output
     * Displays a playing card equivalent to the actual score
     * Re-enables scoring buttons after having been disabled by winning score
     *
     * @param v
     */
    public void subtractOneFromThem(View v) {
        scoreThem = scoreThem - 1;
        minScore();
        convertScore();
        displayForThem(scoreThemEquiv);
        enableButtons();

    }

    /**
     * Displays Team Them score playing card in the designated XML text view
     */
    public void displayForThem(String score) {

        TextView scoreView = (TextView) findViewById(R.id.score_them);
        convertScore();

        scoreView.setText(String.valueOf(score));

    }

    /**
     * Checks to see if a team has won and displays a full screen winner toast that displays a
     * message including winning player names
     */
    public void checkWin() {

        //Establishes a custom full screen toast
        LayoutInflater inflater = getLayoutInflater();
        final View toastLayout = inflater.inflate(R.layout.custom_toast, (ViewGroup) findViewById(R.id.custom_toast_container));
        final TextView toastText = toastLayout.findViewById(R.id.text);
        final ImageView toastImage = toastLayout.findViewById(R.id.image);
        toastImage.setImageResource(R.drawable.trophy);
        final Toast toast = Toast.makeText(getApplicationContext(), toastText.getText(), Toast.LENGTH_LONG);
        toast.setGravity(Gravity.FILL_VERTICAL | Gravity.FILL_HORIZONTAL, 0, 0);
        toast.setView(toastLayout);

        // creates objects for each team's undo scoring button
        Button usUndo = findViewById(R.id.UsUndoButton);
        Button themUndo = findViewById(R.id.ThemUndoButton);


        /**
         * Checks to see if Team Us has won the game; if so, shows a custom toast and disables
         * all scoring buttons except the winning team's undo button
         */
        if (scoreUs > 9) {
            toastText.setText(playerOne + " and " + playerTwo + " win! ");
            toast.show();
            disableButtons();
            themUndo.setEnabled(false);
        }

        if (scoreThem > 9) {
            toastText.setText(playerThree + " and " + playerFour + " win! ");
            toast.show();
            disableButtons();
            usUndo.setEnabled(false);
        }

    }

    /**
     * Changes value of all scores to zero
     * Resets the values of equivalent score strings
     * Redisplays the starting Joker cards in the scoring text views
     * Re-enables all scoring buttons
     */
    public void gameOver(View v) {
        scoreUs = 0;
        scoreThem = 0;
        convertScore();
        displayForUs(scoreUsEquiv);
        displayForThem(scoreThemEquiv);
        enableButtons();


    }

    // Disables all scoring buttons; called when a team has won the game
    public void disableButtons() {

        Button usLoner = findViewById(R.id.UsLonerButton);
        Button usSet = findViewById(R.id.UsSetButton);
        Button usAll = findViewById(R.id.UsAllTricksButton);
        Button usHand = findViewById(R.id.UsWinHandButton);
        Button themLoner = findViewById(R.id.ThemLonerButton);
        Button themSet = findViewById(R.id.ThemSetButton);
        Button themAll = findViewById(R.id.ThemAllTricksButton);
        Button themHand = findViewById(R.id.ThemWinHandButton);

        usLoner.setEnabled(false);
        usSet.setEnabled(false);
        usAll.setEnabled(false);
        usHand.setEnabled(false);
        themLoner.setEnabled(false);
        themSet.setEnabled(false);
        themAll.setEnabled(false);
        themHand.setEnabled(false);

    }

    /**
     * Enables all scoring buttons; called when a winning team's undo button has been pressed
     * Called when the new game button has been pressed
     */

    public void enableButtons() {

        Button usLoner = findViewById(R.id.UsLonerButton);
        Button usSet = findViewById(R.id.UsSetButton);
        Button usAll = findViewById(R.id.UsAllTricksButton);
        Button usHand = findViewById(R.id.UsWinHandButton);
        Button usUndo = findViewById(R.id.UsUndoButton);
        Button themLoner = findViewById(R.id.ThemLonerButton);
        Button themSet = findViewById(R.id.ThemSetButton);
        Button themAll = findViewById(R.id.ThemAllTricksButton);
        Button themHand = findViewById(R.id.ThemWinHandButton);
        Button themUndo = findViewById(R.id.ThemUndoButton);

        usLoner.setEnabled(true);
        usSet.setEnabled(true);
        usAll.setEnabled(true);
        usHand.setEnabled(true);
        usUndo.setEnabled(true);
        themLoner.setEnabled(true);
        themSet.setEnabled(true);
        themAll.setEnabled(true);
        themHand.setEnabled(true);
        themUndo.setEnabled(true);
    }

}
