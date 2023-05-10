package com.example.novella;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class Glava1_3 extends AppCompatActivity {

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
        setContentView(R.layout.activity_glava1_3);

        text = findViewById(R.id.text);
        name = findViewById(R.id.name);
        pers1 = findViewById(R.id.personaj1);
        pers2 = findViewById(R.id.personaj2);

        imageButton = findViewById(R.id.imageButton);

        dialogPers1 = new ArrayList<Integer>();
        dialogPers1.add(R.drawable.angry_raychel_school);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(R.drawable.angry_jastin_school);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(R.drawable.smile_jastin_school);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(R.drawable.sad_rayan_school);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(R.drawable.angry_jastin_school);
        dialogPers1.add(0);
        dialogPers1.add(0);

        dialogPers2 = new ArrayList<Integer>();
        dialogPers2.add(0);
        dialogPers2.add(R.drawable.sad_gg_school);
        dialogPers2.add(R.drawable.angry_gg_school);
        dialogPers2.add(R.drawable.sad_gg_school);
        dialogPers2.add(R.drawable.normal_gg_school);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(R.drawable.angry_gg_school);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(R.drawable.normal_gg_school);
        dialogPers2.add(R.drawable.normal_gg_school);
        dialogPers2.add(R.drawable.angry_gg_school);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(R.drawable.sad_gg_school);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(R.drawable.fun_gg_school);
        dialogPers2.add(R.drawable.fun_gg_school);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(R.drawable.think_gg_school);
        dialogPers2.add(R.drawable.think_gg_school);
        dialogPers2.add(R.drawable.think_gg_school);
        dialogPers2.add(R.drawable.think_gg_school);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);

        dialogName = new ArrayList<String>();
        dialogName.add("Рейчел");
        dialogName.add("Я");
        dialogName.add("Я");
        dialogName.add("Я");
        dialogName.add("Я");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("Я");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("Джастин");
        dialogName.add("Я");
        dialogName.add("Я");
        dialogName.add("Я");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("Я");
        dialogName.add("Джастин");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("Райан");
        dialogName.add("Я");
        dialogName.add("Я");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("Я");
        dialogName.add("Я");
        dialogName.add("Я");
        dialogName.add("Я");
        dialogName.add("Джастин");
        dialogName.add("");
        dialogName.add("");

        // Dummy questions
        dialogList = new ArrayList<String>();
        dialogList.add("Джуди!");
        dialogList.add("*слышу голос своей подруги, и что-то в нём определённо не так. Что-то, что мне не нравится.  *");
        dialogList.add("Я ведь просила меня так не называть!");
        dialogList.add("*С самого детства мне не нравилась полная форма моего имени и я предпочитала краткое «Джуд».*");
        dialogList.add("*Но, похоже, остальные считают иначе и продолжают звать меня, как раньше. *");
        dialogList.add("*Посмотрев на неё, замечаю, как она внимательно смотрит за мою спину.*");
        dialogList.add("*Слышу, как хлопает дверь, по телу проходит резкий холодок, что не очень свойственно для весны. *");
        dialogList.add("Только не говори, что они за моей спиной ");
        dialogList.add("*Слышу, как шаги приближаются, и уже готовлюсь дать отпор. *");
        dialogList.add("*Смотрю на Рэйчел, чтобы ещё раз высказать всё своё негодование, *");
        dialogList.add("*Hо не успеваю ничего сказать, как кто-то грубо пихает меня в плечо. *");
        dialogList.add("В сторону, отбросы");
        dialogList.add("*Слышу я, от чего моё желание врезать этому человеку возрастает в несколько раз. *");
        dialogList.add("*Мне даже гадать не нужно, чтобы сказать, кто это был.*");
        dialogList.add("Джастин...");
        dialogList.add("*Передо мной стоит компания что-то возомнивших из себя людей. *");
        dialogList.add("*А во главе человек, который меня и пихнул, Джастин Коллинс.*");
        dialogList.add("*Два года назад этот человек был моим лучшим другом, поверить не могу. *");
        dialogList.add("Ты что-то сказала или это дверь скрипнула?");
        dialogList.add("*Его глупая шутка, конечно же, вызывает смех у его дружков и подружек, почти у всех.*");
        dialogList.add("* Его лучший друг Райан Скотт, кажется, просто безэмоционально стоит рядом. Похоже, происходящее его вообще не волнует. *");
        dialogList.add("");
        dialogList.add("Называешь меня отбросом? Серьёзно? Как-то неинтересно, стареешь, Коллинс!");
        dialogList.add("Придумай что-нибудь получше, тебе ведь нужно поддерживать статус мерзавца школы.");
        dialogList.add("*спокойно и уверенно заключаю я, наблюдая за тем, как он старается оставаться спокойным снаружи и как бесится внутри.*");
        dialogList.add("*Мне нравится видеть, как он злиться и раздражается. Уж слишком я хорошо его знаю.*");
        dialogList.add("*Он только делает вид, будто бы мои слова его никак не тронули.*");
        dialogList.add("*Но если взглянуть в эти зелёные глаза, можно увидеть самый сильный пожар, что горит изнутри.*");
        dialogList.add("*Он только делает вид, будто бы мои слова его никак не тронули.*");
        dialogList.add("*Не то, чтобы я люблю его бесить, хотя отрицать не буду, иногда мне этого хочется.*");
        dialogList.add("*Он сам выбрал это общение, сам начал относиться ко мне так, словно я никто. После того, что мы пережили вместе. *");
        dialogList.add("*Слишком много эмоций заставляет меня испытывать человек, которого я бы предпочла забыть.* ");
        dialogList.add("*Но это уже как наркотик, невозможно остановиться. И он сам это знает, наверное. *");
        dialogList.add("Не нарывайся, Бэйкер!");
        dialogList.add("*А ещё я ненавижу, когда меня зовут по фамилии, и этот засранец прекрасно об этом знает. *");
        dialogList.add("*Меня успокаивает только тот факт, что мне вновь удалось взбесить его. Пускай он чувствует ко мне ненависть и отвращение, пусть он хотя бы что-то чувствует. *");




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


        loadGameData();
    }

    private void loadGameData() {
        SharedPreferences sharedPreferences = getSharedPreferences("GameSave", Context.MODE_PRIVATE);

        // Загрузка сохраненных данных
        int savedDialogPosition = sharedPreferences.getInt("dialogPosition", 0);

        // Другие данные, которые требуется загрузить

        // Продолжение с последнего сохранения
        Dialog = savedDialogPosition;
        showQuestion();
    }



    public void showQuestion() {

        if (Dialog < dialogList.size()) {
            text.setText(dialogList.get(Dialog));
            name.setText(dialogName.get(Dialog));
            pers1.setImageResource(dialogPers1.get(Dialog));
            pers2.setImageResource(dialogPers2.get(Dialog));
        } else {
            Intent gl1_4 = new Intent(this, Glava1_4.class);
            gl1_4.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(gl1_4);
        }
    }
    public void back(View view) {
        Intent gl1_5 = new Intent(this, MainActivity.class);
        startActivity(gl1_5);
    }
}