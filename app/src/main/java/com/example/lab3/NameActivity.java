package com.example.lab3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class NameActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);

        TextView welcomeText = findViewById(R.id.welcomeText);
        Button thankYouButton = findViewById(R.id.thankYouButton);
        Button changeNameButton = findViewById(R.id.changeNameButton);

        String name = getIntent().getStringExtra("name");
        if (name == null) {
            name = "";
        }

        welcomeText.setText(getString(R.string.welcome_name, name));

        thankYouButton.setOnClickListener(view -> {
            setResult(1);
            finish();
        });

        changeNameButton.setOnClickListener(view -> {
            setResult(0);
            finish();
        });
    }
}
