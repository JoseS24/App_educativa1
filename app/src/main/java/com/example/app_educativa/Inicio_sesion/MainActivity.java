package com.example.app_educativa.Inicio_sesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.app_educativa.Inicio_sesion.Login;
import com.example.app_educativa.R;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //botonera
    public void inicio(View view) {
        Intent empezemos = new Intent(this, Login.class);
        startActivity(empezemos);
    }
}