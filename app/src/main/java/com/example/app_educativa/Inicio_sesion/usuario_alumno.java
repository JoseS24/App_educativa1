package com.example.app_educativa.Inicio_sesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
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

public class usuario_alumno extends AppCompatActivity {
    private EditText usuario,contraseña;
    Button crear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuario_alumno);

        usuario=(EditText) findViewById(R.id.txtnombre);
        contraseña=(EditText) findViewById(R.id.txtcontraseña);
        crear = (Button) findViewById(R.id.crear_alumno);

        crear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crear_us("http://192.168.2.25:8080/app_educativa/usuarios_alumnos.php");
            }
        });
    }
    private void crear_us(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,URL,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Registro exitoso", Toast.LENGTH_SHORT).show();
            }
        },new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros = new HashMap<String, String>();
                parametros.put("usuario", usuario.getText().toString());
                parametros.put("contraseña", contraseña.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    public void guardar_alumno(View view) {
            Intent registro_final= new Intent(this, alumno_registrado.class);
            startActivity(registro_final);
    }
    public void regreso_alumno (View view){
        Intent alumno_reg= new Intent(this, reg_alumno.class);
        startActivity(alumno_reg);
    }
}
