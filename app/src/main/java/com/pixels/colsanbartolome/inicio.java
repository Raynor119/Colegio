package com.pixels.colsanbartolome;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.support.v7.app.*;
import android.os.*;
import android.content.*;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class inicio extends AppCompatActivity
{
	Context context;
	private PendingIntent pendingIntent;

	private final static String CHANNEL_ID = "NOTIFICACION";

	private static int NOTIFICACION_ID = 0;
	@Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);
        context=this;
		new android.os.Handler().postDelayed(new Runnable() {











			@Override



			public void run() {



				Intent intent;



				switch(getFirstTimeRun(this)) {



					case 0:

						basedeinicio n=new basedeinicio(getApplicationContext());
						basedenoti nn=new basedenoti(getApplicationContext());
						n.agregarE("1","nada","nada","nada","nada","nada","nada");
						nn.agregarE("0");



						intent =new Intent(inicio.this,metas.class);
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




							intent = new Intent(inicio.this, metas.class);
							startActivity(intent);
							finish();

						}else{
							if(usurr.get(0).getNombre().equals("0")||usurr.get(0).getNombre().equals("1")){
							    intent =new Intent(inicio.this,menuadmi.class);

								intent.putExtra("Usuario", usurr.get(0).getUsuario());
								intent.putExtra("Contra", usurr.get(0).getContraseña());
								intent.putExtra("tipo", usurr.get(0).getNombre());
								intent.putExtra("sede", usurr.get(0).getMaterias());


								startActivity(intent);


								finish();
							}else {

if(usurr.get(0).getTipo().length()==2) {
	intent = new Intent(inicio.this, menuprofesores.class);

	intent.putExtra("Usuario", usurr.get(0).getUsuario());
	intent.putExtra("Nombre", usurr.get(0).getNombre());
	intent.putExtra("Materias", usurr.get(0).getMaterias());
	intent.putExtra("Cursos", usurr.get(0).getCursos());


	startActivity(intent);


	finish();
}else {
	intent = new Intent(inicio.this, menuestudiantes.class);

	intent.putExtra("Usuario", usurr.get(0).getUsuario());
	intent.putExtra("Nombre", usurr.get(0).getNombre());
	intent.putExtra("Materias", usurr.get(0).getMaterias());
	intent.putExtra("Cursos", usurr.get(0).getCursos());


	startActivity(intent);


	finish();
}
							}

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
