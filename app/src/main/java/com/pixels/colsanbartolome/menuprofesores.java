package com.pixels.colsanbartolome;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class menuprofesores extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    String Materias,Cursos,Usuario1,Nombre1;
    public List<materias> materias=new ArrayList<>();
    private RecyclerView reciclemateria;
    TextView Usuario,Nombre;
   AlertDialog.Builder alert;
    private MostrarMateryReci adaptadormateria,obid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuprofesores);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Bundle extra = getIntent().getExtras();
        Usuario1=extra.getString("Usuario");
        Nombre1=extra.getString("Nombre");
        Materias=extra.getString("Materias");
        Cursos=extra.getString("Cursos");
        alert= new AlertDialog.Builder(menuprofesores.this);
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
                intent.putExtra("nombre",Nombre1);
                startActivity(intent);
            }

        });

        reciclemateria.setAdapter(adaptadormateria);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
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
        Usuario.setText(Usuario1);
        Nombre.setText(Nombre1);
        getMenuInflater().inflate(R.menu.main2, menu);
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

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_tools) {

            alert.setMessage("Presione Si para Cambiar la Conraseña para Cancelar presione No")
                    .setCancelable(false)
                    .setPositiveButton("Si", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog,int which){
                            Intent intent=new Intent(menuprofesores.this,cambiarcontra.class);
                            intent.putExtra("usuario",Usuario1);
                            intent.putExtra("nombre",Nombre1);
                            intent.putExtra("materias",Materias);
                            intent.putExtra("cursos",Cursos);
                            startActivity(intent);
                            finish();

                        }

                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener(){
                        @Override

                        public void onClick(DialogInterface dialog,int which){
                            dialog.cancel();
                        }

                    });
            AlertDialog titulo=alert.create();
            titulo.setTitle("Alerta");
            titulo.show();
        } else if (id == R.id.nav_share) {
			basedeinicio n = new basedeinicio(getApplicationContext());
			n.inic("1", "nada","", "", "","","");


			Intent intent = new Intent(menuprofesores.this, sede.class);


			startActivity(intent);


			finish();
        }else if (id == R.id.nav_shar) {
            alert.setMessage("Seleccione Acual sede Pertenece")
                    .setCancelable(false)
                    .setPositiveButton("CENTRAL", new DialogInterface.OnClickListener(){
                        @Override
                        public void onClick(DialogInterface dialog,int which){
                            Intent intent=new Intent(menuprofesores.this,mostrarevento.class);
                            intent.putExtra("sede","0");
                            startActivity(intent);

                        }

                    })
                    .setNegativeButton("COMUNEROS", new DialogInterface.OnClickListener(){
                        @Override

                        public void onClick(DialogInterface dialog,int which){
                            Intent intent=new Intent(menuprofesores.this,mostrarevento.class);
                            intent.putExtra("sede","1");
                            startActivity(intent);
                        }

                    });
            AlertDialog titulo=alert.create();
            titulo.setTitle("Alerta");
            titulo.show();
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}

