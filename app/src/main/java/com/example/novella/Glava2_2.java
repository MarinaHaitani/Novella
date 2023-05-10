package com.example.novella;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

public class Glava2_2 extends AppCompatActivity {


    int otv =0;
    int imp =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_glava2_2);

    }
    public void Otvetstvenost(){
        otv++;

    }
    public void Impulsivnost(){
        imp++;

    }

    public void chois1(View view) {
        Intent gl1_9 = new Intent(Glava2_2.this, Glava2_2_1.class);
        gl1_9.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(gl1_9);
        Impulsivnost();
        Toast toast = Toast.makeText(this, "+ Импульсивность", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 160);
        toast.show();

    }
    public void chois2(View view) {
        Intent gl1_9 = new Intent(Glava2_2.this, Glava2_2_2.class);
        gl1_9.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(gl1_9);
        Otvetstvenost();
        Toast toast = Toast.makeText(this, "+ Ответственность", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP, 0, 160);
        toast.show();
    }
    public void back(View view) {
        Intent gl1_5 = new Intent(this, MainActivity.class);
        startActivity(gl1_5);
    }
}