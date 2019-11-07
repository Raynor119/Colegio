package com.pixels.colsanbartolome;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class estudianteinicio extends AppCompatActivity {
    private Typeface script,script1;
    TextView estua,inici;
    EditText usuario,contra;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_estudianteinicio);
        estua=(TextView)findViewById(R.id.est);
        usuario=(EditText)findViewById(R.id.editTextEmail);
        contra=(EditText)findViewById(R.id.editTextPassword);
        inici=(TextView)findViewById(R.id.inici);
        String fuente ="fuentes/orange.ttf";
        String fuente2 ="fuentes/bial.otf";
        this.script= Typeface.createFromAsset(getAssets(),fuente);
        this.script1= Typeface.createFromAsset(getAssets(),fuente2);
        estua.setTypeface(script);
        inici.setTypeface(script1);
    }
    public void onclic(View view){
        if(usuario.getText().toString().equals("")||contra.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Digite el Usuario y la Contraseña", Toast.LENGTH_LONG).show();

        }else{

            Intent intent =new Intent(estudianteinicio.this,dialogoestu.class);
            intent.putExtra("Usuario",usuario.getText().toString());
            intent.putExtra("Contraseña",contra.getText().toString());
            intent.putExtra("deci","0");
            startActivity(intent);
            finish();

        }


    }
}
