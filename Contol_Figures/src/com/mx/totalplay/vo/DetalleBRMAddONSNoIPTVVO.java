/***
 * @author Nancy
 * Bean para el reporte  ADD ONS Canales BRM vs IPTV - Adicionales 
 */
package com.mx.totalplay.vo;


public class DetalleBRMAddONSNoIPTVVO {
	
	private String fecha;
	private String idConcilicion;
	private String cuenta;
	private String tipo_servicio;
	private String poid_purchased_product;
	private String poid_product;
	private String nombre_producto;
	private String descr;
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha.substring(0, 11);
	}
	public String getIdConcilicion() {
		return idConcilicion;
	}
	public void setIdConcilicion(String idConcilicion) {
		this.idConcilicion = idConcilicion;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getTipo_servicio() {
		return tipo_servicio;
	}
	public void setTipo_servicio(String tipo_servicio) {
		this.tipo_servicio = tipo_servicio;
	}
	public String getPoid_purchased_product() {
		return poid_purchased_product;
	}
	public void setPoid_purchased_product(String poid_purchased_product) {
		this.poid_purchased_product = poid_purchased_product;
	}
	public String getPoid_product() {
		return poid_product;
	}
	public void setPoid_product(String poid_product) {
		this.poid_product = poid_product;
	}
	public String getNombre_producto() {
		return nombre_producto;
	}
	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}
	public String getDescr() {
		return descr;
	}
	public void setDesc(String descr) {
		this.descr = descr;
	}
	
	
	
	

}
