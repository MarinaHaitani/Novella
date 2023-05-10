package com.example.novella;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.Html;
import android.util.TypedValue;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class ViborGlavi extends AppCompatActivity {
    Button Glava1;
    Button Glava2;
    Button continueButton;
    private Button[] Glava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_vibor_glavi);
        Glava1 = (Button) findViewById(R.id.glava1);
        Glava2 = (Button) findViewById(R.id.glava2);
        Glava = new Button[15];
        Glava[0] = findViewById(R.id.glava3);
        Glava[1] = findViewById(R.id.glava4);
        Glava[2] = findViewById(R.id.glava5);
        Glava[3] = findViewById(R.id.glava6);
        Glava[4] = findViewById(R.id.glava7);
        Glava[5] = findViewById(R.id.glava8);
        Glava[6] = findViewById(R.id.glava9);
        Glava[7] = findViewById(R.id.glava10);
        Glava[8] = findViewById(R.id.glava11);
        Glava[9] = findViewById(R.id.glava12);
        Glava[10] = findViewById(R.id.glava13);
        Glava[11] = findViewById(R.id.glava14);
        Glava[12] = findViewById(R.id.glava15);
        Glava[13] = findViewById(R.id.glava16);
        Glava[14] = findViewById(R.id.glava17);

        // Создаем обработчик кликов для каждой кнопки в цикле
        for (int i = 0; i < Glava.length; i++) {
            final int index = i;
            Glava[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    showInProgressDialog();
                }
            });
        }

        Glava1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeaManager.useTicket(); // Списываем билет
                // Другие действия, связанные с нажатием на кнопку
                Glava1();
            }
        });
        Glava2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TeaManager.useTicket();
                Glava2();
            }
        });

    }
    private void showInProgressDialog() {
        @SuppressLint("ResourceType") AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.DialogStyle);
        builder.setTitle("Скоро...")
                .setMessage("Разработка главы в процессе")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        // Изменение шрифта
        Typeface typeface = Typeface.create("sans-serif-condensed", Typeface.BOLD);
        builder.setTitle(Html.fromHtml("<font face='shrift'>Скоро...</font>"));
        builder.setMessage(Html.fromHtml("<font face='shrift'>Разработка главы в процессе</font>"));

        // Изменение цвета кнопки
        builder.setPositiveButton(Html.fromHtml("<font color='#000000'>OK</font>"), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

        Window window = dialog.getWindow();
        if (window != null) {
            WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
            layoutParams.copyFrom(window.getAttributes());

            int width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 350, getResources().getDisplayMetrics());
            int height = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 150, getResources().getDisplayMetrics());

            layoutParams.width = width;
            layoutParams.height = height;

            window.setAttributes(layoutParams);
        }
    }
    public void Glava1(){
        Intent VG = new Intent(this, Glava_1.class);
        startActivity(VG);
    }
    public void Glava2(){
        Intent VG = new Intent(this, Glava_2.class);
        startActivity(VG);
    }


}