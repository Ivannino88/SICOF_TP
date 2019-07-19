package com.mx.totalplay.vo;


public class DetalleIptvNoBrm {

	private String fecha;
	private int id_conciliacion;
	private String cuenta;
	private String nombre;
	private String stb;
	
	
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha.substring(0, 11);
	}
	public int getId_conciliacion() {
		return id_conciliacion;
	}
	public void setId_conciliacion(int id_conciliacion) {
		this.id_conciliacion = id_conciliacion;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getStb() {
		return stb;
	}
	public void setStb(String stb) {
		this.stb = stb;
	}
	
	
	
}

