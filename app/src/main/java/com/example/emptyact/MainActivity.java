package com.example.emptyact;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
FloatingActionButton fab; boolean play=false;
SeekBar seek; Button btn; MediaPlayer mp;
private final Handler mHandler=new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        btn=findViewById(R.id.button);
        fab=findViewById(R.id.floatingActionButton);
        seek=findViewById(R.id.seekBar);

         mp=MediaPlayer.create(this,R.raw.audio);
       seek.setMax(mp.getDuration());

//start
        fab.setOnClickListener(new View.OnClickListener() {
                                   @Override
                                   public void onClick(View v) {
                                       if (mp.isPlaying()) {

                                           mp.pause();
                                       } else {
                                           mp.start();
                                       }
                                   }
                               });

        //seekbar
/*new Timer().scheduleAtFixedRate(new TimerTask() {
    @Override
    public void run() {
        seek.setProgress(mp.getCurrentPosition());
    }
}, 0, 900);*/
        mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                // Update SeekBar position
                updateSeekBar();
            }
        });

seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        mp.seekTo(progress);
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {

    }
});


    //intent
btn.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        Intent intt=new Intent(MainActivity.this,SecondActivity.class);
        startActivity(intt);
    }
});


    }

    private void updateSeekBar() {
        seek.setProgress(mp.getCurrentPosition());
        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                updateSeekBar();
            }
        },200000);  // Update every second
    }
}