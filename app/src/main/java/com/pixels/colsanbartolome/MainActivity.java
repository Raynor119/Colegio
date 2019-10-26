package com.pixels.colsanbartolome;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
	TextView sedee;
	String sede;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
		Bundle extra = getIntent().getExtras();
		sede=extra.getString("sede");
		sedee=(TextView)findViewById(R.id.sede);
		if(sede.equals("0")) {
			sedee.setText("SEDE CENTRAL");
		}
		if(sede.equals("1")){
			sedee.setText("SEDE COMUNEROS");
		}
    }
	public void onclic(View View){
		Intent intent =new Intent(MainActivity.this,iniciarprofesores.class);
		intent.putExtra("sede",sede);


		startActivity(intent);
		
	}
	public void onclice(View view){
		Intent intent =new Intent(MainActivity.this,estudiante.class);
		intent.putExtra("sede",sede);
		startActivity(intent);
	}
}
