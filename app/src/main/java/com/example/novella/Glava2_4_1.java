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

public class Glava2_4_1 extends AppCompatActivity {

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
        setContentView(R.layout.activity_glava2_4_1);

        text = findViewById(R.id.text);
        name = findViewById(R.id.name);
        pers1 = findViewById(R.id.personaj1);
        pers2 = findViewById(R.id.personaj2);

        imageButton = findViewById(R.id.imageButton);

        dialogPers1 = new ArrayList<Integer>();
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(R.drawable.smile_raychel);
        dialogPers1.add(R.drawable.funny_raychel);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(R.drawable.boring_raychel);
        dialogPers1.add(0);
        dialogPers1.add(0);


        dialogPers2 = new ArrayList<Integer>();
        dialogPers2.add(R.drawable.normal_gg_school);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(R.drawable.speek_gg_school);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(R.drawable.smile_gg);

        dialogName = new ArrayList<String>();

        dialogName.add("Я");
        dialogName.add("");
        dialogName.add("Рейчел");
        dialogName.add("Рейчел");
        dialogName.add("");
        dialogName.add("Я");
        dialogName.add("");
        dialogName.add("Рейчел");
        dialogName.add("");
        dialogName.add("Я");

        // Dummy questions
        dialogList = new ArrayList<String>();
        dialogList.add("Ладно, хорошо, допустим ты меня уговорила, я пойду.");
        dialogList.add("*Настроение подруги мгновенно меняется и она чуть ли не хлопает в ладоши от счастья. *");
        dialogList.add("Я так рада, что не пришлось тебя долго уговаривать!");
        dialogList.add("Тебе нужно подобрать что-нибудь сногсшибательное, — задумчиво бормочет она, оказавшись перед моим шкафом.");
        dialogList.add("*Рэйчел была далеко не перфекционисткой, но когда дело касалось внешнего вида — то всё должно быть идеальным. *");
        dialogList.add("Вот только не надо меня наряжать, не хочу выделяться, хочу просто смешаться с толпой и отдохнуть.");
        dialogList.add("*Но её согласное мычание меня совсем не успокаивает. Хотелось бы испариться и оказаться где-нибудь в другом месте. Где никто не будет донимать меня своими вечеринками*");
        dialogList.add("Не истери, я не позволю тебе ходить в одном и том же. Вот, вот это очень даже не плохою Давай одевайся и поедем, буду ждать тебя на улице.");
        dialogList.add("*Наверное, делать ей очередное замечание по поводу моего имени бесполезно. Поэтому, для собственной же безопасности, я промолчала.*");
        dialogList.add("*Хм, а это и в правду неплохо выглядит. Ладно, пора выходить, а то Рейч заждалась уже.*");
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