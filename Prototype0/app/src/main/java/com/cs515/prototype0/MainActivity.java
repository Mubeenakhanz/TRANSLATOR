package com.cs515.prototype0;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;


//import com.google.android.material.floatingactionbutton.FloatingActionButton;
//import com.google.android.material.snackbar.Snackbar;
//import com.google.android.material.tabs.TabLayout;
//import com.google.android.material.button.MaterialButton;

import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;


//import android.view.Menu;
//import android.view.MenuItem;
//import android.view.View;

import com.cs515.prototype0.ui.main.SectionsPagerAdapter;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        Button myLanguage_button = findViewById(R.id.button);
        Button foreignLanguage_button = findViewById(R.id.button2);
        Button repeat_button = findViewById(R.id.button6);

        RadioButton englishButton = findViewById(R.id.radioEnglish);
        RadioButton spanishButton = findViewById(R.id.radioSpanish);
        RadioButton englishButton1 = findViewById(R.id.radioEnglish1);
        RadioButton spanishButton1 = findViewById(R.id.radioSpanish1);

//        viewPager.setAdapter(sectionsPagerAdapter);
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
//                repeat_button.setBackgroundTintList(ColorStateList.valueOf(Color.GREEN));
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
                Toast.makeText(this, "You selected English language", Toast.LENGTH_LONG).show();
                radioGroup.setVisibility(View.INVISIBLE);
                viewPager.setVisibility(View.VISIBLE);
                myLanguage_button.setText("English");
                break;
            case R.id.radioSpanish:
                Toast.makeText(this, "You selected Spanish language", Toast.LENGTH_LONG).show();
                radioGroup.setVisibility(View.INVISIBLE);
                viewPager.setVisibility(View.VISIBLE);
                myLanguage_button.setText("Spanish");
                break;
            case R.id.radioEnglish1:
                Toast.makeText(this, "You selected English language", Toast.LENGTH_LONG).show();
                radioGroup1.setVisibility(View.INVISIBLE);
                viewPager.setVisibility(View.VISIBLE);
                foreignLanguage_button.setText("English");
                break;
            case R.id.radioSpanish1:
                Toast.makeText(this, "You selected Spanish language", Toast.LENGTH_LONG).show();
                radioGroup1.setVisibility(View.INVISIBLE);
                viewPager.setVisibility(View.VISIBLE);
                foreignLanguage_button.setText("Spanish");
                break;

        }

    }

}