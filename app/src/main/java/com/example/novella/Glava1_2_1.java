package com.example.novella;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class Glava1_2_1 extends AppCompatActivity {
    private int chapter = 1;
    private int classIndex = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_glava1_2_1);
    }
    public void gl1_11(View view) {
        Intent gl1_11 = new Intent(Glava1_2_1.this, Glava1_3.class);
        gl1_11.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(gl1_11);
    }
    public void back(View view) {
        Intent gl1_5 = new Intent(this, MainActivity.class);
        startActivity(gl1_5);
    }
}