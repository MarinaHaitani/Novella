package com.example.novella;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

public class Glava2_6 extends AppCompatActivity {

    private TextView currencyTextView;
    private Currency currency;
    private SharedPreferences sharedPrefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_glava2_6);

        // Получаем объект SharedPreferences
        sharedPrefs = getSharedPreferences("myPrefs", MODE_PRIVATE);

        // Используем сохраненное значение валюты, если оно есть
        int savedCurrency = sharedPrefs.getInt("currency", 100);
        currency = new Currency(savedCurrency);

        currencyTextView = findViewById(R.id.coins);
        currencyTextView.setText("" + currency.getValue());

    }
    public void chois1(View view) {
        Intent gl1_9 = new Intent(this, Glava2_6_1.class);
        gl1_9.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(gl1_9);
        Toast toast = Toast.makeText(this, "Ты узнала кое-что интересное", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 160);
        toast.show();

        if (currency.getValue() >= 15) {
            currency.subtract(15);
            currencyTextView.setText("" + currency.getValue());

            // Сохраняем значение валюты в SharedPreferences
            SharedPreferences.Editor editor = sharedPrefs.edit();
            editor.putInt("currency", currency.getValue());
            editor.apply();

            // выполнение действий при нажатии на кнопку 1
        } else {
            Toast.makeText(this, "Недостаточно монет для покупки!", Toast.LENGTH_SHORT).show();
        }
    }
    public void chois2(View view) {
        Intent gl1_9 = new Intent(this, Glava2_6_2.class);
        gl1_9.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(gl1_9);
    }

    public void back(View view) {
        Intent gl1_5 = new Intent(this, MainActivity.class);
        startActivity(gl1_5);
    }
}