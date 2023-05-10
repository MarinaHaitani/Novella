package com.example.novella;
import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
public class GlavaMusicService extends Service {
    private MediaPlayer mediaPlayer;
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        mediaPlayer = MediaPlayer.create(this, R.raw.glava_muzic);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        return START_STICKY;
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        mediaPlayer.stop();
        mediaPlayer.release();
    }
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
