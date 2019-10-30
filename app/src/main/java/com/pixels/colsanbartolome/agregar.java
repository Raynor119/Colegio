package com.pixels.colsanbartolome;

import android.content.Context;
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

public class agregar extends AppCompatActivity {
    String id="",mensaje,fecha,tabla,materia,curso,nombre;
    EditText tex;
    boolean n=true;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        Bundle extra = getIntent().getExtras();
        tex=(EditText)findViewById(R.id.editText);
        context=this;
        tabla=extra.getString("tabla");
        materia=extra.getString("materia");
        curso=extra.getString("curso");
        nombre=extra.getString("nombre");
        new android.os.Handler().postDelayed(new Runnable() {


            @Override


            public void run() {
                mensajesprof.gene();

            }
        },500);

        Button bton=findViewById(R.id.cirLoginButton);
        bton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                if(n)
                {
                    n=false;
                    agregarr("1");


                }
            }
        });
    }
    public void agregarr(String nn) {
        if (nn.equals(" ")) {

        } else {
            ///Toast.makeText(getApplicationContext(), tabla, Toast.LENGTH_SHORT).show();

            String URL = "https://colegiobartolome.000webhostapp.com/agregarmensaje.php?tabla="+tabla;

            StringRequest strindd = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {

                public void onResponse(String response) {
                   Toast.makeText(getApplicationContext(), "Mensaje Agregado Correctamente", Toast.LENGTH_SHORT).show();


                       String URL = "https://colegiobartolome.000webhostapp.com/agregarnoti.php";

                       StringRequest strindd = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
                           public void onResponse(String response) {


                           }

                       }, new Response.ErrorListener() {

                           public void onErrorResponse(VolleyError error) {

                               Toast.makeText(getApplicationContext(), "Error de notificacion Verifique su conexion a Internet", Toast.LENGTH_SHORT).show();

                           }
                       }){


                           protected Map<String, String> getParams() throws AuthFailureError {


                               Map<String, String> parametros = new HashMap<String, String>();


                               String contr = String.valueOf(tex.getText().toString());

                               SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy|HH:mm", Locale.getDefault());

                               Date date = new Date();

                               String fecha = dateFormat.format(date);

                               parametros.put("id", "0");

                               parametros.put("notificaciones", "El Profesor "+nombre+" agregro un nuevo mensaje al curso "+curso+" de la Materia "+materia+"");

                               parametros.put("fecha", fecha);


                               return parametros;

                           }

                       };

                       RequestQueue requestQueue = Volley.newRequestQueue(context);


                       requestQueue.add(strindd);



                    finish();
                    mensajesprof.actualizar();


                }


            }, new Response.ErrorListener() {

                public void onErrorResponse(VolleyError error) {

                    Toast.makeText(getApplicationContext(), "Error de Conexion Verifique su conexion a Internet", Toast.LENGTH_SHORT).show();

                }
            }) {


                protected Map<String, String> getParams() throws AuthFailureError {


                    Map<String, String> parametros = new HashMap<String, String>();


                    String contr = String.valueOf(tex.getText().toString());

                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy|HH:mm", Locale.getDefault());

                    Date date = new Date();

                    String fecha = dateFormat.format(date);

                    parametros.put("id", "0");

                    parametros.put("mensaje", contr);

                    parametros.put("fecha", fecha);


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
}
