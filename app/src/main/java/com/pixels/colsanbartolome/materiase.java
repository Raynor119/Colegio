package com.pixels.colsanbartolome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class materiase extends AppCompatActivity {
    public List<cursos> cursos2=new ArrayList<>();
    private RecyclerView reciclemateria;
    public List<cursos> cursos1=new ArrayList<>();

    private MostrarMateryReci2 adaptadormateria;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_materiase);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        reciclemateria=(RecyclerView)findViewById(R.id.recyclerMateria1);
        reciclemateria.setLayoutManager(new LinearLayoutManager(this));
        Bundle extra = getIntent().getExtras();
       final String curso=extra.getString("curso");
        String Materias=extra.getString("mater");
        String cur="";
        for(int b=0;b<Materias.length();b++){
            char cC=Materias.charAt(b);
            String cuc=""+cC;
            if(cuc.equals("/")){
                cursos2.add(new cursos(cur));
                cur="";

            }else{
                cur=cur+cuc;
            }if(b==Materias.length()-1){
                cursos2.add(new cursos(cur));
            }
        }
        adaptadormateria =new MostrarMateryReci2(cursos2);
        adaptadormateria.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view){
                String curs1;
                curs1=adaptadormateria.promedioLista.get(reciclemateria.getChildAdapterPosition(view)).getCursos();
                String cur="";
                for(int i=0;i<curso.length();i++){
                    char l=curso.charAt(i);
                    String ll=""+l;
                    if(ll.equals("-")){
                    }else{
                        cur=cur+ll;
                    }
                }
                String mat="";
                for(int i=0;i<curs1.length();i++){
                    char l=curs1.charAt(i);
                    String ll=""+l;
                    if(ll.equals(" ")){
                    }else{
                        mat=mat+ll;
                    }
                }

                Intent intent=new Intent(materiase.this,mensajeses.class);
                intent.putExtra("tabla",cur+mat);
                startActivity(intent);


            }

        });

        reciclemateria.setAdapter(adaptadormateria);



    }
}
