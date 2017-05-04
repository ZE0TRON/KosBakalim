package com.kosutakimi.kosbakalim;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void quake(View v){
        Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vib.vibrate(400);
    }

    public void gotoClassicMode(View v){
        Intent intent = new Intent(this, classicMode.class);
        startActivity(intent);
    }

    public void salla(View v){
        MediaPlayer mp=MediaPlayer.create(this,R.raw.cikicikibaba);
        mp.start();
    }

}
