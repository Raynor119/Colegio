package com.pixels.colsanbartolome;
import android.content.Context;

import android.database.Cursor;

import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteOpenHelper;



import java.util.ArrayList;

import java.util.List;



public class basedenoti extends SQLiteOpenHelper {

    private static final String NOMBRE_BD="noti";

    private static final int VERSION_BD=1;

    private static final String TABLA_INICIO="CREATE TABLE NOTIFICACIONES(ID TEXT PRIMARY KEY)";



    public basedenoti(Context context) {

        super(context, NOMBRE_BD, null, VERSION_BD);





    }

    @Override

    public void onCreate(SQLiteDatabase sqLiteDatabase) {



        sqLiteDatabase.execSQL(TABLA_INICIO);

    }



    @Override

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int il) {

        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLA_INICIO);

        sqLiteDatabase.execSQL(TABLA_INICIO);

    }





    public void agregarE(String id){

        SQLiteDatabase bd=getWritableDatabase();

        if(bd!=null)

        {

            bd.execSQL("INSERT INTO NOTIFICACIONES VALUES('"+id+"')");

            bd.close();

        }

    }

    public List<noti> obtusur(){

        SQLiteDatabase bd=getReadableDatabase();

        Cursor cursor=bd.rawQuery("SELECT * FROM NOTIFICACIONES",null);

        List<noti> usurr=new ArrayList<>();

        if(cursor.moveToFirst()){

            do{

                usurr.add(new noti(cursor.getString(0)));





            }while(cursor.moveToNext());

        }

        return usurr;



    }




}
