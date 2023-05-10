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

public class Glava2_5 extends AppCompatActivity {

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
        setContentView(R.layout.activity_glava2_5);

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
        dialogPers1.add(R.drawable.think_raychel);
        dialogPers1.add(0);
        dialogPers1.add(R.drawable.think_raychel);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(0);
        dialogPers1.add(R.drawable.smile_raychel);

        dialogPers2 = new ArrayList<Integer>();
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(R.drawable.think_gg);
        dialogPers2.add(0);
        dialogPers2.add(R.drawable.think_gg);
        dialogPers2.add(0);
        dialogPers2.add(R.drawable.ablush_gg);
        dialogPers2.add(0);
        dialogPers2.add(0);
        dialogPers2.add(0);


        dialogName = new ArrayList<String>();
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("Я");
        dialogName.add("Рейчел");
        dialogName.add("Я");
        dialogName.add("Рейчел");
        dialogName.add("Я");
        dialogName.add("");
        dialogName.add("");
        dialogName.add("Рейчел");


        // Dummy questions
        dialogList = new ArrayList<String>();
        dialogList.add("*Заведя машину, Рэйчел, негодующе уставилась в лобовое стекло. Настрой подруги слегка подпортился после того, как я обула белые кроссовки вместо каблуков, которые она мне так упорно впихивала.*");
        dialogList.add("*Кроссовки для меня намного комфортнее, и если мне, по какой-то причине, всё-таки захочется сбежать с вечеринки, то удобнее это будет сделать именно в них. *");
        dialogList.add("*Я знаю, что она не сильно то и обиделась. Тем более, Рэйчел, достаточно быстро успокаивается. Но когда она злится, лучше её не трогать. *");
        dialogList.add("*Пару минут мы ехали в тишине. Подруга уже умела водить и спокойно ехала по дороге. Не все девушки в её возрасте уже имели права и машину. *");
        dialogList.add("Кто устраивает вечеринку? ");
        dialogList.add("Кажется это Бэн Фокс, из другого класса. Хотя, честно говоря, я даже не имею малейшего понятия о том, как он выглядит.");
        dialogList.add("А кто там будет? Мне же нужно знать, с кем мне предстоит встретиться.");
        dialogList.add("На сколько я знаю, туда собирались пойти наши одноклассники, пару ребят из других классов, и друзья этого Бэна.");
        dialogList.add("А он… там будет?");
        dialogList.add("*Я даже не могу определиться, чего я бы хотела больше. Чтобы он там был, или же, чтобы его там не было.*");
        dialogList.add("*Хотя, учитывая то, что если он всё-таки соизволит там появиться, то ссоры нам не избежать, я бы всё-таки предпочла, чтобы он не пришёл и я смогла спокойно оторваться.*");
        dialogList.add("Нет, его сегодня там не будет. Джастин будет кататься по своим делам.");
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
            Intent gl1_4 = new Intent(this, Glava2_6.class);
            gl1_4.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            startActivity(gl1_4);
        }
    }
    public void back(View view) {
        Intent gl1_5 = new Intent(this, MainActivity.class);
        startActivity(gl1_5);
    }
}