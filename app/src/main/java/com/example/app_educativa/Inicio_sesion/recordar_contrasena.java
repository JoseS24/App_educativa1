package com.example.app_educativa.Inicio_sesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.app_educativa.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class recordar_contrasena extends AppCompatActivity {
    EditText usuario;
    TextView contrasena;
    Button buscar;

    RequestQueue requestQueue;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recordar_contrasena);

        usuario=(EditText) findViewById(R.id.recUsuario);
        contrasena=(TextView) findViewById(R.id.verContra);
        buscar=(Button) findViewById(R.id.buscar_contrasena);

        buscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                buscarContrasena("http://192.168.2.25:8080/app_educativa/recuperarContra_alumno.php?usuario="+usuario.getText()+"");
            }
        });
    }

    private void buscarContrasena(String URL) {
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jsonObject = response.getJSONObject(i);
                        contrasena.setText(jsonObject.getString("contrasena"));
                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"Error de conexion", Toast.LENGTH_SHORT).show();
            }
        }
        );
            requestQueue= Volley.newRequestQueue(this);
            requestQueue.add(jsonArrayRequest);
    }
    public void entradeNuevo (View view){
        Intent intent = new Intent(this,iniciar_sesion.class);
        startActivity(intent);
    }
    public void nu_usuario (View view){
        Intent intent = new Intent(this,reg_alumno.class);
        startActivity(intent);
    }
    public void regresarMenu (View view){
        Intent intent = new Intent(this,Login.class);
        startActivity(intent);
    }
}

