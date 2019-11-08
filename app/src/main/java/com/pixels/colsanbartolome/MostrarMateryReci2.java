package com.pixels.colsanbartolome;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.graphics.Typeface;

import java.util.List;
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

import android.content.res.*;
import java.util.concurrent.locks.*;



public class MostrarMateryReci2  extends RecyclerView.Adapter<MostrarMateryReci2.ViewHolder> implements View.OnClickListener{

    public int idtex;
	static public Typeface script;

    public static class ViewHolder extends RecyclerView.ViewHolder{

        private TextView Materia,Promedio;

        Context context;



        public ViewHolder(View itemView) {

            super(itemView);

			String fuente ="fuentes/orange.ttf";

            Materia=(TextView)itemView.findViewById(R.id.MAterit);
			

			




        }

    }

    public List<cursos> promedioLista;



    private View.OnClickListener listener;



    public  MostrarMateryReci2(List<cursos> promedioLista){



        this.promedioLista=promedioLista;
	script=menuestudiantes.script;
		


    }

    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_materiases,parent,false);

        ViewHolder viewHolder=new ViewHolder(view);


		
        view.setOnClickListener(this);



        return viewHolder;

    }



    @Override

    public void onBindViewHolder(ViewHolder holder,int position){

	  
//AssetManager t=new AssetManager();


        holder.Materia.setText(promedioLista.get(position).getCursos());
		
        
        holder.Materia.setTypeface(script);








    }









    public void setOnClickListener(View.OnClickListener listener) {

        this.listener=listener;

    }

    @Override

    public void onClick(View view){

        if(listener!=null){





            int positi=idtex;

            listener.onClick(view);





        }



    }



    @Override

    public int getItemCount() {

        return promedioLista.size();

    }

}
