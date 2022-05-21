package com.example.app_educativa.Inicio_sesion;

import androidx.annotation.Nullable;
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
import com.example.app_educativa.actividades.menu_niveles;

import java.util.HashMap;
import java.util.Map;

public class iniciar_sesion extends AppCompatActivity {
    EditText usuario, contrasena;
    Button iniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        usuario = findViewById(R.id.val_usuario);
        contrasena = findViewById(R.id.val_contra);
        iniciar = findViewById(R.id.entrada);

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarUsuario("http://192.168.28.209:8080/app_educativa/validar_usuario.php");
            }
        });
    }

    private void validarUsuario(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (usuario.length() == 0 && contrasena.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Faltan campos por llenar", Toast.LENGTH_SHORT).show();
                }else if (!response.isEmpty()) {
                    Intent intent = new Intent(getApplicationContext(), menu_niveles.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(iniciar_sesion.this, "Usuario o contraseña incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(iniciar_sesion.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametro=new HashMap<String,String>();
                parametro.put("usuario",usuario.getText().toString());
                parametro.put("contrasena",contrasena.getText().toString());
                return parametro;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void olvido (View view){
        Intent olvidar = new Intent(this,recordar_contrasena.class);
        startActivity(olvidar);
    }
    public void registro2(View view){
        Intent reg_nuevo = new Intent(this,reg_alumno.class);
        startActivity(reg_nuevo);
    }
    public void reg_menu(View view){
        Intent menu = new Intent(this,Login.class);
        startActivity(menu);
    }
}




