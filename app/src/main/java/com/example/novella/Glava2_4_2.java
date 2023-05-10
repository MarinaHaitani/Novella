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

public class Glava2_4_2 extends AppCompatActivity {


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
        setContentView(R.layout.activity_glava2_4_2);

        text = findViewById(R.id.text);
        name = findViewById(R.id.name);
        pers1 = findViewById(R.id.personaj1);
        pers2 = findViewById(R.id.personaj2);

        imageButton = findViewById(R.id.imageButton);

        dialogPers1 = new ArrayList<Integer>();
        dialogPers1.add(0);
        dialogPers1.add(R.drawable.angry_raychel);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(R.drawable.angry_raychel);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(R.drawable.angry_raychel);

        dialogPers2 = new ArrayList<Integer>();
        dialogPers2.add(R.drawable.sad_gg_school);
        dialogPers2.add(0);
        dialogPers2.add(R.drawable.ablush_gg_school);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(R.drawable.normal_gg_school);
        dialogPers2.add(R.drawable.think_gg_school);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);

        dialogName = new ArrayList<String>();
        dialogName.add("Я");
        dialogName.add("Рейчел");
        dialogName.add("Я");
        dialogName.add("");
        dialogName.add("Рейчел");
        dialogName.add("Я");
        dialogName.add("Я");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("Рейчел");

        // Dummy questions
        dialogList = new ArrayList<String>();
        dialogList.add("Прости...Но я никуда не пойду...");
        dialogList.add("Да что с тобой не так??? Либо ты идёшь, либо забудь о моём существовании!");
        dialogList.add("Ладно, я пойду, но только ради тебя.");
        dialogList.add("*Рейчел лишь холодно посмотрела на меня. Я знаю, через пару минут всё придёт в норму и она снова будет вести себя как прежде.*");
        dialogList.add("Я надеюсь ты не собираешься ехать в этом? Переоденься!");
        dialogList.add("Ладно, как скажешь.");
        dialogList.add("*Я решила согласиться с ней, чтобы не портить отношения. Не хотелось бы терять подругу из-за такого пустяка.*");
        dialogList.add("*После этого Рейчел вышла на улицу, оставив меня на едине с собой.*");
        dialogList.add("*Думаю не буду силно наряжаться, не хочется выделяться, хочется просто смешаться с толпой и отдохнуть.*");
        dialogList.add("*Я бстро накинула на себя то, что показалось мне более-менее приличнм, и выбежала из дома, чтобы не заставлять Рейчел ждать.*");
        dialogList.add("О, наконец-то ты вышла. Запрыгвай в машину, сейчас поедем!");
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
            Intent gl1_4 = new Intent(this, Glava2_5.class);
            gl1_4.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(gl1_4);
        }
    }
    public void back(View view) {
        Intent gl1_5 = new Intent(this, MainActivity.class);
        startActivity(gl1_5);
    }
}