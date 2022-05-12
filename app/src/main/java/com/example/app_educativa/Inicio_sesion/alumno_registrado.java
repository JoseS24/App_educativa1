package com.example.app_educativa.Inicio_sesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.app_educativa.R;
import com.example.app_educativa.actividades.menu_niveles;

public class alumno_registrado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno_registrado);
    }

    public void actividades(View view) {
        Intent act = new Intent(this, menu_niveles.class);
        startActivity(act);
    }
    public void regreso_menu1 (View view){
        Intent regreso = new Intent(this,crear_cuenta.class);
        startActivity(regreso);
    }
}