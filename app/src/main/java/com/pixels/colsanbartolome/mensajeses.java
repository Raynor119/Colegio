package com.pixels.colsanbartolome;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
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

import java.util.ArrayList;
import java.util.List;

public class mensajeses extends AppCompatActivity {
    String tabla;
    boolean n=true;
    public List<mensajes> promedioLista =new ArrayList<>();
    private RecyclerView reciclemateria;


    private MostrarMateryRecim adaptadormateria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensajeses);
        Bundle extra = getIntent().getExtras();

        tabla=extra.getString("tabla");
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        getSupportActionBar().setCustomView(R.layout.toolbar);
        reciclemateria=(RecyclerView)findViewById(R.id.recyclerMateria1);
        reciclemateria.setLayoutManager(new LinearLayoutManager(this));
        Button bton=findViewById(R.id.peri);

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

        mostrarmensajes(tabla,"0");
    }

    public void mostrarmensajes(final String tabla, final String actuali){
if(tabla.equals(" ")){
    new android.os.Handler().postDelayed(new Runnable() {


        @Override


        public void run() {
            n=true;

        }
    },500);
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
                    Toast.makeText(getApplicationContext(), "error de Bd", Toast.LENGTH_LONG).show();

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
                    Toast.makeText(getApplicationContext(), "Error de Conexion Verifique su conexion a Internet  " + tabla, Toast.LENGTH_LONG).show();
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
