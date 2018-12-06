package com.glintec.app.audioclou;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private Button btnCloud;
    private MediaPlayer mp;
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
            mp.setDataSource("http://frogames.es/course-contents/palma-activa-introduccion-android/song_1.mp3");
            mp.prepare();
            mp.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
