package com.kosutakimi.kosbakalim;

import com.kosutakimi.kosbakalim.Sensors.StepCounter;
import com.kosutakimi.kosbakalim.login.login;
import com.kosutakimi.kosbakalim.signup.signup;
import com.kosutakimi.kosbakalim.splashscreen.splashscreen;

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

    public void gotologin(View v){
        Intent intent = new Intent(this, login.class);
        startActivity(intent);
    }
    public void gotosignup(View v){
        Intent intent = new Intent(this, signup.class);
        startActivity(intent);
    }
    public void gotosplash(View v){
        Intent intent = new Intent(this, splashscreen.class);
        startActivity(intent);
    }
    float stem = StepCounter.getSteps();



    /*public void salla(View v){


        MediaPlayer mp=MediaPlayer.create(this,R.raw.cikicikibaba);
        mp.start();
    }
    */

}
