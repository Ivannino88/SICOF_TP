/***
 * @author G
 * Bean PARA EL REPORTE Salida de Equipos vs. Equipos Capitalizados SAP
 */
package com.mx.totalplay.vo;

public class SalidaEqvsEqCapitalizadosSAPVO {
	
	private String fecha;
	private String salida_almacen;
	private String importe;
	private String activo_fijo;
	private String importe_activo_fijo;
	private String estatus;
	private String fecha_consulta;
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha.substring(0, 11);
	}
	public String getSalida_almacen() {
		return salida_almacen;
	}
	public void setSalida_almacen(String salida_almacen) {
		this.salida_almacen = salida_almacen;
	}
	public String getImporte() {
		return importe;
	}
	public void setImporte(String importe) {
		this.importe = importe;
	}
	public String getActivo_fijo() {
		return activo_fijo;
	}
	public void setActivo_fijo(String activo_fijo) {
		this.activo_fijo = activo_fijo;
	}
	public String getImporte_activo_fijo() {
		return importe_activo_fijo;
	}
	public void setImporte_activo_fijo(String importe_activo_fijo) {
		this.importe_activo_fijo = importe_activo_fijo;
	}
	public String getEstatus() {
		return estatus;
	}
	public void setEstatus(String estatus) {
		this.estatus = estatus;
	}
	public String getFecha_consulta() {
		return fecha_consulta;
	}
	public void setFecha_consulta(String fecha_consulta) {
		this.fecha_consulta = fecha_consulta.substring(0, 11);
	}
	


}
