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

public class reg_maestro extends AppCompatActivity {
    private EditText nombre, edad, celular, usuario, contrasena,rfc;
    Button agregar;
    String nom,eda,cel,usu,contra,rf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg_maestro);

        nombre = (EditText) findViewById(R.id.Mnombre);
        edad = (EditText) findViewById(R.id.Maños);
        celular = (EditText) findViewById(R.id.Mcelular);
        usuario = (EditText) findViewById(R.id.nombre_usuario2);
        contrasena = (EditText) findViewById(R.id.contrasena2);
        agregar = (Button) findViewById(R.id.guardar_maestro);


        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nom = nombre.getText().toString();
                eda = edad.getText().toString();
                cel = celular.getText().toString();
                usu = usuario.getText().toString();
                contra = contrasena.getText().toString();
                rf = rfc.getText().toString();
                if (!nom.isEmpty() && !eda.isEmpty() && !cel.isEmpty() && !usu.isEmpty() && !contra.isEmpty() && !rf.isEmpty()) {
                    guardarM("http://192.168.2.25:8080/app_educativa/insertar_maestros.php");
                } else {
                    Toast.makeText(getApplicationContext(), "Faltan datos por llenar", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void guardarM(String URL) {
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
                Map<String, String> parametro = new HashMap<String, String>();
                parametro.put("nombre", nom);
                parametro.put("edad", eda);
                parametro.put("celular", cel);
                parametro.put("usuario", usu);
                parametro.put("contrasena", contra);
                parametro.put("RFC",rf);
                return parametro;
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