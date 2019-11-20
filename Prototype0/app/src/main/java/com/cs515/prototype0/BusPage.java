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

public class BusPage extends AppCompatActivity {

    private SoundPool soundPool;
    private int travelSound1, travelSound2, travelSound3, travelSound4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bus_page);

        // Go Back Button Code
        Button goBackTravelBtn = (Button) findViewById(R.id.goBackTravelBtn);
        goBackTravelBtn.setOnClickListener(new View.OnClickListener() {

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
        travelSound1 = soundPool.load(this, R.raw.donde_el_hospital, 1);
        travelSound2 = soundPool.load(this, R.raw.weneeddoctor, 1);
        travelSound3 = soundPool.load(this, R.raw.wehadaccident, 1);
        travelSound4 = soundPool.load(this, R.raw.ithurts, 1);


    }

    public void playSound(View v) {
        switch (v.getId()) {
            case R.id.travelBtn1:
                soundPool.play(travelSound1, 1, 1, 0, 0, 1);
                break;
            case R.id.travelBtn2:
                soundPool.play(travelSound2, 1, 1, 0, 0, 1);
                break;
            case R.id.travelBtn3:
                soundPool.play(travelSound3, 1, 1, 0, 0, 1);
                break;
            case R.id.travelBtn4:
                soundPool.play(travelSound4, 1, 1, 0, 0, 1);
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
