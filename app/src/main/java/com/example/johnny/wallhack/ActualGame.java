package com.example.johnny.wallhack;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;
import java.util.Arrays;

public class ActualGame extends AppCompatActivity {

    Random rn = new Random();

    private static final int NUM_ROWS = 3;
    private static final int NUM_COLS = 3;
    private boolean finished = false;
    private Handler h;
    private int time = 5;
    private boolean[][] click = {{false, false, false},
                                 {false, false, false},
                                 {false, false, false}};
    //private int clickNum = 0;
    private int score = 0;
    private int[] randCols = {0, 0, 0};
    private int[] randRows = {0, 0, 0};

    Button buttons[][] = new Button [NUM_ROWS][NUM_COLS];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual_game);
        initClick();
        populateButtons();
        ravensAppear();
        stopwatch();
    }

    private void populateButtons() {
        TableLayout table = (TableLayout) findViewById(R.id.tableForButtons);
        for (int row = 0; row < NUM_ROWS; row++){
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f
            ));
            table.addView(tableRow);

            for (int col = 0; col < NUM_COLS; col++){
                final int FINAL_COL = col;
                final int FINAL_ROW = row;
                Button button = new Button(this);
                button.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT,
                        1.0f
                ));
                button.setText("" + col + "," + row);
                //make Text not clip on small buttons
                button.setPadding(0, 0, 0, 0);

                button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        gridButtonClicked(FINAL_COL, FINAL_ROW);
                    }
                });
                tableRow.addView(button);
                buttons[row][col] = button;
            }
        }
    }

    private void gridButtonClicked(int col, int row) {
        //Toast.makeText(this, "Button clicked" +col+ "," +row, Toast.LENGTH_SHORT).show();
        Button button = buttons[row][col];
        //Lock Button Sizes
        LockButtonSizes();


        //doesn't scale image
        //button.setBackgroundResource(R.mipmap.raven_head);

        //scale Image
        int newWidth = button.getWidth();
        int newHeight = button.getHeight();

        /*Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth,newHeight,true);
        Resources resource = getResources();
        button.setBackground(new BitmapDrawable(resource, scaledBitmap));*/

        //change text
        click[row][col] = true;
        //clickNum++;
        //button.setText("clicked");
    }

    private void LockButtonSizes() {
        for (int r = 0; r < NUM_ROWS; r++){
            for (int c = 0; c < NUM_COLS; c++){
                Button button = buttons[c][r];

                int width = button.getWidth();
                button.setMinWidth(width);
                button.setMaxWidth(width);

                int height = button.getHeight();
                button.setMinHeight(height);
                button.setMaxHeight(height);

            }
        }
    }

    private int[] getCol() {
        for (int i = 0; i < 3; i++) {
            int col = rn.nextInt(3);
            randCols[i] = col;
        }
        return randCols;
    }

    private int[] getRow() {
        for (int i = 0; i < 3; i++) {
            int row = rn.nextInt(3);
            randRows[i] = row;
        }
        return randRows;
    }

    private void ravensAppear() {
        //while(!finished) {
            //Random rn = new Random();
            for (int i = 0; i < 3; i++) {
                int col = getCol()[i];
                int row = getRow()[i];
                buttons[col][row].setText("RAVEN");
            }
            //int col = rn.nextInt(3);
            //int row = rn.nextInt(3);
            //buttons[col][row].setText("RAVEN");
            //int col = 2;
            //int row = 1;
            LockButtonSizes();
            //scale Image
            //buttons[col][row].setBackgroundResource(R.mipmap.raven_head);
            //buttons[col][row].setText("RAVEN");
            //int newWidth = buttons[col][row].getWidth();
            //int newHeight = buttons[col][row].getHeight();
            //Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.raven_head);
            //Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, true);
            //Resources resource = getResources();
            //buttons[col][row].setBackground(new BitmapDrawable(resource, scaledBitmap));*//**//*

            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }*/
        //}
        //return buttons[col][row].getText();

    }

    private void ravensDisappear() {
        for (int col = 0; col < NUM_COLS; col++) {
            for (int row = 0; row < NUM_ROWS; row++) {
                buttons[col][row].setText(col + "," + row);
            }
        }
    }

    private void stopwatch() {
        CountDownTimer countdown = new CountDownTimer(time * 1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                check();
            }
            public void onFinish() {
                initClick();
                ravensDisappear();
                ravensAppear();
                start();
            }
        }.start();
    }

    private void initClick() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                click[i][j] = false;
            }
        }
    }

    private void check() {
        //if (ravensAppear() == "RAVEN") {
            for (int i = 0; i < 3; i++) {
                if (click[getCol()[i]][getRow()[i]] == true) { // For some reason, checking immediate previous location of 'RAVEN'
                    score++;
                    Toast.makeText(this, "Score: " + score, Toast.LENGTH_SHORT).show();
                }
            }
        //}
    }
}