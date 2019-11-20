package com.cs515.prototype0;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        // Go Back Btn
        Button goBackBtn = (Button) findViewById(R.id.goBackBtn);
        goBackBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }
        }); // End code for Go Back Btn

        // Health Btn
        Button healthBtn = (Button) findViewById(R.id.healthBtn);
        healthBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent startIntent2 = new Intent(getApplicationContext(), HealthPage.class);
                startActivity(startIntent2);
            }
        });

       // Food Btn
        Button foodBtn = (Button) findViewById(R.id.foodBtn);
        foodBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent startIntent = new Intent(getApplicationContext(), FoodPage.class);
                startActivity(startIntent);
            }
        });

        // Bus Btn
        Button busBtn = (Button) findViewById(R.id.busBtn);
        busBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent startIntent = new Intent(getApplicationContext(), BusPage.class);
                startActivity(startIntent);
            }
        });

        // restroom Btn
        Button restroomBtn = (Button) findViewById(R.id.restroomBtn);
        restroomBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent startIntent = new Intent(getApplicationContext(), RestroomPage.class);
                startActivity(startIntent);
            }
        }); // end restroom Btn

    }
}