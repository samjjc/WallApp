package com.example.johnny.wallhack;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class GetName extends AppCompatActivity {
    private EditText text;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_name);
        text = (EditText) findViewById(R.id.usernameinput);
        button = (Button) findViewById(R.id.OK);
        button.setEnabled(false);

        text.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(s.toString().trim().equals("")){
                    button.setEnabled(false);
                } else {
                    button.setEnabled(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                // TODO Auto-generated method stub
            }
            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            Intent startNewActivity = new Intent(GetName.this, ActualGame.class);
            @Override
            public void onClick(View v) {
                //if(TextUtils.isEmpty(getText)) {
                //    Toast.makeText(GetName.this, "EditText is Empty", Toast.LENGTH_LONG).show();
                //} else {
                startActivity(startNewActivity);
                finish();
                //}
            }
        });

    }
    /*
    public void OKMessage(View view) {
        //getText = text.getText().toString();
        Intent startNewActivity = new Intent(this, ActualGame.class);
        startActivity(startNewActivity);
        finish();
    }
    */
}
