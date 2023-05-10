package com.example.novella;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;
public class Settings extends AppCompatActivity {
    //объявляем переменные
SeekBar seekBar;
TextView value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_settings);
        //регулировка громкости
        seekBar=findViewById(R.id.volume_seekbar);
        value=findViewById(R.id.progress);
        // calling the seekbar event change listener
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            // increment or decrement on process changed
            // increase the textsize
            // with the value of progress
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                value.setText(progress+"/"+"15");
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                // This method will automatically
                // called when the user touches the SeekBar
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                // This method will automatically
                // called when the user
                // stops touching the SeekBar
            }
        });
        // Initialize the SeekBar in your Activity or Fragment:
        SeekBar seekBar = (SeekBar) findViewById(R.id.volume_seekbar);
        // Get the audio manager
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        // Set the maximum volume of the SeekBar to the maximum volume of the MediaPlayer:
        int maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        seekBar.setMax(maxVolume);
        // Set the current volume of the SeekBar to the current volume of the MediaPlayer:
        int currVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        seekBar.setProgress(currVolume);
        // Add a SeekBar.OnSeekBarChangeListener to the SeekBar:
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                audioManager.setStreamVolume(AudioManager.STREAM_MUSIC,i,0);
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });
    }
    public void back(View view) {
        Intent gl1_5 = new Intent(Settings.this, MainActivity.class);
        startActivity(gl1_5);
    }
}