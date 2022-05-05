package com.example.app_educativa.Inicio_sesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;

import com.example.app_educativa.R;

public class usuario_alumno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_alumno);
    }
    public void alumno(View view) {
        Intent regreso_alumno= new Intent(this, reg_alumno.class);
        startActivity(regreso_alumno);
    }
    public void guardar1 (View view){
        Intent alumno_reg= new Intent(this, alumno_registrado.class);
        startActivity(alumno_reg);
    }
}
