package com.example.app_educativa.Inicio_sesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_educativa.R;

public class usuario_maestro extends AppCompatActivity {
    private EditText usuario, contraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_maestro);

        usuario = (EditText) findViewById(R.id.nombre_usuario);
        contraseña = (EditText) findViewById(R.id.contraseña);
    }

    public void regreso_maestro(View view) {
        Intent regreso_maestro = new Intent(this, reg_maestro.class);
        startActivity(regreso_maestro);
    }

    public void guardarMaestro(View view) {
            Intent maestro_reg = new Intent(this, maestro_registrado.class);
            startActivity(maestro_reg);
    }
}
