package com.pixels.colsanbartolome;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
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

public class mostrarevento extends AppCompatActivity {
    String tipo,sede;
    boolean n=true;
    public List<meventos> promedioLista =new ArrayList<>();
    private RecyclerView reciclemateria;


    private MostrarMateryReci3 adaptadormateria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrarevento);
        Bundle extra = getIntent().getExtras();
        //tipo=extra.getString("tipo");
        sede=extra.getString("sede");
        reciclemateria=(RecyclerView)findViewById(R.id.recyclerMateria1);
        reciclemateria.setLayoutManager(new LinearLayoutManager(this));

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        getSupportActionBar().setCustomView(R.layout.toolbare);



        Button bton=findViewById(R.id.peri);

        bton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                if(n)
                {
                    n=false;
                    mostrarmensajes(" ","1");
                    mostrarmensajes( "1","1");
                }




            }

        });

        mostrarmensajes("1","0");
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
