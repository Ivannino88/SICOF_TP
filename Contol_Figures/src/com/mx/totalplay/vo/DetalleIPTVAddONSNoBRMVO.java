/***
 * @author Nancy
 * Bean para el reporte  ADD ONS Canales BRM vs IPTV - Adicionales 
 */
package com.mx.totalplay.vo;


public class DetalleIPTVAddONSNoBRMVO {
	
	private String fecha;
	private String id_conciliacion;
	private String cuenta;
	private String nombre;
	private String plan;
	private String status_cuenta;
	private String paquete_principal;
	private String addon;
	private String fecha_aprovisanamiento;
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getStatus_cuenta() {
		return status_cuenta;
	}
	public void setStatus_cuenta(String status_cuenta) {
		this.status_cuenta = status_cuenta;
	}
	public String getPaquete_principal() {
		return paquete_principal;
	}
	public void setPaquete_principal(String paquete_principal) {
		this.paquete_principal = paquete_principal;
	}
	public String getAddon() {
		return addon;
	}
	public void setAddon(String addon) {
		this.addon = addon;
	}
	public String getFecha_aprovisanamiento() {
		return fecha_aprovisanamiento;
	}
	public void setFecha_aprovisanamiento(String fecha_aprovisanamiento) {
		this.fecha_aprovisanamiento = fecha_aprovisanamiento.substring(0, 11);
	}
	
	
	
	
	
	

}
