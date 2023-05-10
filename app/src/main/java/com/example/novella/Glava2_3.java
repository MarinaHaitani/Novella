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

public class Glava2_3 extends AppCompatActivity {

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
        setContentView(R.layout.activity_glava2_3);

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
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);

        dialogPers2 = new ArrayList<Integer>();
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(R.drawable.sad_gg_school);
        dialogPers2.add(0);
        dialogPers2.add(0);


        dialogName = new ArrayList<String>();
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("Я");
        dialogName.add("");
        dialogName.add("");


        // Dummy questions
        dialogList = new ArrayList<String>();
        dialogList.add("*Не любить школу и при этом быть отличницей, это про неё. *");
        dialogList.add("*Рэйчел захлопывает свою палетку с тенями, и кидает её ко мне на кровать. Улыбается своему отражению, поправляя волосы. *");
        dialogList.add("*Она была красавицей. Стройная и спортивная фигура, загорелая кожа, которая каждый месяц проходила множество процедур. *");
        dialogList.add("*Рэйчел тщательно следила за своей внешностью и не напрасно. Красивые карие глаза, густые каштановые волосы, блестящие на солнце. *");
        dialogList.add("*Она была очень привлекательной и нравилась почти всем. Но каким-то образом, оставалась без отношений. *");
        dialogList.add("*Нет, они у неё были и даже серьёзные. Но тот мерзкий тип бросил её, как только какая-то девушка бросилась ему на шею, стоило ему ей улыбнуться. *");
        dialogList.add("*Благо Рэйчел говорила о том, что просто была к нему привязана и ей не особо больно. Но было видно, что неприятный осадок остался. *");
        dialogList.add("*Я тогда чуть ли не сломала ему нос. Мне было обидно за подругу, и я хотела её как-то защитить, но как оказалось, она и сама смогла за себя постоять. *");
        dialogList.add("*В какой-то день она рассказала почти всей школе, один его секрет. После этого, ещё где-то пару месяцев, над ним жёстко подшучивали и смеялись. *");
        dialogList.add("*А он с этого жутко бесился, потому что никак не мог ответить. И после этой ситуации, подруга, просто отшивала каждого, кому бы она не нравилась. А в последние месяцы, даже в их сторону не смотрела. *\n");
        dialogList.add("Именно это, я и собиралась делать. Отдыхать от школы лёжа в своей кровати");
        dialogList.add("*в очередной раз высказываю ей своё нежелание идти на эту вечеринку. *");
        dialogList.add("*Рэйчел медленно поворачивается ко мне и недовольно складывает руки у себя на груди. Молча и пристально смотрит на меня.*");

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
            Intent gl1_4 = new Intent(this, Glava2_4.class);
            gl1_4.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(gl1_4);
        }
    }
    public void back(View view) {
        Intent gl1_5 = new Intent(this, MainActivity.class);
        startActivity(gl1_5);
    }
}