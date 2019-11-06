package com.pixels.colsanbartolome;
import android.support.v7.app.*;
import android.os.*;
import android.widget.*;
import java.net.*;
import android.net.*;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class metas extends AppCompatActivity
{
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metas);
		getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.tolbarvi);
		VideoView VideoView=findViewById(R.id.video_view);
		String videopath="android.resource://"+getPackageName()+"/"+R.raw.video;
	    Uri uri= Uri.parse(videopath);
		VideoView.setVideoURI(uri);
		
		
		MediaController mendiaconroller=new MediaController(this);
		VideoView.setMediaController(mendiaconroller);
		mendiaconroller.setAnchorView(VideoView);
	 
		Button bton=findViewById(R.id.peri);

        bton.setOnClickListener(new View.OnClickListener() {

				@Override

				public void onClick(View v) {
					
					String sede="0";
					Intent intent =new Intent(metas.this,MainActivity.class);
					intent.putExtra("sede",sede);
					startActivity(intent);
					finish();

				}

			});
    }
}
