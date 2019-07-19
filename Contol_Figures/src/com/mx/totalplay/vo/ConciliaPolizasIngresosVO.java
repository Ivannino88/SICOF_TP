package com.mx.totalplay.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class ConciliaPolizasIngresosVO {
private int id;
private Date fecha;
private String empresa;
private String sociedad;
private String moneda;
private int monto_sap;
private int monto_brm;
private String semaforo;
private String fechaNew;

//---formato de la fecha ----
public String getFechaNew() {
	SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
	return fechaNew=sdf.format(fecha);
}
public void setFechaNew(String fechaNew) {
	this.fechaNew = fechaNew;
}
//------setter y getter generales------ 
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public String getEmpresa() {
	return empresa;
}
public void setEmpresa(String empresa) {
	this.empresa = empresa;
}
public String getSociedad() {
	return sociedad;
}
public void setSociedad(String sociedad) {
	this.sociedad = sociedad;
}
public String getMoneda() {
	return moneda;
}
public void setMoneda(String moneda) {
	this.moneda = moneda;
}
public int getMonto_sap() {
	return monto_sap;
}
public void setMonto_sap(int monto_sap) {
	this.monto_sap = monto_sap;
}
public int getMonto_brm() {
	return monto_brm;
}
public void setMonto_brm(int monto_brm) {
	this.monto_brm = monto_brm;
}
public String getSemaforo() {
	return semaforo;
}
public void setSemaforo(String semaforo) {
	this.semaforo = semaforo;
}



}
