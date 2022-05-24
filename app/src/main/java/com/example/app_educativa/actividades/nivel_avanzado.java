package com.example.app_educativa.actividades;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.app_educativa.R;

public class nivel_avanzado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nivel_avanzado);
    }
    public void regresarNiveles(View view){
        Intent intent = new Intent(this,menu_niveles.class);
        startActivity(intent);
    }
}