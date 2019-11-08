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

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class eventos extends AppCompatActivity {
    private static RecyclerView reciclemateria;
    public static MostrarMateryReci3 adaptadormateria;
    static   AlertDialog.Builder alert;
    public static List<meventos> promedioLista =new ArrayList<>();
    static Context context;
    static boolean n=true;
    static String tipo,sede;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        Bundle extra = getIntent().getExtras();
        tipo=extra.getString("tipo");
        sede=extra.getString("sede");
        context=this;
        alert= new AlertDialog.Builder(eventos.this);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.toolbare);
        reciclemateria=(RecyclerView)findViewById(R.id.recyclerMateria1);
        reciclemateria.setLayoutManager(new LinearLayoutManager(this));
        Button bton=findViewById(R.id.peri);

        bton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                if(n)
                {
                    n=false;
                    mostrarmensajes(" ",sede,"1");
                    mostrarmensajes(tipo,sede, "1");

                }




            }

        });
        Button bt1on=findViewById(R.id.cirLoginButton);
        bt1on.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                if(n) {
                    n = false;
                    Intent intent = new Intent(eventos.this, agregarevento.class);
                    intent.putExtra("tipo", tipo);
                    intent.putExtra("sede", sede);
                    startActivity(intent);
                }


            }
        });
        mostrarmensajes(tipo, sede,"1");
    }

    public static void  mostrarmensajes(final String tipo, final String sede, final String actuali){
        if(tipo.equals(" ")){
            new android.os.Handler().postDelayed(new Runnable() {


                @Override


                public void run() {
                    n=true;

                }
            },1500);
        }else {
            String Url;
            if (sede.equals("0")) {
                Url = "https://colegiobartolome.000webhostapp.com/eventos.php";
            } else {
                Url = "https://colegiobartolome.000webhostapp.com/eventosc.php";
            }
            JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Url, new Response.Listener<JSONArray>() {

                @Override
                public void onResponse(JSONArray response) {
                    JSONObject jo = null;
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            jo = response.getJSONObject(i);
                            if(i==0) {

                            }else {
                                promedioLista.add(new meventos(jo.getString("id"), jo.getString("mensaje"), jo.getString("fecha"), jo.getString("quien")));
                            }
                        } catch (JSONException e) {
                            Toast.makeText(context, "error de Bd", Toast.LENGTH_LONG).show();

                        }
                    }
                    if(promedioLista.size()==0) {

                    }else{
                        adaptadormateria = new MostrarMateryReci3(promedioLista);
                        if (actuali.equals("1")) {
                            adaptadormateria.clear();
                            mostrarmensajes(tipo,sede, "0");
                        }

                        adaptadormateria = new MostrarMateryReci3(promedioLista);
                        adaptadormateria.setOnClickListener(new View.OnClickListener() {
                            @Override

                            public void onClick(View view) {
                                final   String id,mensaje,fecha,quien;
                                id=promedioLista.get(reciclemateria.getChildAdapterPosition(view)).getId();
                                mensaje=promedioLista.get(reciclemateria.getChildAdapterPosition(view)).getMensaje();
                                fecha=promedioLista.get(reciclemateria.getChildAdapterPosition(view)).getFecha();
                                quien=promedioLista.get(reciclemateria.getChildAdapterPosition(view)).getQuien();


                                alert.setMessage("Seleccione una de las Siguientes Opciones")
                                        .setCancelable(false)
                                        .setPositiveButton("editar", new DialogInterface.OnClickListener(){
                                            @Override
                                            public void onClick(DialogInterface dialog,int which){

                                                //    Toast.makeText(context, id, Toast.LENGTH_LONG).show();
                                                Intent intent=new Intent(context,editare.class);
                                                intent.putExtra("id",id);
                                                intent.putExtra("mensaje",mensaje);
                                                intent.putExtra("fecha",fecha);
                                                intent.putExtra("quien",quien);
                                                intent.putExtra("sede",sede);
                                                context.startActivity(intent);

                                            }

                                        })
                                        .setNegativeButton("eliminar", new DialogInterface.OnClickListener(){
                                            @Override

                                            public void onClick(DialogInterface dialog,int which){
                                                String Url;
                                                if(sede.equals("0")) {

                                                    Url="https://colegiobartolome.000webhostapp.com/elimineeven.php";
                                                }else {
                                                    Url="https://colegiobartolome.000webhostapp.com/elimineevenc.php";
                                                }
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
        mostrarmensajes(tipo,sede,"1");

    }
    public static void gene(){
        n=true;
    }


}
