package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    int turn = 0;
    int gameState[] = {2,2,2,2,2,2,2,2,2};

    public void dropIn(View view){
        ImageView tic = (ImageView) view;

        if(gameState[Integer.parseInt(tic.getTag().toString())] == 2){
            tic.setTranslationY(-1000f);
            if(turn == 0){
                tic.setImageResource(R.drawable.yellow);
                gameState[Integer.parseInt(tic.getTag().toString())] = 1;
                turn = 1;
            }else{
                tic.setImageResource(R.drawable.red);
                gameState[Integer.parseInt(tic.getTag().toString())] = 0;
                turn = 0;
            }
            tic.animate().translationYBy(1000f).rotationBy(720).setDuration(700);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}