package com.pixels.colsanbartolome;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class puntaje extends AppCompatActivity {
TextView t1,t2,t3;
    public static Typeface script;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_puntaje);
        Bundle extra = getIntent().getExtras();
        String pun=extra.getString("p");
        t1=(TextView)findViewById(R.id.textView3);
        t2=(TextView)findViewById(R.id.n);
        t3=(TextView)findViewById(R.id.textView5);
        String fuente ="fuentes/orange.ttf";
        this.script= Typeface.createFromAsset(getAssets(),fuente);
        t3.setText(""+pun);
        t1.setTypeface(script);
        t2.setTypeface(script);
        t3.setTypeface(script);

    }
}
