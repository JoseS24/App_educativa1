package com.example.app_educativa.actividades;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.app_educativa.R;

public class menu_niveles extends AppCompatActivity {
    Button salida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_niveles);

        salida = (Button) findViewById(R.id.salida);

        salida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alerta = new AlertDialog.Builder(menu_niveles.this);
                alerta.setMessage("¿Desea salir de la aplicacion?")
                        .setCancelable(false)
                        .setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {

                                Intent salir2 = new Intent(Intent.ACTION_MAIN);
                                salir2.addCategory(Intent.CATEGORY_HOME);
                                salir2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                startActivity(salir2);
                            }
                        })
                        .setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                AlertDialog titulo = alerta.create();
                titulo.setTitle("Salida");
                titulo.show();
            }
        });
    }
    public void avanzado (View view){
        Intent intent = new Intent(this, nivel_avanzado.class);
        startActivity(intent);
    }
}