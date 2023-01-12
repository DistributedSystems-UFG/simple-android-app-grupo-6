package com.example.my1stapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

public class DisplayInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);

        Intent intent = getIntent();
        String[] message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE).split(",");

        String date = message[0];
        double weight = Double.valueOf(message[1]);
        double height = Double.valueOf(message[2]);

        String imcText = getString(R.string.imc_text, calculateIMC(weight, height));
        String ageText = getString(R.string.age_text, calculateAge(date));

        TextView viewIMC = findViewById(R.id.imc);
        TextView viewAge = findViewById(R.id.age);
        viewIMC.setText(imcText);
        viewAge.setText(ageText);
    }

    private double calculateIMC(double weight, double height) {
        return weight / (height * height);
    }

    private int calculateAge(String date) {
        LocalDate dayBirth = LocalDate.parse(date);
        LocalDate currentDate = LocalDate.now();
        return Period.between(dayBirth, currentDate).getYears();
    }
}
