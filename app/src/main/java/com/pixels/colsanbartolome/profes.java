package com.pixels.colsanbartolome;

public class profes
{
	private String Usuario,Contraseña,Nombre,Jornada,Sede;
	
	public profes(){
		
	}
	public profes(String usuario,String contraseña,String nombre,String jornada,String sede){

		this.Usuario=usuario;
		this.Contraseña=contraseña;
		this.Nombre=nombre;
		this.Jornada=jornada;
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

	public String getNombre(){

		return Nombre;

	}

	public void setNombre(String nombre){

		Nombre=nombre;

	}

	public String getJornada(){

		return Jornada;

	}

	public void setJornada(String jornada){

		Jornada=jornada;

	}
	public String getSede(){

		return Sede;

	}

	public void setSede(String sede){

		Sede=sede;

	}
	
}
