package com.pixels.colsanbartolome;

public class materias {
    private String Materias,Cursos;

    public materias(){

    }
    public materias(String materias,String cursos){
        this.Materias=materias;
        this.Cursos=cursos;

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
}
