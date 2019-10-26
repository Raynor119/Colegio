package com.pixels.colsanbartolome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;


public class dialogcarga extends AppCompatActivity {
    public List<profes> usurr=new ArrayList<>();
    public List<profes> promedioLista =new ArrayList<>();;
    String user,cont;
    int p;
    String dat="0";

    InputStream is =null;

    String line=null;

    String result=null;

    String[] data;

    String deci;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_dialogcarga);
        Bundle extra = getIntent().getExtras();
        user=extra.getString("Usuario");
        cont=extra.getString("Contraseña");
        deci=extra.getString("deci");
        profes busca=new profes();
        ip c= new ip();

        final String ipt=c.ip();
        String Url="https://colegiobartolome.000webhostapp.com/usulist.php";

        // sacar
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                JSONObject jo = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jo = response.getJSONObject(i);
                        promedioLista.add(new profes(jo.getString("usuario"), jo.getString("contrasena"), jo.getString("nombre"), jo.getString("jornada"), jo.getString("sede")));

                           } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), "puta", Toast.LENGTH_LONG).show();

                    }
                }
                int i;
                int confu=0;
                int confc=0;
                p=0;

                for(i=0;i<promedioLista.size();i++){


                    String usurrr=promedioLista.get(i).getUsuario();
                    if(usurrr.equals(user)){
                        confu=1;
                        p=i;
                    }

                }
                if(confu==1){


                    String conr=promedioLista.get(p).getContraseña();
                    if(conr.equals(cont)){



                        final String uss=promedioLista.get(p).getUsuario();
                        Intent intent =new Intent(dialogcarga.this,menuprofesores.class);
                        startActivity(intent);
                        finish();

                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Contraseña incorrecta",Toast.LENGTH_LONG).show();

                        finish();
                    }
                }else{
                    Toast.makeText(getApplicationContext(), "usurio no encontrdo",Toast.LENGTH_LONG).show();

                    finish();
                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                
            }
        });
        RequestQueue requestQueue;
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);












    }
}
