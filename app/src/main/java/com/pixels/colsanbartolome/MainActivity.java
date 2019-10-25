package com.pixels.colsanbartolome;

import android.support.v7.app.AppCompatActivity;
import android.os.*;
import android.app.Activity;
import android.view.*;
import android.content.*;

public class MainActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
	public void onclic(View View){
		Intent intent =new Intent(MainActivity.this,iniciarprofesores.class);
		startActivity(intent);
		
	}
}
