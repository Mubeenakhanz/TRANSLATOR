package com.cs515.prototype0;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button secondPage = (Button) findViewById(R.id.secondPageBtn);
        secondPage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent startIntentpage2 = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(startIntentpage2);
            }
        });


        Button myLanguage_button = findViewById(R.id.button);
        Button foreignLanguage_button = findViewById(R.id.button2);
        Button repeat_button = findViewById(R.id.button6);

        RadioButton englishButton = findViewById(R.id.radioEnglish);
        RadioButton spanishButton = findViewById(R.id.radioSpanish);
        RadioButton englishButton1 = findViewById(R.id.radioEnglish1);
        RadioButton spanishButton1 = findViewById(R.id.radioSpanish1);

        myLanguage_button.setOnClickListener(this);
        foreignLanguage_button.setOnClickListener(this);
        repeat_button.setOnClickListener(this);
        englishButton.setOnClickListener(this);
        spanishButton.setOnClickListener(this);
        englishButton1.setOnClickListener(this);
        spanishButton1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        ConstraintLayout viewPager = findViewById(R.id.view_pager);
        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        RadioGroup radioGroup1 = findViewById(R.id.radioGroup1);
        Button repeat_button = findViewById(R.id.button6);
        Button myLanguage_button = findViewById(R.id.button);
        Button foreignLanguage_button = findViewById(R.id.button2);
        switch (v.getId()){
            case R.id.button6:
                Toast.makeText(this, "Repeat button clicked", Toast.LENGTH_SHORT).show();
                repeat_button.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                break;
            case R.id.button:
                Toast.makeText(this, "My language button clicked", Toast.LENGTH_SHORT).show();
                radioGroup.setVisibility(View.VISIBLE);
                viewPager.setVisibility(View.INVISIBLE);
                break;
            case R.id.button2:
                Toast.makeText(this, "Foreign language button clicked", Toast.LENGTH_SHORT).show();
                radioGroup1.setVisibility(View.VISIBLE);
                viewPager.setVisibility(View.INVISIBLE);
                break;
            case R.id.radioEnglish:
                Toast.makeText(this, "You selected English language", Toast.LENGTH_SHORT).show();
                radioGroup.setVisibility(View.INVISIBLE);
                viewPager.setVisibility(View.VISIBLE);
                myLanguage_button.setText("English");
                break;
            case R.id.radioSpanish:
                Toast.makeText(this, "You selected Spanish language", Toast.LENGTH_SHORT).show();
                radioGroup.setVisibility(View.INVISIBLE);
                viewPager.setVisibility(View.VISIBLE);
                myLanguage_button.setText("Spanish");
                break;
            case R.id.radioEnglish1:
                Toast.makeText(this, "You selected English language", Toast.LENGTH_SHORT).show();
                radioGroup1.setVisibility(View.INVISIBLE);
                viewPager.setVisibility(View.VISIBLE);
                foreignLanguage_button.setText("English");
                break;
            case R.id.radioSpanish1:
                Toast.makeText(this, "You selected Spanish language", Toast.LENGTH_SHORT).show();
                radioGroup1.setVisibility(View.INVISIBLE);
                viewPager.setVisibility(View.VISIBLE);
                foreignLanguage_button.setText("Spanish");
                break;

        }

    }

}