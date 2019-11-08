package com.pixels.colsanbartolome;

public class admilist {
    private String Usuario,Contraseña,Tipo,Sede;

    public admilist(){

    }
    public admilist(String usuario,String contraseña,String tipo,String sede){

        this.Usuario=usuario;
        this.Contraseña=contraseña;
        this.Tipo=tipo;
        this.Sede=sede;

    }
    public String getUsuario(){

        return Usuario;

    }

    public void setUsuario(String usuario){

        Usuario=usuario;

    }

    public String getContraseña(){

        return Contraseña;

    }

    public void setContraseña(String contraseña){

        Contraseña=contraseña;

    }

    public String getTipo(){

        return Tipo;

    }

    public void setTipo(String tipo){

        Tipo=tipo;

    }

    public String getSede(){

        return Sede;

    }

    public void setSede(String sede){

        Sede=sede;

    }

}
