package com.example.app_educativa.Inicio_sesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.app_educativa.R;

public class iniciar_sesion extends AppCompatActivity {
    private EditText usuario, contrasena;
    Button entrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);
    }
    public void regreso_menu (View view){
        Intent regresar = new Intent(this,Login.class);
        startActivity(regresar);
    }

}