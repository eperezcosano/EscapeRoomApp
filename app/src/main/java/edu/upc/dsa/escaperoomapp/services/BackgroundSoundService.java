package edu.upc.dsa.escaperoomapp.services;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;

import edu.upc.dsa.escaperoomapp.R;

public class BackgroundSoundService extends Service {

    private MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //getting systems default ringtone
        player = MediaPlayer.create(this, R.raw.background);
        //setting loop play to true
        //this will make the ringtone continuously playing
        player.setLooping(true);
        player.setVolume(100,100);
        //staring the player
        player.start();

        //we have some options for service
        //start sticky means service will be explicity started and stopped
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        //stopping the player when service is destroyed
        if (player != null) player.stop();
    }
}