package com.pixels.colsanbartolome;

public class estudit {
    private String Usuario,Contraseña,Nombre,Materias,Cursos,Tipo;

    public estudit(){

    }
    public estudit(String usuario,String contraseña,String nombre,String materias,String cursos,String tipo){

        this.Usuario=usuario;
        this.Contraseña=contraseña;
        this.Nombre=nombre;
        this.Materias=materias;
        this.Cursos=cursos;
        this.Tipo=tipo;
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

    public String getNombre(){

        return Nombre;

    }

    public void setNombre(String nombre){

        Nombre=nombre;

    }

    public String getMaterias(){

        return Materias;

    }

    public void setMaterias(String materias){

        Materias=materias;

    }
    public String getCursos(){

        return Cursos;

    }

    public void setCursos(String cursos){

        Cursos=cursos;

    }
    public String getTipo(){

        return Tipo;

    }

    public void setTipo(String tipo){

        Tipo=tipo;

    }


}
