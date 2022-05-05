package com.example.app_educativa.Inicio_sesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.app_educativa.R;

public class usuario_maestro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_maestro);
    }

    public void regreso_maestro(View view) {
        Intent regreso_maestro= new Intent(this, reg_maestro.class);
        startActivity(regreso_maestro);
    }
    public void guardar (View view){
        Intent maestro_reg= new Intent(this, maestro_registrado.class);
        startActivity(maestro_reg);
    }
}