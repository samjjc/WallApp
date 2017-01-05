package com.example.johnny.wallhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Help_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help__page);
    }
    public void RETURNMessage(View view) {
        Intent startNewActivity = new Intent(this, MainActivity.class);
        startActivity(startNewActivity);
    }
    public void PLAYMessage(View view) {
        Intent startNewActivity = new Intent(this, GetName.class);
        startActivity(startNewActivity);
    }
}
