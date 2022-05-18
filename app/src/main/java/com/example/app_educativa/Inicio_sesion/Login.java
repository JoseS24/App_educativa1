package com.example.app_educativa.Inicio_sesion;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.app_educativa.R;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    public void regreso(View view) {
        Intent regreso = new Intent(Intent.ACTION_MAIN);
        regreso.addCategory(Intent.CATEGORY_HOME);
        regreso.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(regreso);
    }

    public void cuenta_nueva(View view) {
        Intent cuenta_nueva = new Intent(this, crear_cuenta.class);
        startActivity(cuenta_nueva);
    }

    public void sesion(View view) {
        Intent iniciar = new Intent(this, crear_cuenta.class);
        startActivity(iniciar);
    }
}
