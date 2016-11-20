package com.example.johnny.wallhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class GetName extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_name);
    }

    public void OKMessage(View view) {
        Intent startNewActivity = new Intent(this, ActualGame.class);
        startActivity(startNewActivity);
    }
}
