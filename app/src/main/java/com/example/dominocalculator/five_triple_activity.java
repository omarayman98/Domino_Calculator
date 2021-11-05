package com.example.dominocalculator;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class five_triple_activity extends AppCompatActivity {

    TextView current_score_ffp1;
    EditText DownValue_ffp1;
    Player player1 =new Player();

    TextView current_score_ffp2;
    EditText DownValue_ffp2;
    Player player2 =new Player();

    TextView current_score_ffp3;
    EditText DownValue_ffp3;
    Player player3 =new Player();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_triple_activity);

        current_score_ffp1 = findViewById(R.id.current_score_ffp1);
        DownValue_ffp1 = findViewById(R.id.DownValue_ffp1);

        current_score_ffp2 = findViewById(R.id.current_score_ffp2);
        DownValue_ffp2 = findViewById(R.id.DownValue_ffp1);

        current_score_ffp3 = findViewById(R.id.current_score_ffp3);
        DownValue_ffp3 = findViewById(R.id.DownValue_ffp1);


    }

    public int IfWon(Player player_X , Player player_Y,Player player_Z){

        if (player_X.getScore()>=51&&player_Y.getScore()<51&&player_Z.getScore()<51){
            return 1;
        }else if(player_X.getScore()>=51&&player_Y.getScore()>=51&&player_Z.getScore()>=51
        &&player_X.getScore()>player_Y.getScore()&&player_X.getScore()>player_Z.getScore()){
            return 1;
        }
        else if(player_Y.getScore()>=51&&player_X.getScore()<51&&player_Z.getScore()<51){
            return 2;
        }else if(player_Y.getScore()>=51&&player_X.getScore()>=51&&player_Z.getScore()>=51
                &&player_Y.getScore()>player_X.getScore()&&player_Y.getScore()>player_Z.getScore()){
            return 2;
        }
        else if(player_X.getScore()<51&&player_Y.getScore()<51&&player_Z.getScore()>=51){
            return 3;
        }else if(player_X.getScore()>=51&&player_Y.getScore()>=51&&player_Z.getScore()>=51
                &&player_Z.getScore()>player_X.getScore()&&player_Z.getScore()>player_Y.getScore()        ){
            return 3;
        }

        else return 4;
    }


    public void OnAllFives_3Players(View view)  {

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        switch (view.getId()) {
            case R.id.DownValue2_ffp1:
                try {
                    if (DownValue_ffp1.getText().toString().trim().equals("")) {
                        Toast.makeText(this, "Please Add Numbers", Toast.LENGTH_SHORT).show();
                    } else {
                        int won = (Integer.parseInt(DownValue_ffp1.getText().toString().trim()));
                        if (won<15&&won!=0) {
                            player1.AddToScoreList(-won);
                            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                            current_score_ffp1.setText("Current Score : " + player1.getScore());
                            DownValue_ffp1.setText("");
                        } else {
                            Toast.makeText(this, "Please Add a Valid Number", Toast.LENGTH_SHORT).show();
                        }
                    }

                } catch (NullPointerException e) {
                    Toast.makeText(this, "Catch", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.add1_ffp1:
                player1.AddToScoreList(1);
                current_score_ffp1.setText("Current Score : " + player1.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add2_ffp1:
                player1.AddToScoreList(2);
                current_score_ffp1.setText("Current Score : " + player1.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add3_ffp1:
                player1.AddToScoreList(3);
                current_score_ffp1.setText("Current Score : " + player1.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add4_ffp1:
                player1.AddToScoreList(4);
                current_score_ffp1.setText("Current Score : " + player1.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add5_ffp1:
                player1.AddToScoreList(5);
                current_score_ffp1.setText("Current Score : " + player1.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add6_ffp1:
                player1.AddToScoreList(6);
                current_score_ffp1.setText("Current Score : " + player1.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add7_ffp1:
                player1.AddToScoreList(7);
                current_score_ffp1.setText("Current Score : " + player1.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.undo_ffp1:
                if (player1.undo()) {
                    current_score_ffp1.setText("Current Score : " + player1.getScore());
                } else Toast.makeText(this, "No Values To Undo", Toast.LENGTH_SHORT).show();
                break;

            case R.id.redo_ffp1:
                if (player1.redo()) {
                    current_score_ffp1.setText("Current Score : " + player1.getScore());
                } else Toast.makeText(this, "No Values to be back ", Toast.LENGTH_SHORT).show();
                break;

            case R.id.imageView_ffp1:
                String History1 = "";
                for (int i = 0; i < player1.getScoreList().size(); i++) {
                    History1 = History1 + "\n" + player1.getScoreList().get(i).toString();
                }
                builder.setTitle("History");
                builder.setMessage("" + History1);
                builder.show();
                break;
            //Player 2
            case R.id.DownValue2_ffp2:
                try {
                    if (DownValue_ffp2.getText().toString().trim().equals("")) {
                        Toast.makeText(this, "Please Add Numbers", Toast.LENGTH_SHORT).show();
                    } else {
                        int won = (Integer.parseInt(DownValue_ffp2.getText().toString().trim()));
                        if (won<15&&won!=0) {
                            player2.AddToScoreList(-won);
                            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                            current_score_ffp2.setText("Current Score : " + player2.getScore());
                            DownValue_ffp2.setText("");
                        } else {
                            Toast.makeText(this, "Please Add a Valid Number", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (NullPointerException e) {
                    Toast.makeText(this, "Catch", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.add1_ffp2:
                player2.AddToScoreList(1);
                current_score_ffp2.setText("Current Score : " + player2.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add2_ffp2:
                player2.AddToScoreList(2);
                current_score_ffp2.setText("Current Score : " + player2.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add3_ffp2:
                player2.AddToScoreList(3);
                current_score_ffp2.setText("Current Score : " + player2.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add4_ffp2:
                player2.AddToScoreList(4);
                current_score_ffp2.setText("Current Score : " + player2.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add5_ffp2:
                player2.AddToScoreList(5);
                current_score_ffp2.setText("Current Score : " + player2.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add6_ffp2:
                player2.AddToScoreList(6);
                current_score_ffp2.setText("Current Score : " + player2.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add7_ffp2:
                player2.AddToScoreList(7);
                current_score_ffp2.setText("Current Score : " + player2.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.undo_ffp2:
                if (player2.undo()) {
                    current_score_ffp2.setText("Current Score : " + player2.getScore());
             } else Toast.makeText(this, "No Values To Undo", Toast.LENGTH_SHORT).show();

                break;

            case R.id.redo_ffp2:
                if (player2.redo()) {
                    current_score_ffp2.setText("Current Score : " + player2.getScore());
                } else Toast.makeText(this, "No Values to be back ", Toast.LENGTH_SHORT).show();
                break;


            case R.id.imageView_ffp2:
                String History2 = "";
                for (int i = 0; i < player2.getScoreList().size(); i++) {
                    History2 = History2 + "\n" + player2.getScoreList().get(i).toString();
                }
                builder.setTitle("History");
                builder.setMessage("" + History2);
                builder.show();
                break;

            //Player 3
            case R.id.DownValue2_ffp3:
                try {
                    if (DownValue_ffp3.getText().toString().trim().equals("")) {
                        Toast.makeText(this, "Please Add Numbers", Toast.LENGTH_SHORT).show();
                    } else {
                        int won = (Integer.parseInt(DownValue_ffp3.getText().toString().trim()));
                        if (won<15&&won!=0) {
                            player3.AddToScoreList(-won);
                            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                            current_score_ffp3.setText("Current Score : " + player3.getScore());
                            DownValue_ffp3.setText("");
                        } else {
                            Toast.makeText(this, "Please Add a Valid Number", Toast.LENGTH_SHORT).show();
                        }
                    }
                } catch (NullPointerException e) {
                    Toast.makeText(this, "Catch", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.add1_ffp3:
                player3.AddToScoreList(1);
                current_score_ffp3.setText("Current Score : " + player3.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add2_ffp3:
                player3.AddToScoreList(2);
                current_score_ffp3.setText("Current Score : " + player3.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add3_ffp3:
                player3.AddToScoreList(3);
                current_score_ffp3.setText("Current Score : " + player3.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add4_ffp3:
                player3.AddToScoreList(4);
                current_score_ffp3.setText("Current Score : " + player3.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add5_ffp3:
                player3.AddToScoreList(5);
                current_score_ffp3.setText("Current Score : " + player3.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add6_ffp3:
                player3.AddToScoreList(6);
                current_score_ffp3.setText("Current Score : " + player3.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add7_ffp3:
                player3.AddToScoreList(7);
                current_score_ffp3.setText("Current Score : " + player3.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.undo_ffp3:
                if (player3.undo()) {
                    current_score_ffp3.setText("Current Score : " + player3.getScore());
                } else Toast.makeText(this, "No Values To Undo", Toast.LENGTH_SHORT).show();

                break;

            case R.id.redo_ffp3:
                if (player3.redo()) {
                    current_score_ffp3.setText("Current Score : " + player3.getScore());
                } else Toast.makeText(this, "No Values to be back ", Toast.LENGTH_SHORT).show();
                break;


            case R.id.imageView_ffp3:
                String History3 = "";
                for (int i = 0; i < player3.getScoreList().size(); i++) {
                    History3 = History3 + "\n" + player3.getScoreList().get(i).toString();
                }
                builder.setTitle("History");
                builder.setMessage("" + History3);
                builder.show();
                break;

            case R.id.EndRound_3players:

                if (IfWon(player1, player2,player3) == 1) {
                    builder.setMessage("Player 1 Won");
                } else if (IfWon(player1, player2,player3) == 2) {
                    builder.setMessage("Player 2 Won");
                }else if (IfWon(player1, player2,player3) ==3){
                    builder.setMessage("Player 3 Won");
                }else {
                    Toast.makeText(this,"Round Ended",Toast.LENGTH_SHORT).show();
                }
                    builder.setTitle("Congratulations");
                    builder.setPositiveButton("Play Again?", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent x = new Intent(five_triple_activity.this, five_triple_activity.class);
                            startActivity(x);
                        }
                    });
                    builder.setNegativeButton("No!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent x = new Intent(five_triple_activity.this, MainActivity.class);
                            startActivity(x);
                        }
                    });
                    builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            Intent x = new Intent(five_triple_activity.this, MainActivity.class);
                            startActivity(x);
                        }
                    });
                    builder.show();


                break;

        }

    }
        }
