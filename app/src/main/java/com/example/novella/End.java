package com.example.novella;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class End extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_end);
    }

    public void back_glM(View view) {
        Intent intent = new Intent(End.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
        startActivity(intent);
    }
}