package com.pixels.colsanbartolome;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;
import android.util.Log;
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

import static android.content.ContentValues.TAG;

public class servicionoti extends Service {
    basedenoti nnn;
    List<noti> notiguardadas;
    MediaPlayer reproductor;
    Context context;
    List<notionline> promedioLista;
    JsonArrayRequest jsonArrayRequest;
    NotificationCompat.Builder builder;
    String Url;
    List<noti> finalNotiguardadas;
    CharSequence name;
    String fecha;
    NotificationManager notificationManager;
    NotificationChannel notificationChannel;
    String cuc;
    RequestQueue requestQueue;
    String hora;
    char cC;
    private final static String CHANNEL_ID = "NOTIFICACION";
int recur=0;
    private static int NOTIFICACION_ID = 0;

    @Override

    public void onCreate() {

      //  Toast.makeText(this,"Servicio creado",Toast.LENGTH_SHORT).show();

    }



    @Override

    public int onStartCommand(Intent intenc, int flags, int idArranque) {

       // Toast.makeText(this,"Servicio arrancado "+ idArranque,Toast.LENGTH_SHORT).show();

recur();



        return START_REDELIVER_INTENT;

    }

    public IBinder onUnBind(Intent arg0) {
        Log.i(TAG, "onUnBind()");
        return null;
    }


    @Override

    public void onDestroy() {

     //   Toast.makeText(this,"Servicio detenido",Toast.LENGTH_SHORT).show();



    }



    @Override

    public IBinder onBind(Intent intencion) {
        Log.i(TAG, "onBind()" );
        return null;

    }




    public void recur() {
        if (recur<=5) {
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                   nnn = new basedenoti(getApplicationContext());
                    notiguardadas = new ArrayList<>();
                    notiguardadas = nnn.obtusur();
                    promedioLista = new ArrayList<>();
                    Url = "https://colegiobartolome.000webhostapp.com/notilist.php";
                    finalNotiguardadas = notiguardadas;

                    jsonArrayRequest = new JsonArrayRequest(Url, new Response.Listener<JSONArray>() {

                        @Override
                        public void onResponse(JSONArray response) {
                            JSONObject jo = null;
                            for (int i = 0; i < response.length(); i++) {
                                try {
                                    jo = response.getJSONObject(i);
                                    promedioLista.add(new notionline(jo.getString("id"), jo.getString("notificacion"), jo.getString("fecha")));

                                } catch (JSONException e) {
                                    Toast.makeText(getApplicationContext(), "error de Bd", Toast.LENGTH_LONG).show();

                                }
                            }
                            //Toast.makeText(getApplicationContext(), finalNotiguardadas.size()+"", Toast.LENGTH_LONG).show();
                            int tr = 0;
                            if (finalNotiguardadas.size() == 0) {

                            } else {
                                for (int i = 0; i < promedioLista.size(); i++) {
                                    int t = 0;
                                    for (int b = 0; b < finalNotiguardadas.size(); b++) {
                                        String idd = "" + promedioLista.get(i).getId();
                                        String ic = "" + finalNotiguardadas.get(b).getId();
                                        //Toast.makeText(getApplicationContext(), idd+"  "+ic, Toast.LENGTH_LONG).show();
                                        if (idd.equals(ic)) {
                                            //Toast.makeText(getApplicationContext(), "error de Bd "+tr, Toast.LENGTH_LONG).show();
                                            t = 1;
                                        }
                                    }
                                    if (t == 0) {
                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {

                                            name = promedioLista.get(i).getId();

                                            notificationChannel = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_HIGH);

                                            notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

                                            notificationManager.createNotificationChannel(notificationChannel);

                                        }

                                        builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID);

                                        builder.setSmallIcon(R.drawable.mensa);
                                        fecha = "";

                                        for (int x = 0; x < promedioLista.get(i).getFecha().length(); x++) {
                                             cC = promedioLista.get(i).getFecha().charAt(x);
                                             cuc = "" + cC;
                                            if (cuc.equals("|")) {
                                                t = x + 1;
                                                break;

                                            } else {
                                                fecha = fecha + cuc;
                                            }
                                        }
                                         hora = "";
                                        for (int z = t; z < promedioLista.get(i).getFecha().length(); z++) {
                                             cC = promedioLista.get(i).getFecha().charAt(z);
                                             cuc = "" + cC;

                                            hora = hora + cuc;
                                        }
                                        builder.setContentTitle("Nuevo Mensaje Bartolino");
                                        builder.setContentText("");
                                        builder.setColor(Color.WHITE);
                                        builder.setPriority(NotificationCompat.PRIORITY_DEFAULT);
                                        builder.setLights(Color.MAGENTA, 10000, 10000);
                                        builder.setVibrate(new long[]{1000, 1000, 1000, 1000, 1000});
                                        builder.setDefaults(Notification.DEFAULT_SOUND);
                                        builder.setStyle(new NotificationCompat.BigTextStyle().bigText(promedioLista.get(i).getNotificaion() + " En la Fecha : " + fecha + " alas " + hora)).build();
                                        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(getApplicationContext());
                                        notificationManagerCompat.notify(NOTIFICACION_ID, builder.build());
                                        //Toast.makeText(getApplicationContext(), ""+b+"  "+finalNotiguardadas.get(0).getId(), Toast.LENGTH_LONG).show();
                                        nnn.agregarE(promedioLista.get(i).getId());
                                        NOTIFICACION_ID += NOTIFICACION_ID + 1;
                                    } else {

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
                                    //   Toast.makeText(getApplicationContext(), "Error de Conexion Verifique su conexion a Internet", Toast.LENGTH_LONG).show();

                                }
                            }, 2000);
                        }
                    });


                    requestQueue = Volley.newRequestQueue(getApplicationContext());
                    requestQueue.add(jsonArrayRequest);

                    recur++;
                    recur();
                }
            }, 5000);
        }else {
            recur=0;
            new android.os.Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    recur();
                }
            },30000);
        }
    }
}

