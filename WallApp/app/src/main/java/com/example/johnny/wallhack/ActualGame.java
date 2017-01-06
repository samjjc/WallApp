package com.example.johnny.wallhack;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ActualGame extends AppCompatActivity {

    //TextView text = new TextView(this);
    //TextView text = (TextView) findViewById(R.id.text1);

    Random rand = new Random();

    private static final int NUM_ROWS = 3;
    private static final int NUM_COLS = 3;
    private static boolean[][] check = {{false, false, false},
                                        {false, false, false},
                                        {false, false, false}};
    //private static boolean clicked = false;

    //private static String s;
    /*private static String[][] sArr = {{"blank", "blank", "blank"},
                                      {"blank", "blank", "blank"},
                                      {"blank", "blank", "blank"}};*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual_game);
        //text = (TextView) findViewById(R.id.text1);
        randLoop();
        populateButtons();
    }

    public boolean[][] randGenerator() {
        //while (true) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    check[i][j] = rand.nextBoolean();
                }
            }
            return check;
        //}
    }

    /*private void checkAndDo() {
        boolean[][] randArray = randGenerator();
        *//*for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (randArray[i][j] == true) {
                    sArr[i][j] = "RAVEN";
                    //return raven;
                } else {
                    sArr[i][j] = "blank";
                }
                //text.setText(sArr[i][j]);
            }
        }*//*
        //return sArr;
    }*/

    private void populateButtons() {
        //Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.raven_head);
        //Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth,newHeight,true);
        //Resources resource = getResources();
        //button.setBackground(new BitmapDrawable(resource, scaledBitmap));
        //final ImageView view = new ImageView(this);
        TableLayout table = (TableLayout) findViewById(R.id.table);
        //String s = checkAndDo();
        final boolean[][] randArray = randGenerator();
        for (int col = 0; col < NUM_COLS; col++){
            final TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f
            ));
            table.addView(tableRow);
            for (int row = 0; row < NUM_ROWS; row++) {
                final ImageView view = new ImageView(this);
                //final TextView text = new TextView(this);
                view.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT,
                        1.0f
                ));
                final int finalCol = col;
                final int finalRow = row;
                new CountDownTimer(30000, 2000) {
                    public void onTick(long millisUntilFinished) {
                        if (randArray[finalCol][finalRow] == true) {
                            //text.setText("RAVEN");
                            view.setImageResource(R.mipmap.raven_head);
                            //tableRow.addView(view);
                        } else {
                            //text.setText("blank");
                            view.setImageResource(R.mipmap.placeholder);
                        }
                    }
                    public void onFinish() {
                        start();
                    }
                }.start();

                /*view.setOnClickListener(
                    new View.OnClickListener() {
                        public void onClick(View view) {
                            Log.d("click status", "clicked");
                        }
                    }
                );*/

                //make Text not clip on small buttons
                //text.setPadding(0, 0, 0, 0);
                view.setPadding(0, 0, 0, 0);
                tableRow.addView(view);
                //tableRow.addView(text);
                //text.setText(checkAndDo()[col][row]);
            }
        }
    }

    private void randLoop() {
        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                //checkAndDo();
                randGenerator();
            }

            public void onFinish() {
                start();
            }
        }.start();
    }
}