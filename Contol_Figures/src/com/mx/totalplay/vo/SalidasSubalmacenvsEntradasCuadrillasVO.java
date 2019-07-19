package com.mx.totalplay.vo;

public class SalidasSubalmacenvsEntradasCuadrillasVO {
	
	private String material;
	private String descr_material; 
	private String numeroserie;
	private String centro;
	private String cuadrilla;
	private String nombre_modifico;
	private String fecha_modificacion;
	private String numero_lote;
	private String tipo_stock;
	private String numero_equipo;
	private String tipo_equipo;
	private String fecha_equipo;
	private String nombre_responsable;
	private String numero_objeto;
	private String fecha_mov_mercancias;
	private String semaforo;
	private String fecha_consulta;
	
	private String verde;
	private String amarillo;
	private String rojo;
	
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
	public String getNumeroserie() {
		return numeroserie;
	}
	public void setNumeroserie(String numeroserie) {
		this.numeroserie = numeroserie;
	}
	public String getCentro() {
		return centro;
	}
	public void setCentro(String centro) {
		this.centro = centro;
	}
	public String getCuadrilla() {
		return cuadrilla;
	}
	public void setCuadrilla(String cuadrilla) {
		this.cuadrilla = cuadrilla;
	}
	public String getNombre_modifico() {
		return nombre_modifico;
	}
	public void setNombre_modifico(String nombre_modifico) {
		this.nombre_modifico = nombre_modifico;
	}
	public String getFecha_modificacion() {
		return fecha_modificacion;
	}
	public void setFecha_modificacion(String fecha_modificacion) {
		this.fecha_modificacion = fecha_modificacion.substring(0, 11);
	}
	public String getNumero_lote() {
		return numero_lote;
	}
	public void setNumero_lote(String numero_lote) {
		this.numero_lote = numero_lote;
	}
	public String getTipo_stock() {
		return tipo_stock;
	}
	public void setTipo_stock(String tipo_stock) {
		this.tipo_stock = tipo_stock;
	}
	public String getNumero_equipo() {
		return numero_equipo;
	}
	public void setNumero_equipo(String numero_equipo) {
		this.numero_equipo = numero_equipo;
	}
	public String getTipo_equipo() {
		return tipo_equipo;
	}
	public void setTipo_equipo(String tipo_equipo) {
		this.tipo_equipo = tipo_equipo;
	}
	public String getFecha_equipo() {
		return fecha_equipo;
	}
	public void setFecha_equipo(String fecha_equipo) {
		this.fecha_equipo = fecha_equipo.substring(0, 11);
	}
	public String getNombre_responsable() {
		return nombre_responsable;
	}
	public void setNombre_responsable(String nombre_responsable) {
		this.nombre_responsable = nombre_responsable;
	}
	public String getNumero_objeto() {
		return numero_objeto;
	}
	public void setNumero_objeto(String numero_objeto) {
		this.numero_objeto = numero_objeto;
	}
	public String getFecha_mov_mercancias() {
		return fecha_mov_mercancias;
	}
	public void setFecha_mov_mercancias(String fecha_mov_mercancias) {
		this.fecha_mov_mercancias = fecha_mov_mercancias.substring(0, 11);
	}
	public String getSemaforo() {
		return semaforo;
	}
	public void setSemaforo(String semaforo) {
		this.semaforo = semaforo;
	}	
	public String getFecha_consulta() {
		return fecha_consulta;
	}
	public void setFecha_consulta(String fecha_consulta) {
		this.fecha_consulta = fecha_consulta.substring(0, 11);
	}
	public String getVerde() {
		return verde;
	}
	public void setVerde(String verde) {
		this.verde = verde;
	}
	public String getAmarillo() {
		return amarillo;
	}
	public void setAmarillo(String amarillo) {
		this.amarillo = amarillo;
	}
	public String getRojo() {
		return rojo;
	}
	public void setRojo(String rojo) {
		this.rojo = rojo;
	}
		


	
	
}
