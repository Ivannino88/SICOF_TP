package com.mx.totalplay.vo;

public class aCentralvsEntradaSaVO {
	private String material;
	private String descr_material;
	private String centro;
	private String nombre;
	private String cantidad;
	private String cantidad_salida;
	private String fecha_pedido;
	private String semaforo;
	
	public String getMaterial() {
		return material;
	}
	public void setMaterial(String material) {
		this.material = material;
	}
	public String getDescr_material() {
		return descr_material;
	}
	public void setDescr_material(String descr_material) {
		this.descr_material = descr_material;
	}
	public String getCentro() {
		return centro;
	}
	public void setCentro(String centro) {
		this.centro = centro;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCantidad() {
		return cantidad;
	}
	public void setCantidad(String cantidad) {
		this.cantidad = cantidad;
	}
	public String getCantidad_salida() {
		return cantidad_salida;
	}
	public void setCantidad_salida(String cantidad_salida) {
		this.cantidad_salida = cantidad_salida;
	}
	public String getFecha_pedido() {
		return fecha_pedido;
	}
	public void setFecha_pedido(String fecha_pedido) {
		this.fecha_pedido = fecha_pedido;
	}
	public String getSemaforo() {
		return semaforo;
	}
	public void setSemaforo(String semaforo) {
		this.semaforo = semaforo;
	}
	
	@Override
	public String toString() {
		return "aCentralvsEntradaSaVO [material=" + material
				+ ", descr_material=" + descr_material + ", centro=" + centro
				+ ", nombre=" + nombre + ", cantidad=" + cantidad
				+ ", cantidad_salida=" + cantidad_salida + ", fecha_pedido="
				+ fecha_pedido + ", semaforo=" + semaforo + "]";
	}
}
