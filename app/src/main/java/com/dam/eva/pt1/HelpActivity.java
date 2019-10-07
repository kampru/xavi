package com.dam.eva.pt1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class HelpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);


        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        String nomBundle=intent.getStringExtra("NOM");


        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.txtViewHelp);
        textView.setText(message + "\n  "+ nomBundle);

    }
}
