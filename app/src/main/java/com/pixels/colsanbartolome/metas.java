package com.pixels.colsanbartolome;
import android.support.v7.app.*;
import android.os.*;
import android.widget.*;
import java.net.*;
import android.net.*;
public class metas extends AppCompatActivity
{
	protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_metas);
       
		VideoView VideoView=findViewById(R.id.video_view);
		String videopath="android.resource://"+getPackageName()+"/"+R.raw.video;
	    Uri uri= Uri.parse(videopath);
		VideoView.setVideoURI(uri);
		
		MediaController mendiaconroller=new MediaController(this);
		VideoView.setMediaController(mendiaconroller);
		mendiaconroller.setAnchorView(VideoView);
	 

    }
}
