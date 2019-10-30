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
	boolean n=true;
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
		if(n=true)
		{
			n=false;
			Intent intent =new Intent(MainActivity.this,iniciarprofesores.class);
			intent.putExtra("sede",sede);
			startActivity(intent);
			finish();
		}

		
	}
	public void onclice(View view){
		if(n=true)
		{
			n=false;
			if(sede.equals("0")) {
				Intent intent =new Intent(MainActivity.this,estudiante.class);

				startActivity(intent);
			}
			if(sede.equals("1")){
				Intent intent =new Intent(MainActivity.this,cursoses.class);
				intent.putExtra("sede","1");
				intent.putExtra("jornada","tarde");
				startActivity(intent);
			}

		}
	}
	public void onclicee(View view){
		if(n=true) {
			n = false;
			if (sede.equals("0")) {
				Intent intent =new Intent(MainActivity.this,admi.class);
				intent.putExtra("sede","0");
				startActivity(intent);
				finish();
			}
			if (sede.equals("1")) {
				Intent intent =new Intent(MainActivity.this,admi.class);
				intent.putExtra("sede","1");
				startActivity(intent);
				finish();
			}
		}
	}
}
