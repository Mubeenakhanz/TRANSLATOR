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

public class HealthPage extends AppCompatActivity {

    private SoundPool soundPool;
    private int sound1;

    public void playSound(View v) {
        switch (v.getId()) {
            case R.id.sound1Btn:
                soundPool.play(sound1, 1, 1, 0, 0, 1);
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundPool.release();
        soundPool = null;
    } //end SoundPool Code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_page);

        // Go Back Button Code
        Button goBackBtn = (Button) findViewById(R.id.goBackBtn);
        goBackBtn.setOnClickListener(new View.OnClickListener() {

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
        sound1 = soundPool.load(this, R.raw.pacman_death, 1);
    }

} // end public class
