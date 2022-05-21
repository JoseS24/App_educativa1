package com.example.app_educativa.Inicio_sesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.app_educativa.R;

public class crear_cuenta extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);
    }

    public void regreso_login(View view) {
        Intent regreso_login = new Intent(this, Login.class);
        startActivity(regreso_login);
    }

    public void cuenta_alumno(View view) {
        Intent cuenta_nueva = new Intent(this, reg_alumno.class);
        startActivity(cuenta_nueva);
    }

    public void cuenta_maestro(View view) {
        Intent cuenta_nueva = new Intent(this, reg_maestro.class);
        startActivity(cuenta_nueva);
    }
    public void entrada(View view){
        Intent intent = new Intent(this,tipo_usuario.class);
        startActivity(intent);
    }
}