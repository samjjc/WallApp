package com.example.johnny.wallhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class End extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end);
    }

    public void leader(View view) {
        Intent intent = new Intent(this, Leaderboard.class);
        startActivity(intent);
    }

    public void returnMain(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

    public void returnName(View view) {
        Intent intent = new Intent(this, GetName.class);
        startActivity(intent);
    }
}
