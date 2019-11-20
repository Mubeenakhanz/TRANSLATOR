package com.cs515.prototype0;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends AppCompatActivity{




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ConstraintLayout viewPager = findViewById(R.id.view_pager);

//        final ListView simpleList;
//        String countryList[] = {"English", "Arabic", "Spanish", "Hindi", "French", "German", "Italian", "Russian"};

//        simpleList = findViewById(R.id.simpleListView);
//        final CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), countryList);
//        simpleList.setAdapter(customAdapter);

        final RadioGroup radioGroup = findViewById(R.id.radioGroup);
        final RadioGroup radioGroup1 = findViewById(R.id.radioGroup1);

        Button secondPage = findViewById(R.id.secondPageBtn);
        secondPage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent startIntent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(startIntent);
            }
        });


        final Button myLanguage_button = findViewById(R.id.button);
        myLanguage_button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view)
             {

                 Toast.makeText(getApplicationContext(), "My language button clicked", Toast.LENGTH_SHORT).show();
                 radioGroup.setVisibility(View.VISIBLE);
                 viewPager.setVisibility(View.INVISIBLE);
             }
         }
        );

        final Button foreignLanguage_button = findViewById(R.id.button2);
        foreignLanguage_button.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View view)
             {
                 Toast.makeText(getApplicationContext(), "Foreign language button clicked", Toast.LENGTH_SHORT).show();
                 radioGroup1.setVisibility(View.VISIBLE);
                 viewPager.setVisibility(View.INVISIBLE);
             }
         }
        );

        final Button repeat_button = findViewById(R.id.button6);
        repeat_button.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view)
              {
                  Toast.makeText(getApplicationContext(), "Repeat button clicked", Toast.LENGTH_SHORT).show();
                  repeat_button.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
              }
          }
        );

        RadioButton radioEnglish = findViewById(R.id.radioEnglish);
        radioEnglish.setOnClickListener(new View.OnClickListener() {
                                            @Override
                                            public void onClick(View view){
                                                Toast.makeText(getApplicationContext(), "You selected English language", Toast.LENGTH_SHORT).show();
                                                radioGroup.setVisibility(View.INVISIBLE);
                                                viewPager.setVisibility(View.VISIBLE);
                                                myLanguage_button.setText("English");
                                            }
        });

        RadioButton radioSpanish = findViewById(R.id.radioSpanish);
        radioSpanish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(), "You selected Spanish language", Toast.LENGTH_SHORT).show();
                radioGroup.setVisibility(View.INVISIBLE);
                viewPager.setVisibility(View.VISIBLE);
                myLanguage_button.setText("Spanish");
            }
        });

        RadioButton radioEnglish1 = findViewById(R.id.radioEnglish1);
        radioEnglish1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(), "You selected English language", Toast.LENGTH_SHORT).show();
                radioGroup1.setVisibility(View.INVISIBLE);
                viewPager.setVisibility(View.VISIBLE);
                foreignLanguage_button.setText("English");
            }
        });

        RadioButton radioSpanish1 = findViewById(R.id.radioSpanish1);
        radioSpanish1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Toast.makeText(getApplicationContext(), "You selected Spanish language", Toast.LENGTH_SHORT).show();
                radioGroup1.setVisibility(View.INVISIBLE);
                viewPager.setVisibility(View.VISIBLE);
                foreignLanguage_button.setText("Spanish");
            }
        });


    }

}