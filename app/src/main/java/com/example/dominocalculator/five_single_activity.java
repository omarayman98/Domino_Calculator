package com.example.dominocalculator;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class five_single_activity extends AppCompatActivity {
    TextView current_score_fp1;
    TextView current_score_fp2;
    TextView textView_fp1;
    TextView textView_fp2;
    EditText DownValue_fp1;
    EditText DownValue_fp2;
    Player player1 =new Player();
    Player player2 =new Player();
    String congratsSingle_fp1;
    String congratsSingle_fp2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_five_single);
        current_score_fp1 = findViewById(R.id.current_score_fp1);
        DownValue_fp1 = findViewById(R.id.DownValue_fp1);
        textView_fp1 =findViewById(R.id.textView_fp1);
        congratsSingle_fp1 ="Congratulations Player 1 Won !!";
        current_score_fp2 = findViewById(R.id.current_score_fp2);
        DownValue_fp2 = findViewById(R.id.DownValue_fp2);
        textView_fp2 =findViewById(R.id.textView_fp2);
        congratsSingle_fp2="Congratulations Player 2 Won !!";
        if(getIntent().hasExtra("kind")){
            textView_fp1.setText("Team 1");
            textView_fp2.setText("Team 2");
            congratsSingle_fp1 ="Team 1 Won !!";
            congratsSingle_fp2 ="Team 2 Won !!";
        }
    }

    public int IfWon(Player player_X , Player player_Y){

         if((player_Y.getScore()>=51&&player_X.getScore()<51)){
            return 2;
        }
        else if ((player_X.getScore()>=51&&player_Y.getScore()<51)){
            return 1;
        }else if ((player_X.getScore()>=51&&player_Y.getScore()>=51)&&player_X.getScore()>player_Y.getScore()){
             return 1;
         }else if ((player_X.getScore()>=51&&player_X.getScore()>=51)&&player_X.getScore()<player_Y.getScore()){
             return 2;
         }
         else return 3;
    }

    @SuppressLint("NonConstantResourceId")

    public void OnAllFives_2Players(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        switch (view.getId()) {
            case R.id.DownValue2_fp1:
                    if (DownValue_fp1.getText().toString().trim().equals("")) {
                        Toast.makeText(this, "Please Add Numbers", Toast.LENGTH_SHORT).show();
                    } else {
                        int won = (Integer.parseInt(DownValue_fp1.getText().toString().trim()));
                        if (15 > won && won != 0) {
                            player1.AddToScoreList(-won);
                            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                            current_score_fp1.setText("Current Score : " + player1.getScore());
                            DownValue_fp1.setText("");
                        } else {
                            Toast.makeText(this, "Please Add a Valid Number", Toast.LENGTH_SHORT).show();
                        }
                    }
                    break;

            case R.id.add1_fp1:
                player1.AddToScoreList(1);
                current_score_fp1.setText("Current Score : " + player1.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add2_fp1:
                player1.AddToScoreList(2);
                current_score_fp1.setText("Current Score : " + player1.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add3_fp1:
                player1.AddToScoreList(3);
                current_score_fp1.setText("Current Score : " + player1.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add4_fp1:
                player1.AddToScoreList(4);
                current_score_fp1.setText("Current Score : " + player1.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add5_fp1:
                player1.AddToScoreList(5);
                current_score_fp1.setText("Current Score : " + player1.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add6_fp1:
                player1.AddToScoreList(6);
                current_score_fp1.setText("Current Score : " + player1.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add7_fp1:
                player1.AddToScoreList(7);
                current_score_fp1.setText("Current Score : " + player1.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.undo_fp1:
                if (player1.undo()) {
                    current_score_fp1.setText("Current Score : " + player1.getScore());
                } else Toast.makeText(this, "No Values To Undo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.redo_fp1:
                if (player1.redo()) {
                    current_score_fp1.setText("Current Score : " + player1.getScore());
                } else Toast.makeText(this, "No Values to be back ", Toast.LENGTH_SHORT).show();
                break;

            case R.id.imageView_fp1:
                String History1 = "";
                for (int i = 0; i < player1.getScoreList().size(); i++) {
                    History1 = History1 + "\n" + player1.getScoreList().get(i).toString();
                }
                builder.setTitle("History");
                builder.setMessage("" + History1);
                builder.show();
                break;



        //Player 2

            case R.id.DownValue2_fp2:
                try {
                    if (DownValue_fp2.getText().toString().trim().equals("")) {
                        Toast.makeText(this, "Please Add Numbers", Toast.LENGTH_SHORT).show();
                    } else {
                        int won=(Integer.parseInt(DownValue_fp2.getText().toString().trim()));
                        if (won<15&&won!=0) {
                            player2.AddToScoreList(-won);
                            Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                            current_score_fp2.setText("Current Score : " + player2.getScore());
                            DownValue_fp2.setText("");
                        } else {
                            Toast.makeText(this, "Please Add a Valid Number", Toast.LENGTH_SHORT).show();
                        }
                    }

                } catch (NullPointerException e) {
                    Toast.makeText(this, "Catch", Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.add1_fp2:
                player2.AddToScoreList(1);
                current_score_fp2.setText("Current Score : " + player2.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add2_fp2:
                player2.AddToScoreList(2);
                current_score_fp2.setText("Current Score : " + player2.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add3_fp2:
                player2.AddToScoreList(3);
                current_score_fp2.setText("Current Score : " + player2.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add4_fp2:
                player2.AddToScoreList(4);
                current_score_fp2.setText("Current Score : " + player2.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add5_fp2:
                player2.AddToScoreList(5);
                current_score_fp2.setText("Current Score : " + player2.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add6_fp2:
                player2.AddToScoreList(6);
                current_score_fp2.setText("Current Score : " + player2.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.add7_fp2:
                player2.AddToScoreList(7);
                current_score_fp2.setText("Current Score : " + player2.getScore());
                Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                break;

            case R.id.undo_fp2:
                if (player2.undo()) {
                    current_score_fp2.setText("Current Score : " + player2.getScore());
                } else Toast.makeText(this, "No Values To Undo", Toast.LENGTH_SHORT).show();

                break;

            case R.id.redo_fp2:
                if (player2.redo()) {
                    current_score_fp2.setText("Current Score : " + player2.getScore());
                } else Toast.makeText(this, "No Values to be back ", Toast.LENGTH_SHORT).show();
                break;


            case R.id.imageView_fp2:
                String History2 = "";
                for (int i = 0; i < player2.getScoreList().size(); i++) {
                    History2 = History2 + "\n" + player2.getScoreList().get(i).toString();
                }
                builder.setTitle("History");
                builder.setMessage("" + History2);
                builder.show();
                break;

            case R.id.EndRound_f1vs1:
                if (IfWon(player1, player2) < 3) {
                    if (IfWon(player1, player2) == 1) {
                        builder.setMessage(""+congratsSingle_fp1);
                    } else if (IfWon(player1, player2) == 2) {
                        builder.setMessage(""+congratsSingle_fp1);
                    }
                    builder.setTitle("Congratulations");
                    builder.setPositiveButton("Play Again?", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent x = new Intent(five_single_activity.this, five_single_activity.class);
                            startActivity(x);
                        }
                    });
                    builder.setNegativeButton("No!", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent x = new Intent(five_single_activity.this, MainActivity.class);
                            startActivity(x);
                        }
                    });
                    builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                        @Override
                        public void onDismiss(DialogInterface dialog) {
                            Intent x = new Intent(five_single_activity.this, MainActivity.class);
                            startActivity(x);
                        }
                    });
                    builder.show();
                } else {
                    Toast.makeText(this,"Round Ended",Toast.LENGTH_SHORT).show();
                }
                break;

        }
        }
    }
