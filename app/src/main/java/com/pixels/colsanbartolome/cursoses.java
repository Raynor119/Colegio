package com.pixels.colsanbartolome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class cursoses extends AppCompatActivity {
    public List<cursolist> promedioLista =new ArrayList<>();
    private RecyclerView reciclemateria;
    public List<cursos> cursos1=new ArrayList<>();
    public List<cursos> cursos2=new ArrayList<>();
    private MostrarMateryReci1 adaptadormateria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursoses);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle extra = getIntent().getExtras();
        String sede=extra.getString("sede");
        String jornada=extra.getString("jornada");
        if(sede.equals("0")){
            if(jornada.equals("manana")){
                manana();
            }else {
                tarde();
            }
        }else{
                tardec();
        }
        reciclemateria=(RecyclerView)findViewById(R.id.recyclerMateria1);
        reciclemateria.setLayoutManager(new LinearLayoutManager(this));


    }

    public void manana(){
        String Url="https://colegiobartolome.000webhostapp.com/cursosm.php";
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                JSONObject jo = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jo = response.getJSONObject(i);
                        promedioLista.add(new cursolist(jo.getString("grado"), jo.getString("grados"), jo.getString("materias")));

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), "error de Bd", Toast.LENGTH_LONG).show();

                    }
                }

                for(int i=0;i<promedioLista.size();i++){
                    cursos1.add(new cursos(promedioLista.get(i).getCuso()));
                }
                adaptadormateria =new MostrarMateryReci1(cursos1);
                adaptadormateria.setOnClickListener(new View.OnClickListener(){
                    @Override

                    public void onClick(View view){

                        String Cursos,mater;
                        Cursos=promedioLista.get(reciclemateria.getChildAdapterPosition(view)).getCusos();
                        mater=promedioLista.get(reciclemateria.getChildAdapterPosition(view)).getMaterias();
                        Intent intent=new Intent(cursoses.this,cursosesn.class);
                        intent.putExtra("cursos",Cursos);
                        intent.putExtra("mater",mater);
                        startActivity(intent);




                    }

                });

                reciclemateria.setAdapter(adaptadormateria);



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                new android.os.Handler().postDelayed(new Runnable() {


                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Error de Conexion Verifique su conexion a Internet",Toast.LENGTH_LONG).show();
                        finish();
                    }},2000);
            }
        });
        RequestQueue requestQueue;
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);

    }
    public void tarde(){
        String Url="https://colegiobartolome.000webhostapp.com/cursost.php";
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                JSONObject jo = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jo = response.getJSONObject(i);
                        promedioLista.add(new cursolist(jo.getString("grado"), jo.getString("grados"), jo.getString("materias")));

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), "error de Bd", Toast.LENGTH_LONG).show();

                    }
                }

                for(int i=0;i<promedioLista.size();i++){
                    cursos1.add(new cursos(promedioLista.get(i).getCuso()));
                }
                adaptadormateria =new MostrarMateryReci1(cursos1);
                adaptadormateria.setOnClickListener(new View.OnClickListener(){
                    @Override

                    public void onClick(View view){

                        String Cursos,mater;
                        Cursos=promedioLista.get(reciclemateria.getChildAdapterPosition(view)).getCusos();
                        mater=promedioLista.get(reciclemateria.getChildAdapterPosition(view)).getMaterias();
                        Intent intent=new Intent(cursoses.this,cursosesn.class);
                        intent.putExtra("cursos",Cursos);
                        intent.putExtra("mater",mater);
                        startActivity(intent);




                    }

                });

                reciclemateria.setAdapter(adaptadormateria);



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                new android.os.Handler().postDelayed(new Runnable() {


                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Error de Conexion Verifique su conexion a Internet",Toast.LENGTH_LONG).show();
                        finish();
                    }},2000);
            }
        });
        RequestQueue requestQueue;
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);

    }
    public void tardec(){
        String Url="https://colegiobartolome.000webhostapp.com/cursostc.php";
        JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Url, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {
                JSONObject jo = null;
                for (int i = 0; i < response.length(); i++) {
                    try {
                        jo = response.getJSONObject(i);
                        promedioLista.add(new cursolist(jo.getString("grado"), jo.getString("grados"), jo.getString("materias")));

                    } catch (JSONException e) {
                        Toast.makeText(getApplicationContext(), "error de Bd", Toast.LENGTH_LONG).show();

                    }
                }

                for(int i=0;i<promedioLista.size();i++){
                    cursos1.add(new cursos(promedioLista.get(i).getCuso()));
                }
                adaptadormateria =new MostrarMateryReci1(cursos1);
                adaptadormateria.setOnClickListener(new View.OnClickListener(){
                    @Override

                    public void onClick(View view){

                        String Cursos,mater;
                        Cursos=promedioLista.get(reciclemateria.getChildAdapterPosition(view)).getCuso();
                        mater=promedioLista.get(reciclemateria.getChildAdapterPosition(view)).getMaterias();
                        Intent intent=new Intent(cursoses.this,materiase.class);
                        intent.putExtra("curso",Cursos);
                        intent.putExtra("mater",mater);
                        startActivity(intent);




                    }

                });

                reciclemateria.setAdapter(adaptadormateria);



            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                new android.os.Handler().postDelayed(new Runnable() {


                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(), "Error de Conexion Verifique su conexion a Internet",Toast.LENGTH_LONG).show();
                        finish();
                    }},2000);
            }
        });
        RequestQueue requestQueue;
        requestQueue= Volley.newRequestQueue(this);
        requestQueue.add(jsonArrayRequest);

    }
}
