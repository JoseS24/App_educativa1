package com.example.app_educativa.Inicio_sesion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
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
import com.example.app_educativa.Inicio_sesion.crear_cuenta;
import com.example.app_educativa.R;

import java.util.HashMap;
import java.util.Map;

public class reg_maestro extends AppCompatActivity {
    private EditText nombre, edad, escuela, celular;
    Button agregar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_maestro);

        nombre = (EditText) findViewById(R.id.Mnombre);
        edad = (EditText) findViewById(R.id.Maños);
        escuela = (EditText) findViewById(R.id.Mescuela);
        celular = (EditText) findViewById(R.id.Mcelular);
        agregar = (Button) findViewById(R.id.guardar_maestro);

        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarM("http://192.168.2.25:8080/app_educativa/insertar_maestros.php");
            }
        });
    }
    private void guardarM(String URL) {
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
                parametros.put("nombre", nombre.getText().toString());
                parametros.put("edad", edad.getText().toString());
                parametros.put("escuela", escuela.getText().toString());
                parametros.put("celular", celular.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        Intent reg_exitoso = new Intent(this, usuario_maestro.class);
        startActivity(reg_exitoso);
    }

    public void regreso_crearCuenta(View view) {
        Intent regreso_crearCuenta = new Intent(this, crear_cuenta.class);
        startActivity(regreso_crearCuenta);

    }
    public void guardar(View view) {
            Intent reg_exitoso = new Intent(this, usuario_maestro.class);
            startActivity(reg_exitoso);
    }
}




