package com.pixels.colsanbartolome;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class mensajesprof extends AppCompatActivity {
    public static String tabla,materia,curso,nombre;
    static boolean n=true;
    public static List<mensajes> promedioLista =new ArrayList<>();
    private static RecyclerView reciclemateria;
    public static MostrarMateryRecim adaptadormateria;
  static   AlertDialog.Builder alert;
   static Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle extra = getIntent().getExtras();
        setContentView(R.layout.activity_mensajesprof);
        tabla=extra.getString("tabla");
        materia=extra.getString("materia");
        curso=extra.getString("curso");
        nombre=extra.getString("nombre");
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
context=this;
        getSupportActionBar().setCustomView(R.layout.toolbar);
        reciclemateria=(RecyclerView)findViewById(R.id.recyclerMateria1);
        reciclemateria.setLayoutManager(new LinearLayoutManager(this));
        Button bton=findViewById(R.id.peri);
       alert= new AlertDialog.Builder(mensajesprof.this);
        bton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                if(n)
                {
                    n=false;
                    mostrarmensajes(" ","1");
                    mostrarmensajes(tabla, "1");
                }




            }

        });
        Button bt1on=findViewById(R.id.cirLoginButton);
        bt1on.setOnClickListener(new View.OnClickListener() {

                                    @Override

                                    public void onClick(View v) {
                                        if(n) {
                                            n = false;
                                            Intent intent = new Intent(mensajesprof.this, agregar.class);
                                            intent.putExtra("tabla", tabla);
                                            intent.putExtra("materia",materia);
                                            intent.putExtra("curso",curso);
                                            intent.putExtra("nombre",nombre);
                                            startActivity(intent);
                                        }


                                    }
                                });
        mostrarmensajes(tabla, "1");
    }
    public static void  mostrarmensajes(final String tabla, final String actuali){
        if(tabla.equals(" ")){
            new android.os.Handler().postDelayed(new Runnable() {


                @Override


                public void run() {
                    n=true;

                }
            },1500);
        }else {
            String Url = "https://colegiobartolome.000webhostapp.com/mensajeslist.php?tabla=" + tabla;
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Url, new Response.Listener<JSONArray>() {

                @Override
                public void onResponse(JSONArray response) {
                    JSONObject jo = null;
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            jo = response.getJSONObject(i);
                            if(i==0) {

                            }else {
                                promedioLista.add(new mensajes(jo.getString("id"), jo.getString("mensaje"), jo.getString("fecha")));
                            }
                        } catch (JSONException e) {
                            Toast.makeText(context, "error de Bd", Toast.LENGTH_LONG).show();

                        }
                    }
                    if(promedioLista.size()==0) {

                    }else{
                        adaptadormateria = new MostrarMateryRecim(promedioLista);
                        if (actuali.equals("1")) {
                            adaptadormateria.clear();
                            mostrarmensajes(tabla, "0");
                        }

                        adaptadormateria = new MostrarMateryRecim(promedioLista);
                        adaptadormateria.setOnClickListener(new View.OnClickListener() {
                            @Override

                            public void onClick(View view) {
                              final   String id,mensaje,fecha;
                                id=promedioLista.get(reciclemateria.getChildAdapterPosition(view)).getId();
                                mensaje=promedioLista.get(reciclemateria.getChildAdapterPosition(view)).getMensaje();
                                fecha=promedioLista.get(reciclemateria.getChildAdapterPosition(view)).getFecha();


                                alert.setMessage("Seleccione una de las Siguientes Opciones")
                                        .setCancelable(false)
                                        .setPositiveButton("editar", new DialogInterface.OnClickListener(){
                                            @Override
                                            public void onClick(DialogInterface dialog,int which){

                                            //    Toast.makeText(context, id, Toast.LENGTH_LONG).show();
                                                Intent intent=new Intent(context,editar.class);
                                                intent.putExtra("tabla",tabla);
                                                intent.putExtra("id",id);
                                                intent.putExtra("mensaje",mensaje);
                                                intent.putExtra("fecha",fecha);
                                                context.startActivity(intent);

                                            }

                                        })
                                        .setNegativeButton("eliminar", new DialogInterface.OnClickListener(){
                                            @Override

                                            public void onClick(DialogInterface dialog,int which){

                                                String Url="https://colegiobartolome.000webhostapp.com/eliminarmensaje.php?tabla="+tabla;
                                                StringRequest strindd=new StringRequest(Request.Method.POST,Url,new Response.Listener<String>(){

                                                    public void onResponse(String response){
                                                        Toast.makeText(context,"Mensaje eliminado Correctamente",Toast.LENGTH_SHORT).show();

                                                        actualizar();


                                                    }


                                                },new Response.ErrorListener(){

                                                    public void onErrorResponse(VolleyError error){

                                                        Toast.makeText(context,"Error de Conexion Verifique su conexion a Internet",Toast.LENGTH_SHORT).show();

                                                    }
                                                }){



                                                    protected Map<String, String> getParams() throws AuthFailureError {



                                                        Map<String, String> parametros=new HashMap<String, String>();





                                                        parametros.put("id",id);







                                                        return parametros;

                                                    }

                                                };

                                                RequestQueue requestQueue= Volley.newRequestQueue(context);


                                                requestQueue.add(strindd);

                                            }

                                        });
                                AlertDialog titulo=alert.create();
                                titulo.setTitle("Opciones de Mensaje");
                                titulo.show();



                            }
                        });

                        reciclemateria.setAdapter(adaptadormateria);
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    new android.os.Handler().postDelayed(new Runnable() {


                        @Override
                        public void run() {
                            Toast.makeText(context, "Error de Conexion Verifique su conexion a Internet  ", Toast.LENGTH_LONG).show();
                        }
                    }, 2000);
                }
            });
            RequestQueue requestQueue;
            requestQueue = Volley.newRequestQueue(context);
            requestQueue.add(jsonArrayRequest);
        }
    }
    public static void actualizar(){
        mostrarmensajes(tabla,"1");

    }
    public static void gene(){
        n=true;
    }
}
