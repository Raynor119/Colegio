package com.pixels.colsanbartolome;

import android.content.Intent;
import android.provider.Telephony;
import android.support.v7.app.*;
import android.os.*;
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

public class estudiante extends AppCompatActivity
{

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudiante);

    }

    public void manaña(View v){
	    Intent intent=new Intent(estudiante.this,cursoses.class);
        intent.putExtra("sede","0");
        intent.putExtra("jornada","manana");
	    startActivity(intent);
    }


    public void tarde(View v){
        Intent intent=new Intent(estudiante.this,cursoses.class);
        intent.putExtra("sede","0");
        intent.putExtra("jornada","tarde");
        startActivity(intent);

    }
}
