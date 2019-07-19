package com.mx.totalplay.vo;

public class DetalleAddonsU2000NoBrmVO {
	
	
	private String fecha;
	private String id_conciliacion;
	private String cuenta;
	private String addons;
	private String megas;
	private String descr;
	private String ont;
	private String perfil_bajada;
	private String accion;
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha.substring(0, 11);
	}
	public String getId_conciliacion() {
		return id_conciliacion;
	}
	public void setId_conciliacion(String id_conciliacion) {
		this.id_conciliacion = id_conciliacion;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getAddons() {
		return addons;
	}
	public void setAddons(String addons) {
		this.addons = addons;
	}
	public String getMegas() {
		return megas;
	}
	public void setMegas(String megas) {
		this.megas = megas;
	}
	public String getDescr() {
		return descr;
	}
	public void setDescr(String descr) {
		this.descr = descr;
	}
	public String getOnt() {
		return ont;
	}
	public void setOnt(String ont) {
		this.ont = ont;
	}
	public String getPerfil_bajada() {
		return perfil_bajada;
	}
	public void setPerfil_bajada(String perfil_bajada) {
		this.perfil_bajada = perfil_bajada;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	
	

}
