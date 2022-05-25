package com.example.app_educativa.Inicio_sesion;

import androidx.appcompat.app.AppCompatActivity;


import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.app_educativa.R;

import java.util.HashMap;
import java.util.Map;


public class reg_alumno extends AppCompatActivity {
    private EditText nombre, edad, celular, usuario, contrasena;
    Button agregar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_alumno);

        nombre = (EditText) findViewById(R.id.txnombre);
        edad = (EditText) findViewById(R.id.txaños);
        celular = (EditText) findViewById(R.id.txcelular);
        usuario = (EditText) findViewById(R.id.txtnombre2);
        contrasena = (EditText) findViewById(R.id.txtcontrasena2);
        agregar = (Button) findViewById(R.id.boton_alumno);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar("http://192.168.2.25:8080/app_educativa/insertar_datos.php");
            }
        });
    }

    private void guardar(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (nombre.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Falta el nombre", Toast.LENGTH_SHORT).show();
                }else if (edad.getText().toString().isEmpty()){
                     Toast.makeText(getApplicationContext(), "Falta la edad", Toast.LENGTH_SHORT).show();
                    } else if (celular.getText().toString().isEmpty()) {
                         Toast.makeText(getApplicationContext(), "Falta el celular", Toast.LENGTH_SHORT).show();
                        }else if (usuario.getText().toString().isEmpty()) {
                           Toast.makeText(getApplicationContext(), "Falta tu usuario", Toast.LENGTH_SHORT).show();
                             }else if (contrasena.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Falta tu contrasena", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("nombre", nombre.getText().toString());
                parametros.put("edad", edad.getText().toString());
                parametros.put("celular", celular.getText().toString());
                parametros.put("usuario", usuario.getText().toString());
                parametros.put("contrasena", contrasena.getText().toString());

                return parametros;
            }

        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void regreso_menu(View view){
        Intent regresar = new Intent(this, crear_cuenta.class);
        startActivity(regresar);
    }
}













