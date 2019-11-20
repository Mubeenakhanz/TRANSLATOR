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

public class FoodPage extends AppCompatActivity {

    private SoundPool soundPool;
    private int foodSound1, foodSound2, foodSound3, foodSound4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_page);

        // Go Back Button Code
        Button goBackFoodBtn = (Button) findViewById(R.id.goBackFoodBtn);
        goBackFoodBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent startIntent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(startIntent);
            }
        }); // End code for Go Back Btn

        // SoundPool code
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes audioAttributes = new AudioAttributes.Builder().setUsage(AudioAttributes.USAGE_ASSISTANCE_SONIFICATION).build();
            soundPool = new SoundPool.Builder().setMaxStreams(6).setAudioAttributes(audioAttributes).build();
        } else {
            soundPool = new SoundPool(6, AudioManager.STREAM_MUSIC, 0);
        }
        foodSound1 = soundPool.load(this, R.raw.donde_el_hospital, 1);
        foodSound2 = soundPool.load(this, R.raw.weneeddoctor, 1); // change here later
        foodSound3 = soundPool.load(this, R.raw.wehadaccident, 1);
        foodSound4 = soundPool.load(this, R.raw.ithurts, 1);

    }

    public void playSound(View v) {
        switch (v.getId()) {
            case R.id.foodBtn1:
                soundPool.play(foodSound1, 1, 1, 0, 0, 1);
                break;
            case R.id.foodBtn2:
                soundPool.play(foodSound2, 1, 1, 0, 0, 1);
                break;
            case R.id.foodBtn3:
                soundPool.play(foodSound3, 1, 1, 0, 0, 1);
                break;
            case R.id.foodBtn4:
                soundPool.play(foodSound4, 1, 1, 0, 0, 1);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    } //end SoundPool Code




}
