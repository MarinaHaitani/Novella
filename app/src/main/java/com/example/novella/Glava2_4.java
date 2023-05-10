package com.example.novella;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class Glava2_4 extends AppCompatActivity {

    int ll_Reychel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_glava2_4);

    }
    public void increment(){
        ll_Reychel++;

    }
    public void decrement(){
        ll_Reychel--;

    }

    public void chois1(View view) {
        Intent gl1_9 = new Intent(Glava2_4.this, Glava2_4_1.class);
        gl1_9.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(gl1_9);
        increment();
        Toast toast = Toast.makeText(this, "Отношения с Рейчел улучшились", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 160);
        toast.show();

    }
    public void chois2(View view) {
        Intent gl1_9 = new Intent(Glava2_4.this, Glava2_4_2.class);
        gl1_9.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(gl1_9);
        decrement();
        Toast toast = Toast.makeText(this, "Отношения с Рейчел ухудшились", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 160);
        toast.show();
    }
    public void back(View view) {
        Intent gl1_5 = new Intent(this, MainActivity.class);
        startActivity(gl1_5);
    }
}