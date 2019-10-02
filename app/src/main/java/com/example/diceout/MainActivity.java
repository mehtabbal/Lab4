package com.example.diceout;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] deck = {
            R.drawable.ace_of_clubs,
            R.drawable.two_of_clubs,
            R.drawable.three_of_clubs,
            R.drawable.four_of_clubs,
            R.drawable.five_of_clubs,
            R.drawable.six_of_clubs,
            R.drawable.seven_of_clubs,
            R.drawable.eight_of_clubs,
            R.drawable.nine_of_clubs,
            R.drawable.ten_of_clubs,
            R.drawable.jack_of_clubs,
            R.drawable.king_of_clubs,
            R.drawable.queen_of_clubs,
            R.drawable.ace_of_diamonds,
            R.drawable.two_of_diamonds,
            R.drawable.three_of_diamonds,
            R.drawable.four_of_diamonds,
            R.drawable.five_of_diamonds,
            R.drawable.six_of_diamonds,
            R.drawable.seven_of_diamonds,
            R.drawable.eight_of_diamonds,
            R.drawable.nine_of_diamonds,
            R.drawable.ten_of_diamonds,
            R.drawable.jack_of_diamonds,
            R.drawable.king_of_diamonds,
            R.drawable.queen_of_diamonds,
            R.drawable.ace_of_hearts,
            R.drawable.two_of_hearts,
            R.drawable.three_of_hearts,
            R.drawable.four_of_hearts,
            R.drawable.five_of_hearts,
            R.drawable.six_of_hearts,
            R.drawable.seven_of_hearts,
            R.drawable.eight_of_hearts,
            R.drawable.nine_of_hearts,
            R.drawable.ten_of_hearts,
            R.drawable.jack_of_hearts,
            R.drawable.king_of_hearts,
            R.drawable.queen_of_hearts,
            R.drawable.ace_of_spades,
            R.drawable.two_of_spades,
            R.drawable.three_of_spades,
            R.drawable.four_of_spades,
            R.drawable.five_of_spades,
            R.drawable.six_of_spades,
            R.drawable.seven_of_spades,
            R.drawable.eight_of_spades,
            R.drawable.nine_of_spades,
            R.drawable.ten_of_spades,
            R.drawable.jack_of_spades,
            R.drawable.king_of_spades,
            R.drawable.queen_of_spades
    };


    TextView rollResult;


    int score;


    TextView scoreText;


    Random rand;
    ImageView card1image, card2image, card3image;


    int card1;
    int card2;
    int card3;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rollDice(view);
            }
        });


        score = 0;


        Toast.makeText(getApplicationContext(),"Welcome to Poker!", Toast.LENGTH_SHORT).show();


        rollResult = (TextView) findViewById(R.id.rollResult);
        scoreText = (TextView) findViewById(R.id.scoreText);


        rand = new Random();



        card1image = (ImageView) findViewById(R.id.c1);
        card2image = (ImageView) findViewById(R.id.c2);
        card3image = (ImageView) findViewById(R.id.c3);



    }

    public void rollDice(View v) {

        card1 = rand.nextInt(deck.length);
        card2 = rand.nextInt(deck.length);
        card3 = rand.nextInt(deck.length);

        card1image.setImageResource(deck[card1]);
        card2image.setImageResource(deck[card2]);
        card3image.setImageResource(deck[card3]);





        String msg;


        if (card1 % 13 == card2 % 13 && card2 % 13 == card3 % 13) {

            msg = "You have drawn a triple! You scored 100 points!";
            score += 100;
        } else if (card1 % 13 == card2 % 13 || card1 % 13 == card3 % 13 || card2 % 13 == card3 % 13) {

            msg = "You have drawn a double for 50 points!";
            score += 50;
        } else {
            msg = "You didn't score this roll. Try again!";
        }


        rollResult.setText(msg);
        scoreText.setText("Score: " + score);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
