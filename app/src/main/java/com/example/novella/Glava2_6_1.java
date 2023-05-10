package com.example.novella;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Glava2_6_1 extends AppCompatActivity {

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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_glava2_6_1);

        text = findViewById(R.id.text);
        name = findViewById(R.id.name);
        pers1 = findViewById(R.id.personaj1);
        pers2 = findViewById(R.id.personaj2);

        imageButton = findViewById(R.id.imageButton);

        dialogPers1 = new ArrayList<Integer>();
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(R.drawable.smile_raychel);
        dialogPers1.add(0);
        dialogPers1.add(R.drawable.funny_raychel);
        dialogPers1.add(0);

        dialogPers2 = new ArrayList<Integer>();
        dialogPers2.add(R.drawable.suprise_gg);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(R.drawable.think_gg);


        dialogName = new ArrayList<String>();
        dialogName.add("Я");
        dialogName.add("");
        dialogName.add("Рейчел");
        dialogName.add("");
        dialogName.add("Рейчел");
        dialogName.add("Я");


        // Dummy questions
        dialogList = new ArrayList<String>();
        dialogList.add("А ты откуда знаешь где он будет пропадать сегодня вечером? ");
        dialogList.add("*Я реально, даже представить не могу, откуда у неё такая точная информация.*");
        dialogList.add("У меня свои источники.");
        dialogList.add("*Я продолжаю смотреть на неё пытливым взглядом, слегка нервничая. А она, похоже, это замечает и звонко смеётся. А мне, что-то, не очень смешно.*");
        dialogList.add("Да всё, всё. Успокойся. Знакомые сказали. А какие именно знакомые, ты узнаешь чуть позже.");
        dialogList.add("*Ладно, её ответ меня вполне устроил. Ну, почти.*");
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

    public void showQuestion() {

        if (Dialog < dialogList.size()) {
            text.setText(dialogList.get(Dialog));
            name.setText(dialogName.get(Dialog));
            pers1.setImageResource(dialogPers1.get(Dialog));
            pers2.setImageResource(dialogPers2.get(Dialog));
        } else {
            Intent gl1_4 = new Intent(this, Glava2_7.class);
            gl1_4.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(gl1_4);
        }
    }
    public void back(View view) {
        Intent gl1_5 = new Intent(this, MainActivity.class);
        startActivity(gl1_5);
    }
}