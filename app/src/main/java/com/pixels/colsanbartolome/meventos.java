package com.pixels.colsanbartolome;

public class meventos {
    private String Id,Mensaje,Fecha,Quien;
    public meventos(){

    }
    public meventos(String id,String mensaje,String fecha,String quien){
        this.Id=id;
        this.Mensaje=mensaje;
        this.Fecha=fecha;
        this.Quien=quien;
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
    public String getQuien(){

        return Quien;

    }

    public void setQuien(String quien){

        Quien=quien;

    }
}
