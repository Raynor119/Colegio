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


							final basedenoti nnn=new basedenoti(getApplicationContext());
							List<noti> notiguardadas=new ArrayList<>();
							notiguardadas=nnn.obtusur();
							final List<notionline> promedioLista =new ArrayList<>();
							String Url="https://colegiobartolome.000webhostapp.com/notilist.php";
							final List<noti> finalNotiguardadas = notiguardadas;
							JsonArrayRequest jsonArrayRequest=new JsonArrayRequest(Url, new Response.Listener<JSONArray>() {

								@Override
								public void onResponse(JSONArray response) {
									JSONObject jo = null;
									for (int i = 0; i < response.length(); i++) {
										try {
											jo = response.getJSONObject(i);
											promedioLista.add(new notionline(jo.getString("id"),jo.getString("notificacion"),jo.getString("fecha")));

										} catch (JSONException e) {
											Toast.makeText(getApplicationContext(), "error de Bd", Toast.LENGTH_LONG).show();

										}
									}
									//Toast.makeText(getApplicationContext(), finalNotiguardadas.size()+"", Toast.LENGTH_LONG).show();
									int tr=0;
									if(finalNotiguardadas.size()==0) {

									}else {
										for (int i = 0; i < promedioLista.size(); i++) {
											int t=0;
											for (int b = 0; b < finalNotiguardadas.size(); b++) {
												String idd=""+promedioLista.get(i).getId();
												String ic=""+finalNotiguardadas.get(b).getId();
												//Toast.makeText(getApplicationContext(), idd+"  "+ic, Toast.LENGTH_LONG).show();
												if (idd.equals(ic)) {
													//Toast.makeText(getApplicationContext(), "error de Bd "+tr, Toast.LENGTH_LONG).show();
													t=1;
												}
											}
											if(t==0){
												if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

													CharSequence name = promedioLista.get(i).getId();

													NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_HIGH);

													NotificationManager notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

													notificationManager.createNotificationChannel(notificationChannel);

												}

												NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);

												builder.setSmallIcon(R.drawable.mensa);
												String fecha="";

												for(int x=0;x<promedioLista.get(i).getFecha().length();x++){
													char cC=promedioLista.get(i).getFecha().charAt(x);
													String cuc=""+cC;
													if(cuc.equals("|")){
														t=x+1;
														break;

													}else{
														fecha=fecha+cuc;
													}
												}
												String hora="";
												for(int z=t;z<promedioLista.get(i).getFecha().length();z++){
													char cC=promedioLista.get(i).getFecha().charAt(z);
													String cuc=""+cC;

													hora=hora+cuc;
												}
												builder.setContentTitle("Nueva Notificacion");
												builder.setContentText("");
												builder.setColor(Color.WHITE);
												builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
												builder.setLights(Color.MAGENTA, 10000, 10000);
												builder.setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});
												builder.setDefaults(Notification.DEFAULT_SOUND);
												builder.setStyle(new NotificationCompat.BigTextStyle().bigText(promedioLista.get(i).getNotificaion()+" En la Fecha : "+fecha+" alas "+hora)).build();
												NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
												notificationManagerCompat.notify(NOTIFICACION_ID, builder.build());
												//Toast.makeText(getApplicationContext(), ""+b+"  "+finalNotiguardadas.get(0).getId(), Toast.LENGTH_LONG).show();
												nnn.agregarE(promedioLista.get(i).getId());
												NOTIFICACION_ID+=NOTIFICACION_ID+1;
											}else {

											}

										}
									}
								}
							}, new Response.ErrorListener() {
								@Override
								public void onErrorResponse(VolleyError error) {
									new android.os.Handler().postDelayed(new Runnable() {


										@Override
										public void run() {
											Toast.makeText(getApplicationContext(), "Error de Conexion Verifique su conexion a Internet",Toast.LENGTH_LONG).show();

										}},2000);
								}
							});
							RequestQueue requestQueue;
							requestQueue= Volley.newRequestQueue(context);
							requestQueue.add(jsonArrayRequest);

							intent = new Intent(inicio.this, sede.class);
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


								intent = new Intent(inicio.this, menuprofesores.class);

								intent.putExtra("Usuario", usurr.get(0).getUsuario());
								intent.putExtra("Nombre", usurr.get(0).getNombre());
								intent.putExtra("Materias", usurr.get(0).getMaterias());
								intent.putExtra("Cursos", usurr.get(0).getCursos());


								startActivity(intent);


								finish();

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
