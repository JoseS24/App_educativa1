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
import com.example.app_educativa.apartadoMaestro.menu_maestros;

import java.util.HashMap;
import java.util.Map;

public class iniciar_sesionMaestro extends AppCompatActivity {
    EditText usuario, contrasena, rfc;
    Button checar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion_maestro);

        usuario=findViewById(R.id.usuarioProfe);
        contrasena=findViewById(R.id.contrasenaProfe);
        rfc=findViewById(R.id.rfc);
        checar = findViewById(R.id.entrarProfe);

        checar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validarMaestro("http://192.168.2.25:8080/app_educativa/validar_usuarioMaestro.php");
            }
        });
    }
    private void validarMaestro(String URL){
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if(rfc.toString().isEmpty()){
                    Toast.makeText(iniciar_sesionMaestro.this, "Datos incompletos", Toast.LENGTH_SHORT).show();
                }
                if (!response.isEmpty()) {
                    Intent intent = new Intent(getApplicationContext(), menu_maestros.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(iniciar_sesionMaestro.this, "Usuario, contraseña o rfc incorrectos", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(iniciar_sesionMaestro.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametro=new HashMap<String,String>();
                parametro.put("usuario",usuario.getText().toString());
                parametro.put("contrasena",contrasena.getText().toString());
                parametro.put("rfc",rfc.getText().toString());
                return parametro;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
    public void olvidoContra(View view){
        Intent rec_contra = new Intent(this, recordar_contrasenaM.class);
        startActivity(rec_contra);
    }
    public void registrarMstro (View view){
        Intent nuevo = new Intent(this, reg_maestro.class);
        startActivity(nuevo);
    }
    public void regresarMstro (View view){
        Intent reg_login = new Intent(this, Login.class);
        startActivity(reg_login);
    }
}