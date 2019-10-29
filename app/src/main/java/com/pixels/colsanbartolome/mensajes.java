package com.pixels.colsanbartolome;

public class mensajes {
    private String Id,Mensaje,Fecha;
    public mensajes(){

    }
    public mensajes(String id,String mensaje,String fecha){
        this.Id=id;
        this.Mensaje=mensaje;
        this.Fecha=fecha;
    }
    public String getId(){

        return Id;

    }

    public void setId(String id){

        Id=id;

    }
    public String getMensaje(){

        return Mensaje;

    }

    public void setMensaje(String mensaje){

        Mensaje=mensaje;

    }
    public String getFecha(){

        return Fecha;

    }

    public void setFecha(String fecha){

        Fecha=fecha;

    }
}
