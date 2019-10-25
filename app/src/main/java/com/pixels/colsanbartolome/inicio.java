package com.pixels.colsanbartolome;

import android.support.v7.app.*;
import android.os.*;
import android.content.*;

public class inicio extends AppCompatActivity
{
	@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
		new android.os.Handler().postDelayed(new Runnable() {


				@Override
				public void run() {
					Intent intent =new Intent(inicio.this,MainActivity.class);
					startActivity(intent);
					finish();
				}
				},1000);
    }
}
