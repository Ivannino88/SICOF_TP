/***
 * @author RicardoM
 * Bean PARA EL REPORTE DE SALIDAS ALMACEN CENTRAL VS ENTRADAS SUB ALMACENES
 */
package com.mx.totalplay.vo;

public class SalidasAlmacenCvsEntradasSubalmacVO {
	private String pedido;
	private String plaza;
	private String fecha_pedido;
	private String semaforo;
	private String nombre;
	private String descripcion;
	private String cantidad;
	private String fecha_insercion;
	public String getPedido() {
		return pedido;
	}
	public void setPedido(String pedido) {
		this.pedido = pedido;
	}
	public String getPlaza() {
		return plaza;
	}
	public void setPlaza(String plaza) {
		this.plaza = plaza;
	}
	public String getFecha_pedido() {
		return fecha_pedido;
	}
	public void setFecha_pedido(String fecha_pedido) {
		this.fecha_pedido = fecha_pedido.substring(0, 11);
	}
	public String getSemaforo() {
		return semaforo;
	}
	public void setSemaforo(String semaforo) {
		this.semaforo = semaforo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getFecha_insercion() {
		return fecha_insercion;
	}
	public void setFecha_insercion(String fecha_insercion) {
		this.fecha_insercion = fecha_insercion.substring(0, 11);
	}
	
}
