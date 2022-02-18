package com.example.dominocalculator;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {
    RadioGroup rg;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.txt);
        txt.setPaintFlags(txt.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
    }



    public void ToPerfectActivity(View view) {
        AlertDialog.Builder info = new AlertDialog.Builder(this);

        Intent go;
        String doubles;
        switch (view.getId()) {
            case R.id.draw_single:
                        go = new Intent(this, draw_single_activity.class);
                        startActivity(go);
                        break;
            case R.id.draw_teams:
                        doubles = "doubles";
                        go = new Intent(this, draw_single_activity.class);
                        go.putExtra("kind", doubles);
                        startActivity(go);
                        Toast.makeText(this, " Let's play Doubles", Toast.LENGTH_SHORT).show();
                        break;
            case R.id.draw_triple:
                        go = new Intent(this, draw_triple_activity.class);
                        startActivity(go);
                        Toast.makeText(this, "Let's play Triples", Toast.LENGTH_SHORT).show();
                        break;

            case R.id.five_single:
                go = new Intent(this, five_single_activity.class);
                startActivity(go);
                break;
            case R.id.five_teams:
                doubles = "doubles";
                go = new Intent(this, five_single_activity.class);
                go.putExtra("kind", doubles);
                startActivity(go);
                Toast.makeText(this, " Let's play Doubles", Toast.LENGTH_SHORT).show();
                break;
            case R.id.five_triple:
                go = new Intent(this, five_triple_activity.class);
                startActivity(go);
                break;
            case R.id.draw_info:
                info.setTitle("How to play Draw Domino");
                info.setMessage("How to play: Each player tries to match the pips on one end of a tile from his hand with the pips on an open end of any tile in the layout. If a player is unable to match a tile from his hand with a tile in the layout, the player passes his turn to the player on his left. Each player may play only one tile per turn.\n" +
                        "The first player to get rid of all dominoes announces \"Domino!\" and wins the game. if none of the players can make a play, the game ends in a block. If a game ends in a block, all the players turn the tiles in their hands faceup, count the pips on each tile, and add them together. The player with the lowest total wins the game and earns the points (1 point per pip) of all the tiles left remaining in his opponents' hands. The player who first reaches 100 points or more is the overall winner.\n" +
                        "Set Variations: 1) highest double, and in the event no double is drawn, re-shuffle and re-draw; 2) 6-6, and in the event the 6-6 is not drawn, re-shuffle and re-draw; or 3) highest double, and in the event no double is drawn, play the highest single.\n" +
                        "\n" +
                        "Other rules: The game can be played with no spinners (which seems the most often used rule) or by using the first double as the only spinner of the game.\n" +
                        "In most places, Draw is played to 100 points. However, there are many different variations, including to 50, 150, 200, or 101 points.");
                info.show();
                break;
            case R.id.five_info:
                info.setTitle("How to play All Fives Domino");
                info.setMessage("How to play: After the first domino is set, subsequent players must join a tile from their hand with an open end in the line of play. The ends of the two tiles that are joined must have the same number of pips.\n" +
                        "\n" +
                        "If a player is unable to make a play from his hand, he must draw tiles from the boneyard until he draws a playable tile. If a player is unable to make a play from his hand and there are no tiles left in the boneyard, the player must skip his turn until he is able to make a play.\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "Scoring if hand is blocked: Each player counts the pips on the remaining tiles in his hand. The player with the lowest number of pips scores the difference between his total and that of each of his opponents. Then, the player with the next-lowest number of pips scores the difference between his total and that of each of his opponents, and so on.\n" +
                        "\n" +
                        " \n" +
                        "\n" +
                        "Scoring when partners play: Players must play individually, but a common score is kept for partners. When a player dominoes, the number of pips on the tiles remaining in the hand of his partner are subtracted from their score.\n" +
                        "\n" +
                        "Scoring: A player is awarded points every time he makes a play that results in the open ends of the tiles in the line of play adding up to a multiple of 5. (5 points for 5 pips; 10 points for 10 pips; 15 points for 15 pips; and so on.) The player who dominoes is also awarded points at the end of each hand by adding up, and rounding to the nearest multiple of 5, the pips on the tiles left in his opponents' hands. Only 1 or 2 pips is worth nothing; 3, 4, 5, 6, and 7 is worth 5 points; 8, 9, 10, 11, and 12 is worth 10 points; and so on. The first player, or partnership if 4 are playing, to reach 200 points wins the game. If a player reaches 200 points during play, the game ends at that point. If points are tallied at the end of a hand and more than one player has a score of 200 or more, the player with the highest score wins. In case of a tie, follow these rules: If 2 are playing, play two more hands; 3 players, play three more hands; 4 players, play four more hands.");
                info.show();
                break;

            case R.id.txt:
                        final Dialog bio_dialog = new Dialog(new ContextThemeWrapper(MainActivity.this, R.style.AppTheme));
                        final View add_new_car_layout = getLayoutInflater().inflate(R.layout.bio, null);
                        bio_dialog.setContentView(add_new_car_layout);
                        bio_dialog.setCancelable(true);
                        bio_dialog.show();
                        break;
                }

        }
    }


