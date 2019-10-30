package com.pixels.colsanbartolome;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class menuadmi extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {
    TextView Usuario,Nombre;
    String Usuari,Contra,tipo,sede;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menuadmi);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
            Bundle extra = getIntent().getExtras();
            Usuari=extra.getString("Usuario");
            Contra=extra.getString("Contra");
            tipo=extra.getString("tipo");
            sede=extra.getString("sede");
            DrawerLayout drawer = findViewById(R.id.drawer_layout);

            NavigationView navigationView = findViewById(R.id.nav_view);
            ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                    this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
            drawer.addDrawerListener(toggle);
            toggle.syncState();
            navigationView.setNavigationItemSelectedListener(this);
      }
      public void onlic(View view){
        Intent intent=new Intent(menuadmi.this,eventos.class);
        intent.putExtra("tipo",tipo);
        intent.putExtra("sede",sede);
        startActivity(intent);
      }
      public void salir(View view){
        finish();
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
            Usuario=(TextView)findViewById(R.id.SEDE);
            if(tipo.equals("0")){
                Nombre.setText("RECTOR");
            }else {
                Nombre.setText("COORDINADOR");
            }
            if(sede.equals("0")){
                Usuario.setText("SEDE CENTRAL");
            }else {
                Usuario.setText("SEDE COMUNEROS");
            }

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

          if (id == R.id.nav_share) {
                basedeinicio n = new basedeinicio(getApplicationContext());
                n.inic("1", "nada","", "", "","","");


                Intent intent = new Intent(menuadmi.this, sede.class);


                startActivity(intent);


                finish();
            }

            DrawerLayout drawer = findViewById(R.id.drawer_layout);
            drawer.closeDrawer(GravityCompat.START);
            return true;
        }

}
