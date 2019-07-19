package com.mx.totalplay.vo;


public class DetalleNoBrmIptv {

	private String fecha;
	private int id_conciliacion;
	private String cuenta;
	private String plan;
	private String stb;
	private String tmcode;
	
	public DetalleNoBrmIptv(String fecha, int id_conciliacion, String cuenta,
			String plan, String stb, String tmcode) {
		super();
		this.fecha = fecha;
		this.id_conciliacion = id_conciliacion;
		this.cuenta = cuenta;
		this.plan = plan;
		this.stb = stb;
		this.tmcode = tmcode;
	}
	
	public DetalleNoBrmIptv() {
		// TODO Auto-generated constructor stub
	}

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
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getStb() {
		return stb;
	}
	public void setStb(String stb) {
		this.stb = stb;
	}
	public String getTmcode() {
		return tmcode;
	}
	public void setTmcode(String tmcode) {
		this.tmcode = tmcode;
	}
	
	
	
}
