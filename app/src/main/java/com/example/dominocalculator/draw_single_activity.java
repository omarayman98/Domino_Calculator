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

public class draw_single_activity extends AppCompatActivity {

    TextView textView_p1;    TextView current_score_p1;    EditText WonValue_p1;
    Player player1,player2;
    TextView textView_p2;   TextView current_score_p2;    EditText WonValue_p2;

    int Win_limit=101;
    String congratsSingle_p1;
    String congratsSingle_p2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw_single_activity);




        player1=new Player();
        textView_p1 =findViewById(R.id.textView_p1);
        current_score_p1 = findViewById(R.id.current_scorep1);
        WonValue_p1 = findViewById(R.id.WonValue_p1);

        player2=new Player();
        current_score_p2 = findViewById(R.id.current_scorep2);
        WonValue_p2 = findViewById(R.id.WonValue_p2);
        textView_p2 =findViewById(R.id.textView_p2);

        congratsSingle_p1="Player 1 Won !!";
        congratsSingle_p2="Player 2 Won !!";
        if(getIntent().hasExtra("kind")){
            textView_p1.setText("Team 1");
            textView_p2.setText("Team 2");
            congratsSingle_p1="Team 1 Won !!";
            congratsSingle_p2="Team 2 Won !!";
        }
    }

    public void OnDraw_2Players(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        switch (view.getId()) {
            case R.id.add_p1:
                if (WonValue_p1.getText().toString().trim().equals("")){
                    Toast.makeText(this, "Please Add Numbers", Toast.LENGTH_SHORT).show();
                }else{
                    int won=Integer.parseInt(WonValue_p1.getText().toString().trim());
                    if (won>0&&won<90){
                        player1.AddToScoreList(won);
                        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                        WonValue_p1.setText("");
                        if (player1.getScore()< Win_limit){
                            current_score_p1.setText("Current Score is: "+player1.getScore());}
                        else if(player1.getScore()>= Win_limit) {
                            builder.setTitle("Congratulations");
                            builder.setMessage(""+congratsSingle_p1);
                            builder.setPositiveButton("Play Again?", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent x = new Intent(draw_single_activity.this, draw_single_activity.class);
                                    startActivity(x);
                                }
                            });
                            builder.setNegativeButton("No!", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent x = new Intent(draw_single_activity.this, MainActivity.class);
                                    startActivity(x);
                                }
                            });
                            builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialog) {
                                    Intent x = new Intent(draw_single_activity.this, MainActivity.class);
                                    startActivity(x);
                                }
                            });
                            builder.show();
                        }}
                    else {Toast.makeText(this, "Please Add a Valid Number", Toast.LENGTH_SHORT).show();
                    }}
                break;

            case R.id.undo_p1:
                if (player1.undo()) {
                    current_score_p1.setText("Current Score : " + player1.getScore());
                } else Toast.makeText(this, "No Values To Undo", Toast.LENGTH_SHORT).show();
                break;

            case R.id.redo_p1:
                if (player1.redo()) {
                    current_score_p1.setText("Current Score : " + player1.getScore());
                } else Toast.makeText(this, "No Values to be back ", Toast.LENGTH_SHORT).show();
                break;

            case R.id.imageView_p1:
                String History1 = "";
                for (int i = 0; i < player1.getScoreList().size(); i++) {
                    History1 = History1 + "\n" + player1.getScoreList().get(i).toString();
                }
                builder.setTitle("History");
                builder.setMessage("" + History1);
                builder.show();
                break;

            case R.id.add_p2:
                if (WonValue_p2.getText().toString().trim().equals("")){
                    Toast.makeText(this, "Please Add Numbers", Toast.LENGTH_SHORT).show();
                }else{
                    int won=Integer.parseInt(WonValue_p2.getText().toString().trim());
                    if (won>0&&won<90){
                        player2.AddToScoreList(won);
                        Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                        WonValue_p2.setText("");
                        if (player2.getScore()< Win_limit){
                            current_score_p2.setText("Current Score is: "+player2.getScore());}
                        else if(player2.getScore()>= Win_limit) {
                            builder.setTitle("Congratulations");
                            builder.setMessage(""+congratsSingle_p2);
                            builder.setPositiveButton("Play Again?", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent x = new Intent(draw_single_activity.this, draw_single_activity.class);
                                    startActivity(x);
                                }
                            });
                            builder.setNegativeButton("No!", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    Intent x = new Intent(draw_single_activity.this, MainActivity.class);
                                    startActivity(x);
                                }
                            });
                            builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                                @Override
                                public void onDismiss(DialogInterface dialog) {
                                    Intent x = new Intent(draw_single_activity.this, MainActivity.class);
                                    startActivity(x);
                                }
                            });
                            builder.show();
                        }}
                    else {Toast.makeText(this, "Please Add a Valid Number", Toast.LENGTH_SHORT).show();
                    }}
                break;
            case R.id.undo_p2:
                if (player2.undo()) {
                    current_score_p2.setText("Current Score : " + player2.getScore());
                } else Toast.makeText(this, "No Values To Undo", Toast.LENGTH_SHORT).show();
                break;
            case R.id.redo_p2:
                if (player2.redo()) {
                    current_score_p2.setText("Current Score : " + player2.getScore());
                } else Toast.makeText(this, "No Values to be back ", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView_p2:
                String History2 = "";
                for (int i = 0; i < player2.getScoreList().size(); i++) {
                    History2 = History2 + "\n" + player2.getScoreList().get(i).toString();
                }
                builder.setTitle("History");
                builder.setMessage("" + History2);
                builder.show();
                break;

    }}

}
