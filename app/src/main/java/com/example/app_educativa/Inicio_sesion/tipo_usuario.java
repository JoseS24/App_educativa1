package com.example.app_educativa.Inicio_sesion;

import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.app_educativa.R;

public class tipo_usuario extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tipo_usuario);
    }
    public void alumno (View view){
        Intent entrar_alumno = new Intent(this, iniciar_sesion.class);
        startActivity(entrar_alumno);
    }
    public void maestro (View view){
      Intent entrar_maestro = new Intent(this, iniciar_sesionMaestro.class);
        startActivity(entrar_maestro);
    }
    public void primeraVez (View view){
        Intent crear_sesion = new Intent(this, crear_cuenta.class);
        startActivity(crear_sesion);
    }
    public void menu (View view){
        Intent regreso_menu = new Intent(this, Login.class);
        startActivity(regreso_menu);
    }
}