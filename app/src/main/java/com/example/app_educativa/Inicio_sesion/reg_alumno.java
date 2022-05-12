package com.example.app_educativa.Inicio_sesion;

import androidx.appcompat.app.AppCompatActivity;


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
    private EditText nombre, edad, escuela, celular;
    Button agregar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_alumno);

        nombre = (EditText) findViewById(R.id.txnombre);
        edad = (EditText) findViewById(R.id.txaños);
        escuela = (EditText) findViewById(R.id.txescuela);
        celular = (EditText) findViewById(R.id.txcelular);
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
                Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
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
                parametros.put("escuela", escuela.getText().toString());
                parametros.put("celular", celular.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        Intent crear_usuario = new Intent(this, usuario_alumno.class);
        startActivity(crear_usuario);
    }
    public void regreso_sesion(View view) {
        Intent regreso_sesion = new Intent(this, crear_cuenta.class);
        startActivity(regreso_sesion);
    }
}













