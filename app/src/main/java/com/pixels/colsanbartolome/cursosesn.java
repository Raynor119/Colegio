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

public class cursosesn extends AppCompatActivity {
    public List<cursolist> promedioLista =new ArrayList<>();
    private RecyclerView reciclemateria;
    public List<cursos> cursos1=new ArrayList<>();
    public List<cursos> cursos2=new ArrayList<>();
    private MostrarMateryReci1 adaptadormateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursosesn);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        reciclemateria=(RecyclerView)findViewById(R.id.recyclerMateria1);
        reciclemateria.setLayoutManager(new LinearLayoutManager(this));
        Bundle extra = getIntent().getExtras();

        String Cursos=extra.getString("cursos");
        final String Materias=extra.getString("mater");
        String cur="";
        for(int b=0;b<Cursos.length();b++){
            char cC=Cursos.charAt(b);
            String cuc=""+cC;
            if(cuc.equals("/")){
                cursos2.add(new cursos(cur));
                cur="";

            }else{
                cur=cur+cuc;
            }if(b==Cursos.length()-1){
                cursos2.add(new cursos(cur));
            }
        }
        adaptadormateria =new MostrarMateryReci1(cursos2);
        adaptadormateria.setOnClickListener(new View.OnClickListener(){
            @Override

            public void onClick(View view){
                String curs1;
                curs1=adaptadormateria.promedioLista.get(reciclemateria.getChildAdapterPosition(view)).getCursos();
                Intent intent=new Intent(cursosesn.this,materiase.class);
                intent.putExtra("curso",curs1);
                intent.putExtra("mater",Materias);
                startActivity(intent);

            }

        });

        reciclemateria.setAdapter(adaptadormateria);

    }
}
