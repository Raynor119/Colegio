package com.pixels.colsanbartolome;

import android.support.v7.app.*;
import android.os.*;
import android.content.*;
import java.util.ArrayList;
import java.util.List;

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



				Intent intent;



				switch(getFirstTimeRun(this)) {



					case 0:

						basedeinicio n=new basedeinicio(getApplicationContext());

						n.agregarE("1","nada","nada","nada","nada","nada");



						intent =new Intent(inicio.this,sede.class);
						startActivity(intent);
						finish();



						break;



					case 1:

						basedeinicio ne=new basedeinicio(getApplicationContext());

						usa c=new usa();

						ne.buscu(c,"1");

						List<usa> usurr=new ArrayList<>();

						usurr=ne.obtusur();



						String usu=usurr.get(0).getUsuario();

					

						if(usu.equals("nada")){

							intent = new Intent(inicio.this, sede.class);



							startActivity(intent);



							finish();

						}else{

							intent = new Intent(inicio.this, menuprofesores.class);

							intent.putExtra("Usuario",usurr.get(0).getUsuario());
							intent.putExtra("Nombre",usurr.get(0).getNombre());
							intent.putExtra("Materias",usurr.get(0).getMaterias());
							intent.putExtra("Cursos",usurr.get(0).getCursos());


							startActivity(intent);



							finish();



						}





						break;



					case 2:







						break;



				}



























			}



		},1000);

	}

	public int getFirstTimeRun(Runnable contexto) {



		SharedPreferences sp = getSharedPreferences("MYAPP", 0);



		int result, currentVersionCode = 2;



		int lastVersionCode = sp.getInt("FIRSTTIMERUN", -1);



		if (lastVersionCode == -1) result = 0; else



			result = (lastVersionCode == currentVersionCode) ? 1 : 2;



		sp.edit().putInt("FIRSTTIMERUN", currentVersionCode).apply();



		return result;



	}
}
