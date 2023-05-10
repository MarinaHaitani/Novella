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

public class Glava_2 extends AppCompatActivity {

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
        setContentView(R.layout.activity_glava2);

        text = findViewById(R.id.text);
        name = findViewById(R.id.name);
        pers1 = findViewById(R.id.personaj1);
        pers2 = findViewById(R.id.personaj2);

        imageButton = findViewById(R.id.imageButton);

        dialogPers1 = new ArrayList<Integer>();
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(R.drawable.smile_raychel);
        dialogPers1.add(0);
        dialogPers1.add(0);

        dialogPers2 = new ArrayList<Integer>();
        dialogPers2.add(R.drawable.suprise_gg_school);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(R.drawable.sad_gg_school);
        dialogPers2.add(R.drawable.sad_gg_school);


        dialogName = new ArrayList<String>();
        dialogName.add("Я");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("Рейчел");
        dialogName.add("Я");
        dialogName.add("Я");


        // Dummy questions
        dialogList = new ArrayList<String>();
        dialogList.add("Ты уверена в том, что мне нужно туда пойти?");
        dialogList.add("*Уже в десятый раз спрашиваю я Рэйчел, сидя на своей кровати. *");
        dialogList.add("*С самого утра, в субботу, ко мне приехала подруга, и была настроена уйти отсюда только со мной.*");
        dialogList.add("*Иногда меня пугает её безумное желание вытащить меня из дома. *");
        dialogList.add("Давай-ка подумаем вместе. Когда ты последний раз отрывалась на вечеринках?");
        dialogList.add("*А ведь и правда. Когда? Не то чтобы я не любила все эти вечеринки. Хотя и тусовщицей меня назвать тоже нельзя. *");
        dialogList.add("*Просто, я как-то совсем позабыла, что такое отдыхать, выпивать, да и просто веселиться. *");

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
            Intent gl1_4 = new Intent(this, Glava2_2.class);
            gl1_4.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(gl1_4);
        }
    }
    public void back(View view) {
        Intent gl1_5 = new Intent(this, MainActivity.class);
        startActivity(gl1_5);
    }
}