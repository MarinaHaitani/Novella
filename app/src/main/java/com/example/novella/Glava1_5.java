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

public class Glava1_5 extends AppCompatActivity {

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
        setContentView(R.layout.activity_glava1_5);

        text = findViewById(R.id.text);
        name = findViewById(R.id.name);
        pers1 = findViewById(R.id.personaj1);
        pers2 = findViewById(R.id.personaj2);

        imageButton = findViewById(R.id.imageButton);

        dialogPers1 = new ArrayList<Integer>();
        dialogPers1.add(R.drawable.unhappy_raychel_school);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(R.drawable.serios_raychel_school);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(R.drawable.normal_raychel_school);
        dialogPers1.add(R.drawable.fun_raychel_school);


        dialogPers2 = new ArrayList<Integer>();
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(R.drawable.suprise_gg_school);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(R.drawable.sad_gg_school);
        dialogPers2.add(R.drawable.think_gg_school);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);

        dialogName = new ArrayList<String>();
        dialogName.add("Рейчел");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("Я");
        dialogName.add("");
        dialogName.add("Рейчел");
        dialogName.add("Я");
        dialogName.add("Я");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("Рейчел");
        dialogName.add("Рейчел");

        // Dummy questions
        dialogList = new ArrayList<String>();
        dialogList.add("И не надоело вам? ");
        dialogList.add("*Всё это время она стояла рядом, но Рэйчел никогда не вступает в споры. Так же, как и дружки Джастина. *");
        dialogList.add("*Обычно перепалка происходит только между мной и ним, и все уже привыкли, что даже не обращают внимания. *");
        dialogList.add("Что ты имеешь в виду?");
        dialogList.add("*Притворяюсь, что не понимаю, о чём она. Хотя прекрасно осознаю, о чём сейчас пойдёт речь. *");
        dialogList.add("Ты, вне всякого сомнения, понимаешь, что именно я имею ввиду, не надоело вот так собачиться с ним каждый день? Не проще ли было бы просто взять и поговорить? *");
        dialogList.add("Рэйчел, ты ведь знаешь, как это всё сложно. За эти два года он не проявил ни единой попытки поговорить, вот и я не буду. Два года назад он ясно дал понять чего хочет. ");
        dialogList.add("А если я подойду к нему и попрошу мира, он просто высмеет меня, вот и всё, Мне легче участвовать в его перепалках, чем объяснять ему то, на что ему явно будет наплевать.");
        dialogList.add("*К сожалению или нет, но это правда. Наша с ним крепкая дружба прервалась очень резко по непонятным причинам, похоже, известным только ему.*");
        dialogList.add("*У меня по сей день остаётся много того, что он должен бы знать. Но с каждым днём я всё больше и больше думаю, что ему на это наплевать так же, как и на меня. *");
        dialogList.add("*И от этого больно, очень больно. Я бы рассказала ему всё, но я трусиха. Боюсь его реакции, его ответа. Какой бы сволочью он не был по отношению ко мне, он всё ещё мне дорог. *");
        dialogList.add("*А я не хочу терять его окончательно. И эти постоянные перепалки — единственный вариант нашего общения, и я это приняла. *");
        dialogList.add("*Даже если наше общение будет состоять из оскорблений и насмешек, я готова казаться сильной и холодной. *");
        dialogList.add("*Только ради того, чтобы слышать его голос и видеть его эмоции, ибо иначе Джастин Коллинс будет говорящим камнем, а этого я тоже не хочу. *");
        dialogList.add("*Наверное, это очень странно и глупо, но по другому я не могу. *");
        dialogList.add("Так, ладно, как скажешь, у вас и правда всё слишком запутанно.");
        dialogList.add("Давай поговорим об этом в другой раз, иначе этот помешанный на своих числах профессор нас отчитает за отсутствие на его уроке.");


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
            Intent gl1_4 = new Intent(this, Glava1_6.class);
            gl1_4.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(gl1_4);
        }
    }
    public void back(View view) {
        Intent gl1_5 = new Intent(this, MainActivity.class);
        startActivity(gl1_5);
    }
}