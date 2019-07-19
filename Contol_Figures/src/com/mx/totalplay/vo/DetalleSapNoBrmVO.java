package com.mx.totalplay.vo;

public class DetalleSapNoBrmVO {
	
	private String fecha;
	private String id_conciliacion;
	private String no_serie;
	private String fe_contable;
	private String numero_material;
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
	public String getNo_serie() {
		return no_serie;
	}
	public void setNo_serie(String no_serie) {
		this.no_serie = no_serie;
	}
	public String getFe_contable() {
		return fe_contable;
	}
	public void setFe_contable(String fe_contable) {
		this.fe_contable = fe_contable.substring(0, 11);
	}
	public String getNumero_material() {
		return numero_material;
	}
	public void setNumero_material(String numero_material) {
		this.numero_material = numero_material;
	}
	
	

	

}
