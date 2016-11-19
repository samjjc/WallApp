package com.example.johnny.wallhack;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final int NUM_ROWS = 3;
    private static final int COL_ROWS = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        populateButtons();
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

            for (int col=0; col< COL_ROWS;col++){
                final int FINAL_COL = col;
                final int FINAL_ROW = row;
                Button button = new Button(this);
                button.setLayoutParams(new TableRow.LayoutParams(
                        TableRow.LayoutParams.MATCH_PARENT,
                        TableRow.LayoutParams.MATCH_PARENT,
                        1.0f
                ));
                button.setText(""+row+","+col);
                //make Text not clip on small buttons
                button.setPadding(0,0,0,0);

                button.setOnClickListener(new View.OnClickListener(){
                    @Override
                    public void onClick(View v){
                        gridButtonClicked(FINAL_COL, FINAL_ROW);
                    }
                });
                tableRow.addView(button);
            }
        }
    }

    private void gridButtonClicked(int x, int y) {
        Toast.makeText(this, "Button clicked", Toast.LENGTH_SHORT).show();
    }


}
