package com.mx.totalplay.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class cuentasactivasimsvsbrmVO {
	
	private Date fecha;
	private String id;
	private String dn;
	private String fechaShort;
	
//	public Date getFecha() {
//		return fecha;
//	}
//	public void setFecha(Date fecha) {
//		this.fecha = fecha.substring(0, 11);
//	}
	public String getFechaShort() {
		SimpleDateFormat ff = new SimpleDateFormat("dd/MM/yyyy");
		return fechaShort=ff.format(fecha);
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
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getDn() {
		return dn;
	}
	public void setDn(String dn) {
		this.dn = dn;
	}
	@Override
	public String toString() {
		return "cuentasactivasimsvsbrmVO [fecha=" + fecha + ", id=" + id
				+ ", dn=" + dn + "]";
	}
	
	

}
