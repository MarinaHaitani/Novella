package com.example.novella;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Glava1_4_2 extends AppCompatActivity {
    TextView text;
    TextView name;
    ImageView pers1;
    ImageView pers2;
    ImageButton imageButton;
    ArrayList<String> dialogList;
    ArrayList<String> dialogName;
    ArrayList<Integer> dialogPers1;
    ArrayList<Integer> dialogPers2;
    int Dialog = 0;

    private int chapter = 1;
    private int classIndex = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_glava1_4_2);

        text = findViewById(R.id.text);
        name = findViewById(R.id.name);
        pers1 = findViewById(R.id.personaj1);
        pers2 = findViewById(R.id.personaj2);

        imageButton = findViewById(R.id.imageButton);

        dialogPers1 = new ArrayList<Integer>();
        dialogPers1.add(0);
        dialogPers1.add(R.drawable.smile_jastin_school);
        dialogPers1.add(0);

        dialogPers2 = new ArrayList<Integer>();
        dialogPers2.add(R.drawable.sad_gg_school);
        dialogPers2.add(0);
        dialogPers2.add(R.drawable.angry_gg_school);


        dialogName = new ArrayList<String>();
        dialogName.add("Я");
        dialogName.add("Джастин");
        dialogName.add("Я");

        // Dummy questions
        dialogList = new ArrayList<String>();
        dialogList.add("*Лучше не буду отвечать, чтобы не привлекать лишнего внимания.*");
        dialogList.add("Ого! Неужели снег пойдёт - Бейкер решила промолчать... Сдаёшь позиции!");
        dialogList.add("*Мерзаец!*");
        showQuestion();

        imageButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Dialog++;
                showQuestion();
            }
        });

        Intent serviceIntent = new Intent(this, GlavaMusicService.class);
        startService(serviceIntent);

        Intent sIntent = new Intent(this, BackgroundMusicService.class);
        stopService(sIntent);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        SharedPreferences sharedPreferences = getSharedPreferences("GameProgress", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("chapter", chapter);
        editor.putInt("classIndex", classIndex);
        editor.apply();
    }

    public void showQuestion() {

        if (Dialog < dialogList.size()) {
            text.setText(dialogList.get(Dialog));
            name.setText(dialogName.get(Dialog));
            pers1.setImageResource(dialogPers1.get(Dialog));
            pers2.setImageResource(dialogPers2.get(Dialog));
        } else {
            Intent gl1_4 = new Intent(this, Glava1_5.class);
            gl1_4.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(gl1_4);
        }
    }
    public void back(View view) {
        Intent gl1_5 = new Intent(this, MainActivity.class);
        startActivity(gl1_5);
    }
}