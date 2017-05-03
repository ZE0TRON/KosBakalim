package com.kosutakimi.kosbakalim;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //kendi xml lime yöndendirme bulamadım şimdlik bunlar kalsın burda
    public void quake(View v){
        Vibrator vib = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        vib.vibrate(400);
    }

    public void salla(View v){
        MediaPlayer mp=MediaPlayer.create(this,R.raw.cikicikibaba);
        mp.start();
    }
}
