package com.example.app_educativa.Inicio_sesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.app_educativa.R;

public class iniciar_sesion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ini_sesion_alumno);
    }

    public void incio(View view) {
        Intent reg_inicio = new Intent(this, Login.class);
        startActivity(reg_inicio);
    }
    public void ingresar(View view){

        }
    }

