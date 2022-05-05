package com.example.app_educativa.Inicio_sesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.app_educativa.R;


public class reg_alumno extends AppCompatActivity {
    private EditText nombre, edad, escuela, celular;
    private Bundle savedInstanceState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_alumno);

        nombre = (EditText) findViewById(R.id.txnombre);
        edad = (EditText) findViewById(R.id.txaños);
        escuela = (EditText) findViewById(R.id.txescuela);
        celular = (EditText) findViewById(R.id.txcelular);
    }

    public void regreso_crearCuenta(View view) {
        Intent regreso_crearCuenta = new Intent(this, crear_cuenta.class);
        startActivity(regreso_crearCuenta);
    }

    public void guardar(View view) {
        Intent us_alumno = new Intent(this, usuario_alumno.class);
        startActivity(us_alumno);
        }
    }


