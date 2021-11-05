package com.example.dominocalculator;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class draw_triple_activity extends AppCompatActivity {
    Player player1,player2,player3;
    TextView current_score_dp1;    EditText WonValue_dp1;
    TextView current_score_dp2;    EditText WonValue_dp2;
    TextView current_score_dp3;    EditText WonValue_dp3;
    int Win_limit=101;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_triple_activity);
        player1=new Player();
        WonValue_dp1=findViewById(R.id.WonValue_dp1);
        current_score_dp1=findViewById(R.id.current_score_dp1);

        player2=new Player();
        WonValue_dp2=findViewById(R.id.WonValue_dp2);
        current_score_dp2=findViewById(R.id.current_score_dp2);

        player3=new Player();
        WonValue_dp3=findViewById(R.id.WonValue_dp3);
        current_score_dp3=findViewById(R.id.current_score_dp3);

    }

    public void OnDraw_3Players(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        String history;int won;
        switch (view.getId()) {
            case R.id.add_dp1:
                if (WonValue_dp1.getText().toString().trim().equals("")){
                    Toast.makeText(this, "Please Add Numbers", Toast.LENGTH_SHORT).show();
                }else{
                    won = Integer.parseInt(WonValue_dp1.getText().toString().trim());
                    if (won>0&&won<90){
                        player1.AddToScoreList(won);
                        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                        WonValue_dp1.setText("");
                        if (player1.getScore()< Win_limit){
                            current_score_dp1.setText("Current Score is: "+player1.getScore());}
                        else if(player1.getScore()>= Win_limit) {
                            builder.setTitle("Congratulations");
                            builder.setMessage("Player 1 Won!");
                            builder.setPositiveButton("Play Again?", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent x = new Intent(draw_triple_activity.this, draw_triple_activity.class);
                                    startActivity(x);
                                }
                            });
                            builder.setNegativeButton("No!", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent x = new Intent(draw_triple_activity.this, MainActivity.class);
                                    startActivity(x);
                                }
                            });
                            builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialog) {
                                    Intent x = new Intent(draw_triple_activity.this, MainActivity.class);
                                    startActivity(x);
                                }
                            });
                            builder.show();
                        }}}
                break;

            case R.id.undo_dp1:
                if (player1.undo()) {
                    current_score_dp1.setText("Current Score : " + player1.getScore());
                } else Toast.makeText(this, "No Values To Undo", Toast.LENGTH_SHORT).show();

                break;
            case R.id.redo_dp1:
                if (player1.redo()) {
                    current_score_dp1.setText("Current Score : " + player1.getScore());
                } else Toast.makeText(this, "No Values to be back ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView_dp1:
                 history = "";
                for (int i = 0; i < player1.getScoreList().size(); i++) {
                    history = history + "\n" + player1.getScoreList().get(i).toString();
                }
                builder.setTitle("History");
                builder.setMessage("" + history);
                builder.show();
                break;

            case R.id.add_dp2:
                if (WonValue_dp2.getText().toString().trim().equals("")){
                    Toast.makeText(this, "Please Add Numbers", Toast.LENGTH_SHORT).show();
                }else{
                    won = Integer.parseInt(WonValue_dp2.getText().toString().trim());
                    if (won>0&&won<90){
                        player2.AddToScoreList(won);
                        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                        WonValue_dp2.setText("");
                        if (player2.getScore()< Win_limit){
                            current_score_dp2.setText("Current Score is: "+player2.getScore());}
                        else if(player2.getScore()>= Win_limit) {
                            builder.setTitle("Congratulations");
                            builder.setMessage("Player 2 Won!");
                            builder.setPositiveButton("Play Again?", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent x = new Intent(draw_triple_activity.this, draw_triple_activity.class);
                                    startActivity(x);
                                }
                            });
                            builder.setNegativeButton("No!", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent x = new Intent(draw_triple_activity.this, MainActivity.class);
                                    startActivity(x);
                                }
                            });
                            builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialog) {
                                    Intent x = new Intent(draw_triple_activity.this, MainActivity.class);
                                    startActivity(x);
                                }
                            });
                            builder.show();
                        }}}

                break;
            case R.id.undo_dp2:
                if (player2.undo()) {
                    current_score_dp2.setText("Current Score : " + player2.getScore());
                } else Toast.makeText(this, "No Values To Undo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.redo_dp2:
                if (player2.redo()) {
                    current_score_dp2.setText("Current Score : " + player2.getScore());
                } else Toast.makeText(this, "No Values to be back ", Toast.LENGTH_SHORT).show();

                break;
            case R.id.imageView_dp2:
                history= "";
                for (int i = 0; i < player2.getScoreList().size(); i++) {
                    history = history + "\n" + player2.getScoreList().get(i).toString();
                }
                builder.setTitle("History");
                builder.setMessage("" + history);
                builder.show();
                break;

            case R.id.add_dp3:
                if (WonValue_dp3.getText().toString().trim().equals("")){
                    Toast.makeText(this, "Please Add Numbers", Toast.LENGTH_SHORT).show();
                }else{
                    won= Integer.parseInt(WonValue_dp3.getText().toString().trim());
                    if (won>0&&won<90){
                        player3.AddToScoreList(won);
                        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                        WonValue_dp3.setText("");
                        if (player3.getScore()< Win_limit){
                            current_score_dp3.setText("Current Score is: "+player3.getScore());}
                        else if(player3.getScore()>= Win_limit) {
                            builder.setTitle("Congratulations");
                            builder.setMessage("Player 3 Won!");
                            builder.setPositiveButton("Play Again?", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent x = new Intent(draw_triple_activity.this, draw_triple_activity   .class);
                                    startActivity(x);
                                }
                            });
                            builder.setNegativeButton("No!", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent x = new Intent(draw_triple_activity.this, MainActivity.class);
                                    startActivity(x);
                                }
                            });
                            builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialog) {
                                    Intent x = new Intent(draw_triple_activity.this, MainActivity.class);
                                    startActivity(x);
                                }
                            });
                            builder.show();
                        }}}

                break;
            case R.id.undo_dp3:
                if (player3.undo()) {
                    current_score_dp3.setText("Current Score : " + player3.getScore());
                } else Toast.makeText(this, "No Values To Undo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.redo_dp3:
                if (player3.redo()) {
                    current_score_dp3.setText("Current Score : " + player3.getScore());
                } else Toast.makeText(this, "No Values to be back ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView_dp3:
                history ="";
                for (int i = 0 ;i<player3.getScore();i++){
                    history= history+"\n"+player3.getScoreList().get(i).toString();
                }
                AlertDialog.Builder builder4 = new AlertDialog.Builder(this);
                builder4.setTitle("History");
                builder4.setMessage(""+history);
                builder4.show();
                break;

        }
    }
}
