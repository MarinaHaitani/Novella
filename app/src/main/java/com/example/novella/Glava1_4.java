package com.example.novella;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class Glava1_4 extends AppCompatActivity {
    int popular=0;
    private int chapter = 1;
    private int classIndex = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_glava1_4);

    }
    public void increment(){
        popular++;

    }
    public void decrement(){
        popular--;

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
    public void chois1(View view) {
        Intent gl1_9 = new Intent(Glava1_4.this, Glava1_4_1.class);
        gl1_9.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(gl1_9);
        increment();
        Toast toast = Toast.makeText(this, "+ Популярность", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 160);
        toast.show();

    }
    public void chois2(View view) {
        Intent gl1_9 = new Intent(Glava1_4.this, Glava1_4_2.class);
        gl1_9.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(gl1_9);
    }
    public void back(View view) {
        Intent gl1_5 = new Intent(this, MainActivity.class);
        startActivity(gl1_5);
    }
}