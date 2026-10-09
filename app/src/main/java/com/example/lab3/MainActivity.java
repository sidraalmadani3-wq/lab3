package com.example.lab3;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

    private EditText nameEditText;
    private SharedPreferences preferences;
    private static final int NAME_REQUEST = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.nameEditText);
        Button nextButton = findViewById(R.id.nextButton);

        preferences = getSharedPreferences("NamePreferences", MODE_PRIVATE);
        nameEditText.setText(preferences.getString("name", ""));

        nextButton.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, NameActivity.class);
            intent.putExtra("name", nameEditText.getText().toString());
            startActivityForResult(intent, NAME_REQUEST);
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        // Save name to SharedPreferences
        preferences.edit().putString("name", nameEditText.getText().toString()).apply();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == NAME_REQUEST) {

            if (resultCode == 0) {
                nameEditText.requestFocus();
                nameEditText.selectAll();
            }

            else if (resultCode == 1) {
                finish();
            }
        }
    }
}
