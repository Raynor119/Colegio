package com.pixels.colsanbartolome;

public class profes
{
	private String Usuario,Contraseña,Nombre,Materias,Cursos;
	
	public profes(){
		
	}
	public profes(String usuario,String contraseña,String nombre,String materias,String cursos){

		this.Usuario=usuario;
		this.Contraseña=contraseña;
		this.Nombre=nombre;
		this.Materias=materias;
		this.Cursos=cursos;
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
	
}
