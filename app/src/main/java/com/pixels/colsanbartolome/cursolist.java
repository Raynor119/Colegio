package com.pixels.colsanbartolome;

public class cursolist {
    private  String Cuso,Cusos,Materias;
    public cursolist(){

    }
    public cursolist(String curso,String cursos,String materias){
        this.Cuso=curso;
        this.Cusos=cursos;
        this.Materias=materias;

    }
    public String getCuso(){

        return Cuso;

    }

    public void setCuso(String curso){

        Cuso=curso;

    }
    public String getCusos(){

        return Cusos;

    }

    public void setCusos(String cursos){

        Cusos=cursos;

    }

    public String getMaterias(){

        return Materias;

    }

    public void setMaterias(String materias){

        Materias=materias;

    }
}
