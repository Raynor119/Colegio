package com.pixels.colsanbartolome;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class matemati extends AppCompatActivity {
    RadioButton r1,r2,r3,r4;
    double puntuaje=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matemati);
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);

        getSupportActionBar().setCustomView(R.layout.tollboxp);
        Button bton=findViewById(R.id.peri);
        r1=(RadioButton)findViewById(R.id.p1);
        r2=(RadioButton)findViewById(R.id.p2);
        r3=(RadioButton)findViewById(R.id.p3);
        r4=(RadioButton)findViewById(R.id.p4);

        bton.setOnClickListener(new View.OnClickListener() {

            @Override

            public void onClick(View v) {
                if(r1.isChecked()==true){
                    puntuaje=puntuaje+1.25;
                }
                if(r2.isChecked()==true){
                    puntuaje=puntuaje+1.25;
                }
                if(r3.isChecked()==true){
                    puntuaje=puntuaje+1.25;
                }
                if(r4.isChecked()==true){
                    puntuaje=puntuaje+1.25;
                }
                Intent intent =new Intent(matemati.this, puntaje.class);
                Toast.makeText(getApplicationContext(), puntuaje+"", Toast.LENGTH_LONG).show();

                intent.putExtra("p",""+puntuaje);
                startActivity(intent);
                finish();

            }

        });

    }
}
