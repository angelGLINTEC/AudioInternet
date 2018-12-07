package com.glintec.app.audioclou;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements MediaPlayer.OnPreparedListener{

    private Button btnCloud;
    private MediaPlayer mp;
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCloud = findViewById(R.id.btdAudio);
        btnCloud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reproducirAudioWeb();
            }
        });
    }

    public void reproducirAudioWeb(){
        try {
            mp= new MediaPlayer();
            mp.setOnPreparedListener(this);
            mp.setDataSource("http://frogames.es/course-contents/palma-activa-introduccion-android/song_1.mp3");
            mp.prepareAsync();
            Log.d(TAG, "reproducirAudioWeb: He hecho llamada Asic");
//            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onPrepared(MediaPlayer mp) {
        mp.start();
        Log.d(TAG, "onPrepared: Preparado para reproducir");
    }
}
