package com.example.novella;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import java.util.Timer;
import java.util.TimerTask;
public class Ad extends AppCompatActivity {
    //Объявляем переменные
Timer timer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_ad);
        //устанавливаем автоматическое закрытие рекламы через 15 секунд
        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Ad.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        },15000);
    }
    //закрываем рекламу
    public void closeAd(View view) {
        Intent intent = new Intent(Ad.this, MainActivity.class);
        startActivity(intent);
    }
}