package com.example.johnny.wallhack;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void PLAYMessage(View view) {
        Intent startNewActivity = new Intent(this, GetName.class);
        startActivity(startNewActivity);}
    public void HELPMessage(View view) {
        Intent startNewActivity = new Intent(this, Help_Page.class);
        startActivity(startNewActivity);
    }

    public void leader(View view) {
        Intent intent = new Intent(this, Leaderboard.class);
        startActivity(intent);
    }


}