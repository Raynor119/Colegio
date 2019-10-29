package com.pixels.colsanbartolome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class cambiarcontra extends AppCompatActivity {
String Usuario,Nombre,Materias,Cursos;
    boolean n=true;
    EditText contra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cambiarcontra);
        Bundle extra = getIntent().getExtras();
        Usuario=extra.getString("usuario");
        Nombre=extra.getString("nombre");
        Materias=extra.getString("materias");
        Cursos=extra.getString("cursos");
        contra=(EditText)findViewById(R.id.editText2);
        Button bton=findViewById(R.id.cirLoginButton);
        bton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                if(n)
                {
                    n=false;
                    cambiar();


                }
            }
        });
    }

    public void cambiar(){
        String URL = "https://colegiobartolome.000webhostapp.com/cambiarcontra.php";

        StringRequest strindd = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {

            public void onResponse(String response) {
                basedeinicio n = new basedeinicio(getApplicationContext());
                n.inic("1", "nada","", "", "","");
                Intent intent=new Intent(cambiarcontra.this,sede.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "se a Cambiado la Contraseña ", Toast.LENGTH_SHORT).show();
                finish();



            }


        }, new Response.ErrorListener() {

            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "Error de Conexion Verifique su conexion a Internet", Toast.LENGTH_SHORT).show();

            }
        }) {


            protected Map<String, String> getParams() throws AuthFailureError {


                Map<String, String> parametros = new HashMap<String, String>();



                String conta=contra.getText().toString();


                parametros.put("usuarios", Usuario);
                parametros.put("contra", conta);
                parametros.put("nombre", Nombre);
                parametros.put("materias", Materias);
                parametros.put("cursos", Cursos);


                return parametros;

            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);


        requestQueue.add(strindd);
        new android.os.Handler().postDelayed(new Runnable() {


            @Override


            public void run() {
                n=true;

            }
        },6000);
    }
}
