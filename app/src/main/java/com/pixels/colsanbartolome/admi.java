package com.pixels.colsanbartolome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class admi extends AppCompatActivity {
    static View vie;
    EditText usuario,contra;
    String sede;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admi);
        Bundle extra= getIntent().getExtras();
         sede=extra.getString("sede");
        usuario=(EditText)findViewById(R.id.editTextEmail);
        contra=(EditText)findViewById(R.id.editTextPassword);



    }
    public void onclic(View view){
        if(usuario.getText().toString().equals("")||contra.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Digite el Usuario y la Contraseña", Toast.LENGTH_LONG).show();

        }else{

            Intent intent =new Intent(admi.this,dialogoadmi.class);
            intent.putExtra("Usuario",usuario.getText().toString());
            intent.putExtra("Contraseña",contra.getText().toString());
            intent.putExtra("sede",sede);
            startActivity(intent);
            finish();

        }


    }

}
