package com.example.johnny.wallhack;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

import java.util.Random;

public class ActualGame extends AppCompatActivity {

    private static final int NUM_ROWS = 3;
    private static final int NUM_COLS = 3;
    private boolean finished = false;
    private Handler h;
    private int time = 5;

    Button buttons[][] = new Button [NUM_ROWS][NUM_COLS];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actual_game);
        populateButtons();
        /*Runnable runGame = new Runnable() {
            public void run() {
                ravensAppear();
            }
        };
        new Thread(runGame).start();*/

//        h = new Handler();
//
//        Runnable runnable = new Runnable(){
//            @Override
//            public void run() {
//                ravensAppear();
//                Log.v("ct", "life");
//                time-=1;
//                if(time>0) {
//                    h.postDelayed(this, 1000);
//                }
//            }
//        };
//        h.postDelayed(runnable, 1000);
        /*int delay = 1000; //milliseconds
       // while(!finished) {
            h.postDelayed(new Runnable() {
                public void run() {
                    ravensAppear();
                    if (!finished) {
                        h.postDelayed(this, 1000);
                    }
                }
            }, delay);
        }*/
    }

    private void populateButtons() {
        TableLayout table = (TableLayout) findViewById(R.id.tableForButtons);
        for (int row=0; row< NUM_ROWS;row++){
            TableRow tableRow = new TableRow(this);
            tableRow.setLayoutParams(new TableLayout.LayoutParams(
                    TableLayout.LayoutParams.MATCH_PARENT,
                    TableLayout.LayoutParams.MATCH_PARENT,
                    1.0f
            ));
            table.addView(tableRow);

            for (int col=0; col< NUM_COLS;col++){
                final int FINAL_COL = col;
                final int FINAL_ROW = row;
                Button button = new Button(this);
                button.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT,
                        1.0f
                ));
                button.setText(""+col+","+row);
                //make Text not clip on small buttons
                button.setPadding(0,0,0,0);

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
        Toast.makeText(this, "Button clicked" +col+ "," +row, Toast.LENGTH_SHORT).show();
        Button button = buttons[row][col];
        //Lock Button Sizes
        LockButtonSizes();


        //doesn't scale image
        //button.setBackgroundResource(R.mipmap.raven_head);

        //scale Image
        int newWidth = button.getWidth();
        int newHeight = button.getHeight();
        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(),R.mipmap.ic_launcher);
        Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth,newHeight,true);
        Resources resource = getResources();
        button.setBackground(new BitmapDrawable(resource, scaledBitmap));

        //change text
        button.setText("clicked");
    }

    private void LockButtonSizes() {
        for(int r = 0; r<NUM_ROWS;r++){
            for(int c = 0; c<NUM_COLS;c++){
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
    private void ravensAppear() {
        while(!finished) {
            Random rn = new Random();
            int col = rn.nextInt(3);
            int row = rn.nextInt(3);
            //int col=2;
            //int row=1;
            LockButtonSizes();
            buttons[col][row].setBackgroundResource(R.mipmap.raven_head);
            //scale Image
            /*buttons[col][row].setBackgroundResource(R.mipmap.raven_head);
            int newWidth = buttons[col][row].getWidth();
            int newHeight = buttons[col][row].getHeight();
            Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.raven_head);
            Bitmap scaledBitmap = Bitmap.createScaledBitmap(originalBitmap, newWidth, newHeight, true);
            Resources resource = getResources();
            buttons[col][row].setBackground(new BitmapDrawable(resource, scaledBitmap));
            /*try {
                Thread.sleep(1000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }*/
        }

    }


}
