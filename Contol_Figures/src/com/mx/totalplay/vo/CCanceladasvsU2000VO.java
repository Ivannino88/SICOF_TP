package com.mx.totalplay.vo;

public class CCanceladasvsU2000VO {
	private String fecha;
	private String no_u2000;
	private String no_brm;
	private String t_conciliados;
	private String error_total;
	private String error_u2000;
	private String error_brm;
	private String total;
	private String status;
	private String empresa;
	private String tipo_conciliacion;
	private String orden;
	
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getNo_u2000() {
		return no_u2000;
	}
	public void setNo_u2000(String no_u2000) {
		this.no_u2000 = no_u2000;
	}
	public String getNo_brm() {
		return no_brm;
	}
	public void setNo_brm(String no_brm) {
		this.no_brm = no_brm;
	}
	public String getT_conciliados() {
		return t_conciliados;
	}
	public void setT_conciliados(String t_conciliados) {
		this.t_conciliados = t_conciliados;
	}
	public String getError_total() {
		return error_total;
	}
	public void setError_total(String error_total) {
		this.error_total = error_total;
	}
	public String getError_u2000() {
		return error_u2000;
	}
	public void setError_u2000(String error_u2000) {
		this.error_u2000 = error_u2000;
	}
	public String getError_brm() {
		return error_brm;
	}
	public void setError_brm(String error_brm) {
		this.error_brm = error_brm;
	}
	public String getTotal() {
		return total;
	}
	public void setTotal(String total) {
		this.total = total;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getTipo_conciliacion() {
		return tipo_conciliacion;
	}
	public void setTipo_conciliacion(String tipo_conciliacion) {
		this.tipo_conciliacion = tipo_conciliacion;
	}
	public String getOrden() {
		return orden;
	}
	public void setOrden(String orden) {
		this.orden = orden;
	}
	
	
	@Override
	public String toString() {
		return "CCanceladasvsU2000VO [fecha=" + fecha + ", no_u2000="
				+ no_u2000 + ", no_brm=" + no_brm + ", t_conciliados="
				+ t_conciliados + ", error_total=" + error_total
				+ ", error_u2000=" + error_u2000 + ", error_brm=" + error_brm
				+ ", total=" + total + ", status=" + status + ", empresa="
				+ empresa + ", tipo_conciliacion=" + tipo_conciliacion
				+ ", orden=" + orden + "]";
	}
}
