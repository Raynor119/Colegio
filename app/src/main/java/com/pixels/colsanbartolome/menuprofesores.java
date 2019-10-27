package com.pixels.colsanbartolome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class menuprofesores extends AppCompatActivity {
    String Materias,Cursos;
    public List<materias> materias=new ArrayList<>();
    private RecyclerView reciclemateria;

    private MostrarMateryReci adaptadormateria,obid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprofesores);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle extra = getIntent().getExtras();
        Materias=extra.getString("Materias");
        Cursos=extra.getString("Cursos");
        reciclemateria=(RecyclerView)findViewById(R.id.recyclerMateria);
        reciclemateria.setLayoutManager(new LinearLayoutManager(this));


        int i;
        String mater="";
        String cur="";
        int t=0;
        for(i=0;i<Materias.length();i++){
            char caracter = Materias.charAt(i);
            String car=""+caracter;
            if(car.equals("/")){
                for(int b=t;b<Cursos.length();b++){
                    char cC=Cursos.charAt(b);
                    String cuc=""+cC;
                    if(cuc.equals("/")){
                        t=b+1;
                        break;
                    }else{
                        cur=cur+cuc;
                    }
                }
                materias.add(new materias(mater,cur));
                mater="";
                cur="";
            }else{
                mater=mater+car;
            }
             if(i==Materias.length()-1){
                 for(int b=t;b<Cursos.length();b++){
                     char cC=Cursos.charAt(b);
                     String cuc=""+cC;
                     if(cuc.equals("/")){
                         t=b+1;
                         break;
                     }else{
                         cur=cur+cuc;
                     }
                 }
                 materias.add(new materias(mater,cur));
           }
        }
        adaptadormateria =new MostrarMateryReci(materias);
        adaptadormateria.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view){

                String mater1,curs1;
                mater1=adaptadormateria.promedioLista.get(reciclemateria.getChildAdapterPosition(view)).getMaterias();
                curs1=adaptadormateria.promedioLista.get(reciclemateria.getChildAdapterPosition(view)).getCursos();
                Intent intent=new Intent(menuprofesores.this,menucursos.class);
                intent.putExtra("Materias",mater1);
                intent.putExtra("Cursos",curs1);
                startActivity(intent);
            }

        });

        reciclemateria.setAdapter(adaptadormateria);

    }

    }

