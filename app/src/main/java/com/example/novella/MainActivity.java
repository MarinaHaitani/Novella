package com.example.novella;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
//Объявление переменных
    Button buttonChoice;
    Button Nachat;
    public static Currency currency;
    private TextView currencyTextView;
    private SharedPreferences sharedPrefs;
    private TextView ticketCountText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        // Получаем объект SharedPreferences
        sharedPrefs = getSharedPreferences("myPrefs", MODE_PRIVATE);
        // Используем сохраненное значение валюты, если оно есть
        int savedCurrency = sharedPrefs.getInt("currency", 100);
        currency = new Currency(savedCurrency);
        currencyTextView = findViewById(R.id.coinsText);
        currencyTextView.setText("" + currency.getValue());
        buttonChoice = (Button) findViewById(R.id.buttonChoice);
        Nachat = (Button) findViewById(R.id.buttonStart);
        //Сбрасываем прогресс и начинаем игру с начала
        Nachat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetProgress();
            }
        });
        ticketCountText = findViewById(R.id.teaText);
        updateTicketStatus(); // Обновляем состояние чая при создании активности
        //Запускаем музыку для главного меню
        Intent serviceIntent = new Intent(this, BackgroundMusicService.class);
        startService(serviceIntent);
        //Останавливаем музыку для глав
        Intent sIntent = new Intent(this, GlavaMusicService.class);
        stopService(sIntent);
    }
    //Продолжаем игру
    public void continueGame(View view) {
        Intent intent = new Intent(this, Glava_1.class);
        startActivity(intent);
    }
    //Переходим к выбору глав
    public void ViborGlavi(View view) {
        Intent VG = new Intent(this, ViborGlavi.class);
        startActivity(VG);
    }
    //Переходим к настройкам приложения
    public void settings(View view) {
        Intent gl1_5 = new Intent(MainActivity.this, Settings.class);
        startActivity(gl1_5);
    }
    //Переходим к просмотру рекламы
    public void ad(View view) {
        Intent ad = new Intent(this, Ad.class);
        startActivity(ad);
        if (currency.getValue() >= 0) {
            currency.add(5);
            currencyTextView.setText("" + currency.getValue());
            // Сохраняем значение валюты в SharedPreferences
            SharedPreferences.Editor editor = sharedPrefs.edit();
            editor.putInt("currency", currency.getValue());
            editor.apply();
            // выполнение действий при нажатии на кнопку 1
        }
    }
    private void resetProgress() {
        // Очищаем сохраненное значение последней главы
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.remove("currentDialog");
        editor.apply();
        // Другие действия для сброса прогресса, если необходимо
        // Запускаем первую главу
        Intent intent = new Intent(this, Glava_1.class);
        startActivity(intent);
    }
    public void updateTicketStatus() {
        int ticketCount = TeaManager.getTicketCount();
        ticketCountText.setText(String.valueOf(ticketCount)); // Обновляем текстовое поле с количеством билетов
        long timeSinceLastTicket = System.currentTimeMillis() - TeaManager.getLastTicketTime();
        long remainingTime = TeaManager.getTicketRestoreInterval() - timeSinceLastTicket;
        if (ticketCount > 0) {
            ticketCountText.setEnabled(true); // Если есть билеты, делаем кнопку активной
        } else {
            ticketCountText.setEnabled(false); // Если нет билетов, делаем кнопку неактивной
            ticketCountText.setText("" + remainingTime / 1000); // Отображаем время до восстановления билета
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        TeaManager.restoreTickets(); // Восстанавливаем билеты при возобновлении активности
        updateTicketStatus(); // Обновляем состояние билетов
    }
}