package com.example.novella;
import androidx.appcompat.app.AppCompatActivity;
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
public class Glava_1 extends AppCompatActivity {
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
        setContentView(R.layout.activity_glava1);
        text = findViewById(R.id.text);
        name = findViewById(R.id.name);
        pers1 = findViewById(R.id.personaj1);
        pers2 = findViewById(R.id.personaj2);
        imageButton = findViewById(R.id.imageButton);
        //подгружаем первого персонажа
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
        dialogPers1.add(R.drawable.fun_raychel_school);
        dialogPers1.add(0);
        dialogPers1.add(R.drawable.sad_konor_school);
        dialogPers1.add(R.drawable.hot_konor_school);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        //подгружаем второго персонажа
        dialogPers2 = new ArrayList<Integer>();
        dialogPers2.add(0);
        dialogPers2.add(R.drawable.sad_gg_school);
        dialogPers2.add(R.drawable.sad_gg_school);
        dialogPers2.add(R.drawable.speek_gg_school);
        dialogPers2.add(R.drawable.speek_gg_school);
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
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(R.drawable.suprise_gg_school);
        //Подгружаем имя говорящего персонажа
        dialogName = new ArrayList<String>();
        dialogName.add("Рейчел");
        dialogName.add("Я");
        dialogName.add("Я");
        dialogName.add("Я");
        dialogName.add("Я");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("Рейчел");
        dialogName.add("");
        dialogName.add("Конор");
        dialogName.add("Конор");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("Я");
        // Подгружаем диалоги
        dialogList = new ArrayList<String>();
        dialogList.add("Да она совсем свихнулась! Прочитать эту огромную книгу за неделю... Это ведь каждый вечер придётся сидеть и читать, тупо уткнувшись в этот дурацкий роман,");
        dialogList.add("*Моя подруга отнюдь не радуется домашнему заданию, которое нам дала наша учительница мисс Остин. *");
        dialogList.add("*Она уже минут пять идёт по коридору и возмущается, активно жестикулируя руками и сдвигая брови к переносице, явно показывая своё недовольство. *");
        dialogList.add("Не переживай ты так, сомневаюсь, что она будет делать по этой книге тест. Всего то спросит тех, кто прогуливал.");
        dialogList.add("А у тебя по её предмету зачёт, не о чем беспокоиться. Прочти краткое содержание и дело в шляпе. ");
        dialogList.add("*Рэйчел, по совместительству моя лучшая подруга, непростая личность. Только из-за внешности люди считают её высокомерной и привередливой.*");
        dialogList.add("*А статус её семьи в обществе ещё больше подначивает людей придерживаться этих догадок.*");
        dialogList.add("*Но на мнение окружающих как мне, так и ей откровенно плевать, и она никогда не пыталась их в чём-то переубедить.*");
        dialogList.add("*Да, семья Уайт достаточно влиятельна, но это не делает мою подругу эгоистичной, какими являются некоторые особы нашей школы.*");
        dialogList.add("*Она крайне внимательна, заботлива и добра. И учится она хорошо не из-за папиных денег, а благодаря собственным умениям.*");
        dialogList.add("*Она не заучка и не тихоня, вовсе нет. Я бы назвала её прекрасной девушкой, с которой, между прочим, хочет общаться половина школы.*");
        dialogList.add("Это радует потому, что мне не хотелось отменять планы на эти выходные.");
        dialogList.add("*Мы останавливаемся в коридоре среди остальных учеников. Непринуждённо оглядываюсь по сторонам, рассматривая людей, и мой взгляд останавливается на одном парне. *");
        dialogList.add("");
        dialogList.add("");
        dialogList.add("*Конор — командир футбольной команды, учится в параллели. Старше меня на пару месяцев, с прекрасной внешностью и чувством юмора.*");
        dialogList.add("*Многие девушки за ним бегают, но ни одна из них не продержалась с ним больше месяца. Множество неудач или он просто бабник?*");
        dialogList.add("*Он посмотрел на меня и улыбнулся мне. Или мне просто показалось.* ");
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
    protected void onPause() {
        super.onPause();
        // Сохраните текущий прогресс игры в SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("GameSave", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("currentDialog", Dialog);
        // Добавьте другие данные, которые требуется сохранить
        editor.apply();
    }
    @Override
    protected void onResume() {
        super.onResume();
        // Восстановите сохраненный прогресс игры из SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("GameSave", Context.MODE_PRIVATE);
        Dialog = sharedPreferences.getInt("currentDialog", 0);
        // Восстановите другие данные
        showQuestion();
    }
  public void showQuestion() {
        if (Dialog < dialogList.size()) {
            text.setText(dialogList.get(Dialog));
            name.setText(dialogName.get(Dialog));
            pers1.setImageResource(dialogPers1.get(Dialog));
            pers2.setImageResource(dialogPers2.get(Dialog));
        } else {
            Intent gl1_4 = new Intent(this, Glava1_2.class);
            gl1_4.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(gl1_4);
        }
    }
    //Возвращаемся к главному меню
    public void back(View view) {
        Intent gl1_5 = new Intent(this, MainActivity.class);
        startActivity(gl1_5);
    }
}