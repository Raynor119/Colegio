package com.pixels.colsanbartolome;

import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class tips extends AppCompatActivity {
TextView t1,t2;
    private Typeface script,script1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);
        VideoView VideoView=findViewById(R.id.video_view);
        VideoView VideoView1=findViewById(R.id.video_view1);
        VideoView VideoView2=findViewById(R.id.video_view2);
        VideoView VideoView3=findViewById(R.id.video_view3);
        VideoView VideoView4=findViewById(R.id.video_view4);
        VideoView VideoView5=findViewById(R.id.video_view5);
        String videopath="android.resource://"+getPackageName()+"/"+R.raw.v1;
        String videopath1="android.resource://"+getPackageName()+"/"+R.raw.v2;
        String videopath2="android.resource://"+getPackageName()+"/"+R.raw.v3;
        String videopath3="android.resource://"+getPackageName()+"/"+R.raw.v4;
        String videopath4="android.resource://"+getPackageName()+"/"+R.raw.v5;
        String videopath5="android.resource://"+getPackageName()+"/"+R.raw.v6;
        Uri uri= Uri.parse(videopath);
        Uri uri1= Uri.parse(videopath1);
        Uri uri2= Uri.parse(videopath2);
        Uri uri3= Uri.parse(videopath3);
        Uri uri4= Uri.parse(videopath4);
        Uri uri5= Uri.parse(videopath5);


        VideoView.setVideoURI(uri);
        VideoView1.setVideoURI(uri1);
        VideoView2.setVideoURI(uri2);
        VideoView3.setVideoURI(uri3);
        VideoView4.setVideoURI(uri4);
        VideoView5.setVideoURI(uri5);
        MediaController mendiaconroller=new MediaController(this);
        MediaController mendiaconroller1=new MediaController(this);
        MediaController mendiaconroller2=new MediaController(this);
        MediaController mendiaconroller3=new MediaController(this);
        MediaController mendiaconroller4=new MediaController(this);
        MediaController mendiaconroller5=new MediaController(this);
        VideoView.setMediaController(mendiaconroller);
        VideoView1.setMediaController(mendiaconroller1);
        VideoView2.setMediaController(mendiaconroller2);
        VideoView3.setMediaController(mendiaconroller3);
        VideoView4.setMediaController(mendiaconroller4);
        VideoView5.setMediaController(mendiaconroller5);
        mendiaconroller.setAnchorView(VideoView);
        mendiaconroller1.setAnchorView(VideoView1);
        mendiaconroller2.setAnchorView(VideoView2);
        mendiaconroller3.setAnchorView(VideoView3);
        mendiaconroller4.setAnchorView(VideoView4);
        mendiaconroller5.setAnchorView(VideoView5);
        String fuente ="fuentes/orange.ttf";
        this.script= Typeface.createFromAsset(getAssets(),fuente);
        t1=(TextView)findViewById(R.id.tt1);
        t2=(TextView)findViewById(R.id.tt2);
        t1.setTypeface(script);
        t2.setTypeface(script);
      //  mendiaconroller.show();
    }
    public void onclicm(View v){
        Intent intent=new Intent(tips.this,matemati.class);
        startActivity(intent);

    }
    public void onclicc(View v){
        Intent intent=new Intent(tips.this,compete.class);
        startActivity(intent);
    }
    public void onclica(View v){
        Intent intent=new Intent(tips.this,ambien.class);
        startActivity(intent);
    }
    public void onclici(View v){
        Intent intent=new Intent(tips.this,ingle.class);
        startActivity(intent);
    }
    public void onclich(View v){
        Intent intent=new Intent(tips.this,historia.class);
        startActivity(intent);
    }
    public void onclice(View v){
        Intent intent=new Intent(tips.this,esp.class);
        startActivity(intent);
    }
}
