package com.vyakunin.brightcoveimpl;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.brightcove.player.view.BaseVideoView;

public class MainActivity extends AppCompatActivity {

    private BaseVideoView baseVideoView;
    private View videoParent;
    private boolean fullscreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoParent = findViewById(R.id.video_player_container);
        baseVideoView = (BaseVideoView) findViewById(R.id.brightcove_player);
        baseVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                baseVideoView.start();
                Toast.makeText(MainActivity.this, "Prepared", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.full_screen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                toggleFullscreen();
            }
        });
        baseVideoView.setVideoPath("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4");
    }

    private void toggleFullscreen() {
        //here you should lock the screen orientation and simulate fullscreen playback in landscape
        fullscreen = !fullscreen;
        if (fullscreen) {
            videoParent.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
            videoParent.setRotation(90);
        } else {
            videoParent.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            videoParent.setRotation(0);
        }


    }
}
