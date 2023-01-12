package com.example.my1stapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        String text = getString(R.string.welcome_text, message);
        TextView textView = findViewById(R.id.textview_welcome);
        textView.setText(text);
    }

    public void sendInfo(View view) {
        Intent intent = new Intent(this, DisplayInfoActivity.class);
        EditText editText1 = (EditText) findViewById(R.id.editTextDate);
        EditText editText2 = (EditText) findViewById(R.id.editTextNumberDecimal);
        EditText editText3 = (EditText) findViewById(R.id.editTextNumberDecimal2);

        String message = editText1.getText().toString() + "," + editText2.getText().toString() + "," + editText3.getText().toString();
        intent.putExtra(MainActivity.EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}