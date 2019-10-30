package com.pixels.colsanbartolome;

public class notionline {
    private String Id,Notificaion,Fecha;
    public notionline(){

    }
    public notionline(String id,String notificaion,String fecha){
        this.Id=id;
        this.Notificaion=notificaion;
        this.Fecha=fecha;
    }
    public String getId(){
        return Id;
    }
    public void setId(String id){
        Id=id;
    }
    public String getNotificaion(){
        return Notificaion;
    }
    public void setNotificaion(String notificaion){
        Notificaion=notificaion;
    }
    public String getFecha(){
        return Fecha;
    }
    public void setFecha(String fecha){
        Fecha=fecha;
    }
}
