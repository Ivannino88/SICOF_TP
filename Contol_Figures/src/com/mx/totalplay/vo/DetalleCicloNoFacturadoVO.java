package com.mx.totalplay.vo;

public class DetalleCicloNoFacturadoVO {
	
	private int idConciliacion;
	private String fecha;
	private String cuenta;
	private String empresa;
	private String plan;
	private String nombreCliente;
	private int monto;
	private String bill_no;
	
	
	 	
	public int getIdConciliacion() {
		return idConciliacion;
	}
	public void setIdConciliacion(int idConciliacion) {
		this.idConciliacion = idConciliacion;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha.substring(0, 11);
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
	public String getNombreCliente() {
		return nombreCliente;
	}
	public void setNombreCliente(String nombreCliente) {
		this.nombreCliente = nombreCliente;
	}
	public int getMonto() {
		return monto;
	}
	public void setMonto(int monto) {
		this.monto = monto;
	}
	public String getBill_no() {
		return bill_no;
	}
	public void setBill_no(String bill_no) {
		this.bill_no = bill_no;
	}

	
}
