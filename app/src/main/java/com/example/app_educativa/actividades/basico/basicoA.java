package com.example.app_educativa.actividades.basico;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.app_educativa.R;

public class basicoA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basico);
    }

    public void pasar (View view){
        Intent intent = new Intent(this, basicoE.class);
        startActivity(intent);
    }
}