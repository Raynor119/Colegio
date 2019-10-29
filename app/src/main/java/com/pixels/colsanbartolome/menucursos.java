package com.pixels.colsanbartolome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class menucursos extends AppCompatActivity {
    String Materias,Cursos;
    public List<cursos> cursos1=new ArrayList<>();
    private RecyclerView reciclemateria;

    private MostrarMateryReci1 adaptadormateria,obid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menucursos);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle extra = getIntent().getExtras();
        Materias=extra.getString("Materias");
        Cursos=extra.getString("Cursos");
        int i;
        String cur="";
        for(int b=0;b<Cursos.length();b++){
            char cC=Cursos.charAt(b);
            String cuc=""+cC;
            if(cuc.equals("|")){
                cursos1.add(new cursos(cur));
                cur="";

            }else{
                cur=cur+cuc;
            }if(b==Cursos.length()-1){
                cursos1.add(new cursos(cur));
            }
        }

        reciclemateria=(RecyclerView)findViewById(R.id.recyclerMateria1);
        reciclemateria.setLayoutManager(new LinearLayoutManager(this));
        adaptadormateria =new MostrarMateryReci1(cursos1);
        adaptadormateria.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view){

                String tbd,curs1;
                curs1=adaptadormateria.promedioLista.get(reciclemateria.getChildAdapterPosition(view)).getCursos();

                String cur="";
                for(int i=0;i<curs1.length();i++){
                    char l=curs1.charAt(i);
                    String ll=""+l;
                    if(ll.equals("-")){
                    }else{
                        cur=cur+ll;
                    }
                }
                String mat="";
                for(int i=0;i<Materias.length();i++){
                    char l=Materias.charAt(i);
                    String ll=""+l;
                    if(ll.equals(" ")){
                    }else{
                        mat=mat+ll;
                    }
                }
                tbd=cur+mat;
                Intent intent=new Intent(menucursos.this,mensajesprof.class);
                intent.putExtra("tabla",cur+mat);
                startActivity(intent);

            }

        });

        reciclemateria.setAdapter(adaptadormateria);


    }
}
