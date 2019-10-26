package com.pixels.colsanbartolome;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class sede extends AppCompatActivity {
TextView sedee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sede);

    }
    public void onclicc(View view){
        String sede="0";
        Intent intent =new Intent(sede.this,MainActivity.class);
        intent.putExtra("sede",sede);
        startActivity(intent);
    }
    public void onclicm(View view){
        String sede="1";
        Intent intent =new Intent(sede.this,MainActivity.class);
        intent.putExtra("sede",sede);
        startActivity(intent);

    }
}
