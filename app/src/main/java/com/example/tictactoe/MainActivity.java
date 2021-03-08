package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int turn = 0;
    int gameState[] = {2,2,2,2,2,2,2,2,2};


    public void dropIn(View view){
        ImageView tic = (ImageView) view;
        TextView winText = (TextView) findViewById(R.id.WinnerText);
        Button btn = findViewById(R.id.button);

        if(gameState[Integer.parseInt(tic.getTag().toString())] == 2){
            tic.setTranslationY(-1000f);
            if(turn == 0){
                tic.setImageResource(R.drawable.yellow);
                gameState[Integer.parseInt(tic.getTag().toString())] = 0;
                turn = 1;
                if(checkWin(0)){
                    winText.setText("YELLOW WINS");
                    btn.animate().alpha(1f).setDuration(100);
                    winText.animate().alpha(1f).setDuration(100);
                }
            }else{
                tic.setImageResource(R.drawable.red);
                gameState[Integer.parseInt(tic.getTag().toString())] = 1;
                turn = 0;
                if(checkWin(1)){
                    winText.setText("RED WINS");
                    btn.animate().alpha(1f).setDuration(100);
                    winText.animate().alpha(1f).setDuration(100);
                }
            }
            tic.animate().translationYBy(1000f).rotationBy(720).setDuration(300);
        }

    }
    public void clear(View view){
        TextView winText = (TextView) findViewById(R.id.WinnerText);
        Button btn = findViewById(R.id.button);
        btn.animate().alpha(0f).setDuration(100);
        winText.animate().alpha(0f).setDuration(100);
        for(int i = 0; i < gameState.length; i++){
            gameState[i] = 2;
        }
        ImageView tic1 = (ImageView) findViewById(R.id.tic1);
        ImageView tic2 = (ImageView) findViewById(R.id.tic2);
        ImageView tic3 = (ImageView) findViewById(R.id.tic3);
        ImageView tic4 = (ImageView) findViewById(R.id.tic4);
        ImageView tic5 = (ImageView) findViewById(R.id.tic5);
        ImageView tic6 = (ImageView) findViewById(R.id.tic6);
        ImageView tic7 = (ImageView) findViewById(R.id.tic7);
        ImageView tic8 = (ImageView) findViewById(R.id.tic8);
        ImageView tic9 = (ImageView) findViewById(R.id.tic9);

        tic1.setImageResource(0);
        tic2.setImageResource(0);
        tic3.setImageResource(0);
        tic4.setImageResource(0);
        tic5.setImageResource(0);
        tic6.setImageResource(0);
        tic7.setImageResource(0);
        tic8.setImageResource(0);
        tic9.setImageResource(0);




    }

    public boolean checkWin(int x){
        if((gameState[0] == x && gameState[1] == x && gameState[2] == x)
                ||(gameState[3] == x && gameState[4] == x && gameState[5] == x)
                ||(gameState[6] == x && gameState[7] == x && gameState[8] == x)
                ||(gameState[0] == x && gameState[4] == x && gameState[8] == x)
                ||(gameState[2] == x && gameState[4] == x && gameState[6] == x)
                ||(gameState[0] == x && gameState[3] == x && gameState[6] == x)
                ||(gameState[1] == x && gameState[4] == x && gameState[7] == x)
                ||(gameState[2] == x && gameState[5] == x && gameState[8] == x)){
            return true;
        }
        return false;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
}