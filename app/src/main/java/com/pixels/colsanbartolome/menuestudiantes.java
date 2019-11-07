package com.pixels.colsanbartolome;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class menuestudiantes extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
TextView bien,Nombre,Usuario;
private Typeface script;
String sede;
    boolean n=true;
    String tipo;
    private RecyclerView reciclemateria;

    String Materias,Cursos,Usuario1,Nombre1;
    private MostrarMateryReci3 adaptadormateria;
    public List<meventos> promedioLista =new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuestudiantes);
        bien=(TextView)findViewById(R.id.biene);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        reciclemateria=(RecyclerView)findViewById(R.id.recyclerMateria1);
        reciclemateria.setLayoutManager(new LinearLayoutManager(this));
        Bundle extra = getIntent().getExtras();
        Usuario1=extra.getString("Usuario");
        Nombre1=extra.getString("Nombre");
        Materias=extra.getString("Materias");
        Cursos=extra.getString("Cursos");
        List<usa> usurr=new ArrayList<>();

        basedeinicio ne=new basedeinicio(getApplicationContext());

        usa c=new usa();
        ne.buscu(c,"1");
        usurr=ne.obtusur();
        char ct=usurr.get(0).getTipo().charAt(0);
        sede=""+ct;
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        String fuente ="fuentes/orange.ttf";
        this.script= Typeface.createFromAsset(getAssets(),fuente);
        bien.setTypeface(script);
        mostrarmensajes("1","0");
    }
    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        Nombre=(TextView)findViewById(R.id.nombreporf);
          Usuario=(TextView)findViewById(R.id.usuarioprof);
         Usuario.setText(Nombre1);
        Nombre.setText("ESTUDIANTE");
        getMenuInflater().inflate(R.menu.menua, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            finish();
        }
        if (id == R.id.acu) {
            if(n)
            {
                n=false;
                mostrarmensajes(" ","1");
                mostrarmensajes( "1","1");
            }
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_share) {
            Intent intent=new Intent(menuestudiantes.this,mostrarevento.class);
            intent.putExtra("sede",sede);
            startActivity(intent);


        }
        if (id == R.id.na) {
            basedeinicio n = new basedeinicio(getApplicationContext());
            n.inic("1", "nada","", "", "","","");


            Intent intent = new Intent(menuestudiantes.this, MainActivity.class);

            intent.putExtra("sede","0");
            startActivity(intent);


            finish();
        }
        if (id == R.id.mater) {

            Intent intent = new Intent(menuestudiantes.this, estmateriase.class);

            intent.putExtra("curso",Cursos);
            intent.putExtra("mater",Materias);
            startActivity(intent);


            finish();
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void mostrarmensajes(String tabla,final String actuali){
        if(tabla.equals(" ")){
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
                            Toast.makeText(getApplicationContext(), "error de Bd", Toast.LENGTH_LONG).show();

                        }
                    }
                    if(promedioLista.size()==0) {

                    }else{
                        adaptadormateria = new MostrarMateryReci3(promedioLista);
                        if (actuali.equals("1")) {
                            adaptadormateria.clear();
                            mostrarmensajes( "1","0");
                        }

                        adaptadormateria = new MostrarMateryReci3(promedioLista);
                        adaptadormateria.setOnClickListener(new View.OnClickListener() {
                            @Override

                            public void onClick(View view) {

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
                            Toast.makeText(getApplicationContext(), "Error de Conexion Verifique su conexion a Internet", Toast.LENGTH_LONG).show();
                        }
                    }, 2000);
                }
            });
            RequestQueue requestQueue;
            requestQueue = Volley.newRequestQueue(this);
            requestQueue.add(jsonArrayRequest);
        }
    }

}
