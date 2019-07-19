package com.mx.totalplay.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 
 * BEAN para descarga de excel para el reporte Cuentas Activas BRM vs IMS
 * @author JRMM
 *
 */

public class cuentasactivasbrmvsimsVO {
	private Date fecha;
	private String cuenta;
	private String plan;
	private String dn;
	private String tmcode;
	
	private String fechaShort; 
	
	public String getFechaShort() {
		SimpleDateFormat fechaX = new SimpleDateFormat("dd/MM/yyyy");
		return fechaShort=fechaX.format(fecha);
	}
	public void setFechaShort(String fechaShort) {
		this.fechaShort = fechaShort;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getCuenta() {
		return cuenta;
	}
	public void setCuenta(String cuenta) {
		this.cuenta = cuenta;
	}
	public String getPlan() {
		return plan;
	}
	public void setPlan(String plan) {
		this.plan = plan;
	}
	public String getDn() {
		return dn;
	}
	public void setDn(String dn) {
		this.dn = dn;
	}
	public String getTmcode() {
		return tmcode;
	}
	public void setTmcode(String tmcode) {
		this.tmcode = tmcode;
	}
}
