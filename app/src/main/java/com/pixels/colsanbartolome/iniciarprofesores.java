package com.pixels.colsanbartolome;

import android.support.v7.app.*;
import android.os.*;
import android.view.*;
import android.content.*;
import android.widget.*;
import android.view.inputmethod.*;
public class iniciarprofesores extends AppCompatActivity
{
	EditText usuario,contra;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
		usuario=(EditText)findViewById(R.id.editTextEmail);
		contra=(EditText)findViewById(R.id.editTextPassword);
    }
	public void onclic(View view){
		if(usuario.getText().toString().equals("")||contra.getText().toString().equals("")){
			Toast.makeText(getApplicationContext(), "Digite el Usuario y la Contraseña", Toast.LENGTH_LONG).show();
			
		}else{
			
			Intent intent =new Intent(iniciarprofesores.this,dialogcarga.class);
			startActivity(intent);
		}
		
		
	}
}
