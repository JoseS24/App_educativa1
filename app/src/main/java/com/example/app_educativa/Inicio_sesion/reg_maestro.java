package com.example.app_educativa.Inicio_sesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_educativa.Inicio_sesion.crear_cuenta;
import com.example.app_educativa.R;

public class reg_maestro extends AppCompatActivity {
    private EditText nombre, edad, escuela, celular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_maestro);

        nombre = (EditText) findViewById(R.id.nombre);
        edad = (EditText) findViewById(R.id.años);
        escuela = (EditText) findViewById(R.id.escuela);
        celular = (EditText) findViewById(R.id.celular);
    }
    public void regreso_crearCuenta(View view) {
        Intent regreso_crearCuenta = new Intent(this, crear_cuenta.class);
        startActivity(regreso_crearCuenta);

    }
    public void guardar(View view) {
        Intent us_maestro = new Intent(this, usuario_maestro.class);
        startActivity(us_maestro);

    }
}




