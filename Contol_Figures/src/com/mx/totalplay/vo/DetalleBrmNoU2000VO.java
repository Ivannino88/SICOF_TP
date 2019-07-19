package com.mx.totalplay.vo;

public class DetalleBrmNoU2000VO {
	
	private String fecha_conciliacion;
	private String id_conciliacion;
	private String cuenta;
	private String empresa;
	private String plan;
	private String sn;
	private String status_cuenta;
	
	
	
	public String getFecha_conciliacion() {
		return fecha_conciliacion;
	}
	public void setFecha_conciliacion(String fecha_conciliacion) {
		this.fecha_conciliacion = fecha_conciliacion.substring(0, 11);
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
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getSn() {
		return sn;
	}
	public void setSn(String sn) {
		this.sn = sn;
	}
	public String getStatus_cuenta() {
		return status_cuenta;
	}
	public void setStatus_cuenta(String status_cuenta) {
		this.status_cuenta = status_cuenta;
	}
	@Override
	public String toString() {
		return "DetalleBrmNoU2000VO [fecha_conciliacion=" + fecha_conciliacion
				+ ", id_conciliacion=" + id_conciliacion + ", cuenta=" + cuenta
				+ ", empresa=" + empresa + ", plan=" + plan + ", sn=" + sn
				+ ", status_cuenta=" + status_cuenta + "]";
	}
	
	
	

}
