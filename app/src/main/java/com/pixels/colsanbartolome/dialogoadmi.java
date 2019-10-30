package com.pixels.colsanbartolome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class dialogoadmi extends AppCompatActivity {
    public List<profes> usurr=new ArrayList<>();
    public List<admilist> promedioLista =new ArrayList<>();;
    String user,cont;
    int p;
    String dat="0";

    InputStream is =null;

    String line=null;

    String result=null;

    String[] data;

    String sede;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialogoadmi);
        Bundle extra = getIntent().getExtras();
        user=extra.getString("Usuario");
        cont=extra.getString("Contraseña");
        sede=extra.getString("sede");
        String Url="https://colegiobartolome.000webhostapp.com/admilist.php";
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                JSONObject jo = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jo = response.getJSONObject(i);
                        promedioLista.add(new admilist(jo.getString("usuario"), jo.getString("contrasena"), jo.getString("tipo"), jo.getString("sede")));

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), "error de Bd", Toast.LENGTH_LONG).show();

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




                        final String usuario=promedioLista.get(p).getUsuario();
                        final String conta=promedioLista.get(p).getContraseña();
                        final String tipo=promedioLista.get(p).getTipo();
                        final String cede=promedioLista.get(p).getSede();

                        basedeinicio nb=new basedeinicio(getApplicationContext());
                        nb.inic("1",usuario,conta,tipo,cede,"","");
                        Intent intent =new Intent(dialogoadmi.this,menuadmi.class);

                        intent.putExtra("Usuario",usuario);
                        intent.putExtra("Contra",conta);
                        intent.putExtra("tipo",tipo);
                        intent.putExtra("sede",cede);
                        startActivity(intent);
                        finish();

                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Contraseña incorrecta",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(dialogoadmi.this,admi.class);
                        startActivity(intent);
                        finish();

                    }
                }else{
                    Toast.makeText(getApplicationContext(), "usurio no encontrdo",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(dialogoadmi.this,admi.class);
                    startActivity(intent);
                    finish();

                }



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                new android.os.Handler().postDelayed(new Runnable() {


                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Error de Conexion Verifique su conexion a Internet",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(dialogoadmi.this,admi.class);
                        startActivity(intent);
                        finish();
                    }},2000);
            }
        });
        RequestQueue requestQueue;
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);
    }


}
